<?php
   require_once('mysqli_connect.php');
   if (isset($_POST['submitted']))
   {
       require_once('includes/login_functions.inc.php');
       list($check,$data) = check_login($dbc,$_POST['email'],$_POST['pass']);
       if ($check)
       {
       	  $_SESSION['user_id'] = $data['id'];
       	  $_SESSION['first_name'] = $data['first_name'];
       	  $_SESSION['agent'] = md5($_SERVER['HTTP_USER_AGENT']);
       	  
       	  // Redirect
       	  $url = absolute_url('loggedin.php');
       	  header("Location: $url");
       	  exit();
       }
       else
       {
       	  // Unsuccessful!
       	  $errors = $data;
       }
   }
   mysqli_close($dbc);
   include('includes/login_page.inc.php');
?>