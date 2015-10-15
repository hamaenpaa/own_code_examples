// HtmlV.h : main header file for the HTMLV application
//

#if !defined(AFX_HTMLV_H__781FDEC3_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_HTMLV_H__781FDEC3_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CHtmlVApp:
// See HtmlV.cpp for the implementation of this class
//

class CHtmlVApp : public CWinApp
{
public:
	CHtmlVApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CHtmlVApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CHtmlVApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_HTMLV_H__781FDEC3_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
