#if !defined(AFX_ROTARYMFC_H__5F078F2C_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_)
#define AFX_ROTARYMFC_H__5F078F2C_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

// RotaryMFC.h : main header file for ROTARYMFC.DLL

#if !defined( __AFXCTL_H__ )
	#error include 'afxctl.h' before including this file
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCApp : See RotaryMFC.cpp for implementation.

class CRotaryMFCApp : public COleControlModule
{
public:
	BOOL InitInstance();
	int ExitInstance();
};

extern const GUID CDECL _tlid;
extern const WORD _wVerMajor;
extern const WORD _wVerMinor;

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ROTARYMFC_H__5F078F2C_F19F_11D3_A8B6_A98D54C87C19__INCLUDED)
