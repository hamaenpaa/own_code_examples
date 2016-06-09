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
    public class OperatorsController : ApiController
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        private TrainsModel db = new TrainsModel();

        // GET: api/Operators
        public IQueryable<Operator> Getops([FromUri] bool reload)
        {
            if (reload)
                reloadOperators();
            var query = from o in db.ops select o;
            foreach (Operator o in query)
                db.ops.Add(o);
            return db.ops;
        }

        private void reloadOperators()
        {
            IEnumerable<Operator> enumOperators = db.ops.AsEnumerable<Operator>();
            foreach (Operator o in enumOperators)
                db.ops.Remove(o);
            db.SaveChanges();
            List<Operator> operators = getRESTOperators();
            foreach (Operator o in operators)
                db.ops.Add(o);
            db.SaveChanges();
        }

        private List<Operator> getRESTOperators()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/operators");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Operator>>(request);
            return clientEx.Data;
        }

        // GET: api/Operators/5
        [ResponseType(typeof(Operator))]
        public IHttpActionResult GetOperator(int id)
        {
            Operator @operator = db.ops.Find(id);
            if (@operator == null)
            {
                return NotFound();
            }

            return Ok(@operator);
        }

        // PUT: api/Operators/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutOperator(int id, Operator @operator)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != @operator.Id)
            {
                return BadRequest();
            }

            db.Entry(@operator).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!OperatorExists(id))
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

        // POST: api/Operators
        [ResponseType(typeof(Operator))]
        public IHttpActionResult PostOperator(Operator @operator)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.ops.Add(@operator);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (OperatorExists(@operator.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = @operator.Id }, @operator);
        }

        // DELETE: api/Operators/5
        [ResponseType(typeof(Operator))]
        public IHttpActionResult DeleteOperator(int id)
        {
            Operator @operator = db.ops.Find(id);
            if (@operator == null)
            {
                return NotFound();
            }

            db.ops.Remove(@operator);
            db.SaveChanges();

            return Ok(@operator);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool OperatorExists(int id)
        {
            return db.ops.Count(e => e.Id == id) > 0;
        }
    }
}