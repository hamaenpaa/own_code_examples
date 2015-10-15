<?php
   $name = FALSE; // Flag
   if (isset($_GET['image']))
   {
   	  $image = "../uploads/{$_GET['image']}";
   	  // Check the image exists in a file
   	  if (file_exists($image) && is_file($image))
   	  {
   	  	  // Make sure the image's file extension
   	  	  $ext = strtolower(substr($_GET['image'], -4));
   	  	  if (($ext == '.jpg') OR ($ext == 'jpeg') OR ($ext == '.png'))
   	  	  	  $name = $_GET['image'];
   	  }
   }
   if (!$name)
   	  $image = 'images/unavailable.png';
   $info = getimagesize($image);
   $fs = filesize($image);
   header("Content-Type:{$_info['mime']}\n");
   header("Content-Disposition: inline,filename=\"$name\"\n");
   header("Content-Length: $fs\n");
   // Send the file
   readfile($name);   
?>