﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RataRESTWebAPI.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.Title = "Train service";

            return View();
        }

        public ActionResult Routes()
        {
            ViewBag.Title = "Routes";

            return View();
        }

    }
}
