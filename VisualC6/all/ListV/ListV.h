// ListV.h : main header file for the LISTV application
//

#if !defined(AFX_LISTV_H__781FDE84_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_LISTV_H__781FDE84_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CListVApp:
// See ListV.cpp for the implementation of this class
//

class CListVApp : public CWinApp
{
public:
	CListVApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CListVApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CListVApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LISTV_H__781FDE84_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
