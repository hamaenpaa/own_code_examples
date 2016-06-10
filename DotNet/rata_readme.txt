The rata applications (console + ASP.NET Web API) demonstrate, how to

- consume REST service from .NET console applications and ASP.NET Web API applications 
  using REST Sharp and NewtonJSON ( JSON used as the way to transfer content, not XML )
- use entity framework to save or query data from local SQL server
  (used contact parameters for database: server (localdb)\MSSQLLocalDB, 
   database: Trains). The console application should create the database itself
   when runned.
- use Web API to give REST responses to HTML pages using jQuery to fetch data in
  JSON format and show the results in HTML tables.
- some trials for fetching DTOs ( data access objects, not entities ) to HTML page
  using Web API ( station information taken that way ) in route seeking page.
  There exist some initial development also for seeking routes based on 
  criteria user gives at web page and TimeTableRow table data in database.
  That development did not get ready and so its launching is commented out 
  but there exists some ideas anyway.
- console application takes about half an hour to complete the data gathering and
  so is possibly also the link to page that reloads data from the service 
  ( there in the web however tables start to fill up when each part gets loaded,
    although some tables may need quite long time )  
  
If for some reasons, Visual studio complains about lacking namespaces, etc.
just use menu command Rebuild solution.

Visual Studio projects used NuGet packages like
    NewtonJSON 
    Rest Sharp
    Entity framework
	jquery
	jquery ui
They were installed using NuGet package manager.	
	