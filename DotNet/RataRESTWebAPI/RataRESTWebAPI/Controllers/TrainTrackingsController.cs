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
    public class TrainTrackingsController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        const int COUNT_OF_DAYS_FROM_PAST = 5;
        private TrainsModel db = new TrainsModel();

        // GET: api/TrainTrackings
        public IQueryable<TrainTracking> GettrainTrackings([FromUri] bool reload)
        {
            if (reload)
                reloadTrainTrackings();
            var query = from tt in db.trainTrackings select tt;
            foreach (TrainTracking tt in query)
                db.trainTrackings.Add(tt);
            return db.trainTrackings;
        }

        private void reloadTrainTrackings()
        {
            IEnumerable<TrainTracking> enumTrainTrackings = db.trainTrackings.AsEnumerable<TrainTracking>();
            foreach (TrainTracking tt in enumTrainTrackings)
                db.trainTrackings.Remove(tt);
            db.SaveChanges();
            List<TrainTracking> trainTrackings = getRESTTrainTrackings(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            foreach (TrainTracking tt in trainTrackings)
                db.trainTrackings.Add(tt);
            db.SaveChanges();
        }

        private IEnumerable<DateTime> EachDay(DateTime from, DateTime thru)
        {
            for (var day = from.Date; day.Date <= thru.Date; day = day.AddDays(1))
                yield return day;
        }

        private List<TrainTracking> getRESTTrainTrackings(DateTime StartDate, DateTime EndDate)
        {
            List<TrainTracking> trainTrackings = new List<TrainTracking>();
            // foreach (DateTime day in EachDay(StartDate, EndDate))
            // {
                var client = new RestClient(SERVICE_ROOT + "/train-tracking");
                var request = new RestRequest(Method.GET);
                request.AddHeader("accept", "application/json");
                request.RequestFormat = DataFormat.Json;
                var clientEx = client.Execute<List<TrainTracking>>(request);
                trainTrackings.AddRange(clientEx.Data);
            // }
            return trainTrackings;
        }


        // GET: api/TrainTrackings/5
        [ResponseType(typeof(TrainTracking))]
        public IHttpActionResult GetTrainTracking(int id)
        {
            TrainTracking trainTracking = db.trainTrackings.Find(id);
            if (trainTracking == null)
            {
                return NotFound();
            }

            return Ok(trainTracking);
        }

        // PUT: api/TrainTrackings/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTrainTracking(int id, TrainTracking trainTracking)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != trainTracking.id)
            {
                return BadRequest();
            }

            db.Entry(trainTracking).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrainTrackingExists(id))
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

        // POST: api/TrainTrackings
        [ResponseType(typeof(TrainTracking))]
        public IHttpActionResult PostTrainTracking(TrainTracking trainTracking)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.trainTrackings.Add(trainTracking);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (TrainTrackingExists(trainTracking.id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = trainTracking.id }, trainTracking);
        }

        // DELETE: api/TrainTrackings/5
        [ResponseType(typeof(TrainTracking))]
        public IHttpActionResult DeleteTrainTracking(int id)
        {
            TrainTracking trainTracking = db.trainTrackings.Find(id);
            if (trainTracking == null)
            {
                return NotFound();
            }

            db.trainTrackings.Remove(trainTracking);
            db.SaveChanges();

            return Ok(trainTracking);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TrainTrackingExists(int id)
        {
            return db.trainTrackings.Count(e => e.id == id) > 0;
        }
    }
}