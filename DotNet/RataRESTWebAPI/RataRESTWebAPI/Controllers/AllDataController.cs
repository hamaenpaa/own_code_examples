using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RataRESTWebAPI.Controllers
{
    public class AllDataController : Controller
    {
        // GET: AllData
        public ActionResult Index()
        {
            return View();
        }
    }
}