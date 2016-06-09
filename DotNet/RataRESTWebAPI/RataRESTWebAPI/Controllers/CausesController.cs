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
    public class CausesController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/Causes
        public IQueryable<Cause> Getcauses()
        {
            var query = from c in db.causes select c;
            foreach (Cause c in query)
                db.causes.Add(c);
            return db.causes;
        }

        // GET: api/Causes/5
        [ResponseType(typeof(Cause))]
        public IHttpActionResult GetCause(int id)
        {
            Cause cause = db.causes.Find(id);
            if (cause == null)
            {
                return NotFound();
            }

            return Ok(cause);
        }

        // PUT: api/Causes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCause(int id, Cause cause)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != cause.id)
            {
                return BadRequest();
            }

            db.Entry(cause).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CauseExists(id))
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

        // POST: api/Causes
        [ResponseType(typeof(Cause))]
        public IHttpActionResult PostCause(Cause cause)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.causes.Add(cause);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = cause.id }, cause);
        }

        // DELETE: api/Causes/5
        [ResponseType(typeof(Cause))]
        public IHttpActionResult DeleteCause(int id)
        {
            Cause cause = db.causes.Find(id);
            if (cause == null)
            {
                return NotFound();
            }

            db.causes.Remove(cause);
            db.SaveChanges();

            return Ok(cause);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CauseExists(int id)
        {
            return db.causes.Count(e => e.id == id) > 0;
        }
    }
}