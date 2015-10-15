// ADO_Cont2.h : main header file for the ADO_CONT2 application
//

#if !defined(AFX_ADO_CONT2_H__8D5D1F55_E43B_11D3_8F22_00A024A88AE9__INCLUDED_)
#define AFX_ADO_CONT2_H__8D5D1F55_E43B_11D3_8F22_00A024A88AE9__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// CADO_Cont2App:
// See ADO_Cont2.cpp for the implementation of this class
//

class CADO_Cont2App : public CWinApp
{
public:
	CADO_Cont2App();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CADO_Cont2App)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(CADO_Cont2App)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ADO_CONT2_H__8D5D1F55_E43B_11D3_8F22_00A024A88AE9__INCLUDED_)
