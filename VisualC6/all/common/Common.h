// Common.h : main header file for the COMMON application
//

#if !defined(AFX_COMMON_H__1527A444_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
#define AFX_COMMON_H__1527A444_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CCommonApp:
// See Common.cpp for the implementation of this class
//

class CCommonApp : public CWinApp
{
public:
	CCommonApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCommonApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CCommonApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_COMMON_H__1527A444_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
