function create_window(image, width, height)
{
	// Add some pixels 
	width = width + 10;
	height = height + 10;
	
	// If the window is already open, resize it to the new dimension
	if (window.popup && !window.popup.closed)
	   window.popup.resizeTo(width, height);
	
	// Set the window properties
	var specs = "location=no,scrollbars=no,"+
	            "menubars=no,toolbars=no,resizeable=yes,"+
	            "left=0,top=0,width="+width+",height="+height;
	var url = "show_image.php?image="+image;
	
	// Create the pop-up window:
	popup = window_open(url,"ImageWindow",specs);
}