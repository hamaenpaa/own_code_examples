using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using RestSharp;

namespace RataTrafficGetDataConsole
{
    public class Program
    {
        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        const int COUNT_OF_DAYS_FROM_PAST = 5;
        const int COUNT_OF_DAYS_TO_FUTURE = 5;
        const bool USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS = false;

        static void Main(string[] args)
        {
            long mseconds = 0;
            Console.WriteLine("Starting data gathering");
            try
            {
                RESTTrainsAndStations restTrainsAndStations =
                    new RESTTrainsAndStations(SERVICE_ROOT,
                        DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                        DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE),
                        USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS);
                mseconds = restTrainsAndStations.handleStationsAndTrains();
                mseconds += DbUtils.PerformTrainsAndStationsSaving(
                    restTrainsAndStations.getTrains(),
                    restTrainsAndStations.getStations());

                restTrainsAndStations.getTrains().Clear();
                restTrainsAndStations.getStations().Clear();

                RESTOthers restOthers = new RESTOthers(SERVICE_ROOT,
                    restTrainsAndStations.getTrainNumbers(),
                    DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                    DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE),
                    USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS);
                mseconds += restOthers.getOthers();
                mseconds += DbUtils.PerformOtherDatabaseSavings(
                    restOthers.getTrainTrackings(),
                    restOthers.getCompositions(),
                    restOthers.getOperators(),
                    restOthers.getCategoryCodes(),
                    restOthers.getDetailedCategoryCodes());

                Console.WriteLine("Data got from http://rata.digitraffic.fi/api/v1 in " + mseconds + " ms.");
            }
            catch (Exception e)
            {
                Console.WriteLine("Exception occured");
                Console.WriteLine("Exception " + e.GetBaseException().ToString() +
                    " Inner exception " + e.InnerException.GetBaseException().ToString());
            }
            Console.ReadLine();
        }
    }
}
