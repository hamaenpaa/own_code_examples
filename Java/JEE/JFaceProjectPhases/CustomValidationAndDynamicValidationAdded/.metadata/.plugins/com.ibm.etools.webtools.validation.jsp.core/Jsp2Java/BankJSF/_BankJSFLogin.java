package com.ibm._jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;


public final class _BankJSFLogin extends com.ibm.ws.jsp.runtime.HttpJspBase
     implements com.ibm.ws.jsp.runtime.JspClassInformation {

  private static String[] _jspx_dependants;
  public String[] getDependants() {
    return _jspx_dependants;
  }

  private static String _jspx_classVersion;
  private static boolean _jspx_isDebugClassFile;
  static {
    _jspx_classVersion = new String("6.0.0.0");
    _jspx_isDebugClassFile = false;
  }

  public String getVersionInformation() {
    return _jspx_classVersion;
  }
  public boolean isDebugClassFile() {
    return _jspx_isDebugClassFile;
  }
  private final static char[] _jsp_string1 = "\r\n".toCharArray();
  private final static char[] _jsp_string2 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n\r\n".toCharArray();
  private final static char[] _jsp_string3 = "\r\n<HTML>\r\n<HEAD>\r\n".toCharArray();
  private final static char[] _jsp_string4 = "\r\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=ISO-8859-1\">\r\n<META NAME=\"GENERATOR\" CONTENT=\"IBM Software Development Platform\">\r\n<META HTTP-EQUIV=\"Content-Style-Type\" CONTENT=\"text/css\">\r\n<LINK HREF=\"/BankJSF/theme/Master.css\" REL=\"stylesheet\" TYPE=\"text/css\">\r\n".toCharArray();
  private final static char[] _jsp_string5 = "\r\n\t<TITLE>BankJSFLogin.jsp</TITLE>\r\n".toCharArray();
  private final static char[] _jsp_string6 = "\r\n<LINK rel=\"stylesheet\" type=\"text/css\"\r\n\thref=\"/BankJSF/theme/stylesheet.css\" title=\"Style\">\r\n</HEAD>\r\n".toCharArray();
  private final static char[] _jsp_string7 = "\r\n\t<BODY>".toCharArray();
  private final static char[] _jsp_string8 = "\r\n\t<P></P>\r\n\t\t".toCharArray();
  private final static char[] _jsp_string9 = "\r\n\t\t\t".toCharArray();
  private final static char[] _jsp_string10 = "\r\n\t\t".toCharArray();
  private final static char[] _jsp_string11 = "\r\n\t".toCharArray();
  private final static char[] _jsp_string12 = "\r\n\t<HR>\r\n\t".toCharArray();
  private final static char[] _jsp_string13 = "\r\n\t\t\t\t".toCharArray();
  private final static char[] _jsp_string14 = "\r\n\t\t\t\t\t<P><FONT face=\"Arial\">Enter Customer SSN:</FONT>".toCharArray();
  private final static char[] _jsp_string15 = "\r\n\t\t\t\t\t\t".toCharArray();
  private final static char[] _jsp_string16 = "\r\n\t\t\t\t\t".toCharArray();
  private final static char[] _jsp_string17 = "<BR>\r\n\t\t\t\t\t</P>\r\n\t\t\t\t".toCharArray();
  private final static char[] _jsp_string18 = "\r\n\t<HR>\r\n\t</BODY>\r\n".toCharArray();
  private final static char[] _jsp_string19 = "\r\n</HTML>\r\n".toCharArray();

  static {
  }

  private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap = null;


  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;

    JspWriter _jspx_out = null;


    try {

      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);

      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(_jsp_string1);
      out.write(_jsp_string2);
      out.write(_jsp_string1);
      out.write(_jsp_string3);
      out.write(_jsp_string1);
      out.write(_jsp_string4);
      out.write(_jsp_string5);
      out.write(_jsp_string6);

      if (_jspx_meth_f_view_0(pageContext)) return;
      out.write(_jsp_string19);

    } catch (Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
        if (pageContext != null) pageContext.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
  
  private boolean _jspx_meth_hx_graphicImageEx_0(javax.servlet.jsp.tagext.JspTag _jspx_th_hx_panelBox_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.ibm.faces.taglib.html_extended.GraphicImageExTag _jspx_th_hx_graphicImageEx_0 = new com.ibm.faces.taglib.html_extended.GraphicImageExTag();
    _jspx_th_hx_graphicImageEx_0.setPageContext(pageContext);
    _jspx_th_hx_graphicImageEx_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_hx_panelBox_0);
    _jspx_th_hx_graphicImageEx_0.setStyleClass("graphicImageEx");
    _jspx_th_hx_graphicImageEx_0.setId("headerImage");
    _jspx_th_hx_graphicImageEx_0.setValue("theme/itso_logo.gif");
    int _jspx_eval_hx_graphicImageEx_0 = _jspx_th_hx_graphicImageEx_0.doStartTag();
    if (_jspx_th_hx_graphicImageEx_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_hx_graphicImageEx_0.release();
      return true;
    }
    _jspx_th_hx_graphicImageEx_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_hx_panelBox_0(javax.servlet.jsp.tagext.JspTag _jspx_th_hx_scriptCollector_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.ibm.faces.taglib.html_extended.PanelBoxTag _jspx_th_hx_panelBox_0 = new com.ibm.faces.taglib.html_extended.PanelBoxTag();
    _jspx_th_hx_panelBox_0.setPageContext(pageContext);
    _jspx_th_hx_panelBox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_hx_scriptCollector_0);
    _jspx_th_hx_panelBox_0.setStyleClass("panelBox");
    _jspx_th_hx_panelBox_0.setId("box1");
    int _jspx_eval_hx_panelBox_0 = _jspx_th_hx_panelBox_0.doStartTag();
    if (_jspx_eval_hx_panelBox_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write(_jsp_string9);
      
      if (_jspx_meth_hx_graphicImageEx_0(_jspx_th_hx_panelBox_0, pageContext)) return true;
      out.write(_jsp_string10);
    }
    if (_jspx_th_hx_panelBox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_hx_panelBox_0.release();
      return true;
    }
    _jspx_th_hx_panelBox_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_h_outputText_0(javax.servlet.jsp.tagext.JspTag _jspx_th_hx_scriptCollector_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_outputText_0 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    _jspx_th_h_outputText_0.setPageContext(pageContext);
    _jspx_th_h_outputText_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_hx_scriptCollector_0);
    _jspx_th_h_outputText_0.setStyleClass("outputText");
    _jspx_th_h_outputText_0.setId("text1");
    _jspx_th_h_outputText_0.setValue("ITSO RedBank");
    _jspx_th_h_outputText_0.setStyle("font-family: sans-serif, Arial; font-size: 18pt");
    int _jspx_eval_h_outputText_0 = _jspx_th_h_outputText_0.doStartTag();
    if (_jspx_th_h_outputText_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_outputText_0.release();
      return true;
    }
    _jspx_th_h_outputText_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_hx_scriptCollector_0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.ibm.faces.taglib.html_extended.ScriptCollectorTag _jspx_th_hx_scriptCollector_0 = new com.ibm.faces.taglib.html_extended.ScriptCollectorTag();
    _jspx_th_hx_scriptCollector_0.setPageContext(pageContext);
    _jspx_th_hx_scriptCollector_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_hx_scriptCollector_0.setId("scriptCollector1");
    int _jspx_eval_hx_scriptCollector_0 = _jspx_th_hx_scriptCollector_0.doStartTag();
    if (_jspx_eval_hx_scriptCollector_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write(_jsp_string8);
      
      if (_jspx_meth_hx_panelBox_0(_jspx_th_hx_scriptCollector_0, pageContext)) return true;
      out.write(_jsp_string10);
      
      if (_jspx_meth_h_outputText_0(_jspx_th_hx_scriptCollector_0, pageContext)) return true;
      out.write(_jsp_string11);
    }
    if (_jspx_th_hx_scriptCollector_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_hx_scriptCollector_0.release();
      return true;
    }
    _jspx_th_hx_scriptCollector_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_h_outputText_1(javax.servlet.jsp.tagext.JspTag _jspx_th_hx_scriptCollector_1, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_outputText_1 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    _jspx_th_h_outputText_1.setPageContext(pageContext);
    _jspx_th_h_outputText_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_hx_scriptCollector_1);
    _jspx_th_h_outputText_1.setStyleClass("outputText");
    _jspx_th_h_outputText_1.setId("text2");
    _jspx_th_h_outputText_1.setValue("Login");
    _jspx_th_h_outputText_1.setStyle("font-family: sans-serif, Arial; font-size: 14pt");
    int _jspx_eval_h_outputText_1 = _jspx_th_h_outputText_1.doStartTag();
    if (_jspx_th_h_outputText_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_outputText_1.release();
      return true;
    }
    _jspx_th_h_outputText_1.release();
    return false;
  }
  
  
  private boolean _jspx_meth_f_validateLength_0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_inputText_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.jsf_core.ValidateLengthTag _jspx_th_f_validateLength_0 = new com.sun.faces.taglib.jsf_core.ValidateLengthTag();
    _jspx_th_f_validateLength_0.setPageContext(pageContext);
    _jspx_th_f_validateLength_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_inputText_0);
    _jspx_th_f_validateLength_0.setMinimum("11");
    int _jspx_eval_f_validateLength_0 = _jspx_th_f_validateLength_0.doStartTag();
    if (_jspx_th_f_validateLength_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_f_validateLength_0.release();
      return true;
    }
    _jspx_th_f_validateLength_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_h_inputText_0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_form_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.html_basic.InputTextTag _jspx_th_h_inputText_0 = new com.sun.faces.taglib.html_basic.InputTextTag();
    _jspx_th_h_inputText_0.setPageContext(pageContext);
    _jspx_th_h_inputText_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_form_0);
    _jspx_th_h_inputText_0.setStyleClass("inputText");
    _jspx_th_h_inputText_0.setId("customer");
    _jspx_th_h_inputText_0.setValue("#{sessionScope.customerSSN}");
    _jspx_th_h_inputText_0.setRequired("true");
    int _jspx_eval_h_inputText_0 = _jspx_th_h_inputText_0.doStartTag();
    if (_jspx_eval_h_inputText_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write(_jsp_string15);
      
      if (_jspx_meth_f_validateLength_0(_jspx_th_h_inputText_0, pageContext)) return true;
      out.write(_jsp_string16);
    }
    if (_jspx_th_h_inputText_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_inputText_0.release();
      return true;
    }
    _jspx_th_h_inputText_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_h_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_form_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.html_basic.MessageTag _jspx_th_h_message_0 = new com.sun.faces.taglib.html_basic.MessageTag();
    _jspx_th_h_message_0.setPageContext(pageContext);
    _jspx_th_h_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_form_0);
    _jspx_th_h_message_0.setFor("customer");
    int _jspx_eval_h_message_0 = _jspx_th_h_message_0.doStartTag();
    if (_jspx_th_h_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_message_0.release();
      return true;
    }
    _jspx_th_h_message_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_hx_commandExButton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_form_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.ibm.faces.taglib.html_extended.CommandExButtonTag _jspx_th_hx_commandExButton_0 = new com.ibm.faces.taglib.html_extended.CommandExButtonTag();
    _jspx_th_hx_commandExButton_0.setPageContext(pageContext);
    _jspx_th_hx_commandExButton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_form_0);
    _jspx_th_hx_commandExButton_0.setType("submit");
    _jspx_th_hx_commandExButton_0.setValue("Enter");
    _jspx_th_hx_commandExButton_0.setStyleClass("commandExButton");
    _jspx_th_hx_commandExButton_0.setId("button1");
    _jspx_th_hx_commandExButton_0.setAction("success");
    int _jspx_eval_hx_commandExButton_0 = _jspx_th_hx_commandExButton_0.doStartTag();
    if (_jspx_th_hx_commandExButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_hx_commandExButton_0.release();
      return true;
    }
    _jspx_th_hx_commandExButton_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_h_form_0(javax.servlet.jsp.tagext.JspTag _jspx_th_hx_scriptCollector_1, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.html_basic.FormTag _jspx_th_h_form_0 = new com.sun.faces.taglib.html_basic.FormTag();
    _jspx_th_h_form_0.setPageContext(pageContext);
    _jspx_th_h_form_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_hx_scriptCollector_1);
    _jspx_th_h_form_0.setStyleClass("form");
    _jspx_th_h_form_0.setId("form1");
    int _jspx_eval_h_form_0 = _jspx_th_h_form_0.doStartTag();
    if (_jspx_eval_h_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write(_jsp_string14);
      
      if (_jspx_meth_h_inputText_0(_jspx_th_h_form_0, pageContext)) return true;
      
      if (_jspx_meth_h_message_0(_jspx_th_h_form_0, pageContext)) return true;
      
      if (_jspx_meth_hx_commandExButton_0(_jspx_th_h_form_0, pageContext)) return true;
      out.write(_jsp_string17);
    }
    if (_jspx_th_h_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_form_0.release();
      return true;
    }
    _jspx_th_h_form_0.release();
    return false;
  }
  
  
  private boolean _jspx_meth_hx_scriptCollector_1(javax.servlet.jsp.tagext.JspTag _jspx_th_f_view_0, PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.ibm.faces.taglib.html_extended.ScriptCollectorTag _jspx_th_hx_scriptCollector_1 = new com.ibm.faces.taglib.html_extended.ScriptCollectorTag();
    _jspx_th_hx_scriptCollector_1.setPageContext(pageContext);
    _jspx_th_hx_scriptCollector_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_view_0);
    _jspx_th_hx_scriptCollector_1.setId("scriptCollector2");
    int _jspx_eval_hx_scriptCollector_1 = _jspx_th_hx_scriptCollector_1.doStartTag();
    if (_jspx_eval_hx_scriptCollector_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      
      if (_jspx_meth_h_outputText_1(_jspx_th_hx_scriptCollector_1, pageContext)) return true;
      out.write(_jsp_string13);
      
      if (_jspx_meth_h_form_0(_jspx_th_hx_scriptCollector_1, pageContext)) return true;
      out.write(_jsp_string9);
    }
    if (_jspx_th_hx_scriptCollector_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_hx_scriptCollector_1.release();
      return true;
    }
    _jspx_th_hx_scriptCollector_1.release();
    return false;
  }
  
  
  private boolean _jspx_meth_f_view_0(PageContext pageContext)
     throws Throwable {
    JspWriter out = pageContext.getOut();
    com.sun.faces.taglib.jsf_core.ViewTag _jspx_th_f_view_0 = new com.sun.faces.taglib.jsf_core.ViewTag();
    _jspx_th_f_view_0.setPageContext(pageContext);
    _jspx_th_f_view_0.setParent(null);
    int _jspx_eval_f_view_0 = _jspx_th_f_view_0.doStartTag();
    if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = pageContext.pushBody();
        _jspx_th_f_view_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_f_view_0.doInitBody();
      }
      do {
        out.write(_jsp_string7);
        
        if (_jspx_meth_hx_scriptCollector_0(_jspx_th_f_view_0, pageContext)) return true;
        out.write(_jsp_string12);
        
        if (_jspx_meth_hx_scriptCollector_1(_jspx_th_f_view_0, pageContext)) return true;
        out.write(_jsp_string18);
        int evalDoAfterBody = _jspx_th_f_view_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN) break;
      } while (true);
      if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) out = pageContext.popBody();
    }
    if (_jspx_th_f_view_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_f_view_0.release();
      return true;
    }
    _jspx_th_f_view_0.release();
    return false;
  }
  
}
/*
D:/IBM/rationalsdp6.0/workspaceJFace2/.metadata/.plugins/com.ibm.etools.webtools.validation.jsp.core/Jsp2Java/BankJSF/_BankJSFLogin.java was generated @ Fri Jun 09 09:56:33 EEST 2006
IBM WebSphere Application Server, 6.0.0.0
	Build Number: o0444.14
	Build Date: 11/5/04
 
********************************************************
The JSP engine configuration parameters were set as follows:

classDebugInfo =              [false]
debugEnabled =                [false]
deprecation =                 [false]
compileWithAssert =           [false]
disableJspRuntimeCompilation =[false]
extendedDocumentRoot =        [null]
ieClassId =                   [clsid:8AD9C840-044E-11D1-B3E9-00805F499D93]
keepGenerated =               [true]
outputDir =                   [D:/IBM/rationalsdp6.0/workspaceJFace2/.metadata/.plugins/com.ibm.etools.webtools.validation.jsp.core/Jsp2Java/BankJSF]
reloadEnabled =               [true]
reloadEnabledSet =            [false]
reloadInterval =              [5000]
trackDependencies =           [false]
usePageTagPool =              [false]
useThreadTagPool =            [false]
useImplicitTagLibs =          [true]
verbose =                     [false]
looseLibMap =                 [{}]
useJikes =                    [false]
useFullPackageNames =         [false]
translationContextClass =     [null]
extensionProcessorClass =     [null]
jspCompileClasspath =         [null]
javaEncoding =                [UTF-8]
autoResponseEncoding =        [false]

********************************************************
The following JSP Configuration Parameters were obtained from web.xml:
 
prelude list = [[]]
coda list = [[]]
elIgnored = [false]
pageEncoding = [ISO-8859-1]
isXML = [false]
scriptingInvalid = [false]
*/
