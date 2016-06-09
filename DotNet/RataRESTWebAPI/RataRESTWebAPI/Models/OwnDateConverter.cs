using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Converters;

namespace RataRESTWebAPI.Models
{
    class OwnDateConverter : IsoDateTimeConverter
    {
        public OwnDateConverter()
        {
            base.DateTimeFormat = "yyyy-MM-dd";
        }
    }
}
