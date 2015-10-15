<html>
   <head><title>title</title></head>
<body>
<?php
   DEFINE('DB_USER','username');
   DEFINE('DB_PASSWORD','password');
   DEFINE('DB_HOST','localhost');
   DEFINE('DB_NAME','sitename');

   function tryMySQLIConn()
   {
   echo 'DB_USER'.DB_USER.',DB_PASSWORD='.DB_PASSWORD.',DB_HOST='.DB_HOST.',DB_NAME='.DB_NAME."<br>";
   $dbc = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
     OR die('Could not connect to MySQL: '. mysqli_connect_error());
   echo "connect performed2<br>";
   $q = "SELECT COUNT(*) FROM users";
   echo "query q = ".$q ."<br>";
   $r = @mysqli_query($dbc, $q); 
   if ($r)
   {
   	  echo "result found<br>";
      $row = mysqli_fetch_array($r);
      if ($row) echo "count = " .$row[0] ."<br>"; else echo "Could not find row<br>";
   }
   else
   {
   	  echo "result not found<br>";
   }
   mysqli_close($dbc);
   echo "connection closed<br>";
   }
   
   function tryMySQLConn()
   {
   	  print "hereuu3";
   	  echo 'DB_USER'.DB_USER.',DB_PASSWORD='.DB_PASSWORD.',DB_HOST='.DB_HOST.',DB_NAME='.DB_NAME;
   	  $dbc = mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);
      /* $dbc = mysql_connect(DB_HOST,DB_USER,DB_PASSWORD);*/
      print "connected";
      mysql_select_db(DB_NAME,$dbc);
      print "db selected";
      $q = "SELECT COUNT(*) FROM users";
      print "q = ".$q;
      $r = mysql_query($q, $dbc);
      print "query done";
      if ($r)
      if ($row = mysql_fetch_array($r))
         echo "count = ".$row[0];
      else echo "no row found\n";
      mysql_close($dbc); 
      print "connection closed";  	
   }
   
   /* tryMySQLConn();*/
   tryMySQLIConn();
?>
</body>
</html>