namespace RataRESTWebAPI.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<RataRESTWebAPI.Models.TrainsModel>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
            ContextKey = "RataRESTWebAPI.Models.TrainsModel";
        }

        protected override void Seed(RataRESTWebAPI.Models.TrainsModel context)
        {
            /*var query = from t in context.trains                      
                        select t;
            foreach (Trains t in query)
                context.trains.Add(t);*/

            //            context.trains.
            /*            var tr = from t in context.trains select t;
                        context.trains = tr.ToList;*/


            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
        }
    }
}
