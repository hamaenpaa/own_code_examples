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
    [Table("TrainTracking", Schema = "dbo")]
    public class TrainTracking
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int dbId { get; set; }

        public virtual int id { get; set; }
        public virtual long version { get; set; }
        public virtual string trainNumber { get; set; }

        [JsonProperty(ItemConverterType = typeof(OwnDateConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime departureDate { get; set; }

        [JsonProperty(ItemConverterType = typeof(OwnDateConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime timestamp { get; set; }

        public virtual string trackSection { get; set; }
        public virtual string nextTrackSection { get; set; }
        public virtual string previousTrackSection { get; set; }
        public virtual string station { get; set; }
        public virtual string nextStation { get; set; }
        public virtual string previousStation { get; set; }
        public virtual string type { get; set; }
    }
}
