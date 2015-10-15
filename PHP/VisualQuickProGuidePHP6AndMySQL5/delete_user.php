<?php
   session_start();
   $page_title = "Delete a user";
   include("includes/header.html");
   echo '<h1>Delete a user</h1>';
   
   // Check if valid user id exists through GET or POST
   if (isset($_GET['id']) && is_numeric($_GET['id']))
      $id = $_GET['id'];
   else if (isset($_POST['id']) && is_numeric($_POST['id']))
      $id = $_POST['id'];
   else
   {
   	   echo '<p class="error">This page has been accessed in error</p>';
       include("includes/footer.html");
       exit();
   }
   require_once('mysqli_connect.php');
      
   // Check if the form has been submitted
   if (isset($_POST['submitted']))
   {
      if ($_POST['sure'] == 'Yes')
      {
      	 // Delete the record, make the query:
      	 $q = "DELETE FROM users WHERE id = $id LIMIT 1";
      	 $r = mysqli_query($dbc,$q);
      	 if (mysqli_affected_rows($dbc) == 1)
      	 	echo '<p>The user has been deleted</p>';
      	 else
      	 {
      	 	echo '<p class="error">The user could not been deleted due to a system error</p>';
      	 	echo '<p>'.mysqli_error($dbc)."<br/>Query:".$q.'</p>';
      	 } 
      }
      else
      {
      	 echo '<p>The user has NOT been deleted</p>';
      }
   }
   else
   {
   	   // Show the form, retrieve the user's information
   	   $q = "SELECT CONCAT(last_name, ', ', first_name) FROM users WHERE id = $id";
   	   $r = @mysqli_query($dbc, $q);
   	   if (mysqli_num_rows($r) == 1)
   	   {
   	   	  // Valid user id, show the form
   	   	  $row = mysqli_fetch_array($r,MYSQLI_NUM);
   	   	  // Create the form
   	   	  echo '<form action="delete_user.php" method="POST">'.
   	   	       '<h3>Name: '.$row[0].'</h3>'.
   	   	       '<p>Are you sure you want to delete this user?<br>'.
   	   	       '<input type="radio" name="sure" value="Yes" />Yes'.
   	   	       '<input type="radio" name="sure" value="no" checked="checked"/>No</p>'.
   	   	       '<p><input type="submit" name="submit" value="Submit"/>'.
   	   	       '<input type="hidden" name="submitted" value="TRUE"/>'.
   	   	       '<input type="hidden" name="id" value="'.$id.'" />'.
   	   	       '</form>';
   	   }
   	   else
   	   {
   	   	  // Not a valid user id
   	   	  echo '<p class="error">This page has been accessed in error</p>';
   	   }
   }
   mysqli_close($dbc);
   include("includes/footer.html");
?>   