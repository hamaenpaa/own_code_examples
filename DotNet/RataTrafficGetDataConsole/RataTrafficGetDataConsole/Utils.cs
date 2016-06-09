using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RataTrafficGetDataConsole
{
    public class Utils
    {
        public static IEnumerable<DateTime> EachDay(DateTime from, DateTime thru)
        {
            for (var day = from.Date; day.Date <= thru.Date; day = day.AddDays(1))
                yield return day;
        }

        public static string dateToRESTDate(DateTime date)
        {
            string sMonth = date.Month.ToString();
            if (sMonth.Length == 1) sMonth = "0" + sMonth;
            string sDay = date.Day.ToString();
            if (sDay.Length == 1) sDay = "0" + sDay;
            return date.Year + "-" + sMonth + "-" + sDay;
        }
    }
}
