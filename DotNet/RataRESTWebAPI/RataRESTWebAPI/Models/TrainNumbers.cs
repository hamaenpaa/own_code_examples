using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataRESTWebAPI.Models
{
    [Table("TrainNumbers", Schema = "dbo")]
    public class TrainNumbers
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int dbId { get; set; }

        public virtual int Id { get; set; }
        public virtual int bottomLimit { get; set; }
        public virtual int topLimit { get; set; }
        public virtual string trainCategory { get; set; }

        [ForeignKey("op")]
        public int operatorId { get; set; }

        public Operator op { get; set; }
    }
}
