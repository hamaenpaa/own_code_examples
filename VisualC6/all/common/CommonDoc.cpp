// CommonDoc.cpp : implementation of the CCommonDoc class
//

#include "stdafx.h"
#include "Common.h"

#include "CommonDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCommonDoc

IMPLEMENT_DYNCREATE(CCommonDoc, CDocument)

BEGIN_MESSAGE_MAP(CCommonDoc, CDocument)
	//{{AFX_MSG_MAP(CCommonDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCommonDoc construction/destruction

CCommonDoc::CCommonDoc()
{
	// TODO: add one-time construction code here

}

CCommonDoc::~CCommonDoc()
{
}

BOOL CCommonDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CCommonDoc serialization

void CCommonDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CCommonDoc diagnostics

#ifdef _DEBUG
void CCommonDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CCommonDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCommonDoc commands
