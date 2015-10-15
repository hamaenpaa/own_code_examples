<?php
   function MySQLConnect($server="localhost",$dbname="",$user="admin",$passwd="admin")
   {
   	   $conn = mysql_connect($server,$user,$passwd);
   	   if ($dbname != "") mysql_select_db($dbname,$conn);
   	   return $conn;
   }
   
   function Query($sql,$conn)
   {
   	  $res = mysql_query($conn,$sql);
   	  return $res;
   }
?>