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
    public class LocomotivesController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/Locomotives
        public IQueryable<Locomotive> Getlocomotives()
        {
            var query = from lm in db.locomotives select lm;
            foreach (Locomotive lm in query)
                db.locomotives.Add(lm);
            return db.locomotives;
        }

        // GET: api/Locomotives/5
        [ResponseType(typeof(Locomotive))]
        public IHttpActionResult GetLocomotive(int id)
        {
            Locomotive locomotive = db.locomotives.Find(id);
            if (locomotive == null)
            {
                return NotFound();
            }

            return Ok(locomotive);
        }

        // PUT: api/Locomotives/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutLocomotive(int id, Locomotive locomotive)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != locomotive.id)
            {
                return BadRequest();
            }

            db.Entry(locomotive).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LocomotiveExists(id))
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

        // POST: api/Locomotives
        [ResponseType(typeof(Locomotive))]
        public IHttpActionResult PostLocomotive(Locomotive locomotive)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.locomotives.Add(locomotive);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = locomotive.id }, locomotive);
        }

        // DELETE: api/Locomotives/5
        [ResponseType(typeof(Locomotive))]
        public IHttpActionResult DeleteLocomotive(int id)
        {
            Locomotive locomotive = db.locomotives.Find(id);
            if (locomotive == null)
            {
                return NotFound();
            }

            db.locomotives.Remove(locomotive);
            db.SaveChanges();

            return Ok(locomotive);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool LocomotiveExists(int id)
        {
            return db.locomotives.Count(e => e.id == id) > 0;
        }
    }
}