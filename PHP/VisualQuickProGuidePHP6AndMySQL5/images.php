<!DOCTYPE html PUBLIC 
   "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3c.org/1999/xhtml" xml:lang="en" lang="en">
   <head> 
   <meta http-equiv="content-type" 
         content="text/html; charset=iso-8859-1" />
   
   <title>Upload an Image</title>
   </head>
   <body>
       <p>Click on an image to view it in a separate window.</p>
       <table align="center" cellspacing="5" cellpadding="5" border="1">
           <tr><td align="center">Image name</td></tr>
           <tr><td align="center">Image size</td></tr>
           <?php 
              $dir = "../uploads";
              $files = scandir($dir);
              foreach($files as $image)
              {
              	  if (substr($image,0,1) != '.')
              	  {
              	  	  // Ignore anything with a period
              	  	  $image_size = getimagesize("$dir/$image");
              	  	  // Calculate the image's size to kilobytes
              	  	  $file_size = round((filesize("$dir/$image")) / 1024)."kB";
              	  	  // Make the image's name URL-safe:
              	  	  $image = urlencode($image);
              	  	  echo "\t<tr>\t\t<td>".
              	  	       "<a href=\"javascript:create_window(".
              	  	       "'$image','$image_size[0]','$image_size[1]'\">".
              	  	       "$image</a></td>\t\t<td>$file_size</td>\t</tr>\n";
              	  }
              }
           ?>
       </table>   
   </body>
</html>   
