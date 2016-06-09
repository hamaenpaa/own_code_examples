using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataTrafficGetDataConsole
{
    public class Wagon
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual int location { get; set; }
        public virtual int salesNumber { get; set; }
        public virtual int length { get; set; }
        public virtual bool playground { get; set; }
        public virtual bool pet { get; set; }
        public virtual bool catering { get; set; }
        public virtual bool video { get; set; }
        public virtual bool luggage { get; set; }
        public virtual bool smoking { get; set; }
        public virtual bool disabled { get; set; }
        public virtual string wagonType { get; set; }
    }
}
