// ListVView.h : interface of the CListVView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_LISTVVIEW_H__781FDE8C_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_LISTVVIEW_H__781FDE8C_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CListVView : public CListView
{
protected: // create from serialization only
	CListVView();
	DECLARE_DYNCREATE(CListVView)

// Attributes
public:
	CListVDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CListVView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual void OnInitialUpdate(); // called first time after construct
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CListVView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CListVView)
	afx_msg void OnClick(NMHDR* pNMHDR, LRESULT* pResult);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in ListVView.cpp
inline CListVDoc* CListVView::GetDocument()
   { return (CListVDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LISTVVIEW_H__781FDE8C_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
