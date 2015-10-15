<?php
   session_start();

   if (!isset($_SESSION['user_id']))
   {
   	  require_once('includes/login_functions.inc.php');
   	  $url = absolute_url();
   	  header("Location: $url");
   	  exit();
   }
   else
   {
   	   $_SESSION = array(); // Clear session variables
   	   session_destroy(); // Destroy the session itself
   }
   
   $page_title = "Logged Out!";
   include("includes/header.html");
   echo '<h1>Logged Out!</h1>';
   include("includes/footer.html");
?>