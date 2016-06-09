using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataTrafficGetDataConsole
{
    public class Locomotive
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual int location { get; set; }
        public virtual string locomotiveType { get; set; }
        public virtual string powerType { get; set; }
    }
}
