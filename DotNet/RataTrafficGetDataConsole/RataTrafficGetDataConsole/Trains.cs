using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace RataTrafficGetDataConsole
{
    public class Trains
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public virtual int id { get; set; }

        public virtual int trainNumber { get; set; } // 1-99999  Junan numero.Esim junan "IC 59" junanumero on 59

        [JsonProperty(ItemConverterType = typeof(OwnDateConverter))]
        [DataType(DataType.DateTime)]
        [Column(TypeName = "datetime2")]
        public virtual DateTime departureDate { get; set; } // date Junan ensimmäisen lähdön päivämäärä
        public virtual int operatorUICCode { get; set; } //  1-9999   Junan operoiman operaattorin UIC-koodi
        public virtual string operatorShortCode { get; set; } // vr, vr-track, destia, ...  Lista operaattoreista löytyy http://rata.digitraffic.fi/api/v1/metadata/operators
        public virtual string trainType { get; set; } // IC, P, S, ...
        public virtual string trainCategory { get; set; }  // lähiliikenne, kaukoliikenne, tavaraliikenne, ...
        public virtual string commuterLineID { get; set; } // Z, K, N....
        public virtual bool runningCurrently { get; set; } // Onko juna tällä hetkellä kulussa
        public virtual bool cancelled { get; set; } // Totta, jos junan peruminen on tehty 10 vuorokauden sisällä. Yli 10 vuorokautta sitten peruttuja junia ei palauteta rajapinnassa laisinkaan.
        public virtual long version { get; set; }

        public virtual List<TimeTableRow> timeTableRows { get; set; } // Kuvaa saapumisia ja lähtöjä liikennepaikoilta. Järjestetty reitin mukaiseen järjestykseen.
    }
}
