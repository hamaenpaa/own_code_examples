// DSplitView.h : interface of the CDSplitView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_DSPLITVIEW_H__781FDEDF_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_DSPLITVIEW_H__781FDEDF_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CDSplitView : public CScrollView
{
protected: // create from serialization only
	CDSplitView();
	DECLARE_DYNCREATE(CDSplitView)

// Attributes
public:
	CDSplitDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDSplitView)
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
	virtual ~CDSplitView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CDSplitView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in DSplitView.cpp
inline CDSplitDoc* CDSplitView::GetDocument()
   { return (CDSplitDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DSPLITVIEW_H__781FDEDF_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
