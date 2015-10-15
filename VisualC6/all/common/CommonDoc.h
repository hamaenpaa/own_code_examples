// CommonDoc.h : interface of the CCommonDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_COMMONDOC_H__1527A44A_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
#define AFX_COMMONDOC_H__1527A44A_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CCommonDoc : public CDocument
{
protected: // create from serialization only
	CCommonDoc();
	DECLARE_DYNCREATE(CCommonDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCommonDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CCommonDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CCommonDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_COMMONDOC_H__1527A44A_1C83_11D4_B4E3_F1FDB72C0E36__INCLUDED_)
