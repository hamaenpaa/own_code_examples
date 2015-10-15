// ListVDoc.cpp : implementation of the CListVDoc class
//

#include "stdafx.h"
#include "ListV.h"

#include "ListVDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CListVDoc

IMPLEMENT_DYNCREATE(CListVDoc, CDocument)

BEGIN_MESSAGE_MAP(CListVDoc, CDocument)
	//{{AFX_MSG_MAP(CListVDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CListVDoc construction/destruction

CListVDoc::CListVDoc()
{
	m_listElements.AddTail("Carbon,C,6");
	m_listElements.AddTail("Uradium,U,92");
	m_listElements.AddTail("Gold,Au,79");
	m_listElements.AddTail("Osmium,Os,76");
	m_listElements.AddTail("Oxygen,O,8");
	m_listElements.AddTail("Lead,Pb,82");
}

CListVDoc::~CListVDoc()
{
}

BOOL CListVDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CListVDoc serialization

void CListVDoc::Serialize(CArchive& ar)
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
// CListVDoc diagnostics

#ifdef _DEBUG
void CListVDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CListVDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CListVDoc commands

const CStringList &CListVDoc::GetElements()
{
	return m_listElements;
}
