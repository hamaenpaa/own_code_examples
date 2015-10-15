/*
 * Created on 29.5.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pagecode;

import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.faces.component.html.HtmlPanelBox;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlOutputText;
import com.ibm.faces.component.html.HtmlGraphicImageEx;
/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankJSFTemplate extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlPanelBox box1;
	protected HtmlDataTable table1;
	protected UIColumn column1;
	protected HtmlOutputText text1;
	protected HtmlGraphicImageEx headerImage;
	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}
	protected HtmlPanelBox getBox1() {
		if (box1 == null) {
			box1 = (HtmlPanelBox) findComponentInRoot("box1");
		}
		return box1;
	}
	protected HtmlDataTable getTable1() {
		if (table1 == null) {
			table1 = (HtmlDataTable) findComponentInRoot("table1");
		}
		return table1;
	}
	protected UIColumn getColumn1() {
		if (column1 == null) {
			column1 = (UIColumn) findComponentInRoot("column1");
		}
		return column1;
	}
	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}
	protected HtmlGraphicImageEx getHeaderImage() {
		if (headerImage == null) {
			headerImage = (HtmlGraphicImageEx) findComponentInRoot("headerImage");
		}
		return headerImage;
	}
}