<?php
   $page_title = 'Login';
   include("includes/header.html");
   
   if (!empty($errors))
   {
   	  echo '<h1>Errors!</h1>';
   	  echo '<p class="error">The following errors occured:<br/>';
   	  foreach($errors as $error)
   	     echo " - $error<br/>";
   	  echo '</p><p>Please try again.</p>'; 
   }
?>
<h1>Login</h1>
<form action="login.php" method="post">
    <p>Email address: <input type="text" name="email" size="30" maxlength="80"/></p>
    <p>Password: <input type="password" name="pass" size="20" maxlength="20"/></p>
    <p><input type="submit" name="submit" value="Login"/></p>
    <p><input type="hidden" name="submitted" value="TRUE"/></p>
</form>
<?php 
   include("includes/footer.html");
?>