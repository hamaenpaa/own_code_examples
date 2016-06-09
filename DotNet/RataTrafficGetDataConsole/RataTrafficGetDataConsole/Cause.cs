using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataTrafficGetDataConsole
{
    public class Cause
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual string categoryCode { get; set; } // Yleisen syyluokan tunnus.Lista syyluokista löytyy osoitteesta metadata/cause-category-codes
        public virtual string detailedCategoryCode { get; set; } // Tarkempi syykoodin tunnus.Lista syykoodeista löytyy osoitteesta metadata/detailed-cause-category-codes

        [ForeignKey("timeTableRow")]
        public int TimeTableRowId { get; set; }

        public TimeTableRow timeTableRow { get; set; }
    }
}
