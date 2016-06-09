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

    class Program
    {
        static List<int> trainNumbers = new List<int>();
        static List<DateTime> departureDates = new List<DateTime>();
        static long operationSeconds = 0;

        const string SERVICE_ROOT = "http://rata.digitraffic.fi/api/v1";
        const int COUNT_OF_DAYS_FROM_PAST = 30;
        const int COUNT_OF_DAYS_TO_FUTURE = 10;

        static void Main(string[] args)
        {
            Console.WriteLine("Starting data gathering");
            long mseconds = 0;
            var watch = System.Diagnostics.Stopwatch.StartNew();
            List<Trains> trains = getRESTTrains();
            Console.WriteLine("got " + trains.Count + " trains during initial gathering of trains");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering trains");

            watch = System.Diagnostics.Stopwatch.StartNew();
            gatherTrainNumbersAndDepartureDates(trains);
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering train numbers and departure dates");

            Console.WriteLine("-----------------------------------------------------");

            List<Trains> moreTrains = getRESTTrainsForDateInterval(trainNumbers, 
                DateTime.Now, DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST));
            trains.AddRange(moreTrains);
            Console.WriteLine("got " + moreTrains.Count + " trains when gathering trains for date interval");
            mseconds += operationSeconds;
            Console.WriteLine("Went " + operationSeconds + " ms. gathering trains for date interval");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTSchedulesWithTrainNumbersAndDates(
                trainNumbers, DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE));
            trains.AddRange(moreTrains);
            Console.WriteLine("got " + moreTrains.Count + " trains when gathering schedules for date interval");
            mseconds += operationSeconds;
            Console.WriteLine("Went " + operationSeconds + " ms. gathering schedules for date interval");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTHistorySchedules(
                DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST), DateTime.Now);
            trains.AddRange(moreTrains);
            Console.WriteLine("got " + moreTrains.Count + " trains when gathering history trains for date interval");
            mseconds += operationSeconds;
            Console.WriteLine("Went " + operationSeconds + " ms. gathering history schedules");

            Console.WriteLine("-----------------------------------------------------");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<TrainTracking> trainTrackings = getRESTTrainTrackings();
            Console.WriteLine("got " + trainTrackings.Count + " train trackings when gathering trains trackings");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering train trackings");

            Console.WriteLine("-----------------------------------------------------");

            List<Composition> compositions = 
                getRESTCompositions(DateTime.Now.AddDays(-COUNT_OF_DAYS_FROM_PAST),
                DateTime.Now.AddDays(COUNT_OF_DAYS_TO_FUTURE));
            Console.WriteLine("got " + compositions.Count + " compositions when gathering for date interval");
            mseconds += operationSeconds;
            Console.WriteLine("Went " + operationSeconds + " ms. gathering compositions");

            Console.WriteLine("-----------------------------------------------------");

            watch = System.Diagnostics.Stopwatch.StartNew();
            List<Station> stations = getRESTStations();
            Console.WriteLine("got " + stations.Count + " stations when gathering stations");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering stations");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTSchedules(stations);
            Console.WriteLine("got " + moreTrains.Count + " schedules when gathering trains with stations");
            trains.AddRange(moreTrains);
            mseconds += operationSeconds;
            Console.WriteLine("Went " + operationSeconds + " ms. gathering schedules");

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
            long millis = PerformDatabaseOperations(
                trains,
                trainTrackings,
                compositions,
                stations, 
                operators, 
                categoryCodes, 
                detailedCategoryCodes);
            mseconds += millis;
            Console.WriteLine("Went " + millis + " ms. to save results to database");

            Console.WriteLine("Data got from http://rata.digitraffic.fi/api/v1 in " + mseconds + " ms.");
            Console.ReadLine();
        }

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

        public static List<Trains> getRESTTrainsForDateInterval(
            List<int> trainNumbers,
            DateTime StartDate, DateTime EndDate)
        {
            operationSeconds = 0;
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
                    operationSeconds += watch.ElapsedMilliseconds;
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds + 
                        " ms. to gather trains for train number " + trainNumber +
                        " and date " + dateToRESTDate(day));

                }
            return trains;
        }

        public static List<Trains> getRESTSchedules(List<Station> stations)
        {
            operationSeconds = 0;
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
                    operationSeconds += watch.ElapsedMilliseconds;
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                   " ms. to gather schedules from station " +
                                   departStation.stationShortCode + 
                                   " to station " + arrivalStation.stationShortCode);
                }
            }
            return trains;
        }

        public static List<Trains> getRESTSchedulesWithTrainNumbersAndDates(
            List<int> trainNumbers, DateTime StartDate, DateTime EndDate)
        {
            operationSeconds = 0;
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
                    operationSeconds += watch.ElapsedMilliseconds;
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                   " ms. to gather schedules for train number " + trainNumber +
                                   " and date " + dateToRESTDate(day));
                }
            return trains;
        }

        public static List<Trains> getRESTHistorySchedules(
            DateTime StartDate, DateTime EndDate)
        {
            operationSeconds = 0;
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
                operationSeconds += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                  " ms. to gather history schedules for date " + 
                                  dateToRESTDate(day));
            }
            return trains;
        }

        public static List<Trains> getRESTTrains()
        {
            var client = new RestClient(SERVICE_ROOT + "/live-trains");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Trains>>(request);
            return clientEx.Data;
        }

        public static List<TrainTracking> getRESTTrainTrackings()
        {
            var client = new RestClient(SERVICE_ROOT + "/train-tracking");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<TrainTracking>>(request);
            return clientEx.Data;
        }

        public static List<Composition> getRESTCompositions(DateTime StartDate, DateTime EndDate)
        {
            operationSeconds = 0;
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
                    operationSeconds += watch.ElapsedMilliseconds;
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                      " ms. to gather compositions for train number " + trainNumber + 
                                      " and date " + dateToRESTDate(day));
                }
            }
            return allCompositions;
        }

        public static void gatherTrainNumbersAndDepartureDates(List<Trains> trains)
        {
            foreach(Trains t in trains)
            {
                if (!trainNumbers.Contains(t.trainNumber))
                    trainNumbers.Add(t.trainNumber);
                if (!departureDates.Contains(t.departureDate))
                    departureDates.Add(t.departureDate);
            }
        }

        public static List<Station> getRESTStations()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/stations");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Station>>(request);
            return clientEx.Data;
        }

        public static List<Operator> getRESTOperators()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/operators");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Operator>>(request);
            return clientEx.Data;
        }

        public static List<CategoryCode> getRESTCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<CategoryCode>>(request);
            return clientEx.Data;
        }

        public static List<DetailedCategoryCode> getRESTDetailedCategoryCodes()
        {
            var client = new RestClient(SERVICE_ROOT + "/metadata/detailed-cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<DetailedCategoryCode>>(request);
            return clientEx.Data;
        }

        public static long PerformDatabaseOperations(
            List<Trains> trains, 
            List<TrainTracking> trainTrackings,
            List<Composition> compositions,
            List<Station> stations,
            List<Operator> ops,
            List<CategoryCode> categoryCodes,
            List<DetailedCategoryCode> detailedCategoryCodes)
        {
            long millis = 0;
            using (var db = new TrainsModel())
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();
                db.trains.AddRange(trains);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add trains to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.trainTrackings.AddRange(trainTrackings);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add train trackings to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.compositions.AddRange(compositions);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add compositions to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.stations.AddRange(stations);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add stations to db");

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
