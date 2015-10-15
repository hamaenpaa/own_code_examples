<?php
   session_start();
   $page_title = "Welcome to this site";
   include("includes/header.html");
?>
<h1>Content header</h1>

<p>This is where the page-specific content goes.
   This section, and the corresponding header, will
   change from one page to the next</p>

<p>Volutpat at various sed sollicitudin et, arcu. Vivamus viverra...</p>   

<?php 
   include("includes/footer.html");
?>