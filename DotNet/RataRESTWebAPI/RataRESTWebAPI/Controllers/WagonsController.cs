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

namespace RataRESTWebAPI.Controllers
{
    public class WagonsController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/Wagons
        public IQueryable<Wagon> Getwagons()
        {
            var query = from w in db.wagons select w;
            foreach (Wagon w in query)
                db.wagons.Add(w);
            return db.wagons;
        }

        // GET: api/Wagons/5
        [ResponseType(typeof(Wagon))]
        public IHttpActionResult GetWagon(int id)
        {
            Wagon wagon = db.wagons.Find(id);
            if (wagon == null)
            {
                return NotFound();
            }

            return Ok(wagon);
        }

        // PUT: api/Wagons/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutWagon(int id, Wagon wagon)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != wagon.id)
            {
                return BadRequest();
            }

            db.Entry(wagon).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!WagonExists(id))
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

        // POST: api/Wagons
        [ResponseType(typeof(Wagon))]
        public IHttpActionResult PostWagon(Wagon wagon)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.wagons.Add(wagon);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = wagon.id }, wagon);
        }

        // DELETE: api/Wagons/5
        [ResponseType(typeof(Wagon))]
        public IHttpActionResult DeleteWagon(int id)
        {
            Wagon wagon = db.wagons.Find(id);
            if (wagon == null)
            {
                return NotFound();
            }

            db.wagons.Remove(wagon);
            db.SaveChanges();

            return Ok(wagon);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool WagonExists(int id)
        {
            return db.wagons.Count(e => e.id == id) > 0;
        }
    }
}