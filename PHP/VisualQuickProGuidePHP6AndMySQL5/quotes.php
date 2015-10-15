<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   <title>Quotes</title>
   </head>
   <body>
      <?php 
          $quantity = 30;
          $price = 119.95;
          $taxrate = .05;
          
          // Calculate the total and add tax
          $total = $quantity * $price;
          $total = $total + $total * $taxrate;
          
          // format total
          $total = number_format($total, 2);
          
          // print the results using double quotation marks
          echo "<h3>Using double quotation marks</h3>";
          echo "<p>You are purchasing <b>$quantity</b> widget(s) at a cost of <b>".
               "$price</b> each. With tax, the total comes to <b>\$$total</b>.</p>";
          
          // print the results using single quotation marks
          echo "<h3>Using single quotation marks</h3>";
          echo '<p>You are purchasing <b>$quantity</b> widget(s) at a cost of <b>'.
               '$price</b> each. With tax, the total comes to <b>\$$total</b>.</p>';
      ?>
   </body>
</html>

