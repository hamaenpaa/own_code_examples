using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using RataRESTWebAPI.Models;
using RestSharp;

namespace RataRESTWebAPI.Controllers
{
    public class TrainsController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        const int COUNT_OF_DAYS_FROM_PAST = 5;

        private TrainsModel db = new TrainsModel();
        private List<int> trainNumbers = new List<int>();

        // GET: api/Trains

        // public IEnumerable<Trains> Gettrains()
        public IQueryable<Trains> Gettrains([FromUri] bool reload)
        {
            if (reload)
                reloadTrains();
            var query = from t in db.trains select t;
            foreach (Trains t in query)
                db.trains.Add(t);
            var query2 = from ttr in db.timeTableRows select ttr;
            foreach (TimeTableRow ttr in query2)
                db.timeTableRows.Add(ttr);
            var query3 = from c in db.causes select c;
            foreach (Cause c in query3)
                db.causes.Add(c);
            return db.trains.AsQueryable<Trains>();
        }

        private void reloadTrains()
        {
            // delete from database
            IEnumerable<Trains> trains = db.trains.AsEnumerable<Trains>();
            foreach (Trains t in trains)
                db.trains.Remove(t);
            IEnumerable<TimeTableRow> timeTableRows = db.timeTableRows.AsEnumerable<TimeTableRow>();
            foreach (TimeTableRow ttr in timeTableRows)
                db.timeTableRows.Remove(ttr);
            IEnumerable<Cause> causes = db.causes.AsEnumerable<Cause>();
            foreach (Cause c in causes)
                db.causes.Remove(c);
            db.SaveChanges();

            // reload from web service
            List<Trains> reloadedTrains = getRESTTrains();
            gatherTrainNumbers(reloadedTrains);
            List<Trains> moreTrains = getRESTTrainsForDateInterval(trainNumbers,
                DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            reloadedTrains.AddRange(moreTrains);
            moreTrains = getRESTHistorySchedules(
                    DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            reloadedTrains.AddRange(moreTrains);
            List<Station> stations = new List<Station>();
            IEnumerable<Station> enumStations = db.stations.AsEnumerable<Station>();
            foreach (Station s in enumStations)
                stations.Add(s);
            moreTrains = getRESTSchedules(stations);
            reloadedTrains.AddRange(moreTrains);
            foreach (Trains t in reloadedTrains)
                db.trains.Add(t);
            db.SaveChanges();
        }

        private List<Trains> getRESTTrains()
        {
            var client = new RestClient(SERVICE_ROOT + "/live-trains");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Trains>>(request);
            return clientEx.Data;
        }

        private string dateToRESTDate(DateTime date)
        {
            string sMonth = date.Month.ToString();
            if (sMonth.Length == 1) sMonth = "0" + sMonth;
            string sDay = date.Day.ToString();
            if (sDay.Length == 1) sDay = "0" + sDay;
            return date.Year + "-" + sMonth + "-" + sDay;
        }

        private IEnumerable<DateTime> EachDay(DateTime from, DateTime thru)
        {
            for (var day = from.Date; day.Date <= thru.Date; day = day.AddDays(1))
                yield return day;
        }

        private List<Trains> getRESTTrainsForDateInterval(
            List<int> trainNumbers,
            DateTime StartDate, DateTime EndDate)
        {
            List<Trains> trains = new List<Trains>();
            foreach (int trainNumber in trainNumbers)
                foreach (DateTime day in EachDay(StartDate, EndDate))
                {
                    var client = new RestClient(SERVICE_ROOT +
                        "/live-trains/" + trainNumber + "?departure_date=" +
                        dateToRESTDate(day));
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    trains.AddRange(clientEx.Data);
                }
            return trains;
        }

        public static List<Trains> getRESTSchedules(List<Station> stations)
        {
            List<Trains> trains = new List<Trains>();
            foreach (Station departStation in stations)
            {
                foreach (Station arrivalStation in stations)
                {
                    if (arrivalStation.id == departStation.id)
                        continue;
                    var client = new RestClient(SERVICE_ROOT +
                        "/schedules/" +
                        "?departure_station=" + departStation.stationShortCode +
                        "&arrival_station=" + arrivalStation.stationShortCode
                        );
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    if (clientEx != null && clientEx.Data != null && clientEx.Data.Count > 0)
                        trains.AddRange(clientEx.Data);
                }
            }
            return trains;
        }

        private List<Trains> getRESTHistorySchedules(
            DateTime StartDate, DateTime EndDate)
        {
            List<Trains> trains = new List<Trains>();
            foreach (DateTime day in EachDay(StartDate, EndDate))
            {
                var client = new RestClient(SERVICE_ROOT +
                    "/history?departure_date=" +
                    dateToRESTDate(day));
                var request = new RestRequest(Method.GET);
                request.AddHeader("accept", "application/json");
                request.RequestFormat = DataFormat.Json;
                var clientEx = client.Execute<List<Trains>>(request);
                trains.AddRange(clientEx.Data);
            }
            return trains;
        }


        private void gatherTrainNumbers(List<Trains> trains)
        {
            foreach (Trains t in trains)
            {
                if (!trainNumbers.Contains(t.trainNumber))
                    trainNumbers.Add(t.trainNumber);
            }
        }

        // GET: api/Trains/5
        [ResponseType(typeof(Trains))]
        public IHttpActionResult GetTrains(int id)
        {
            Trains trains = db.trains.Find(id);
            if (trains == null)
            {
                return NotFound();
            }

            return Ok(trains);
        }

        // PUT: api/Trains/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTrains(int id, Trains trains)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != trains.id)
            {
                return BadRequest();
            }

            db.Entry(trains).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrainsExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Trains
        [ResponseType(typeof(Trains))]
        public IHttpActionResult PostTrains(Trains trains)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.trains.Add(trains);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = trains.id }, trains);
        }

        // DELETE: api/Trains/5
        [ResponseType(typeof(Trains))]
        public IHttpActionResult DeleteTrains(int id)
        {
            Trains trains = db.trains.Find(id);
            if (trains == null)
            {
                return NotFound();
            }

            db.trains.Remove(trains);
            db.SaveChanges();

            return Ok(trains);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TrainsExists(int id)
        {
            return db.trains.Count(e => e.id == id) > 0;
        }
    }
}