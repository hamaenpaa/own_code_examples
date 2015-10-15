<?php
   define(IN_FORMTEXT,"ei ole päiväys muodossa pp.kk.vvvv");
   function daysbetween($db,$mb,$yb,$de,$dm,$ye)
   {
   	 $timebegin = mktime(0,0,0,$mb,$db,$yb);
   	 $timeend = mktime(0,0,0,$me,$de,$ye);
   	 return ($timebegin - $timeend) / 86400;
   }

   list($db,$mb,$yb) = explode(".",$_POST['begindate']);
   list($de,$me,$ye) = explode(".",$_POST['enddate']);
   if (checkdate($mb,$db,$yb) == false)
   	  print "Alkupäivä " . $_POST['begindate'] .
   	       IN_FORMTEXT . "<br>";   	   
   else if (checkdate($me,$de,$ye) == false)
   	  print "Loppupäivä " . $_POST['enddate'] . 
   	       IN_FORMTEXT . "<br>";
   else
   {
	   print "Annoit aloituspäiväksi " . $_POST['begindate']."<br>";
	   print "ja lopetuspäiväksi = " . $_POST['enddate']."<br>";
	   print "Niiden välillä on " .  
	         daysbetween($db,$mb,$yb,$de,$dm,$ye).
	         " päivää";
   }


?>