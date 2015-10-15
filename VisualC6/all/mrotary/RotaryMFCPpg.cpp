// RotaryMFCPpg.cpp : Implementation of the CRotaryMFCPropPage property page class.

#include "stdafx.h"
#include "RotaryMFC.h"
#include "RotaryMFCPpg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif


IMPLEMENT_DYNCREATE(CRotaryMFCPropPage, COlePropertyPage)


/////////////////////////////////////////////////////////////////////////////
// Message map

BEGIN_MESSAGE_MAP(CRotaryMFCPropPage, COlePropertyPage)
	//{{AFX_MSG_MAP(CRotaryMFCPropPage)
	ON_BN_CLICKED(IDC_TICKS_ENABLED, OnTicksEnabled)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()


/////////////////////////////////////////////////////////////////////////////
// Initialize class factory and guid

IMPLEMENT_OLECREATE_EX(CRotaryMFCPropPage, "ROTARYMFC.RotaryMFCPropPage.1",
	0x5f078f27, 0xf19f, 0x11d3, 0xa8, 0xb6, 0xa9, 0x8d, 0x54, 0xc8, 0x7c, 0x19)


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCPropPage::CRotaryMFCPropPageFactory::UpdateRegistry -
// Adds or removes system registry entries for CRotaryMFCPropPage

BOOL CRotaryMFCPropPage::CRotaryMFCPropPageFactory::UpdateRegistry(BOOL bRegister)
{
	if (bRegister)
		return AfxOleRegisterPropertyPageClass(AfxGetInstanceHandle(),
			m_clsid, IDS_ROTARYMFC_PPG);
	else
		return AfxOleUnregisterClass(m_clsid, NULL);
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCPropPage::CRotaryMFCPropPage - Constructor

CRotaryMFCPropPage::CRotaryMFCPropPage() :
	COlePropertyPage(IDD, IDS_ROTARYMFC_PPG_CAPTION)
{
	//{{AFX_DATA_INIT(CRotaryMFCPropPage)
	m_sNumTicks = 20;
	m_bTicks = TRUE;
	//}}AFX_DATA_INIT
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCPropPage::DoDataExchange - Moves data between page and properties

void CRotaryMFCPropPage::DoDataExchange(CDataExchange* pDX)
{
	//{{AFX_DATA_MAP(CRotaryMFCPropPage)
	DDP_Text(pDX, IDC_NUM_TICKS, m_sNumTicks, _T("NumTicks") );
	DDX_Text(pDX, IDC_NUM_TICKS, m_sNumTicks);
	DDV_MinMaxInt(pDX, m_sNumTicks, 1, 100);
	DDP_Check(pDX, IDC_TICKS_ENABLED, m_bTicks, _T("TicksEnable") );
	DDX_Check(pDX, IDC_TICKS_ENABLED, m_bTicks);
	//}}AFX_DATA_MAP
	DDP_PostProcessing(pDX);
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCPropPage message handlers

void CRotaryMFCPropPage::OnTicksEnabled() 
{
	UpdateData(TRUE);	
}
