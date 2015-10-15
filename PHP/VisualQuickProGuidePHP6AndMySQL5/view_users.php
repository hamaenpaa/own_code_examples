<?php
   $page_title = "View the current users";
   include("includes/header.html");
   
   echo '<h1>Registered users</h1>';
   
   require_once('mysqli_connect.php');
   
   // Number of records to show per page
   $display = 10;
   
   // determine how many pages there are
   if (isset($_GET['p']) && is_numeric($_GET['p']))
   {
   	  // Already determined: passed as get attribute
   	  $pages = $_GET['p'];
   }
   else
   {
   	  // Need to determine
   	  $q = "SELECT COUNT(id) FROM users";
   	  $r = @mysqli_query($dbc,$q);
   	  $row = mysqli_fetch_array($r,MYSQLI_NUM);
   	  $records = $row[0];
 	  if ($records > $display)
	  {
	  	  // More than 1 page
	   	  $pages = ceil($records/$display); 
	  }
	  else $pages = 1;
   }
   // Determine where in the database to start resulting results
   if (isset($_GET['s']) && is_numeric($_GET['s']))
   {
   	  // Already determined: passed as get attribute
   	  $start = $_GET['s'];
   }
   else $start = 0;
   
   // Determine the sort
   $sort = (isset($_GET['sort'])) ? $_GET['sort'] : 'rd';
   switch($sort)
   {
   	  case 'ln' : $order_by = 'last_name ASC'; break;
   	  case 'fn' : $order_by = 'first_name ASC'; break;
   	  case 'rd' : $order_by = 'registration_date ASC'; break;
   	  default : $order_by = 'registration_date ASC'; break;
   }
      

   $q = "SELECT last_name, first_name, ".
        "DATE_FORMAT(registration_date, '%M %d, %Y') AS dr, id ".
        "FROM users ORDER BY $order_by LIMIT $start, $display";
   $r = @mysqli_query($dbc, $q);
   $num = mysqli_num_rows($r);
   if ($num > 0)
   {
   	   echo "<p>There are currently $num registered users</p>\n";
   	   
   	   // Table header
   	   echo '<table align="center" cellspacing="0" cellpadding="5" width="75%">'.
   	        '<tr>'.
   	        '<td align="left"><b>Edit</b></td>'.
   	        '<td align="left"><b>Delete</b></td>'.
   	        '<td align="left"><b><a href="view_users.php?sort=ln">Last name</a></b></td>'.
   	        '<td align="left"><b><a href="view_users.php?sort=fn">First name</a></b></td>'.
   	        '<td align="left"><b><a href="view_users.php?sort=rd">Date Registered</a></b></td>'.
   	        '</tr>';
   	   $bg = "#eeeeee"; // Initial background color
   	   
   	   // Fetch and print all the records
   	   while($row = mysqli_fetch_array($r, MYSQLI_ASSOC))
   	   {
   	   	  $bg = ($bg == '#eeeeee') ? '#ffffff' : '#eeeeee'; 
   	   	  echo '<tr bgcolor="'.$bg.'">'.
   	   	       '<td align="left"><a href="edit_user.php?id='.
   	   	          $row['id'].'">Edit</a></td>'.
   	   	       '<td align="left"><a href="delete_user.php?id='.
   	   	          $row['id'].'">Delete</a></td>'.
   	   	       '<td align="left">'.$row['last_name'].'</td>'.
   	   	       '<td align="left">'.$row['first_name'].'</td>'.   
   	   	       '<td align="left">'.$row['dr'].'</td>'.
   	   	       '</tr>';
   	   }
   	   echo '</table>';
   	   mysqli_free_result($r);
   }
   else
   {
   	  echo '<p class="error">There are currently no registered users</p>';
/*   	  echo '<p class="error">The current users could not be retrieved.'.
   	       'We apologize for any inconveniences.</p>';
   	  echo '<p>'.mysqli_error($dbc).'<br/>Query: '.$q.'</p>';*/
   }
   mysqli_close($dbc);
   // Make links to other pages if necessary
   if ($pages > 1)
   {
   	  echo '<br/><p>';
   	  $current_page = ($start/$display) + 1;
   	  // if it is not the first page, make previous button
   	  if ($current_page != 1)
   	     echo '<a href="view_users.php?s='.
   	          ($start-$display).
   	          "&p=".$pages.
   	          '&sort='.$sort.
   	          '">Previous</a>&nbsp;';
   	  // Make all the numbered pages
   	  for($i=1;$i<=$pages;$i++)
   	  {
   	  	 if ($i != $current_page)
   	  	    echo '<a href="view_users.php?s='.
   	  	          ($display*($i - 1)).
   	  	          '&p='.$pages.
   	  	          '&sort='.$sort.
   	  	          '">'.$i.'</a>&nbsp;';
   	  	 else echo $i . ' ';
   	  }
   	  // If it is not theh first page, make a Next button
   	  if ($current_page != $pages)
         echo '&nbsp;<a href="view_users.php?s='.
              ($start + $display).
              '&p='.$pages.
              '&sort='.$sort.
              '">Next</a>';
      echo '</p>';	  	
   }
   include("includes/footer.html");
?>