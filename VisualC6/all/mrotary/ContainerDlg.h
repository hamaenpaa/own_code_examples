// ContainerDlg.h : header file
//
//{{AFX_INCLUDES()
#include "rotarymfc.h"
//}}AFX_INCLUDES

#if !defined(AFX_CONTAINERDLG_H__E543CD56_F1D5_11D3_A8B7_9E23E6107119__INCLUDED_)
#define AFX_CONTAINERDLG_H__E543CD56_F1D5_11D3_A8B7_9E23E6107119__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CContainerDlg dialog

class CContainerDlg : public CDialog
{
// Construction
public:
	CContainerDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CContainerDlg)
	enum { IDD = IDD_CONTAINER_DIALOG };
	double	m_dAngle;
	CRotaryMFC	m_ctlRotaryMFCCtrl;
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CContainerDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CContainerDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnRepositionedRotarymfcctrl(double dNewPosition);
	DECLARE_EVENTSINK_MAP()
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CONTAINERDLG_H__E543CD56_F1D5_11D3_A8B7_9E23E6107119__INCLUDED_)
