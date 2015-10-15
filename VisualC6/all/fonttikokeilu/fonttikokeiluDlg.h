// fonttikokeiluDlg.h : header file
//

#if !defined(AFX_FONTTIKOKEILUDLG_H__70687CA7_CA48_11D3_A755_00105A72C3E0__INCLUDED_)
#define AFX_FONTTIKOKEILUDLG_H__70687CA7_CA48_11D3_A755_00105A72C3E0__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CFonttikokeiluDlg dialog

class CFonttikokeiluDlg : public CDialog
{
// Construction
public:
	CFonttikokeiluDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CFonttikokeiluDlg)
	enum { IDD = IDD_FONTTIKOKEILU_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CFonttikokeiluDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CFonttikokeiluDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_FONTTIKOKEILUDLG_H__70687CA7_CA48_11D3_A755_00105A72C3E0__INCLUDED_)
