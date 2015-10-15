#if !defined(AFX_ROTARYMFCCTL_H__5F078F34_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_)
#define AFX_ROTARYMFCCTL_H__5F078F34_F19F_11D3_A8B6_A98D54C87C19__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

// RotaryMFCCtl.h : Declaration of the CRotaryMFCCtrl ActiveX Control class.

/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl : See RotaryMFCCtl.cpp for implementation.

class CRotaryMFCCtrl : public COleControl
{
	DECLARE_DYNCREATE(CRotaryMFCCtrl)

// Constructor
public:
	CRotaryMFCCtrl();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CRotaryMFCCtrl)
	public:
	virtual void OnDraw(CDC* pdc, const CRect& rcBounds, const CRect& rcInvalid);
	virtual void DoPropExchange(CPropExchange* pPX);
	virtual void OnResetState();
	//}}AFX_VIRTUAL

// Implementation
protected:
	~CRotaryMFCCtrl();

	DECLARE_OLECREATE_EX(CRotaryMFCCtrl)    // Class factory and guid
	DECLARE_OLETYPELIB(CRotaryMFCCtrl)      // GetTypeInfo
	DECLARE_PROPPAGEIDS(CRotaryMFCCtrl)     // Property page IDs
	DECLARE_OLECTLTYPE(CRotaryMFCCtrl)		// Type name and misc status

// Message maps
	//{{AFX_MSG(CRotaryMFCCtrl)
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()

// Dispatch maps
	//{{AFX_DISPATCH(CRotaryMFCCtrl)
	afx_msg BOOL GetTicksEnable();
	afx_msg void SetTicksEnable(BOOL bNewValue);
	afx_msg short GetNumTicks();
	afx_msg void SetNumTicks(short nNewValue);
	//}}AFX_DISPATCH
	DECLARE_DISPATCH_MAP()

	afx_msg void AboutBox();

// Event maps
	//{{AFX_EVENT(CRotaryMFCCtrl)
	void FireRepositioned(double dNewPosition)
		{FireEvent(eventidRepositioned,EVENT_PARAM(VTS_R8), dNewPosition);}
	//}}AFX_EVENT
	DECLARE_EVENT_MAP()

// Dispatch and event IDs
public:
	BOOL m_bTicks;
	short m_sNumTicks;
	double m_dCurrentPosition;
	CPoint m_ptClicked;
	enum {
	//{{AFX_DISP_ID(CRotaryMFCCtrl)
	dispidTicksEnable = 1L,
	dispidNumTicks = 2L,
	eventidRepositioned = 1L,
	//}}AFX_DISP_ID
	};
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ROTARYMFCCTL_H__5F078F34_F19F_11D3_A8B6_A98D54C87C19__INCLUDED)
