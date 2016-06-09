using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataTrafficGetDataConsole
{
    public class CategoryCode
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual string categoryCode { get; set; }
        public virtual string categoryName { get; set; }
    }
}
