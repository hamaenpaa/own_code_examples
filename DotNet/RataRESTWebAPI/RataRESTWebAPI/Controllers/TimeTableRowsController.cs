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
    public class TimeTableRowsController : ApiController
    {
        private TrainsModel db = new TrainsModel();

        // GET: api/TimeTableRows
        public IQueryable<TimeTableRow> GettimeTableRows()
        {
            var query = from ttr in db.timeTableRows select ttr;
            foreach (TimeTableRow ttr in query)
                db.timeTableRows.Add(ttr);
            return db.timeTableRows;
        }

        // GET: api/TimeTableRows/5
        [ResponseType(typeof(TimeTableRow))]
        public IHttpActionResult GetTimeTableRow(int id)
        {
            TimeTableRow timeTableRow = db.timeTableRows.Find(id);
            if (timeTableRow == null)
            {
                return NotFound();
            }

            return Ok(timeTableRow);
        }

        // PUT: api/TimeTableRows/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTimeTableRow(int id, TimeTableRow timeTableRow)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != timeTableRow.id)
            {
                return BadRequest();
            }

            db.Entry(timeTableRow).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TimeTableRowExists(id))
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

        // POST: api/TimeTableRows
        [ResponseType(typeof(TimeTableRow))]
        public IHttpActionResult PostTimeTableRow(TimeTableRow timeTableRow)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.timeTableRows.Add(timeTableRow);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = timeTableRow.id }, timeTableRow);
        }

        // DELETE: api/TimeTableRows/5
        [ResponseType(typeof(TimeTableRow))]
        public IHttpActionResult DeleteTimeTableRow(int id)
        {
            TimeTableRow timeTableRow = db.timeTableRows.Find(id);
            if (timeTableRow == null)
            {
                return NotFound();
            }

            db.timeTableRows.Remove(timeTableRow);
            db.SaveChanges();

            return Ok(timeTableRow);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TimeTableRowExists(int id)
        {
            return db.timeTableRows.Count(e => e.id == id) > 0;
        }
    }
}