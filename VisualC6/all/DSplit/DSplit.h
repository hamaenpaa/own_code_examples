// DSplit.h : main header file for the DSPLIT application
//

#if !defined(AFX_DSPLIT_H__781FDED7_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_DSPLIT_H__781FDED7_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CDSplitApp:
// See DSplit.cpp for the implementation of this class
//

class CDSplitApp : public CWinApp
{
public:
	CDSplitApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDSplitApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CDSplitApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DSPLIT_H__781FDED7_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
