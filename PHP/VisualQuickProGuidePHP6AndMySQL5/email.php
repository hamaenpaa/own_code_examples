<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Contact me</title>
   </head>
   <body>
       <h1>Contact me</h1>
       <?php 
           date_default_timezone_set('America/New_York');
		   // Check if the form has been submitted
		   if (isset($_POST['submitted']))
		   {
		   	   if (!empty($_POST['name']) && 
		   	       !empty($_POST['email']) && 
		   	       !empty($_POST['comments']))
		   	   {
		   	       $body = "Name:{$_POST['name']}\n\n". 
		   	               "Comments:{$_POST['comments']}\n\n".
		   	       // Make rows no longer than 70 characters long
		   	       $body = wordwrap($body, 70);
		   	       // Send the email
		   	       mail('harri.maenpaa@gmail.com',
		   	            'Contact Form submission',
		   	            $body,"From: {$_POST['email']}");
		   	       // Print a message
		   	       echo '<p><em>Thank you for contacting me at'.
		   	            date('g:i a (T)').' on '.
		   	            date('l F j, Y').
		   	            '.I will reply some day.</em></p>';
		   	       echo '<p><strong>It took '.(time() - $_POST['start']).
		   	            'seconds for you to complete and submit the form.</strong></p>';
		   	       // Clear the form so that is not sticky
		   	       $_POST = array();    	
		   	   }
		   }
		   else
		   {
		   	  echo '<p style="font-weight: bold; color=#C00">Please fill out the form completely</p>';
		   }
		   // Create the HTML form
       ?>
       <form action="email.php" method="post">
	       <p>Name: <input type="text" name="name" size="30" maxlength="60" 
	          value="<?php if (isset($_POST['name'])) echo $_POST['name']; ?>"
	       /></p>
	       <p>Email address: <input type="text" name="email" size="30" maxlength="80" 
	          value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>"
	       /></p>
	       <p>Comments: <textarea name="comments" rows="5" cols="30" />
	         <?php if (isset($_POST['comments'])) echo $_POST['comments']; ?>
	       </textarea>
	       </p>
	       <p><input type="submit" name="submit" value="Send!"/></p>
	       <p><input type="hidden" name="start" value="<?php echo time(); ?>"/></p>
	       <p><input type="hidden" name="submitted" value="TRUE"/></p>
       </form>
   </body>
</html>
