// HtmlVView.h : interface of the CHtmlVView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_HTMLVVIEW_H__781FDECB_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_HTMLVVIEW_H__781FDECB_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CHtmlVView : public CHtmlView
{
protected: // create from serialization only
	CHtmlVView();
	DECLARE_DYNCREATE(CHtmlVView)

// Attributes
public:
	CHtmlVDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CHtmlVView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual void OnInitialUpdate(); // called first time after construct
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CHtmlVView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CHtmlVView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in HtmlVView.cpp
inline CHtmlVDoc* CHtmlVView::GetDocument()
   { return (CHtmlVDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_HTMLVVIEW_H__781FDECB_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
