<?php
   define(IN_FORMTEXT,"ei ole p�iv�ys muodossa pp.kk.vvvv");
   function daysbetween($db,$mb,$yb,$de,$dm,$ye)
   {
   	 $timebegin = mktime(0,0,0,$mb,$db,$yb);
   	 $timeend = mktime(0,0,0,$me,$de,$ye);
   	 return ($timebegin - $timeend) / 86400;
   }

   list($db,$mb,$yb) = explode(".",$_POST['begindate']);
   list($de,$me,$ye) = explode(".",$_POST['enddate']);
   if (checkdate($mb,$db,$yb) == false)
   	  print "Alkup�iv� " . $_POST['begindate'] .
   	       IN_FORMTEXT . "<br>";   	   
   else if (checkdate($me,$de,$ye) == false)
   	  print "Loppup�iv� " . $_POST['enddate'] . 
   	       IN_FORMTEXT . "<br>";
   else
   {
	   print "Annoit aloitusp�iv�ksi " . $_POST['begindate']."<br>";
	   print "ja lopetusp�iv�ksi = " . $_POST['enddate']."<br>";
	   print "Niiden v�lill� on " .  
	         daysbetween($db,$mb,$yb,$de,$dm,$ye).
	         " p�iv��";
   }


?>