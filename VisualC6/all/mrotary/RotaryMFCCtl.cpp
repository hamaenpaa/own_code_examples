// RotaryMFCCtl.cpp : Implementation of the CRotaryMFCCtrl ActiveX Control class.

#include "stdafx.h"
#include "RotaryMFC.h"
#include "RotaryMFCCtl.h"
#include "RotaryMFCPpg.h"
#include <math.h>


#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif


IMPLEMENT_DYNCREATE(CRotaryMFCCtrl, COleControl)


/////////////////////////////////////////////////////////////////////////////
// Message map

BEGIN_MESSAGE_MAP(CRotaryMFCCtrl, COleControl)
	//{{AFX_MSG_MAP(CRotaryMFCCtrl)
	ON_WM_LBUTTONDOWN()
	ON_WM_MOUSEMOVE()
	ON_WM_LBUTTONUP()
	//}}AFX_MSG_MAP
	ON_OLEVERB(AFX_IDS_VERB_PROPERTIES, OnProperties)
END_MESSAGE_MAP()


/////////////////////////////////////////////////////////////////////////////
// Dispatch map

BEGIN_DISPATCH_MAP(CRotaryMFCCtrl, COleControl)
	//{{AFX_DISPATCH_MAP(CRotaryMFCCtrl)
	DISP_PROPERTY_EX(CRotaryMFCCtrl, "TicksEnable", GetTicksEnable, SetTicksEnable, VT_BOOL)
	DISP_PROPERTY_EX(CRotaryMFCCtrl, "NumTicks", GetNumTicks, SetNumTicks, VT_I2)
	DISP_STOCKPROP_FORECOLOR()
	//}}AFX_DISPATCH_MAP
	DISP_FUNCTION_ID(CRotaryMFCCtrl, "AboutBox", DISPID_ABOUTBOX, AboutBox, VT_EMPTY, VTS_NONE)
END_DISPATCH_MAP()


/////////////////////////////////////////////////////////////////////////////
// Event map

BEGIN_EVENT_MAP(CRotaryMFCCtrl, COleControl)
	//{{AFX_EVENT_MAP(CRotaryMFCCtrl)
	EVENT_CUSTOM("Repositioned", FireRepositioned, VTS_R8)
	//}}AFX_EVENT_MAP
END_EVENT_MAP()


/////////////////////////////////////////////////////////////////////////////
// Property pages

// TODO: Add more property pages as needed.  Remember to increase the count!
BEGIN_PROPPAGEIDS(CRotaryMFCCtrl, 2)
	PROPPAGEID(CRotaryMFCPropPage::guid)
	PROPPAGEID(CLSID_CColorPropPage)
END_PROPPAGEIDS(CRotaryMFCCtrl)


/////////////////////////////////////////////////////////////////////////////
// Initialize class factory and guid

IMPLEMENT_OLECREATE_EX(CRotaryMFCCtrl, "ROTARYMFC.RotaryMFCCtrl.1",
	0x5f078f26, 0xf19f, 0x11d3, 0xa8, 0xb6, 0xa9, 0x8d, 0x54, 0xc8, 0x7c, 0x19)


/////////////////////////////////////////////////////////////////////////////
// Type library ID and version

IMPLEMENT_OLETYPELIB(CRotaryMFCCtrl, _tlid, _wVerMajor, _wVerMinor)


/////////////////////////////////////////////////////////////////////////////
// Interface IDs

const IID BASED_CODE IID_DRotaryMFC =
		{ 0x5f078f24, 0xf19f, 0x11d3, { 0xa8, 0xb6, 0xa9, 0x8d, 0x54, 0xc8, 0x7c, 0x19 } };
const IID BASED_CODE IID_DRotaryMFCEvents =
		{ 0x5f078f25, 0xf19f, 0x11d3, { 0xa8, 0xb6, 0xa9, 0x8d, 0x54, 0xc8, 0x7c, 0x19 } };


/////////////////////////////////////////////////////////////////////////////
// Control type information

static const DWORD BASED_CODE _dwRotaryMFCOleMisc =
	OLEMISC_ACTIVATEWHENVISIBLE |
	OLEMISC_SETCLIENTSITEFIRST |
	OLEMISC_INSIDEOUT |
	OLEMISC_CANTLINKINSIDE |
	OLEMISC_RECOMPOSEONRESIZE;

IMPLEMENT_OLECTLTYPE(CRotaryMFCCtrl, IDS_ROTARYMFC, _dwRotaryMFCOleMisc)


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::CRotaryMFCCtrlFactory::UpdateRegistry -
// Adds or removes system registry entries for CRotaryMFCCtrl

BOOL CRotaryMFCCtrl::CRotaryMFCCtrlFactory::UpdateRegistry(BOOL bRegister)
{
	// TODO: Verify that your control follows apartment-model threading rules.
	// Refer to MFC TechNote 64 for more information.
	// If your control does not conform to the apartment-model rules, then
	// you must modify the code below, changing the 6th parameter from
	// afxRegApartmentThreading to 0.

	if (bRegister)
		return AfxOleRegisterControlClass(
			AfxGetInstanceHandle(),
			m_clsid,
			m_lpszProgID,
			IDS_ROTARYMFC,
			IDB_ROTARYMFC,
			afxRegApartmentThreading,
			_dwRotaryMFCOleMisc,
			_tlid,
			_wVerMajor,
			_wVerMinor);
	else
		return AfxOleUnregisterClass(m_clsid, m_lpszProgID);
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::CRotaryMFCCtrl - Constructor

CRotaryMFCCtrl::CRotaryMFCCtrl()
{
	InitializeIIDs(&IID_DRotaryMFC, &IID_DRotaryMFCEvents);

	m_bTicks = TRUE;
	m_sNumTicks = 20;
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::~CRotaryMFCCtrl - Destructor

CRotaryMFCCtrl::~CRotaryMFCCtrl()
{
	// TODO: Cleanup your control's instance data here.
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::OnDraw - Drawing function

void CRotaryMFCCtrl::OnDraw(
			CDC* pdc, const CRect& rcBounds, const CRect& rcInvalid)
{
	// ** Set up the background and foreground brushes
	CBrush brForeGnd(TranslateColor(GetForeColor()));
	CBrush brBackGnd(TranslateColor(AmbientBackColor()));

	// ** Draw the control background
	pdc->FillRect(rcBounds, &brBackGnd);

	CBrush* pOldBrush = pdc->SelectObject(&brForeGnd);

	// ** Calculate the relative positions and mid point
	CPoint ptRelative = m_ptClicked - rcBounds.TopLeft();
	CPoint ptMid(rcBounds.Width()/2,rcBounds.Height()/2);
	ptMid = ptMid + rcBounds.TopLeft();

	// ** Finf offset from the middle
	double dRelX = ptRelative.x - ptMid.x;
	double dRelY = ptRelative.y - ptMid.y;

	// ** Use trig to find the angle by T=O/A
	double dAngle = atan2(dRelY, dRelX);
	double dRadX = (double)ptMid.x * 0.9;
	double dRadY = (double)ptMid.y * 0.9;

	// ** Find a point on the radius of the knob
	int dXPos = ptMid.x + (int)(cos(dAngle) * dRadX);
	int dYPos = ptMid.y + (int)(sin(dAngle) * dRadY);

	// ** Set the notch point position
	CPoint ptKnob = CPoint(dXPos,dYPos) + rcBounds.TopLeft();

	// ** Set a rect and draw the notch circle
	CRect rcPoint(ptKnob-CSize(4,4),CSize(8,8));
	pdc->Ellipse(rcPoint);

	// ** Draw the main rotary circle
	pdc->Ellipse(ptMid.x-(int)dRadX,ptMid.y-(int)dRadY,
		ptMid.x+(int)dRadX,ptMid.y+(int)dRadY);

	// ** Draw a line from the center to the knotch
	pdc->MoveTo(ptMid);
	pdc->LineTo(ptKnob);

	pdc->SelectObject(pOldBrush);
	m_dCurrentPosition = dAngle >= 0 ? 360-dAngle*57.2978 : -dAngle*57.2978;

	// ** Check if the ticks are enabled
	if (m_bTicks)
	{
		// ** Iterate in radians from -2*PI to +2*PI
		const double dPi = 3.14185;
		double r = -2.0*dPi;
		for (int i=0;i<m_sNumTicks;i++)
		{
			// ** Move to a position outside the main circle
			int nXPos = ptMid.x + (int)(cos(r) * dRadX * 1.05);
			int nYPos = ptMid.y + (int)(sin(r) * dRadY * 1.05);
			pdc->MoveTo(CPoint(nXPos,nYPos));

			// ** Draw a line even further out for a tick mark
			nXPos = ptMid.x + (int)(cos(r) * dRadX * 1.15);
			nYPos = ptMid.y + (int)(sin(r) * dRadY * 1.15);
			pdc->LineTo(CPoint(nXPos,nYPos));

			// ** Increment the angle
			r += dPi / (m_sNumTicks/2.0);
		}
	}
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::DoPropExchange - Persistence support

void CRotaryMFCCtrl::DoPropExchange(CPropExchange* pPX)
{
	ExchangeVersion(pPX, MAKELONG(_wVerMinor, _wVerMajor));
	COleControl::DoPropExchange(pPX);

	// ** Serialize the Enable Ticks Option
	PX_Bool(pPX, _T("TicksEnable"), m_bTicks, TRUE);

	// ** Serialize the Number of Ticks Option
	PX_Short(pPX, _T("NumTicks"), m_sNumTicks, 20);
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::OnResetState - Reset control to default state

void CRotaryMFCCtrl::OnResetState()
{
	COleControl::OnResetState();  // Resets defaults found in DoPropExchange

	// TODO: Reset any other control state here.
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl::AboutBox - Display an "About" box to the user

void CRotaryMFCCtrl::AboutBox()
{
	CDialog dlgAbout(IDD_ABOUTBOX_ROTARYMFC);
	dlgAbout.DoModal();
}


/////////////////////////////////////////////////////////////////////////////
// CRotaryMFCCtrl message handlers

void CRotaryMFCCtrl::OnLButtonDown(UINT nFlags, CPoint point) 
{
	// ** Start Mouse Capture
	SetCapture();

	// ** Store the clicked point
	m_ptClicked = point;

	// ** Redraw the control
	InvalidateControl();

	// ** Call the base class
	COleControl::OnLButtonDown(nFlags, point);
}

void CRotaryMFCCtrl::OnMouseMove(UINT nFlags, CPoint point) 
{
		// ** Check the left mouse button is held down
	if (nFlags & MK_LBUTTON)
	{
		// ** Store the moved position
		m_ptClicked = point;

		// ** Redraw the control
		InvalidateControl();
	}

	// ** Call the base class function
	COleControl::OnMouseMove(nFlags, point);
}

void CRotaryMFCCtrl::OnLButtonUp(UINT nFlags, CPoint point) 
{
	ReleaseCapture();
	FireRepositioned(m_dCurrentPosition);
	COleControl::OnLButtonUp(nFlags, point);
}

BOOL CRotaryMFCCtrl::GetTicksEnable() 
{
	return m_bTicks;
}

void CRotaryMFCCtrl::SetTicksEnable(BOOL bNewValue) 
{
	m_bTicks = bNewValue;
	SetModifiedFlag();
}

short CRotaryMFCCtrl::GetNumTicks() 
{
	return m_sNumTicks;
}

void CRotaryMFCCtrl::SetNumTicks(short nNewValue) 
{
	m_sNumTicks = nNewValue;
	SetModifiedFlag();
}
