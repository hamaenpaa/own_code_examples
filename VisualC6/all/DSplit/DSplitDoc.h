// DSplitDoc.h : interface of the CDSplitDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_DSPLITDOC_H__781FDEDD_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_DSPLITDOC_H__781FDEDD_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CDSplitDoc : public CDocument
{
protected: // create from serialization only
	CDSplitDoc();
	DECLARE_DYNCREATE(CDSplitDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDSplitDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CDSplitDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CDSplitDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DSPLITDOC_H__781FDEDD_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
