// CommonView.h : interface of the CCommonView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_COMMONVIEW_H__1527A44C_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
#define AFX_COMMONVIEW_H__1527A44C_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CCommonView : public CScrollView
{
protected: // create from serialization only
	CCommonView();
	DECLARE_DYNCREATE(CCommonView)

// Attributes
public:
	CCommonDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCommonView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	virtual void OnInitialUpdate();
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual BOOL OnNotify(WPARAM wParam, LPARAM lParam, LRESULT* pResult);
	//}}AFX_VIRTUAL

// Implementation
public:
	void CreateMonth();
	void CreateDatePicker();
	void CreateIPAddress();
	void CreateRichEdit();
	void CreateTreeView();
	void CreateListView();
	void CreateUpDownCtrl();
	void CreateTrackBar();
	void CreateProgressBar();
	virtual ~CCommonView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:
// Progress bar
	CProgressCtrl m_progressBar;
// Trackbar or Slider
	CSliderCtrl m_trackBar;
	BOOL m_timer;
// Up-Down or Spinner
	CSpinButtonCtrl m_upDown;
	CEdit m_buddyEdit;
// List View
	CListCtrl m_listView;
	CImageList m_smallImageList;
	CImageList m_largeImageList;
	CButton m_smallButton;
	CButton m_largeButton;
	CButton m_listButton;
	CButton m_reportButton;
// Tree View
	CTreeCtrl m_treeView;
	CImageList m_treeImageList;
// Rich Edit
	CRichEditCtrl m_richEdit;
	CButton m_boldButton;
	CButton m_leftButton;
	CButton m_centerButton;	
	CButton m_rightButton;
// IP Address
	CIPAddressCtrl m_ipAddress;
// Date Picker
	CDateTimeCtrl m_date;
// Month Calendar
	CMonthCalCtrl m_month;
// Generated message map functions
protected:
	//{{AFX_MSG(CCommonView)
	afx_msg int OnCreate(LPCREATESTRUCT lpCreateStruct);
	afx_msg void OnCancelMode();
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnDestroy();
	afx_msg void OnTimer(UINT nIDEvent);
	afx_msg void OnHScroll(UINT nSBCode, UINT nPos, CScrollBar* pScrollBar);
	//}}AFX_MSG
	afx_msg void OnSmall();
	afx_msg void OnLarge();
	afx_msg void OnList();
	afx_msg void OnReport();
	afx_msg void OnULine();
	afx_msg void OnLeft();
	afx_msg void OnCenter();
	afx_msg void OnRight();
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in CommonView.cpp
inline CCommonDoc* CCommonView::GetDocument()
   { return (CCommonDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_COMMONVIEW_H__1527A44C_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
