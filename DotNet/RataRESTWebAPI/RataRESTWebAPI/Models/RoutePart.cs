using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RataRESTWebAPI.Models
{
    public class RoutePart
    {
        public RouteStop beginStop { get; set; }
        public RouteStop endStop { get; set; }
        public int trainNumber;
    }
}
