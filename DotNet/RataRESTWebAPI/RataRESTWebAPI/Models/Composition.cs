using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace RataRESTWebAPI.Models
{
    [Table("Composition", Schema = "dbo")]
    public class Composition
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual int trainNumber { get; set; }

        [JsonProperty(ItemConverterType = typeof(OwnDateConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime departureDate { get; set; }

        public virtual int operatorUICCode { get; set; }
        public virtual string operatorShortCode { get; set; }
        public virtual string trainCategory { get; set; }
        public virtual string trainType { get; set; }
        public virtual long version { get; set; }
    }
}
