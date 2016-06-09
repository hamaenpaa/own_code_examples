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
        static List<int> trainNumbers = new List<int>();
        static List<DateTime> departureDates = new List<DateTime>();
        static long operationmSeconds = 0;
        static long trainsGot = 0;
        static long trainsAdded = 0;
        static List<Trains> gatheredTrains = new List<Trains>();
        static Trains similarTrain = null;
        static bool similarFound = false;

        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        const int COUNT_OF_DAYS_FROM_PAST = 10;
        const int COUNT_OF_DAYS_TO_FUTURE = 10;
        const bool USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS = false;

        static void Main(string[] args)
        {
            long mseconds = 0;
            Console.WriteLine("Starting data gathering");
            mseconds = handleStationsAndTrains();

            var watch = System.Diagnostics.Stopwatch.StartNew();
            List<TrainTracking> trainTrackings = getRESTTrainTrackings();
            Console.WriteLine("got " + trainTrackings.Count + " train trackings when gathering trains trackings");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering train trackings");

            Console.WriteLine("-----------------------------------------------------");

            List<Composition> compositions = 
                getRESTCompositions(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE));
            Console.WriteLine("got " + compositions.Count + 
                " compositions when gathering for date interval " +
                dateToRESTDate(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST)) + " - " +
                dateToRESTDate(DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE)));
            mseconds += operationmSeconds;
            Console.WriteLine("Went " + operationmSeconds + " ms. gathering compositions");

            Console.WriteLine("-----------------------------------------------------");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<Operator> operators = getRESTOperators();
            Console.WriteLine("got " + operators.Count + " operators when gathering operators");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering operators");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<CategoryCode> categoryCodes = getRESTCategoryCodes();
            Console.WriteLine("got " + categoryCodes.Count + " category codes when gathering category codes");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering category codes");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<DetailedCategoryCode> detailedCategoryCodes = getRESTDetailedCategoryCodes();
            Console.WriteLine("got " + detailedCategoryCodes.Count + " detailed category codes when gathering detailed category codes");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering detailed category codes");

            watch = System.Diagnostics.Stopwatch.StartNew();
            long millis = PerformOtherDatabaseSavings(
                trainTrackings,
                compositions,
                operators, 
                categoryCodes, 
                detailedCategoryCodes);
            mseconds += millis;
            Console.WriteLine("Went " + millis + " ms. to save other results to database");

            Console.WriteLine("Data got from http://rata.digitraffic.fi/api/v1 in " + mseconds + " ms.");
            Console.ReadLine();
        }

        /********************************** utils *************************************/

        private static IEnumerable<DateTime> EachDay(DateTime from, DateTime thru)
        {
            for (var day = from.Date; day.Date <= thru.Date; day = day.AddDays(1))
                yield return day;
        }

        private static string dateToRESTDate(DateTime date)
        {
            string sMonth = date.Month.ToString();
            if (sMonth.Length == 1) sMonth = "0" + sMonth;
            string sDay = date.Day.ToString();
            if (sDay.Length == 1) sDay = "0" + sDay;
            return date.Year + "-" + sMonth + "-" + sDay;
        }

        /************************ trains and stations begin ****************************/

        public static long handleStationsAndTrains()
        {
            long mseconds = 0;
            long gatheringmSeconds = 0;
            var watch = System.Diagnostics.Stopwatch.StartNew();
            gatheredTrains = getRESTTrains();
            Console.WriteLine("got " + gatheredTrains.Count + " trains during initial gathering of trains");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering trains");

            watch = System.Diagnostics.Stopwatch.StartNew();
            gatherTrainNumbersAndDepartureDates(gatheredTrains);
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + 
                " ms. gathering train numbers and departure dates");
            Console.WriteLine("Got " + trainNumbers.Count + " train numbers.");

            Console.WriteLine("-----------------------------------------------------");

            List<Trains> moreTrains = getRESTTrainsForDateInterval(trainNumbers,
                DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded +  
                " trains when gathering trains for date interval " +
                dateToRESTDate(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST)) + " - " +
                dateToRESTDate(DateTime.Now));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) + 
                " ms. gathering trains for date interval");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTSchedulesWithTrainNumbersAndDates(
                trainNumbers, DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE));
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded + 
                " trains when gathering schedules for date interval " +
                dateToRESTDate(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST)) + " - " +
                dateToRESTDate(DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE)));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) + 
                " ms. gathering schedules for date interval");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTHistorySchedules(
                DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded + 
                " trains when gathering history trains for date interval " +
                dateToRESTDate(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST)) + " - " +
                dateToRESTDate(DateTime.Now));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) + 
                " ms. gathering history schedules");

            Console.WriteLine("-----------------------------------------------------");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<Station> stations = getRESTStations();
            Console.WriteLine("got " + stations.Count + " stations when gathering stations");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering stations");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTSchedules(stations);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded + 
                " schedules when gathering trains with stations");
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) + " ms. gathering schedules");
            moreTrains.Clear();
            Console.WriteLine("-----------------------------------------------------");

            operationmSeconds = PerformTrainsAndStationsSaving(gatheredTrains, stations);
            mseconds += operationmSeconds;
            Console.WriteLine("Went " + operationmSeconds + " ms. to save trains and stations");

            Console.WriteLine("-----------------------------------------------------");
            return mseconds;
        }

        private static long versionOfSimilar(Trains t)
        {
            long version = -1;
            similarTrain = null;
            similarFound = false;
            foreach (Trains gt in gatheredTrains)
            {
                if (gt.departureDate.Equals(t.departureDate) &&
                    gt.trainNumber == t.trainNumber)
                {
                    similarFound = true;
                    version = gt.version;
                    similarTrain = gt;
                    break;
                }
            }
            return version;
        }

        private static long addToTrainsAndRemoveAlreadyExisting(List<Trains> trains)
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            trainsGot = trains.Count;
            trainsAdded = 0;
            List<Trains> toBeRemoved = new List<Trains>();

            foreach(Trains t in trains)
            {
                long similarVersion = versionOfSimilar(t);
                if (similarVersion < t.version && similarVersion != -1 && similarFound &&
                    similarTrain != null)
                    gatheredTrains.Remove(similarTrain);
                else if (similarVersion != -1 && similarTrain != null && similarFound &&
                    similarVersion > t.version)
                    toBeRemoved.Add(t);
                else
                    trainsAdded++;
            }
            foreach (Trains tr in toBeRemoved)
                trains.Remove(tr);
            gatheredTrains.AddRange(trains);
            return watch.ElapsedMilliseconds;
        }

        private static List<Trains> getRESTTrainsForDateInterval(
            List<int> trainNumbers, DateTime StartDate, DateTime EndDate)
        {
            operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (int trainNumber in trainNumbers)
                foreach (DateTime day in EachDay(StartDate, EndDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(SERVICE_ROOT +
                        "/live-trains/" + trainNumber + "?departure_date=" +
                        dateToRESTDate(day));
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    trains.AddRange(clientEx.Data);
                    operationmSeconds += watch.ElapsedMilliseconds;
                    if (USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS == true)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                            " ms. to gather trains for train number " + trainNumber +
                            " and date " + dateToRESTDate(day));
                }
            return trains;
        }

        private static List<Trains> getRESTSchedules(List<Station> stations)
        {
            operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (Station departStation in stations)
            {
                foreach(Station arrivalStation in stations)
                {
                    if (arrivalStation.id == departStation.id)
                        continue;
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(SERVICE_ROOT +
                        "/schedules/" + 
                        "?departure_station=" + departStation.stationShortCode + 
                        "&arrival_station=" + arrivalStation.stationShortCode
                        );
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    trains.AddRange(clientEx.Data);
                    operationmSeconds += watch.ElapsedMilliseconds;
                    if (USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS == true)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                   " ms. to gather schedules from station " +
                                   departStation.stationShortCode +
                                   " to station " + arrivalStation.stationShortCode);
                }
            }
            return trains;
        }

        private static List<Trains> getRESTSchedulesWithTrainNumbersAndDates(
            List<int> trainNumbers, DateTime StartDate, DateTime EndDate)
        {
            operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (int trainNumber in trainNumbers)
                foreach (DateTime day in EachDay(StartDate, EndDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(SERVICE_ROOT +
                        "/schedules/" + trainNumber + "?departure_date=" +
                         dateToRESTDate(day));
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    trains.AddRange(clientEx.Data);
                    operationmSeconds += watch.ElapsedMilliseconds;
                    if (USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS == true)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                   " ms. to gather schedules for train number " + trainNumber +
                                   " and date " + dateToRESTDate(day));
                }
            return trains;
        }

        private static List<Trains> getRESTHistorySchedules(DateTime StartDate, DateTime EndDate)
        {
            operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (DateTime day in EachDay(StartDate, EndDate))
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();
                var client = new RestClient(SERVICE_ROOT +
                    "/history?departure_date=" +
                    dateToRESTDate(day));
                var request = new RestRequest(Method.GET);
                request.AddHeader("accept", "application/json");
                request.RequestFormat = DataFormat.Json;
                var clientEx = client.Execute<List<Trains>>(request);
                trains.AddRange(clientEx.Data);
                operationmSeconds += watch.ElapsedMilliseconds;
                if (USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS == true)
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                  " ms. to gather history schedules for date " + 
                                  dateToRESTDate(day));
            }
            return trains;
        }

        private static List<Trains> getRESTTrains()
        {
            var client = new RestClient(SERVICE_ROOT + "/live-trains");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Trains>>(request);
            return clientEx.Data;
        }

        private static void gatherTrainNumbersAndDepartureDates(List<Trains> trains)
        {
            foreach (Trains t in trains)
            {
                if (!trainNumbers.Contains(t.trainNumber))
                    trainNumbers.Add(t.trainNumber);
                if (!departureDates.Contains(t.departureDate))
                    departureDates.Add(t.departureDate);
            }
        }

        private static List<Station> getRESTStations()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/stations");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Station>>(request);
            return clientEx.Data;
        }

        private static long PerformTrainsAndStationsSaving(List<Trains> trains, List<Station> stations)
        {
            long millis = 0;
            using (var db = new TrainsModel())
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();
                foreach (Trains t in db.trains)
                    db.trains.Remove(t);
                foreach (TimeTableRow ttr in db.timeTableRows)
                    db.timeTableRows.Remove(ttr);
                foreach (Cause c in db.causes)
                    db.causes.Remove(c);
                foreach (Station s in db.stations)
                    db.stations.Remove(s);
                db.SaveChanges();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + 
                    " ms. to remove old train data from database");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.trains.AddRange(trains);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add trains to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                trains.Clear();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to clear trains collection");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.stations.AddRange(stations);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add stations to db");
            }
            return millis;
        }

        /************************ trains and stations end ****************************/

        private static List<TrainTracking> getRESTTrainTrackings()
        {
            var client = new RestClient(SERVICE_ROOT + "/train-tracking");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<TrainTracking>>(request);
            return clientEx.Data;
        }

        private static List<Composition> getRESTCompositions(DateTime StartDate, DateTime EndDate)
        {
            operationmSeconds = 0;
            List<Composition> allCompositions = new List<Composition>();
            foreach(int trainNumber in trainNumbers)
            {
                foreach (DateTime day in EachDay(StartDate, EndDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    String connString = SERVICE_ROOT + "/compositions/" + trainNumber +
                        "?departure_date=" + dateToRESTDate(day);
                    var client = new RestClient(connString);
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    List<Composition> partCompositions =
                         client.Execute<List<Composition>>(request).Data;
                    allCompositions.AddRange(partCompositions);
                    operationmSeconds += watch.ElapsedMilliseconds;
                    if (USE_DAY_STATION_OR_NUMBER_LEVEL_TIME_MEASUREMENT_LOGS == true)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                      " ms. to gather compositions for train number " + trainNumber + 
                                      " and date " + dateToRESTDate(day));
                }
            }
            return allCompositions;
        }

        private static List<Operator> getRESTOperators()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/operators");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Operator>>(request);
            return clientEx.Data;
        }

        private static List<CategoryCode> getRESTCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<CategoryCode>>(request);
            return clientEx.Data;
        }

        private static List<DetailedCategoryCode> getRESTDetailedCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/detailed-cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<DetailedCategoryCode>>(request);
            return clientEx.Data;
        }

        private static long PerformOtherDatabaseSavings(
            List<TrainTracking> trainTrackings,
            List<Composition> compositions,
            List<Operator> ops,
            List<CategoryCode> categoryCodes,
            List<DetailedCategoryCode> detailedCategoryCodes)
        {
            long millis = 0;
            using (var db = new TrainsModel())
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();
                foreach (TrainTracking tt in db.trainTrackings)
                    db.trainTrackings.Remove(tt);
                foreach (Composition c in db.compositions)
                    db.compositions.Remove(c);
                foreach (Operator o in db.ops)
                    db.ops.Remove(o);
                foreach (CategoryCode cc in db.categoryCodes)
                    db.categoryCodes.Remove(cc);
                foreach (DetailedCategoryCode dcc in db.detailedCategoryCodes)
                    db.detailedCategoryCodes.Remove(dcc);
                db.SaveChanges();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                    " ms. to remove old other data than train data from database");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.trainTrackings.AddRange(trainTrackings);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add train trackings to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.compositions.AddRange(compositions);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add compositions to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.ops.AddRange(ops);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add operators to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.categoryCodes.AddRange(categoryCodes);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add category codes to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.detailedCategoryCodes.AddRange(detailedCategoryCodes);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add detailed category codes to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.SaveChanges();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to save changes to db");
            }
            return millis;
        }
    }
}
