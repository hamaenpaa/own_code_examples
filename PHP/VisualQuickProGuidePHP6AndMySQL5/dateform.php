<?php
   $page_title = "Calendar form";
   include("includes/header.html");

   // This function makes three pull-down menus
   // for selecting a month, day and year
   function make_calendar_pulldowns()
   {
         // Make months array and months pull-down menu
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
          echo '<select name="month">';
          foreach($months as $key => $value)
             echo "<option value=\"$key\">$value</option>\n";
          echo '</select>';
          
          // Make days pull-down menu
          echo '<select name="day">';
          for($day=1;$day<=31;$day++)
             echo "<option value=\"$day\">$day</option>\n";
          echo '</select>';
          
          // Make years pull-down menu
          echo '<select name="year">';
          for($year=2008;$year<=2018;$year++)
             echo "<option value=\"$year\">$year</option>\n";
          echo '</select>';
   }
   
   // Create form tags
   echo '<h1>Select a date</h1><form action="dateform.php" method="post">';
   
   // Call the function
   make_calendar_pulldowns();
   
   echo '</form>';
   include("includes/footer.html");
?>