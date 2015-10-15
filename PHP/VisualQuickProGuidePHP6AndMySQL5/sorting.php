<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Sorting arrays</title>
   </head>
   <body>
      <table border="0" 
             cellspacing="3" cellpadding="3" 
             align="center">
         <tr><td><h2>Rating</h2></td><h2>Title</h2></tr>    
         <?php 
            $movies = array(10 => "Casablanca",
                            9 => "To kill a MockingBird",
                            2 => "The english patient",
                            8 => "Stanger Than Fiction",
                            5 => "Story of the Weeping Camel",
                            7 => "Donnie Darko");
            // Display the movies in their original order
            echo '<tr><td colspan="2"><b>In their original order</b></td></tr>';
            foreach($movies as $key => $value)
               echo "<tr><td>$key</td><td>$value</td></tr>\n";
            // Display the movies sorted by title
            asort($movies);
            echo '<tr><td colspan="2"><b>Sorted by title</b></td></tr>';
            foreach($movies as $key => $value)
               echo "<tr><td>$key</td><td>$value</td></tr>\n";
            // Display the movies sorted by rating
            krsort($movies);
            echo '<tr><td colspan="2"><b>Sorted by title</b></td></tr>';
            foreach($movies as $key => $value)
               echo "<tr><td>$key</td><td>$value</td></tr>\n";
         ?>    
      
      </table>
   </body>
</html>



