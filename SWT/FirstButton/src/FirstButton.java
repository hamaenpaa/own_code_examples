/*
 * Created on 5.2.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class FirstButton {

	public static void main(String[] args) 
	{
		Display display = new Display();
		Shell shell = new Shell(display);

		Button button1 = new Button(shell,SWT.PUSH);
		button1.setText("Click me");
		button1.setLocation(0,0);
		button1.setSize(100,20);
		button1.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		System.out.println("Button1 was clicked");
		}
		});
		Button button2 = new Button(shell, SWT.ARROW);
		button2.setSize(20,20);
		button2.setLocation(250,200);		

		Button button3 = new Button(shell, SWT.FLAT|SWT.TOGGLE);
		button3.setSize(50,50);
		button3.setLocation(0,150);
		
		shell.open();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		
	}
}
