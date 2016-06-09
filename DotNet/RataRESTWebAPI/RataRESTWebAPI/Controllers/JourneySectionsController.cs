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
    public class JourneySectionsController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/JourneySections
        public IQueryable<JourneySection> GetJourneySections()
        {
            var query = from js in db.JourneySections select js;
            foreach (JourneySection js in query)
                db.JourneySections.Add(js);
            return db.JourneySections;
        }

        // GET: api/JourneySections/5
        [ResponseType(typeof(JourneySection))]
        public IHttpActionResult GetJourneySection(int id)
        {
            JourneySection journeySection = db.JourneySections.Find(id);
            if (journeySection == null)
            {
                return NotFound();
            }

            return Ok(journeySection);
        }

        // PUT: api/JourneySections/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutJourneySection(int id, JourneySection journeySection)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != journeySection.id)
            {
                return BadRequest();
            }

            db.Entry(journeySection).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!JourneySectionExists(id))
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

        // POST: api/JourneySections
        [ResponseType(typeof(JourneySection))]
        public IHttpActionResult PostJourneySection(JourneySection journeySection)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.JourneySections.Add(journeySection);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = journeySection.id }, journeySection);
        }

        // DELETE: api/JourneySections/5
        [ResponseType(typeof(JourneySection))]
        public IHttpActionResult DeleteJourneySection(int id)
        {
            JourneySection journeySection = db.JourneySections.Find(id);
            if (journeySection == null)
            {
                return NotFound();
            }

            db.JourneySections.Remove(journeySection);
            db.SaveChanges();

            return Ok(journeySection);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool JourneySectionExists(int id)
        {
            return db.JourneySections.Count(e => e.id == id) > 0;
        }
    }
}