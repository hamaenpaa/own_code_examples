<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Constants</title>
   </head>
   <body>
      <?php 
         define('TODAY','November 19,2010');
         // print message using predefined constants
         echo '<p>Today is '.TODAY.
              '.<br/>This server is running version'.
              PHP_VERSION.'</b> of PHP on the <b>'.
              PHP_OS."</b> operating system.</p>";
      ?>
   </body>
</html>

