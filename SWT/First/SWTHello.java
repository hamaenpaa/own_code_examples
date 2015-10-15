import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
public class SWTHello {
	public static void main(String[] args) 
	{
		Display display = new Display();
		Shell shell = new Shell(display);
		Label label = new Label(shell, SWT.NONE);
		label.setText("Hello, World!");
		shell.pack();
		label.pack();
		shell.open();
		while(!shell.isDisposed())
		if(!display.readAndDispatch())
		display.sleep();
		display.dispose();
		label.dispose();
	}
}