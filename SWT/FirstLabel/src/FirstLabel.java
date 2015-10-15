/*
 * Created on 5.2.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FirstLabel {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		Label label1 = new Label(shell, SWT.BORDER);
		label1.setText("See no evil");
		label1.setSize(100,20);
		label1.setLocation(30,30);
		Label sep1 = new
		Label(shell, SWT.SEPARATOR| SWT.HORIZONTAL |
		SWT.SHADOW_IN);
		sep1.setBounds(30,60,100,20);
		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("Hear no evil");
		label2.setSize(100,20);
		label2.setLocation(30,90);
		Label sep2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep2.setBounds(30,120,100,20);
		Label label3 = new Label(shell, SWT.NONE);
		label3.setSize(100,20);
		label3.setLocation(30,150);
		label3.setBackground(new Color(display,200,111,50));
		label3.setText("Speak no evil");
		
		shell.open();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
