<?php
   session_start();
   $page_title = "Edit a user";
   include("includes/header.html");
   echo '<h1>Edit a user</h1>';

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
      $errors = array();
      // Check for a first name:
      if (empty($_POST['first_name']))
      	 $errors[] = 'You forgot to enter your first name';
      else
      	 $fn = mysqli_real_escape_string($dbc, $_POST['first_name']);
      // Check for a last name:
      if (empty($_POST['last_name']))
      	 $errors[] = 'You forgot to enter your last name';
      else
      	 $ln = mysqli_real_escape_string($dbc, $_POST['last_name']);
      // Check for an email address:
      if (empty($_POST['email']))
      	 $errors[] = 'You forgot to enter your email address';
      else
      	 $e = mysqli_real_escape_string($dbc, $_POST['email']);
      if (empty($errors))
      {
      	 // All check resulted OK
      	 // Test for unique email address
      	 $q = "SELECT id FROM users WHERE email='$e' AND id!=$id";
      	 $r = mysqli_query($dbc,$q);
      	 if (mysqli_num_row($r) == 0)
      	 {
      	 	// Make the query
      	 	$q = "UPDATE users SET first_name='$fn', last_name='$ln', email='$e' WHERE id=$id LIMIT 1";
      	 	$r = mysqli_query($dbc,$q);
      	 	if (mysqli_affected_rows($r) == 1)
      	 		echo '<p>The user has been edited</p>';
      	    else
      	    {
      	    	echo '<p class="error">The user could not been edited due to a system error.'.
      	    	     'We apologize for any inconvenience</p>';
      	    	echo '<p>'.mysqli_error($dbc).'<br>Query: '.$q.'</p>';
      	    }
      	 }
      	 else
      	 {
      	 	// Already registered
      	 	echo '<p class="error">The email address has already been registered by another user</p>';
      	 }
      }	 
      else
      {
      	  // Report the errors from the input value checks
      	  echo '<p class="error">The following error(s) occured:<br/>';
      	  foreach($errors as $error)
      	     echo " - $error<br/>\n";
      	  echo '</p><p>Please try again</p>';
      }
      // Always show the form
      $q = "SELECT first_name, last_name, email FROM users WHERE id=$id";
      $r = mysqli_query($dbc,$q);
      if (mysqli_num_rows($r) == 1)
      {
      	  // Get the user's information
      	  $row = mysqli_fetch_array($r,MYSQLI_NUM);
      	  // Create the form
      	  echo '<form action="edit_user.php" method="POST">'.
      	       '<p>First name: '.
      	       '<input type="text" name="first_name"'.
      	       ' size="15" maxlength="15" value="'.
      	       $fn.'" /></p>'.
      	       '<p>Last name: '.
      	       '<input type="text" name="last_name"'.
      	       ' size="15" maxlength="30" value="'.
      	       $ln.'" /></p>'.
      	       '<p>Email address: '.
      	       '<input type="text" name="email"'.
      	       ' size="20" maxlength="40" value="'.
      	       $e.'" /></p>'.
      	       '<p><input type="submit" name="submit" value="submit" /></p>'.
      	       '<input type="hidden" name="submitted" value="TRUE"/>'.
      	       '<input type="hidden" name="id" value="'.$id.'"/>'.
      	       '</form>';
     }
     else
     {
        echo '<p class="error">This page has been accessed in error</p>';     	
     }
     mysqli_close($dbc);
     include("includes/footer.html");      	 
   }
?>