namespace RataRESTWebAPI.Models
{
    using System;
    using System.Linq;
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    public class TrainsModel : DbContext
    {
        // Your context has been configured to use a 'TrainsModel' connection string from your application's 
        // configuration file (App.config or Web.config). By default, this connection string targets the 
        // 'RataTrafficGetDataConsole.TrainsModel' database on your LocalDb instance. 
        // 
        // If you wish to target a different database and/or database provider, modify the 'TrainsModel' 
        // connection string in the application configuration file.
        public TrainsModel()
            : base("name=TrainsModel")
        {

            // Database.SetInitializer<TrainsModel>(new ProductDbInitializer()); }
        }

        // Add a DbSet for each entity type that you want to include in your model. For more information 
        // on configuring and using a Code First model, see http://go.microsoft.com/fwlink/?LinkId=390109.

        public virtual DbSet<Trains> trains { get; set; }
        public virtual DbSet<Station> stations { get; set; }
        public virtual DbSet<TimeTableRow> timeTableRows { get; set; }
        public virtual DbSet<Cause> causes { get; set; }
        public virtual DbSet<Operator> ops { get; set; }
        public virtual DbSet<CategoryCode> categoryCodes { get; set; }
        public virtual DbSet<DetailedCategoryCode> detailedCategoryCodes { get; set; }
        public virtual DbSet<TrainTracking> trainTrackings { get; set; }
        public virtual DbSet<Composition> compositions { get; set; }
        public virtual DbSet<Locomotive> locomotives { get; set; }
        public virtual DbSet<Wagon> wagons { get; set; }
        public virtual DbSet<JourneySection> JourneySections { get; set; }
        public virtual DbSet<TrainNumbers> TrainNumbers { get; set; }


        // protected override void OnModelCreating(DbModelBuilder modelBuilder)
        // {
        //     Database.SetInitializer<TrainsModel>(new DropCreateIfChangeInitializer());
            // Configure Code First to ignore PluralizingTableName convention 
            // If you keep this convention then the generated tables will have pluralized names. 
            // modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        // }

    }

    public class DropCreateIfChangeInitializer : DropCreateDatabaseIfModelChanges<TrainsModel>
    {
        protected override void Seed(TrainsModel context)
        {
/*            var query = from t in context.trains select t;
            foreach (Trains t in query)
                context.trains.Add(t);
            var query2 = from ttr in context.timeTableRows select ttr;
            foreach (TimeTableRow ttr in query2)
                context.timeTableRows.Add(ttr);
            var query3 = from c in context.causes select c;
            foreach (Cause c in query3)
                context.causes.Add(c);
*/


            //            context.Seed(context);
           //  context.trains.Add(context.trains.Find(1));
            base.Seed(context);
            
        }
    }

}