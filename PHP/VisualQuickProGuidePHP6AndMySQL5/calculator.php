<?php
   $page_title = "Widget cost calculator";
   include("includes/header.html");
   
   function calculate_total($qty, $cost, $tax = 5)
   {
   	   // Calculate the results:
       $total = ($qty * $cost);
       $taxrate = ($tax / 100); // Turn 5% to 0.05	      	   
       $total += ($total * $taxrate); // Add the tax
?>
       <h1>Total cost</h1>
       <p>Total cost of purchasing
       <?php print $qty; ?>
       widget(s) at $
       <?php print number_format($cost,2);?>
             each, including a tax rate of
       <?php print $tax; ?>% is $
       <?php print number_format($total,2);?>
       </p>
<?php                   	      	   
   }
   
   if (isset($_POST['submitted']))
   {
   	  if (is_numeric($_POST['quantity']) &&
   	      is_numeric($_POST['price']))
   	      {
   	      	  if (is_numeric($_POST['tax']))
   	      	    calculate_total($_POST['quantity'], 
   	      	      $_POST['price'], $_POST['tax']);
   	      	  else
   	      	    calculate_total($_POST['quantity'], 
   	      	      $_POST['price']);
   	      }
   	      else
   	      {
   	      	 echo '<h1>Error!</h1>';
   	      	 echo '<p class="error">Please enter a valid quantity and price.</p>';
   	      }
   }
?>   
   <h1>Widget cost calculator</h1>
   <form action="calculator.php" method="post">
       <p>Quantity: <input type="text" name="quantity" size="5" maxlength="5" 
          value="<?php if (isset($_POST['quantity'])) echo $_POST['quantity']; ?>"
       /></p>
       <p>Price: <input type="text" name="price" size="5" maxlength="10" 
          value="<?php if (isset($_POST['price'])) echo $_POST['price']; ?>"
       /></p>
       <p>Tax (%): <input type="text" name="tax" size="5" maxlength="10" 
          value="<?php if (isset($_POST['tax'])) echo $_POST['tax']; ?>"
       /> (optional)</p>
       <p><input type="submit" name="submit" value="Calculate!"/></p>
       <input type="hidden" name="submitted" value="1" />       
   </form>