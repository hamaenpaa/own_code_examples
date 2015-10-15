<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Multidimensional arrays</title>
   </head>
   <body>
      <p>Some North American States, Provinces and Territories:</p>
      <?php
         // create item arrays
         $mexico = array("YU" => "Yacatan",
                         "BC" => "Baja California",
                         "OA" => "Oaxaca");
         $us = array("MD" => "Maryland",
                     "IL" => "Illinois",
                     "PA" => "Pennsylvania",
                     "IA" => "Iowa");
         $canada = array("QC" => "Quebec",
                         "AB" => "Alberta",
                         "NT" => "Northwest Territories",
                         "YT" => "Yokon",
                         "PE" => "Prince Edward Island");
         // combine the arrays as 2 dimensional array
         $n_america = array("Mexico" => $mexico,
                            "United States" => $us,
                            "Canada" => $canada);
         // loop through the countries
         foreach($n_america as $country => $list)
         {
         	// Print a heading
         	echo "<h2>$country</h2><ul>";
         	// print state, province or territory
         	foreach($list as $k => $v)
         	  echo "<li>$k - $v</li>\n";
         	echo '</ul>';
         }
         
      ?>
   </body>
</html>


