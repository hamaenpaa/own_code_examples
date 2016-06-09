using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RestSharp;

namespace RataTrafficGetDataConsole
{
    public class RESTOthers
    {
        private string serviceRoot = "";
        private List<int> trainNumbers;
        private bool useDeepTimeMeasurementMsgs;
        private DateTime beginDate;
        private DateTime endDate;

        private List<TrainTracking> trainTrackings;
        private List<Composition> compositions;
        private List<Operator> operators;
        private List<CategoryCode> categoryCodes;
        private List<DetailedCategoryCode> detailedCategoryCodes;

        public RESTOthers(string serviceRoot,
            List<int> trainNumbers, DateTime beginDate, DateTime endDate,
            bool useDeepTimeMeasurementMsgs)
        {
            this.serviceRoot = serviceRoot;
            this.trainNumbers = trainNumbers;
            this.beginDate = beginDate;
            this.endDate = endDate;
            this.useDeepTimeMeasurementMsgs = useDeepTimeMeasurementMsgs;
        }

        public long getOthers()
        {
            long mseconds = getRESTTrainTrackings();
            mseconds += getRESTCompositions();
            mseconds += getRESTOperators();
            mseconds += getRESTCategoryCodes();
            mseconds += getRESTDetailedCategoryCodes();
            Console.WriteLine("Went " + mseconds + " ms. to gather other than train related data");
            return mseconds;
        }

        private long getRESTTrainTrackings()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            var client = new RestClient(this.serviceRoot + "/train-tracking");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<TrainTracking>>(request);
            trainTrackings = clientEx.Data;
            Console.WriteLine("got " + trainTrackings.Count + " train trackings when gathering trains trackings");
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering train trackings");
            return watch.ElapsedMilliseconds;
        }

        private long getRESTCompositions()
        {
            Console.WriteLine("-----------------------------------------------------");
            long operationmSeconds = 0;
            this.compositions = new List<Composition>();
            foreach (int trainNumber in trainNumbers)
            {
                foreach (DateTime day in Utils.EachDay(this.beginDate, this.endDate))
                {
                    var watch = System.Diagnostics.Stopwatch.StartNew();
                    String connString = this.serviceRoot + "/compositions/" + trainNumber +
                        "?departure_date=" + Utils.dateToRESTDate(day);
                    var client = new RestClient(connString);
                    var request = new RestRequest(Method.GET);
                    request.AddHeader("accept", "application/json");
                    request.RequestFormat = DataFormat.Json;
                    List<Composition> partCompositions =
                         client.Execute<List<Composition>>(request).Data;
                    this.compositions.AddRange(partCompositions);
                    operationmSeconds += watch.ElapsedMilliseconds;
                    if (this.useDeepTimeMeasurementMsgs)
                        Console.WriteLine("Went " + watch.ElapsedMilliseconds +
                                      " ms. to gather compositions for train number " + trainNumber +
                                      " and date " + Utils.dateToRESTDate(day));
                }
            }
            Console.WriteLine("Went " + operationmSeconds + " ms. gathering compositions");
            Console.WriteLine("-----------------------------------------------------");
            return operationmSeconds;
        }

        private long getRESTOperators()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            var client = new RestClient(this.serviceRoot + "/metadata/operators");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<Operator>>(request);
            this.operators = clientEx.Data;
            Console.WriteLine("got " + operators.Count + " operators when gathering operators");
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering operators");
            return watch.ElapsedMilliseconds;
        }

        private long getRESTCategoryCodes()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            var client = new RestClient(this.serviceRoot + "/metadata/cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<CategoryCode>>(request);
            this.categoryCodes = clientEx.Data;
            Console.WriteLine("got " + operators.Count + " category codes when gathering category codes");
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering category codes");
            return watch.ElapsedMilliseconds;
        }

        private long getRESTDetailedCategoryCodes()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            var client = new RestClient(this.serviceRoot + "/metadata/detailed-cause-category-codes");
            var request = new RestRequest(Method.GET);
            request.AddHeader("accept", "application/json");
            request.RequestFormat = DataFormat.Json;
            var clientEx = client.Execute<List<DetailedCategoryCode>>(request);
            this.detailedCategoryCodes = clientEx.Data;
            Console.WriteLine("got " + operators.Count + " detailed category codes when gathering detailed category codes");
            Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. gathering detailed category codes");
            return watch.ElapsedMilliseconds;
        }

        public List<TrainTracking> getTrainTrackings()
        {
            return this.trainTrackings;
        }

        public List<Composition> getCompositions()
        {
            return this.compositions;
        }

        public List<Operator> getOperators()
        {
            return this.operators;
        }

        public List<CategoryCode> getCategoryCodes()
        {
            return this.categoryCodes;
        }

        public List<DetailedCategoryCode> getDetailedCategoryCodes()
        {
            return this.detailedCategoryCodes;
        }
    }
}
