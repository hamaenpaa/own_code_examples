<?php
   session_start();
   if (!isset($_SESSION['agent']) OR
        ($_SESSION['agent'] != md5($_SERVER['HTTP_USER_AGENT']))
       )
   {
   	   require_once('includes/login_functions.inc.php');
   	   $url = absolute_url();
   	   header("Location: $url");
   	   exit();
   }
   $page_title = "Logged in!";
   echo '<h1>Logged in!</h1>'.
        "<p>You are now logged in, {$_SESSION['first_name']}</p>".
        '<p><a href="Logout.php">Logout</a></p>';
   include("includes/footer.html");
?>