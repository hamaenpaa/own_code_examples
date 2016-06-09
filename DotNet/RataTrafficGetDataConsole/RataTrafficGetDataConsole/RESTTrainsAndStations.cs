using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RestSharp;

namespace RataTrafficGetDataConsole
{
    public class RESTTrainsAndStations
    {
        private string serviceRoot = "";
        private DateTime beginDate;
        private DateTime endDate;
        private bool useDeepTimeMeasurementMsgs = false;

        private List<Trains> gatheredTrains = new List<Trains>();
        private List<Station> stations = new List<Station>();
        private long operationmSeconds;
        private int trainsGot;
        private int trainsAdded;
        private List<int> trainNumbers = new List<int>();
        private Trains similarTrain = null;
        private bool similarFound = false;

        public RESTTrainsAndStations(string serviceRoot, DateTime beginDate, DateTime endDate,
            bool useDeepTimeMeasurementMsgs)
        {
            this.serviceRoot = serviceRoot;
            this.beginDate = beginDate;
            this.endDate = endDate;
            this.useDeepTimeMeasurementMsgs = useDeepTimeMeasurementMsgs;
        }

        public long handleStationsAndTrains()
        {
            long mseconds = 0;
            long gatheringmSeconds = 0;
            var watch = System.Diagnostics.Stopwatch.StartNew();
            gatheredTrains = getRESTTrains();
            Console.WriteLine("got " + gatheredTrains.Count + " trains during initial gathering of trains");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering trains");

            watch = System.Diagnostics.Stopwatch.StartNew();
            gatherTrainNumbers(gatheredTrains);
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                " ms. gathering train numbers and departure dates");
            Console.WriteLine("Got " + trainNumbers.Count + " train numbers.");

            Console.WriteLine("-----------------------------------------------------");

            List<Trains> moreTrains = getRESTTrainsForDateInterval(trainNumbers,
                beginDate, DateTime.Now);
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded +
                " trains when gathering trains for date interval " +
                Utils.dateToRESTDate(beginDate) + " - " +
                Utils.dateToRESTDate(DateTime.Now));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) +
                " ms. gathering trains for date interval");

            Console.WriteLine("-----------------------------------------------------");

            moreTrains = getRESTSchedulesWithTrainNumbersAndDates(
                trainNumbers, beginDate, endDate);
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded +
                " trains when gathering schedules for date interval " +
                Utils.dateToRESTDate(beginDate) + " - " + Utils.dateToRESTDate(endDate));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) +
                " ms. gathering schedules for date interval");

            Console.WriteLine("-----------------------------------------------------");

       /*     moreTrains = getRESTHistorySchedules(beginDate, DateTime.Now);
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded +
                " trains when gathering history trains for date interval " +
                Utils.dateToRESTDate(beginDate) + " - " + Utils.dateToRESTDate(DateTime.Now));
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) +
                " ms. gathering history schedules");

            Console.WriteLine("-----------------------------------------------------");*/

            watch = System.Diagnostics.Stopwatch.StartNew();
            stations = getRESTStations();
            Console.WriteLine("got " + stations.Count + " stations when gathering stations");
            mseconds += watch.ElapsedMilliseconds;
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering stations");

            /*
            Console.WriteLine("-----------------------------------------------------");
            
            moreTrains = getRESTSchedules(stations);
            Console.WriteLine("got " + trainsGot + " and added " + trainsAdded +
                " schedules when gathering trains with stations");
            gatheringmSeconds = addToTrainsAndRemoveAlreadyExisting(moreTrains);
            mseconds += operationmSeconds + gatheringmSeconds;
            Console.WriteLine("Went " + (operationmSeconds + gatheringmSeconds) + " ms. gathering schedules");*/
            moreTrains.Clear();
            Console.WriteLine("-----------------------------------------------------");
            Console.WriteLine("Went " + mseconds + " ms. to gather train related information");
            return mseconds;
        }

        private long versionOfSimilar(Trains t)
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

        private long addToTrainsAndRemoveAlreadyExisting(List<Trains> trains)
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            trainsGot = trains.Count;
            trainsAdded = 0;
            List<Trains> toBeRemoved = new List<Trains>();
            foreach (Trains t in trains)
            {
                long similarVersion = versionOfSimilar(t);
                if (similarVersion < t.version && similarVersion != -1 && this.similarFound &&
                    this.similarTrain != null)
                    this.gatheredTrains.Remove(this.similarTrain);
                else if (similarVersion != -1 && this.similarTrain != null && this.similarFound &&
                    similarVersion > t.version)
                    toBeRemoved.Add(t);
                else
                    trainsAdded++;
            }
            foreach (Trains tr in toBeRemoved)
                trains.Remove(tr);
            this.gatheredTrains.AddRange(trains);
            return watch.ElapsedMilliseconds;
        }

        private List<Trains> getRESTTrainsForDateInterval(
            List<int> trainNumbers, DateTime StartDate, DateTime EndDate)
        {
            this.operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (int trainNumber in trainNumbers)
                foreach (DateTime day in Utils.EachDay(StartDate, EndDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(this.serviceRoot +
                        "/live-trains/" + trainNumber + "?departure_date=" +
                        Utils.dateToRESTDate(day));
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    if (clientEx.ErrorException != null)
                    {
                        const string message = "Error retrieving live trains response.  Check inner details for more info.";
                        var twilioException = new ApplicationException(message, clientEx.ErrorException);
                        throw twilioException;
                    }
                    trains.AddRange(clientEx.Data);
                    this.operationmSeconds += watch.ElapsedMilliseconds;
                    if (useDeepTimeMeasurementMsgs)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                            " ms. to gather trains for train number " + trainNumber +
                            " and date " + Utils.dateToRESTDate(day));
                }
            return trains;
        }

        private List<Trains> getRESTSchedules(List<Station> stations)
        {
            this.operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (Station departStation in stations)
            {
                foreach (Station arrivalStation in stations)
                {
                    if (arrivalStation.id == departStation.id)
                        continue;
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(this.serviceRoot +
                        "/schedules/" +
                        "?departure_station=" + departStation.stationShortCode +
                        "&arrival_station=" + arrivalStation.stationShortCode
                    );
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    if (clientEx.ErrorException != null)
                    {
                        const string message = "Error retrieving schedules response.  Check inner details for more info.";
                        var twilioException = new ApplicationException(message, clientEx.ErrorException);
                        throw twilioException;
                    }
                    trains.AddRange(clientEx.Data);
                    this.operationmSeconds += watch.ElapsedMilliseconds;
                    if (useDeepTimeMeasurementMsgs)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                            " ms. to gather schedules from station " +
                            departStation.stationShortCode +
                            " to station " + arrivalStation.stationShortCode);
                }
            }
            return trains;
        }

        private List<Trains> getRESTSchedulesWithTrainNumbersAndDates(
            List<int> trainNumbers, DateTime StartDate, DateTime EndDate)
        {
            this.operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (int trainNumber in trainNumbers)
                foreach (DateTime day in Utils.EachDay(StartDate, EndDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    var client = new RestClient(this.serviceRoot +
                        "/schedules/" + trainNumber + "?departure_date=" +
                        Utils.dateToRESTDate(day));
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    var clientEx = client.Execute<List<Trains>>(request);
                    if (clientEx.ErrorException != null)
                    {
                        const string message = "Error retrieving schedules response.  Check inner details for more info.";
                        var twilioException = new ApplicationException(message, clientEx.ErrorException);
                        throw twilioException;
                    }
                    trains.AddRange(clientEx.Data);
                    this.operationmSeconds += watch.ElapsedMilliseconds;
                    if (useDeepTimeMeasurementMsgs)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                            " ms. to gather schedules for train number " + trainNumber +
                            " and date " + Utils.dateToRESTDate(day));
                }
            return trains;
        }

        private List<Trains> getRESTHistorySchedules(DateTime StartDate, DateTime EndDate)
        {
            this.operationmSeconds = 0;
            List<Trains> trains = new List<Trains>();
            foreach (DateTime day in Utils.EachDay(StartDate, EndDate))
            {
                var watch = System.Diagnostics.Stopwatch.StartNew();
                var client = new RestClient(this.serviceRoot +
                    "/history?departure_date=" +
                    Utils.dateToRESTDate(day));
                var request = new RestRequest(Method.GET);
                request.AddHeader("accept", "application/json");
                request.RequestFormat = DataFormat.Json;
                var clientEx = client.Execute<List<Trains>>(request);
                if (clientEx.ErrorException != null)
                {
                    const string message = "Error retrieving history schedules response.  Check inner details for more info.";
                    var twilioException = new ApplicationException(message, clientEx.ErrorException);
                    throw twilioException;
                }
                trains.AddRange(clientEx.Data);
                operationmSeconds += watch.ElapsedMilliseconds;
                if (useDeepTimeMeasurementMsgs)
                    Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                        " ms. to gather history schedules for date " + Utils.dateToRESTDate(day));
            }
            return trains;
        }

        private List<Trains> getRESTTrains()
        {
            var client = new RestClient(this.serviceRoot + "/live-trains");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Trains>>(request);
            if (clientEx.ErrorException != null)
            {
                const string message = "Error retrieving trains response.  Check inner details for more info.";
                var twilioException = new ApplicationException(message, clientEx.ErrorException);
                throw twilioException;
            }
            return clientEx.Data;
        }

        private void gatherTrainNumbers(List<Trains> trains)
        {
            foreach (Trains t in trains)
                if (!trainNumbers.Contains(t.trainNumber))
                    trainNumbers.Add(t.trainNumber);
        }

        private List<Station> getRESTStations()
        {
            var client = new RestClient(this.serviceRoot + "/metadata/stations");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Station>>(request);
            if (clientEx.ErrorException != null)
            {
                const string message = "Error retrieving stations response.  Check inner details for more info.";
                var twilioException = new ApplicationException(message, clientEx.ErrorException);
                throw twilioException;
            }
            return clientEx.Data;
        }

        public List<Trains> getTrains()
        {
            return this.gatheredTrains;
        }

        public List<Station> getStations()
        {
            return this.stations;
        }

        public List<int> getTrainNumbers()
        {
            return this.trainNumbers;
        }
    }
}
