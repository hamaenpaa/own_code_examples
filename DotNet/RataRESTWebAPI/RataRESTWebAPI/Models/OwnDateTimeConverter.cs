using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Converters;

namespace RataRESTWebAPI.Models
{
    class OwnDateTimeConverter : IsoDateTimeConverter
    {
        public OwnDateTimeConverter()
        {
            // 2016-05-31T13:06:18.000Z
            base.DateTimeFormat = "yyyy-MM-ddTHH:mm:ss.fffZ";
        }
    }
}
