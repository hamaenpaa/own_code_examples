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
    public class CompositionsController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/Compositions
        public IQueryable<Composition> Getcompositions()
        {
            var query = from c in db.compositions select c;
            foreach (Composition c in query)
                db.compositions.Add(c);
            return db.compositions;
        }

        // GET: api/Compositions/5
        [ResponseType(typeof(Composition))]
        public IHttpActionResult GetComposition(int id)
        {
            Composition composition = db.compositions.Find(id);
            if (composition == null)
            {
                return NotFound();
            }

            return Ok(composition);
        }

        // PUT: api/Compositions/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutComposition(int id, Composition composition)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != composition.id)
            {
                return BadRequest();
            }

            db.Entry(composition).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CompositionExists(id))
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

        // POST: api/Compositions
        [ResponseType(typeof(Composition))]
        public IHttpActionResult PostComposition(Composition composition)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.compositions.Add(composition);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = composition.id }, composition);
        }

        // DELETE: api/Compositions/5
        [ResponseType(typeof(Composition))]
        public IHttpActionResult DeleteComposition(int id)
        {
            Composition composition = db.compositions.Find(id);
            if (composition == null)
            {
                return NotFound();
            }

            db.compositions.Remove(composition);
            db.SaveChanges();

            return Ok(composition);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CompositionExists(int id)
        {
            return db.compositions.Count(e => e.id == id) > 0;
        }
    }
}