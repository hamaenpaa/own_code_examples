<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Concatenation</title>
   </head>
   <body>
      <?php 
          $first_name = "Larry";
          $last_name = "Ullman";
          $author = $first_name . ' ' . $last_name;
          $book = "Visual QuickPro Guide PHP6 and MySQL5";
          echo "<p>The book <em>$book</em> was written by $author</p>";                    
      ?>
   </body>
</html>
