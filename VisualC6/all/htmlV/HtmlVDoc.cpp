// HtmlVDoc.cpp : implementation of the CHtmlVDoc class
//

#include "stdafx.h"
#include "HtmlV.h"

#include "HtmlVDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CHtmlVDoc

IMPLEMENT_DYNCREATE(CHtmlVDoc, CDocument)

BEGIN_MESSAGE_MAP(CHtmlVDoc, CDocument)
	//{{AFX_MSG_MAP(CHtmlVDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CHtmlVDoc construction/destruction

CHtmlVDoc::CHtmlVDoc()
{
	// TODO: add one-time construction code here

}

CHtmlVDoc::~CHtmlVDoc()
{
}

BOOL CHtmlVDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CHtmlVDoc serialization

void CHtmlVDoc::Serialize(CArchive& ar)
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
// CHtmlVDoc diagnostics

#ifdef _DEBUG
void CHtmlVDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CHtmlVDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CHtmlVDoc commands
