<?php
   session_start(); 
   $page_title = "Change your password";
   include("includes/header.html");
   
   if (isset($_POST['submitted']))
   {
        require_once('mysqli_connect.php');

        $errors = array();
        // Validate the email:
        if (empty($_POST['email']))
           $errors[] = 'You forgot to enter your email.';
        else $e = mysqli_real_escape_string($dbc, $_POST['email']);
        
        // Validate the password:¨
        
        if (empty($_POST['pass']))
           $errors[] = 'You forgot to enter your current password.';
        else $e = mysqli_real_escape_string($dbc, $_POST['pass']);
        
        
        // Validate passwords
        if (!empty($_POST['pass1']))
        {
        	if ($_POST['pass1'] != $_POST['pass2'])
        	   $errors[] = 'Your new password did not match the confirmed password.';
        	else $np = mysqli_real_escape_string($dbc, $_POST['pass1']);
        }
        else $errors[] = 'You forgot to enter your new password';
        if (empty($errors))
        {
            // Check that the correct email, password combination is entered
            $q = "SELECT id FROM users WHERE email='$e' AND pass=SHA1('$p')";
            $r = @mysqli_query($dbc, $r);
            $num = @mysqli_num_rows($r);
            if ($num == 1)
            {
               $row = mysqli_fetch_array($r, MYSQLI_NUM);
               $q = "UPDATE users SET pass=SHA1('$np') WHERE user_id=$row[0]";
               $r = @mysqli_query($dbc,$q);
               if (mysqli_affected_rows($dbc) == 1)
               {
               	   echo '<h1>Thank you!</h1><p>Your password has been updated!</p>';
               }	
               else
               {
               	  echo '<h1>System error</h1>'.
               	       '<p class="error">Your password could not be changed due to a system error'.
               	       'We apologize for any inconvenience.</p>';
               	  echo '<p>'.mysqli_error($dbc).'<br>Query: '.$q.'</p>';
               }
               include("includes/footer.html");
               exit();
            }
            else
            {
            	// Invalid email, password combination
            	echo '<h1>Error!</h1>'.
            	     '<p class="error">'.
            	     'The email address and password did not match those on file.</p>';
            }
        }
        else
        {
        	echo '<h1>Error!</h1>'.
        	     '<p class="error">The following error(s) occured:<br/>';
        	foreach($errors as $error)
        	   echo " - $error<br/>\n";
        	echo '</p><p>Please try again.</p><p><br/></p>';
        }
        mysqli_close($dbc);
   }
?>
<h1>Change your password</h1>
<form action="password" method="post">
   <p>Email address: 
     <input type="text" name="email" size="20" maxlength="80"
            value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>"/>
   </p>
   <p>Current Password: <input type="password" name="pass" size="10" maxlength="20" />
   </p>
   <p>New password: <input type="password" name="pass1" size="10" maxlength="20" />
   </p>
   <p>Confirm password: <input type="password" name="pass2" size="10" maxlength="20" />
   </p>
   <p><input type="submit" name="submit" value="Change password" />
   </p>
   <input type="hidden" name="submitted" value="TRUE" />
</form>
<?php 
   include("includes/footer.html");
?>