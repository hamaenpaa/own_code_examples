// ListVDoc.h : interface of the CListVDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_LISTVDOC_H__781FDE8A_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
#define AFX_LISTVDOC_H__781FDE8A_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CListVDoc : public CDocument
{
protected: // create from serialization only
	CListVDoc();
	DECLARE_DYNCREATE(CListVDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CListVDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	const CStringList &GetElements();
	virtual ~CListVDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CListVDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CStringList m_listElements;
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LISTVDOC_H__781FDE8A_1E92_11D4_B4E3_B06D9DCD0636__INCLUDED_)
