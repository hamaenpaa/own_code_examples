// ADO_Cont2Dlg.h : header file
//
//{{AFX_INCLUDES()
#include "adodc.h"
#include "datagrid.h"
//}}AFX_INCLUDES

#if !defined(AFX_ADO_CONT2DLG_H__8D5D1F57_E43B_11D3_8F22_00A024A88AE9__INCLUDED_)
#define AFX_ADO_CONT2DLG_H__8D5D1F57_E43B_11D3_8F22_00A024A88AE9__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CADO_Cont2Dlg dialog

class CADO_Cont2Dlg : public CDialog
{
// Construction
public:
	CADO_Cont2Dlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CADO_Cont2Dlg)
	enum { IDD = IDD_ADO_CONT2_DIALOG };
	CAdodc	m_ctlAdodc;
	CDataGrid	m_ctlDatagrid;
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CADO_Cont2Dlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CADO_Cont2Dlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnButton();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ADO_CONT2DLG_H__8D5D1F57_E43B_11D3_8F22_00A024A88AE9__INCLUDED_)
