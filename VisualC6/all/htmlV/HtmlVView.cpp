// HtmlVView.cpp : implementation of the CHtmlVView class
//

#include "stdafx.h"
#include "HtmlV.h"

#include "HtmlVDoc.h"
#include "HtmlVView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CHtmlVView

IMPLEMENT_DYNCREATE(CHtmlVView, CHtmlView)

BEGIN_MESSAGE_MAP(CHtmlVView, CHtmlView)
	//{{AFX_MSG_MAP(CHtmlVView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CHtmlView::OnFilePrint)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CHtmlVView construction/destruction

CHtmlVView::CHtmlVView()
{
	// TODO: add construction code here

}

CHtmlVView::~CHtmlVView()
{
}

BOOL CHtmlVView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CHtmlView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CHtmlVView drawing

void CHtmlVView::OnDraw(CDC* pDC)
{
	CHtmlVDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

void CHtmlVView::OnInitialUpdate()
{
	CHtmlView::OnInitialUpdate();

	// TODO: This code navigates to a popular spot on the web.
	//  change the code to go where you'd like.
	Navigate2(_T("http://www.microsoft.com/visualc/"),NULL,NULL);
}

/////////////////////////////////////////////////////////////////////////////
// CHtmlVView printing


/////////////////////////////////////////////////////////////////////////////
// CHtmlVView diagnostics

#ifdef _DEBUG
void CHtmlVView::AssertValid() const
{
	CHtmlView::AssertValid();
}

void CHtmlVView::Dump(CDumpContext& dc) const
{
	CHtmlView::Dump(dc);
}

CHtmlVDoc* CHtmlVView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CHtmlVDoc)));
	return (CHtmlVDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CHtmlVView message handlers
