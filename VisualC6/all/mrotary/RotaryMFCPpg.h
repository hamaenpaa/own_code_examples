#if !defined(AFX_ROTARYMFCPPG_H__5F078F36_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_)
#define AFX_ROTARYMFCPPG_H__5F078F36_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

// RotaryMFCPpg.h : Declaration of the CRotaryMFCPropPage property page class.

////////////////////////////////////////////////////////////////////////////
// CRotaryMFCPropPage : See RotaryMFCPpg.cpp.cpp for implementation.

class CRotaryMFCPropPage : public COlePropertyPage
{
	DECLARE_DYNCREATE(CRotaryMFCPropPage)
	DECLARE_OLECREATE_EX(CRotaryMFCPropPage)

// Constructor
public:
	CRotaryMFCPropPage();

// Dialog Data
	//{{AFX_DATA(CRotaryMFCPropPage)
	enum { IDD = IDD_PROPPAGE_ROTARYMFC };
	short	m_sNumTicks;
	BOOL	m_bTicks;
	//}}AFX_DATA

// Implementation
protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

// Message maps
protected:
	//{{AFX_MSG(CRotaryMFCPropPage)
	afx_msg void OnTicksEnabled();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ROTARYMFCPPG_H__5F078F36_F19F_11D3_A8B6_A98D54C87C19__INCLUDED)
