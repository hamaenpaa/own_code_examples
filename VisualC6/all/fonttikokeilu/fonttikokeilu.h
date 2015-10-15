// fonttikokeilu.h : main header file for the FONTTIKOKEILU application
//

#if !defined(AFX_FONTTIKOKEILU_H__70687CA5_CA48_11D3_A755_00105A72C3E0__INCLUDED_)
#define AFX_FONTTIKOKEILU_H__70687CA5_CA48_11D3_A755_00105A72C3E0__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// CFonttikokeiluApp:
// See fonttikokeilu.cpp for the implementation of this class
//

class CFonttikokeiluApp : public CWinApp
{
public:
	CFonttikokeiluApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CFonttikokeiluApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(CFonttikokeiluApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_FONTTIKOKEILU_H__70687CA5_CA48_11D3_A755_00105A72C3E0__INCLUDED_)
