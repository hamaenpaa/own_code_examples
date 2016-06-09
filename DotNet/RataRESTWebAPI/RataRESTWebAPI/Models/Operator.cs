using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations.Schema;

namespace RataRESTWebAPI.Models
{
    [Table("Operator", Schema = "dbo")]
    public class Operator
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int dbId { get; set; }

        public virtual int Id { get; set; }
        public virtual string operatorName { get; set; }
        public virtual string operatorShortCode { get; set; }
        public virtual int operatorUICCode { get; set; }

        public virtual List<TrainNumbers> trainNumber { get; set; }
    }
}
