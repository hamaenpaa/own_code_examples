// CommonView.cpp : implementation of the CCommonView class
//

#include "stdafx.h"
#include "Common.h"

#include "CommonDoc.h"
#include "CommonView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCommonView

IMPLEMENT_DYNCREATE(CCommonView, CScrollView)

BEGIN_MESSAGE_MAP(CCommonView, CScrollView)
	//{{AFX_MSG_MAP(CCommonView)
	ON_WM_CREATE()
	ON_WM_CANCELMODE()
	ON_WM_LBUTTONDOWN()
	ON_WM_DESTROY()
	ON_WM_TIMER()
	ON_WM_HSCROLL()
	//}}AFX_MSG_MAP
	ON_COMMAND(IDC_LISTVIEW_SMALL, OnSmall)
	ON_COMMAND(IDC_LISTVIEW_LARGE, OnLarge)
	ON_COMMAND(IDC_LISTVIEW_LIST, OnList)
	ON_COMMAND(IDC_LISTVIEW_REPORT, OnReport)
	ON_COMMAND(IDC_RICHEDIT_ULINE, OnULine)
	ON_COMMAND(IDC_RICHEDIT_LEFT, OnLeft)
	ON_COMMAND(IDC_RICHEDIT_CENTER, OnCenter)
	ON_COMMAND(IDC_RICHEDIT_RIGHT, OnRight)
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CScrollView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCommonView construction/destruction

CCommonView::CCommonView()
{
	m_timer = FALSE;
}

CCommonView::~CCommonView()
{
}

BOOL CCommonView::PreCreateWindow(CREATESTRUCT& cs)
{
	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CCommonView drawing

void CCommonView::OnDraw(CDC* pDC)
{
	CCommonDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	pDC->TextOut(20,22,"Progress Bar Control");
	pDC->TextOut(270,22,"TrackBar Control");
	pDC->TextOut(20,102,"Up-Down Control");
	pDC->TextOut(160,102,"List View Control");
	pDC->TextOut(20,240,"Tree View Control");
	pDC->TextOut(180,240,"Rich Edit Control");
	pDC->TextOut(470,22,"IP Address Control");
	pDC->TextOut(470,102,"Date Picker Control");
	pDC->TextOut(470,240,"Month Calendar Control");
}

/////////////////////////////////////////////////////////////////////////////
// CCommonView printing

BOOL CCommonView::OnPreparePrinting(CPrintInfo* pInfo)
{
	return DoPreparePrinting(pInfo);
}

void CCommonView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
}

void CCommonView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
}

/////////////////////////////////////////////////////////////////////////////
// CCommonView diagnostics

#ifdef _DEBUG
void CCommonView::AssertValid() const
{
	CScrollView::AssertValid();
}

void CCommonView::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CCommonDoc* CCommonView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCommonDoc)));
	return (CCommonDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCommonView message handlers

int CCommonView::OnCreate(LPCREATESTRUCT lpCreateStruct) 
{
	if (CScrollView::OnCreate(lpCreateStruct) == -1)
		return -1;
	CreateProgressBar();
	CreateTrackBar();
	CreateUpDownCtrl();
	CreateListView();
	CreateTreeView();
	CreateRichEdit();
	CreateIPAddress();
	CreateDatePicker();
	CreateMonth();
	return 0;
}

void CCommonView::OnCancelMode() 
{
	CScrollView::OnCancelMode();
}

void CCommonView::CreateProgressBar()
{
	m_progressBar.Create( WS_CHILD | WS_VISIBLE | WS_BORDER , 
		CRect(20,40,250,80), this, IDC_PROGRESSBAR );
	m_progressBar.SetRange(1,100);
	m_progressBar.SetStep(10);
	m_progressBar.SetPos(50);
	m_timer = FALSE;
}

void CCommonView::OnLButtonDown(UINT nFlags, CPoint point) 
{
	if (m_timer)
	{
		KillTimer(1);
		m_timer = FALSE;
	}
	else
	{
		SetTimer(1,500,NULL);
		m_timer = TRUE;
	}
	CView::OnLButtonDown(nFlags, point);
}

void CCommonView::OnDestroy() 
{
	CScrollView::OnDestroy();
	KillTimer(1);
}

void CCommonView::OnTimer(UINT nIDEvent) 
{
	m_progressBar.StepIt();
	CScrollView::OnTimer(nIDEvent);
}

void CCommonView::CreateTrackBar()
{
	m_trackBar.Create( WS_CHILD | WS_VISIBLE | WS_BORDER |
		TBS_AUTOTICKS | TBS_BOTH | TBS_HORZ,
		CRect(270,40,450,80), this, IDC_TRACKBAR );
	m_trackBar.SetRange(0,100,TRUE);
	m_trackBar.SetTicFreq(10);
	m_trackBar.SetLineSize(1);
	m_trackBar.SetPageSize(10);
}

void CCommonView::OnHScroll(UINT nSBCode, UINT nPos, CScrollBar* pScrollBar) 
{
	CSliderCtrl* slider = (CSliderCtrl*)pScrollBar;
	if (slider == &m_trackBar)
	{
		int position = slider->GetPos();
		char s[10];
		wsprintf(s,"%d   ", position );
		CClientDC clientDC(this);
		clientDC.TextOut(390,22, s);
	}
	CScrollView::OnHScroll(nSBCode, nPos, pScrollBar);
}

void CCommonView::CreateUpDownCtrl()
{
	m_buddyEdit.Create( WS_CHILD | WS_VISIBLE | WS_BORDER, 
		CRect(50,120,110,160), this, IDC_BUDDYEDIT);
	m_upDown.Create( WS_CHILD | WS_VISIBLE | WS_BORDER |
		UDS_ALIGNRIGHT | UDS_SETBUDDYINT | UDS_ARROWKEYS,
		CRect(0,0,0,0), this, IDC_UPDOWN );
	m_upDown.SetBuddy(&m_buddyEdit);
	m_upDown.SetRange(1,100);
	m_upDown.SetPos(50);
}

void CCommonView::CreateListView()
{
	m_smallImageList.Create(16,16,FALSE,1,0);
	m_largeImageList.Create(32,32,FALSE,1,0);
	HICON hIcon = ::LoadIcon(AfxGetResourceHandle(), MAKEINTRESOURCE(IDI_ICON1));
	m_smallImageList.Add(hIcon);
	hIcon = ::LoadIcon(AfxGetResourceHandle(), MAKEINTRESOURCE(IDI_ICON2));
	m_largeImageList.Add(hIcon);
	// Create the List View Control
	m_listView.Create( WS_CHILD | WS_VISIBLE | WS_BORDER |
		LVS_REPORT | LVS_NOSORTHEADER | LVS_EDITLABELS,
		CRect(160,120,394,220), this, IDC_LISTVIEW );
	m_listView.SetImageList(&m_smallImageList, LVSIL_SMALL );
	m_listView.SetImageList(&m_largeImageList, LVSIL_NORMAL );
	LV_COLUMN lvColumn;
	lvColumn.mask = LVCF_FMT | LVCF_WIDTH | LVCF_TEXT | LVCF_SUBITEM;
	lvColumn.fmt = LVCFMT_CENTER;
	lvColumn.cx = 75;

	lvColumn.iSubItem = 0;
	lvColumn.pszText = "Column 0";
	m_listView.InsertColumn(0, &lvColumn);

	lvColumn.iSubItem = 1;
	lvColumn.pszText = "Column 1";
	m_listView.InsertColumn(1, &lvColumn);

	lvColumn.iSubItem = 2;
	lvColumn.pszText = "Column 2";
	m_listView.InsertColumn(2, &lvColumn);
	// Create the Items
	LV_ITEM lvItem;
	lvItem.mask = LVIF_TEXT | LVIF_IMAGE | LVIF_STATE;
	lvItem.state = 0;
	lvItem.stateMask = 0;
	lvItem.iImage = 0;

	lvItem.iItem = 0;
	lvItem.iSubItem = 0;
	lvItem.pszText = "Item 0";
	m_listView.InsertItem( &lvItem );
	m_listView.SetItemText(0,0,"Sub Item 0.0");
	m_listView.SetItemText(0,1,"Sub Item 0.1");
	m_listView.SetItemText(0,2,"Sub Item 0.2");

	lvItem.iItem = 1;
	lvItem.iSubItem = 0;
	lvItem.pszText = "Item 1";
	m_listView.InsertItem( &lvItem );
	m_listView.SetItemText(1,0,"Sub Item 1.0");
	m_listView.SetItemText(1,1,"Sub Item 1.1");
	m_listView.SetItemText(1,2,"Sub Item 1.2");

	lvItem.iItem = 2;
	lvItem.iSubItem = 0;
	lvItem.pszText = "Item 2";
	m_listView.InsertItem( &lvItem );
	m_listView.SetItemText(2,0,"Sub Item 2.0");
	m_listView.SetItemText(2,1,"Sub Item 2.1");
	m_listView.SetItemText(2,2,"Sub Item 2.2");
	// Create the view-control buttons
	m_smallButton.Create("Small", WS_CHILD | WS_VISIBLE | WS_BORDER, 
		CRect(400,120,450,140), this, IDC_LISTVIEW_SMALL );
	m_largeButton.Create("Large", WS_CHILD | WS_VISIBLE | WS_BORDER, 
		CRect(400,145,450,165), this, IDC_LISTVIEW_LARGE );
	m_listButton.Create("List", WS_CHILD | WS_VISIBLE | WS_BORDER, 
		CRect(400,170,450,190), this, IDC_LISTVIEW_LIST );
	m_reportButton.Create("Report", WS_CHILD | WS_VISIBLE | WS_BORDER, 
		CRect(400,195,450,215), this, IDC_LISTVIEW_REPORT );
}


void CCommonView::CreateTreeView()
{
	m_treeImageList.Create(13,13,FALSE,3,0);
	HICON hIcon = ::LoadIcon(AfxGetResourceHandle(), MAKEINTRESOURCE(IDI_ICON3));
	m_treeImageList.Add(hIcon);
	hIcon = ::LoadIcon(AfxGetResourceHandle(), MAKEINTRESOURCE(IDI_ICON4));
	m_treeImageList.Add(hIcon);
	hIcon = ::LoadIcon(AfxGetResourceHandle(), MAKEINTRESOURCE(IDI_ICON5));
	m_treeImageList.Add(hIcon);
	// Create the Tree View Control
	m_treeView.Create( WS_CHILD | WS_VISIBLE | WS_BORDER |
		TVS_HASLINES | TVS_LINESATROOT | TVS_HASBUTTONS |
		TVS_EDITLABELS, CRect(20,260,160,360), this,
		IDC_TREEVIEW );
	m_treeView.SetImageList(&m_treeImageList, TVSIL_NORMAL );
	// Create the Root Item
	TVITEM tvItem;
	tvItem.mask = TVIF_TEXT | TVIF_IMAGE | TVIF_SELECTEDIMAGE;
	tvItem.pszText = "Root";
	tvItem.cchTextMax = 4;
	tvItem.iImage = 0;
	tvItem.iSelectedImage = 0;
	TVINSERTSTRUCT tvInsert;
	tvInsert.hParent = TVI_ROOT;
	tvInsert.hInsertAfter = TVI_FIRST;
	tvInsert.item = tvItem;
	HTREEITEM hRoot = m_treeView.InsertItem(&tvInsert);
	// Create the first child Item
	tvItem.pszText = "Child Item 1";
	tvItem.cchTextMax = 12;
	tvItem.iImage = 1;
	tvItem.iSelectedImage = 1;
	tvInsert.hParent = hRoot;
	tvInsert.hInsertAfter = TVI_FIRST;
	tvInsert.item = tvItem;
	HTREEITEM hChildItem = m_treeView.InsertItem(&tvInsert);
	// Create a child of the first child Item
	tvItem.pszText = "Child Item 2";
	tvItem.cchTextMax = 12;
	tvItem.iImage = 2;
	tvItem.iSelectedImage = 2;
	tvInsert.hParent = hChildItem;
	tvInsert.hInsertAfter = TVI_FIRST;
	tvInsert.item = tvItem;
	m_treeView.InsertItem(&tvInsert);
	// Create another child of the root Item
	tvItem.pszText = "Child Item 3";
	tvItem.cchTextMax = 12;
	tvItem.iImage = 1;
	tvItem.iSelectedImage = 1;
	tvInsert.hParent = hRoot;
	tvInsert.hInsertAfter = TVI_LAST;
	tvInsert.item = tvItem;
	m_treeView.InsertItem(&tvInsert);
}


void CCommonView::OnSmall()
{
	SetWindowLong(m_listView.m_hWnd, GWL_STYLE, 
		WS_CHILD | WS_VISIBLE | WS_BORDER | 
		LVS_SMALLICON | LVS_EDITLABELS );
}


void CCommonView::OnLarge()
{
	SetWindowLong(m_listView.m_hWnd, GWL_STYLE, 
		WS_CHILD | WS_VISIBLE | WS_BORDER | 
		LVS_ICON | LVS_EDITLABELS );
}

void CCommonView::OnList()
{
	SetWindowLong(m_listView.m_hWnd, GWL_STYLE, 
		WS_CHILD | WS_VISIBLE | WS_BORDER |
		LVS_LIST | LVS_EDITLABELS );
}


void CCommonView::OnReport()
{
	SetWindowLong(m_listView.m_hWnd, GWL_STYLE, 
		WS_CHILD | WS_VISIBLE | WS_BORDER |
		LVS_REPORT | LVS_EDITLABELS );
}


BOOL CCommonView::OnNotify(WPARAM wParam, LPARAM lParam, LRESULT* pResult) 
{
	LV_DISPINFO* lv_dispInfo = (LV_DISPINFO*) lParam;
	if (lv_dispInfo->hdr.code == LVN_BEGINLABELEDIT)
	{
		CEdit* pEdit = m_listView.GetEditControl();
		// manipulate Edit control here
	}
	else
	{
		if ((lv_dispInfo->item.pszText != NULL) &&
			(lv_dispInfo->item.iItem != -1))
		{
			m_listView.SetItemText(lv_dispInfo->item.iItem,
				0, lv_dispInfo->item.pszText );
		}
	}
	
	TV_DISPINFO* tv_dispInfo = (TV_DISPINFO*) lParam;
	if (tv_dispInfo->hdr.code == TVN_BEGINLABELEDIT)
	{
		CEdit* pEdit = m_listView.GetEditControl();
		// manipulate Edit control here
	}
	else
	{
		if (tv_dispInfo->item.pszText != NULL)
		{
			m_treeView.SetItemText(tv_dispInfo->item.hItem, 
				tv_dispInfo->item.pszText );
		}
	}
	return CScrollView::OnNotify(wParam, lParam, pResult);
}

void CCommonView::CreateRichEdit()
{
	m_richEdit.Create( WS_CHILD | WS_VISIBLE | WS_BORDER |
		ES_AUTOVSCROLL | ES_MULTILINE,
		CRect(180,260,393,360), this, IDC_RICHEDIT );
	m_boldButton.Create( "ULine", WS_CHILD | WS_VISIBLE | WS_BORDER,
		CRect(400,260,450,280), this, IDC_RICHEDIT_ULINE );
	m_leftButton.Create( "Left", WS_CHILD | WS_VISIBLE | WS_BORDER,
		CRect(400,285,450,305), this, IDC_RICHEDIT_LEFT);
	m_centerButton.Create( "Center", WS_CHILD | WS_VISIBLE | WS_BORDER,
		CRect(400,310,450,330), this, IDC_RICHEDIT_CENTER );
	m_rightButton.Create( "Right", WS_CHILD | WS_VISIBLE | WS_BORDER,
		CRect(400,335,450,355), this, IDC_RICHEDIT_RIGHT );
}

void CCommonView::OnULine()
{
	CHARFORMAT charFormat;
	charFormat.cbSize = sizeof(CHARFORMAT);
	charFormat.dwMask = CFM_UNDERLINE;
	m_richEdit.GetSelectionCharFormat(charFormat);
	if (charFormat.dwEffects & CFM_UNDERLINE)
		charFormat.dwEffects = 0;
	else
		charFormat.dwEffects = CFM_UNDERLINE;
	m_richEdit.SetSelectionCharFormat(charFormat);
	m_richEdit.SetFocus();
}

void CCommonView::OnLeft()
{
	PARAFORMAT paraFormat;
	paraFormat.cbSize = sizeof(PARAFORMAT);
	paraFormat.dwMask = PFM_ALIGNMENT;
	paraFormat.wAlignment = PFA_LEFT;
	m_richEdit.SetParaFormat(paraFormat);
	m_richEdit.SetFocus();
}

void CCommonView::OnCenter()
{
	PARAFORMAT paraFormat;
	paraFormat.cbSize = sizeof(PARAFORMAT);
	paraFormat.dwMask = PFM_ALIGNMENT;
	paraFormat.wAlignment = PFA_CENTER;
	m_richEdit.SetParaFormat(paraFormat);
	m_richEdit.SetFocus();
}

void CCommonView::OnRight()
{
	PARAFORMAT paraFormat;
	paraFormat.cbSize = sizeof(PARAFORMAT);
	paraFormat.dwMask = PFM_ALIGNMENT;
	paraFormat.wAlignment = PFA_RIGHT;
	m_richEdit.SetParaFormat(paraFormat);
	m_richEdit.SetFocus();
}


void CCommonView::CreateIPAddress()
{
	m_ipAddress.Create( WS_CHILD | WS_VISIBLE | WS_BORDER,
		CRect(470,40,650,65), this, IDC_IPADDRESS );
}

void CCommonView::CreateDatePicker()
{
	m_date.Create( WS_CHILD | WS_VISIBLE | DTS_SHORTDATEFORMAT,
		CRect(470,120,650,150), this, IDC_DATE );
}


void CCommonView::CreateMonth()
{
	m_month.Create( WS_CHILD | WS_VISIBLE | DTS_SHORTDATEFORMAT,
		CRect(470,260,650,420), this, IDC_MONTH );
}

void CCommonView::OnInitialUpdate() 
{
	CScrollView::OnInitialUpdate();
	
	CSize sizeTotal;
	sizeTotal.cx = 700;
	sizeTotal.cx = 500;

	SetScrollSizes(MM_TEXT, sizeTotal);
}
