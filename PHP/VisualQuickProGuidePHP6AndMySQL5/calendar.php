<?php session_start(); ?>
<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Calendar</title>
   </head>
   <body>
      <form action="calendar.php">
      <?php
         // This script makes 3 pull-down menus
         // for an HTML form: months, days, years
         
         // Make months array
         $months = array(
            1 => "January",
            2 => "February",
            3 => "March",
            4 => "April",
            5 => "May",
            6 => "June",
            7 => "July",
            8 => "August",
            9 => "September",
            10 => "October",
            11 => "November",
            12 => "December"
          );
          
          // Make the days and years arrays
          $days = range(1,31);
          $years = range(2008,2018);
          
          // Make the months pull-down menu
          echo '<select name="month">';
          foreach($months as $key => $value)
          {
          	 echo "<option value=\"$key\">$value</option>\n";
          }          
          echo '</select>';

          // Make the days pull-down menu
          echo '<select name="day">';
          foreach($days as $key => $value)
          {
          	 echo "<option value=\"$value\">$value</option>\n";
          }          
          echo '</select>';
          
          // Make the years pull-down menu
          echo '<select name="year">';
          foreach($years as $key => $value)
          {
          	 echo "<option value=\"$value\">$value</option>\n";
          }          
          echo '</select>';
      ?>
         </form>
   </body>
</html>


