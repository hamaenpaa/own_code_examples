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
    public class StationsController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        private TrainsModel db = new TrainsModel();

        // GET: api/Stations
        public IQueryable<Station> Getstations([FromUri] bool reload)
        {
            if (reload)
                reloadStations();
            var query = from s in db.stations select s;
            foreach (Station s in query)
                db.stations.Add(s);
            return db.stations;
        }

        // GET: AX/Stations/options
        [HttpGet]
        public IList<StationOption> options([FromUri] bool reload)
        {
            List<StationOption> stationOptions = new List<StationOption>();
            if (reload)
                reloadStations();
            var query = from s in db.stations select s;
            foreach (Station s in query)
                stationOptions.Add(new StationOption()
                {
                    stationCode = s.stationShortCode,
                    stationName = s.stationName + " (" + s.stationShortCode + ")"
                });
            return stationOptions;
        }

        private void reloadStations()
        {
            IEnumerable<Station> enumStations = db.stations.AsEnumerable<Station>();
            foreach (Station s in enumStations)
                db.stations.Remove(s);
            db.SaveChanges();
            List<Station> stations = getRESTStations();
            foreach (Station s in stations)
                db.stations.Add(s);
            db.SaveChanges();
        }

        private List<Station> getRESTStations()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/stations");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Station>>(request);
            return clientEx.Data;
        }



        // GET: api/Stations/5
        [ResponseType(typeof(Station))]
        public IHttpActionResult GetStation(int id)
        {
            Station station = db.stations.Find(id);
            if (station == null)
            {
                return NotFound();
            }

            return Ok(station);
        }

        // PUT: api/Stations/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutStation(int id, Station station)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != station.id)
            {
                return BadRequest();
            }

            db.Entry(station).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!StationExists(id))
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

        // POST: api/Stations
        [ResponseType(typeof(Station))]
        public IHttpActionResult PostStation(Station station)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.stations.Add(station);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = station.id }, station);
        }

        // DELETE: api/Stations/5
        [ResponseType(typeof(Station))]
        public IHttpActionResult DeleteStation(int id)
        {
            Station station = db.stations.Find(id);
            if (station == null)
            {
                return NotFound();
            }

            db.stations.Remove(station);
            db.SaveChanges();

            return Ok(station);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool StationExists(int id)
        {
            return db.stations.Count(e => e.id == id) > 0;
        }
    }
}