The rata applications (console + ASP.NET Web API) demonstrate, how to

- consume REST service from .NET console applications and ASP.NET Web API applications 
  using REST Sharp and NewtonJSON ( JSON used as the way to transfer content, not XML )
  
  for consuming ASP.NET Wep API REST service see comments just before the 
  method in controller classes. That needs to be prefixed with the localhost:port/ 
  in the browser.
  
  For example in the StationsController, there reads 
  
  // GET: api/Stations
  
  above method 
  
  IQueryable<Station> Getstations([FromUri] bool reload)
  
  where 
  
  [FromUri]
  
  means query parameters in the end of the URI
  
  So if port is 50569 and the data is wanted to be reloaded ( reload=true ),
  put address 
  
  http://localhost:50569/api/Stations?reload=true
  
  The port is something you know only when running the Web API application,
  so replace it to what you get with the initial page address 
  launched to the browser.
  
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
- console application takes about 9 minutes to complete  ( see example_output.txt 
  in RataTrafficGetDataConsole directory, 532206 ms = n. 532 s = n.8,9 min)
  the data gathering and so is possibly also the link to page that reloads data from the service 
  ( there in the web however tables start to fill up when each part gets loaded,
    although some tables may need quite long time. However trains and timetablerows seem not 
	to get to the web for some reason in those big tables: to be fixed later.)  
  The data gathered had to be made for shorter date interval and fewer ways to get train
  information to prevent out of memory exception because it was getting so many train records
  and their related timetablerow records. If for some reasons in less memory etc. environment
  the out of memory exception still occurs, decrease suitably 
  the values of constants COUNT_OF_DAYS_FROM_PAST and COUNT_OF_DAYS_TO_FUTURE in the beginning of 
  Program.cs source code before running.
  
If for some reasons, Visual studio complains about lacking namespaces, etc.
just use menu command Rebuild solution.

Visual Studio projects used NuGet packages like
    NewtonJSON 
    Rest Sharp
    Entity framework
	jquery
	jquery ui
They were installed using NuGet package manager.	
	