<?php
   $page_title = "Register";
   include("includes/header.html");
   
   if (isset($_POST['submitted']))
   {
   	    $errors = array();
        include('mysqli_connect.php');   	 
        // Validate the first name:
        if (empty($_POST['first_name']))
           $errors[] = 'You forgot to enter your first name.';
        else $fn = mysqli_real_escape_string($dbc, $_POST['first_name']);
        // Validate the first name:
        if (empty($_POST['last_name']))
           $errors[] = 'You forgot to enter your last name.';
        else $ln = mysqli_real_escape_string($dbc, $_POST['last_name']);
        // Validate the email:
        if (empty($_POST['email']))
           $errors[] = 'You forgot to enter your email.';
        else $e = mysqli_real_escape_string($dbc, $_POST['email']);
        // Validate passwords
        if (!empty($_POST['pass1']))
        {
        	if ($_POST['pass1'] != $_POST['pass2'])
        	   $errors[] = 'Your password did not match the confirmed password.';
        	else $p = mysqli_real_escape_string($dbc, $_POST['pass1']);
        }
        else $errors[] = 'You forgot to enter your password';
        if (empty($errors))
        {
        	// Register user to the database
        	$q = "INSERT INTO users (first_name, last_name, ".
        	     "email, pass, registration_date ) VALUES (".
        	     "'$fn','$ln','$e',	SHA1('$p'), NOW())";
        	$r = @mysqli_query($dbc, $q);
        	if ($r)
        	{
        		echo '<h1>Thank you!</h1>'.
        		    '<p>You are now registered.</p>';
        	}
        	else
        	{
        		echo '<h1>System error</h1>'.
        		     '<p>You could not be registered due to a system error.'.
        		     'We apologize for any inconvenience.</p>';
        		echo '<p>'.mysqli_error($dbc).'<br/><br/>Query: '.$q.'</p>';
        	}
        	mysqli_close($dbc);
        	include("includes/footer.html");
        	exit();
        }
        else
        {
            echo '<h1>Error!</h1>'.
                 '<p class="error">The following errors occured:<br/>';
            foreach($errors as $error)
                echo ' - '.$error."<br/>\n";
            echo '</p><p>Please try again</p><p><br/></p>'."\n";
                    	
        }
        mysqli_close($dbc);        
   }
?>
<h1>Register</h1>
<form action="register.php" method="post">
   <p>First name: <input type="text" name="first_name" size="15" maxlength="20" 
      value="<?php if (isset($_POST['first_name'])) echo $_POST['first_name']; ?>"
   /></p>
   <p>Last name: <input type="text" name="last_name" size="15" maxlength="40" 
      value="<?php if (isset($_POST['last_name'])) echo $_POST['last_name']; ?>"
   /></p>
   <p>Email address: <input type="text" name="email" size="20" maxlength="80" 
      value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>"
   /></p>
   <p>Password: <input type="password" name="pass1" size="10" maxlength="20" />
   </p>
   <p>Confirm password: <input type="password" name="pass2" size="10" maxlength="20" />
   </p>
   <p><input type="submit" name="submit" value="Register" />
   </p>
   <input type="hidden" name="submitted" value="TRUE" />
</form> 
<?php   
   include("includes/footer.html");
?>