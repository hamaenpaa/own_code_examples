/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlCommandButton;
import expert.LoginBean;

/**
 * @author Harri M‰enp‰‰
 *
 */
public class Login extends PageCodeBase {

	protected HtmlForm loginform;
	protected HtmlInputText username;
	protected HtmlInputSecret password;
	protected HtmlOutputLabel usernamelabel;
	protected HtmlOutputLabel passwordlabel;
	protected HtmlCommandButton button1;
	protected LoginBean loginbean;
	protected HtmlForm getLoginform() {
		if (loginform == null) {
			loginform = (HtmlForm) findComponentInRoot("loginform");
		}
		return loginform;
	}

	protected HtmlInputText getUsername() {
		if (username == null) {
			username = (HtmlInputText) findComponentInRoot("username");
		}
		return username;
	}

	protected HtmlInputSecret getPassword() {
		if (password == null) {
			password = (HtmlInputSecret) findComponentInRoot("password");
		}
		return password;
	}

	protected HtmlOutputLabel getUsernamelabel() {
		if (usernamelabel == null) {
			usernamelabel = (HtmlOutputLabel) findComponentInRoot("usernamelabel");
		}
		return usernamelabel;
	}

	protected HtmlOutputLabel getPasswordlabel() {
		if (passwordlabel == null) {
			passwordlabel = (HtmlOutputLabel) findComponentInRoot("passwordlabel");
		}
		return passwordlabel;
	}

	protected HtmlCommandButton getButton1() {
		if (button1 == null) {
			button1 = (HtmlCommandButton) findComponentInRoot("button1");
		}
		return button1;
	}

	/** 
	 * @managed-bean true
	 */
	protected LoginBean getLoginbean() {
		if (loginbean == null) {
			loginbean = (LoginBean) getManagedBean("loginbean");
		}
		return loginbean;
	}

	/** 
	 * @managed-bean true
	 */
	protected void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}

}