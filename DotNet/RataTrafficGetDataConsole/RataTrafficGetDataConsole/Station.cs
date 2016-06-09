using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace RataTrafficGetDataConsole
{
    public class Station
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        // [Key]
        public virtual string stationShortCode { get; set; }
        public virtual string type { get; set; }
        public virtual int stationUICCode { get; set; }
        public virtual string stationName { get; set; }
        public virtual string countryCode { get; set; }
        public virtual bool passengerTraffic { get; set; }
        public virtual double longitude { get; set; }
        public virtual double latitude { get; set; }
    }
}
