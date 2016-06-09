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
    public class DetailedCategoryCodesController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        private TrainsModel db = new TrainsModel();

        // GET: api/DetailedCategoryCodes
        public IQueryable<DetailedCategoryCode> GetdetailedCategoryCodes([FromUri] bool reload)
        {
            if (reload)
                reloadDetailedCategoryCodes();
            var query = from dcc in db.detailedCategoryCodes select dcc;
            foreach (DetailedCategoryCode dcc in query)
                db.detailedCategoryCodes.Add(dcc);
            return db.detailedCategoryCodes;
        }

        private void reloadDetailedCategoryCodes()
        {
            IEnumerable<DetailedCategoryCode> enumDetailedCategoryCodes = 
                db.detailedCategoryCodes.AsEnumerable<DetailedCategoryCode>();
            foreach (DetailedCategoryCode dcc in enumDetailedCategoryCodes)
                db.detailedCategoryCodes.Remove(dcc);
            db.SaveChanges();
            List<DetailedCategoryCode> detailedCategoryCodes = getRESTDetailedCategoryCodes();
            foreach (DetailedCategoryCode dcc in detailedCategoryCodes)
                db.detailedCategoryCodes.Add(dcc);
            db.SaveChanges();
        }

        private List<DetailedCategoryCode> getRESTDetailedCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/detailed-cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<DetailedCategoryCode>>(request);
            return clientEx.Data;
        }

        // GET: api/DetailedCategoryCodes/5
        [ResponseType(typeof(DetailedCategoryCode))]
        public IHttpActionResult GetDetailedCategoryCode(int id)
        {
            DetailedCategoryCode detailedCategoryCode = db.detailedCategoryCodes.Find(id);
            if (detailedCategoryCode == null)
            {
                return NotFound();
            }

            return Ok(detailedCategoryCode);
        }

        // PUT: api/DetailedCategoryCodes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDetailedCategoryCode(int id, DetailedCategoryCode detailedCategoryCode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != detailedCategoryCode.id)
            {
                return BadRequest();
            }

            db.Entry(detailedCategoryCode).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DetailedCategoryCodeExists(id))
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

        // POST: api/DetailedCategoryCodes
        [ResponseType(typeof(DetailedCategoryCode))]
        public IHttpActionResult PostDetailedCategoryCode(DetailedCategoryCode detailedCategoryCode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.detailedCategoryCodes.Add(detailedCategoryCode);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = detailedCategoryCode.id }, detailedCategoryCode);
        }

        // DELETE: api/DetailedCategoryCodes/5
        [ResponseType(typeof(DetailedCategoryCode))]
        public IHttpActionResult DeleteDetailedCategoryCode(int id)
        {
            DetailedCategoryCode detailedCategoryCode = db.detailedCategoryCodes.Find(id);
            if (detailedCategoryCode == null)
            {
                return NotFound();
            }

            db.detailedCategoryCodes.Remove(detailedCategoryCode);
            db.SaveChanges();

            return Ok(detailedCategoryCode);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DetailedCategoryCodeExists(int id)
        {
            return db.detailedCategoryCodes.Count(e => e.id == id) > 0;
        }
    }
}