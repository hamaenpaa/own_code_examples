// ListVView.cpp : implementation of the CListVView class
//

#include "stdafx.h"
#include "ListV.h"

#include "ListVDoc.h"
#include "ListVView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CListVView

IMPLEMENT_DYNCREATE(CListVView, CListView)

BEGIN_MESSAGE_MAP(CListVView, CListView)
	//{{AFX_MSG_MAP(CListVView)
	ON_NOTIFY_REFLECT(NM_CLICK, OnClick)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CListView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CListView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CListView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CListVView construction/destruction

CListVView::CListVView()
{
	// TODO: add construction code here

}

CListVView::~CListVView()
{
}

BOOL CListVView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CListView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CListVView drawing

void CListVView::OnDraw(CDC* pDC)
{
	CListVDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

void CListVView::OnInitialUpdate()
{
	CListView::OnInitialUpdate();

	GetListCtrl().InsertColumn(0,"Element Name", LVCFMT_LEFT, 120 );
	GetListCtrl().InsertColumn(1,"Symbol", LVCFMT_CENTER, 70 );
	GetListCtrl().InsertColumn(2,"Atomic Number", LVCFMT_RIGHT, 130 );

	CListVDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);

	POSITION pos = pDoc->GetElements().GetHeadPosition();


	while(pos)
	{
		CString strElement = pDoc->GetElements().GetNext(pos);
/*
//		For LVS_LIST and for LVS_ICON style
		GetListCtrl().InsertItem(0,strElement); 
*/
		CString strName = strElement.Left(strElement.Find(","));
		CString strSymbol = strElement.Mid(strElement.Find(",")+1);
		CString strAtomicNumber = strSymbol.Mid(strSymbol.Find(",")+1);
		strSymbol = strSymbol.Left(strSymbol.Find(","));

		GetListCtrl().InsertItem(0,strName);
		GetListCtrl().SetItemText(0,1,strSymbol);
		GetListCtrl().SetItemText(0,2,strAtomicNumber);
	}
	// LVS_LIST/LVS_REPORT -style for List Control
	DWORD dwStyle = GetWindowLong(GetListCtrl().GetSafeHwnd(),GWL_STYLE);
	dwStyle &= ~LVS_TYPEMASK;
	dwStyle |= LVS_REPORT; // LVS_LIST or LVS_REPORT
	SetWindowLong(GetListCtrl().GetSafeHwnd(),GWL_STYLE,dwStyle);
	SetRedraw(TRUE);
}

/////////////////////////////////////////////////////////////////////////////
// CListVView printing

BOOL CListVView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CListVView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CListVView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CListVView diagnostics

#ifdef _DEBUG
void CListVView::AssertValid() const
{
	CListView::AssertValid();
}

void CListVView::Dump(CDumpContext& dc) const
{
	CListView::Dump(dc);
}

CListVDoc* CListVView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CListVDoc)));
	return (CListVDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CListVView message handlers

void CListVView::OnClick(NMHDR* pNMHDR, LRESULT* pResult) 
{
	*pResult = 0;
	CString strSelectedItems;
	int nSelected = -1;
	do
	{
		nSelected = GetListCtrl().GetNextItem(nSelected,LVNI_SELECTED);
		if (nSelected != -1)
		{
			strSelectedItems += " " + GetListCtrl().GetItemText(nSelected,0);
		}
	} while (nSelected != -1);
	GetDocument()->SetTitle("Selected:" + strSelectedItems );
}
