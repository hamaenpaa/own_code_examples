using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace RataRESTWebAPI.Models
{
    [Table("TimeTableRow", Schema = "dbo")]
    public class TimeTableRow
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual bool trainStopping { get; set; }
        public virtual string stationShortCode { get; set; } // Aseman lyhennekoodi
        public virtual int stationcUICCode { get; set; } // 1-9999  Aseman UIC-koodi
        public virtual string countryCode { get; set; } // "FI" tai "RU"
        public virtual string type { get; set; }  // "ARRIVAL" tai "DEPARTURE"  Pysähdyksen tyyppi
        public virtual bool commercialStop { get; set; } // boolean Onko pysähdys kaupallinen.Annettu vain pysähdyksille, ei läpiajoille. Mikäli junalla on osaväliperumisia, saattaa viimeinen perumista edeltävä pysähdys jäädä virheellisesti ei-kaupalliseksi.
        public virtual string commercialTrack { get; set; } // Suunniteltu raidenumero, jolla juna pysähtyy tai jolta se lähtee.Operatiivisissa häiriötilanteissa raide voi olla muu.
        public virtual bool cancelled { get; set; } // Totta, jos lähtö tai saapuminen on peruttu

        [JsonProperty(ItemConverterType = typeof(OwnDateTimeConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime scheduledTime { get; set; } // Aikataulun mukainen pysähtymis- tai lähtöaika

        [JsonProperty(ItemConverterType = typeof(OwnDateTimeConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime liveEstimateTime { get; set; } // Ennuste. Tyhjä jos juna ei ole matkalla

        [JsonProperty(ItemConverterType = typeof(OwnDateTimeConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime actualTime { get; set; } // Aika jolloin juna saapui tai lähti asemalta
        public virtual int differenceInMinutes { get; set; } // Vertaa aikataulun mukaista aikaa ennusteeseen tai toteutuneeseen aikaan ja kertoo erotuksen minuutteina
        public virtual List<Cause> Causes { get; set; } // Syytiedot.Kuvaavat syitä miksi juna oli myöhässä tai etuajassa pysähdyksellä.Kaikkia syyluokkia ja -tietoja ei julkaista.

        [ForeignKey("trains")]
        public int TrainsId { get; set; }

        public Trains trains { get; set; }
    }
}
