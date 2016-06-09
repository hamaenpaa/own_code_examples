using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataRESTWebAPI.Models
{
    [Table("JourneySection", Schema = "dbo")]
    public class JourneySection
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

/*        public virtual TimeTableRow beginTimeTableRow { get; set; }
        public virtual TimeTableRow endTimeTableRow { get; set; }

        public virtual List<Locomotive> locomotives { get; set; }
        public virtual List<Wagon> wagons { get; set; }
  */      
        public virtual int totalLength { get; set; }
        public virtual int maximumSpeed { get; set; }
    }
}
