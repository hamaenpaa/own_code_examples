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
    public class CategoryCodesController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        private TrainsModel db = new TrainsModel();

        // GET: api/CategoryCodes
        public IQueryable<CategoryCode> GetcategoryCodes([FromUri] bool reload)
        {
            if (reload)
                reloadCategoryCodes();
            var q2 = from cc2 in db.categoryCodes select cc2;
            foreach (CategoryCode cc2 in q2)
                db.categoryCodes.Add(cc2);
            return db.categoryCodes;
        }

        private void reloadCategoryCodes()
        {
            IEnumerable<CategoryCode> enumCategoryCodes = db.categoryCodes.AsEnumerable<CategoryCode>();
            foreach (CategoryCode cc in enumCategoryCodes)
                db.categoryCodes.Remove(cc);
            db.SaveChanges();
            List<CategoryCode> categoryCodes = getRESTCategoryCodes();
            foreach (CategoryCode cc in categoryCodes)
                db.categoryCodes.Add(cc);
            db.SaveChanges();
        }

        private List<CategoryCode> getRESTCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<CategoryCode>>(request);
            return clientEx.Data;
        }

        // GET: api/CategoryCodes/5
        [ResponseType(typeof(CategoryCode))]
        public IHttpActionResult GetCategoryCode(int id)
        {
            CategoryCode categoryCode = db.categoryCodes.Find(id);
            if (categoryCode == null)
            {
                return NotFound();
            }

            return Ok(categoryCode);
        }

        // PUT: api/CategoryCodes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCategoryCode(int id, CategoryCode categoryCode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != categoryCode.id)
            {
                return BadRequest();
            }

            db.Entry(categoryCode).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CategoryCodeExists(id))
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

        // POST: api/CategoryCodes
        [ResponseType(typeof(CategoryCode))]
        public IHttpActionResult PostCategoryCode(CategoryCode categoryCode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.categoryCodes.Add(categoryCode);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = categoryCode.id }, categoryCode);
        }

        // DELETE: api/CategoryCodes/5
        [ResponseType(typeof(CategoryCode))]
        public IHttpActionResult DeleteCategoryCode(int id)
        {
            CategoryCode categoryCode = db.categoryCodes.Find(id);
            if (categoryCode == null)
            {
                return NotFound();
            }

            db.categoryCodes.Remove(categoryCode);
            db.SaveChanges();

            return Ok(categoryCode);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CategoryCodeExists(int id)
        {
            return db.categoryCodes.Count(e => e.id == id) > 0;
        }
    }
}