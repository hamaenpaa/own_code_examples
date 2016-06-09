using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RataTrafficGetDataConsole
{
    public class DbUtils
    {
        public static long PerformTrainsAndStationsSaving(List<Trains> trains, List<Station> stations)
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

                Console.WriteLine("Adding " + trains.Count + " trains to database");
                watch = System.Diagnostics.Stopwatch.StartNew();
                db.trains.AddRange(trains);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add trains to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.stations.AddRange(stations);
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to add stations to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                db.SaveChanges();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to save trains related data to db");

                watch = System.Diagnostics.Stopwatch.StartNew();
                trains.Clear();
                millis += watch.ElapsedMilliseconds;
                Console.WriteLine("Went " + watch.ElapsedMilliseconds + " ms. to clear trains collection");
            }
            return millis;
        }

        public static long PerformOtherDatabaseSavings(
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
            Console.WriteLine("Went " + millis + " ms. to save other results to database");
            return millis;
        }
    }
}
