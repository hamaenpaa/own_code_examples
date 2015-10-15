// DSplitView.cpp : implementation of the CDSplitView class
//

#include "stdafx.h"
#include "DSplit.h"

#include "DSplitDoc.h"
#include "DSplitView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDSplitView

IMPLEMENT_DYNCREATE(CDSplitView, CScrollView)

BEGIN_MESSAGE_MAP(CDSplitView, CScrollView)
	//{{AFX_MSG_MAP(CDSplitView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CScrollView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDSplitView construction/destruction

CDSplitView::CDSplitView()
{
	// TODO: add construction code here

}

CDSplitView::~CDSplitView()
{
}

BOOL CDSplitView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CDSplitView drawing

void CDSplitView::OnDraw(CDC* pDC)
{
	CDSplitDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	
	TEXTMETRIC tm;
	int nLineHeight;
	pDC->GetTextMetrics(&tm);
	nLineHeight = tm.tmHeight + tm.tmExternalLeading;
	CString str;
	for( int nLine = 1;nLine < 51; nLine++ )
	{
		str.Format("Line %d - I must NOT feed my homework to my dog.", nLine );
		pDC->TextOut(5,nLine*nLineHeight,str);
	}

}

void CDSplitView::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	CSize sizeTotal;
	// TODO: calculate the total size of this view
	sizeTotal.cx = sizeTotal.cy = 1000;
	SetScrollSizes(MM_TEXT, sizeTotal);
}

/////////////////////////////////////////////////////////////////////////////
// CDSplitView printing

BOOL CDSplitView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CDSplitView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CDSplitView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CDSplitView diagnostics

#ifdef _DEBUG
void CDSplitView::AssertValid() const
{
	CScrollView::AssertValid();
}

void CDSplitView::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CDSplitDoc* CDSplitView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CDSplitDoc)));
	return (CDSplitDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CDSplitView message handlers
