<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Form feedback</title>
   <style type="text/css" title="text/css" media="all">
       .error {
          font-weight:bold;
          color:#C00;       
       }
   </style>
   </head>
   <body>
      <?php
         // Validate the name:
         if (!empty($_REQUEST['name']))
           $name = $_REQUEST['name'];
         else
         { 
           $name = NULL;
           echo '<p class="error">You forgot to enter your name!</p>';
         }
                 
         // Validate the email
         if (!empty($_REQUEST['email']))
           $email = $_REQUEST['email'];
         else
         { 
           $email = NULL;
           echo '<p class="error">You forgot to enter your email address!</p>';
         }
         
         // Validate the comments
         if (!empty($_REQUEST['comments']))
           $email = $_REQUEST['comments'];
         else
         { 
           $email = NULL;
           echo '<p class="error">You forgot to enter your comments!</p>';
         }
         
         // Create a shorthand of form data
         $email = $_REQUEST['email'];
         $comments = $_REQUEST['comments'];

         if (isset($_REQUEST['gender']))
         {
            $gender = $_REQUEST['gender'];
	         // print the message based upon the gender value
	         if ($gender == 'M')
	            echo '<p><b>Good day,Sir!</b></p>';
	         else if ($gender == 'F')
	            echo '<p><b>Good day,Madam!</b></p>';
	         else
	            echo '<p class="error">Gender should be M or F!</p>';   
         }
         else 
         {
            $gender = NULL;
            echo '<p class="error">You forgot to select your gender!</p>';
         }
         if ($name && $email && $gender && $comments)
         {
	         // print the submitted form information
	         echo "<p>Thank you, <b>$name</b>".
	              ", for following comments:<br/><tt>$comments</tt></p>".
	              "we will reply to you at <i>$email</i>.</p>\n";
         }
         else
         {
         	// Missing form value
         	echo '<p class="error">Please go back and fill out the form again.</p>';
         }
          /* not used
             $_REQUEST['age']
             $_REQUEST['submit']
          */
      ?>
   </body>
</html>

