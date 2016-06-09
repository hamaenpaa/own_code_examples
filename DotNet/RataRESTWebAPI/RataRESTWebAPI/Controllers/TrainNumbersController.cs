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
    public class TrainNumbersController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/TrainNumbers
        public IQueryable<TrainNumbers> GetTrainNumbers()
        {
            var query = from tn in db.TrainNumbers select tn;
            foreach (TrainNumbers tn in query)
                db.TrainNumbers.Add(tn);
            return db.TrainNumbers;
        }

        // GET: api/TrainNumbers/5
        [ResponseType(typeof(TrainNumbers))]
        public IHttpActionResult GetTrainNumbers(int id)
        {
            TrainNumbers trainNumbers = db.TrainNumbers.Find(id);
            if (trainNumbers == null)
            {
                return NotFound();
            }

            return Ok(trainNumbers);
        }

        // PUT: api/TrainNumbers/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTrainNumbers(int id, TrainNumbers trainNumbers)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != trainNumbers.Id)
            {
                return BadRequest();
            }

            db.Entry(trainNumbers).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrainNumbersExists(id))
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

        // POST: api/TrainNumbers
        [ResponseType(typeof(TrainNumbers))]
        public IHttpActionResult PostTrainNumbers(TrainNumbers trainNumbers)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TrainNumbers.Add(trainNumbers);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (TrainNumbersExists(trainNumbers.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = trainNumbers.Id }, trainNumbers);
        }

        // DELETE: api/TrainNumbers/5
        [ResponseType(typeof(TrainNumbers))]
        public IHttpActionResult DeleteTrainNumbers(int id)
        {
            TrainNumbers trainNumbers = db.TrainNumbers.Find(id);
            if (trainNumbers == null)
            {
                return NotFound();
            }

            db.TrainNumbers.Remove(trainNumbers);
            db.SaveChanges();

            return Ok(trainNumbers);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TrainNumbersExists(int id)
        {
            return db.TrainNumbers.Count(e => e.Id == id) > 0;
        }
    }
}