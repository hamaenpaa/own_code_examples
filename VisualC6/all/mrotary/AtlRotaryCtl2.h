// AtlRotaryCtl2.h : Declaration of the CAtlRotaryCtl2

#ifndef __ATLROTARYCTL2_H_
#define __ATLROTARYCTL2_H_

#include "resource.h"       // main symbols
#include <atlctl.h>
#include <math.h>
#include "atlrotary2CP.h"

/////////////////////////////////////////////////////////////////////////////
// CAtlRotaryCtl2
class ATL_NO_VTABLE CAtlRotaryCtl2 : 
	public CComObjectRootEx<CComSingleThreadModel>,
	public CStockPropImpl<CAtlRotaryCtl2, IAtlRotaryCtl2, &IID_IAtlRotaryCtl2, &LIBID_ATLROTARY2Lib>,
	public CComControl<CAtlRotaryCtl2>,
	public IPersistStreamInitImpl<CAtlRotaryCtl2>,
	public IOleControlImpl<CAtlRotaryCtl2>,
	public IOleObjectImpl<CAtlRotaryCtl2>,
	public IOleInPlaceActiveObjectImpl<CAtlRotaryCtl2>,
	public IViewObjectExImpl<CAtlRotaryCtl2>,
	public IOleInPlaceObjectWindowlessImpl<CAtlRotaryCtl2>,
	public ISupportErrorInfo,
	public IConnectionPointContainerImpl<CAtlRotaryCtl2>,
	public IPersistStorageImpl<CAtlRotaryCtl2>,
	public ISpecifyPropertyPagesImpl<CAtlRotaryCtl2>,
	public IQuickActivateImpl<CAtlRotaryCtl2>,
	public IDataObjectImpl<CAtlRotaryCtl2>,
	public IProvideClassInfo2Impl<&CLSID_AtlRotaryCtl2, &DIID__IAtlRotaryCtl2Events, &LIBID_ATLROTARY2Lib>,
	public IPropertyNotifySinkCP<CAtlRotaryCtl2>,
	public CComCoClass<CAtlRotaryCtl2, &CLSID_AtlRotaryCtl2>,
	public CProxy_IAtlRotaryCtl2Events< CAtlRotaryCtl2 >
{
public:
	CAtlRotaryCtl2()
	{
		m_clrFillColor = RGB(0xFF, 0xFF, 0);	// Yellow
		m_clrForeColor = RGB(0, 0, 0);			// Black
		m_clrBackColor = RGB(0, 0xFF, 0);		// Green
	}

DECLARE_REGISTRY_RESOURCEID(IDR_ATLROTARYCTL2)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(CAtlRotaryCtl2)
	COM_INTERFACE_ENTRY(IAtlRotaryCtl2)
	COM_INTERFACE_ENTRY(IDispatch)
	COM_INTERFACE_ENTRY(IViewObjectEx)
	COM_INTERFACE_ENTRY(IViewObject2)
	COM_INTERFACE_ENTRY(IViewObject)
	COM_INTERFACE_ENTRY(IOleInPlaceObjectWindowless)
	COM_INTERFACE_ENTRY(IOleInPlaceObject)
	COM_INTERFACE_ENTRY2(IOleWindow, IOleInPlaceObjectWindowless)
	COM_INTERFACE_ENTRY(IOleInPlaceActiveObject)
	COM_INTERFACE_ENTRY(IOleControl)
	COM_INTERFACE_ENTRY(IOleObject)
	COM_INTERFACE_ENTRY(IPersistStreamInit)
	COM_INTERFACE_ENTRY2(IPersist, IPersistStreamInit)
	COM_INTERFACE_ENTRY(ISupportErrorInfo)
	COM_INTERFACE_ENTRY(IConnectionPointContainer)
	COM_INTERFACE_ENTRY(ISpecifyPropertyPages)
	COM_INTERFACE_ENTRY(IQuickActivate)
	COM_INTERFACE_ENTRY(IPersistStorage)
	COM_INTERFACE_ENTRY(IDataObject)
	COM_INTERFACE_ENTRY(IProvideClassInfo)
	COM_INTERFACE_ENTRY(IProvideClassInfo2)
	COM_INTERFACE_ENTRY_IMPL(IConnectionPointContainer)
END_COM_MAP()

BEGIN_PROP_MAP(CAtlRotaryCtl2)
	PROP_DATA_ENTRY("_cx", m_sizeExtent.cx, VT_UI4)
	PROP_DATA_ENTRY("_cy", m_sizeExtent.cy, VT_UI4)
	PROP_ENTRY("BackColor", DISPID_BACKCOLOR, CLSID_StockColorPage)
	PROP_ENTRY("BorderColor", DISPID_BORDERCOLOR, CLSID_StockColorPage)
	PROP_ENTRY("FillColor", DISPID_FILLCOLOR, CLSID_StockColorPage)
	PROP_ENTRY("ForeColor", DISPID_FORECOLOR, CLSID_StockColorPage)
	PROP_ENTRY("NumTicks", 1, CLSID_AtlRotaryProp )
	PROP_ENTRY("TicksEnable", 1, CLSID_AtlRotaryProp )
	// Example entries
	// PROP_ENTRY("Property Description", dispid, clsid)
	// PROP_PAGE(CLSID_StockColorPage)
END_PROP_MAP()

BEGIN_CONNECTION_POINT_MAP(CAtlRotaryCtl2)
	CONNECTION_POINT_ENTRY(IID_IPropertyNotifySink)
	CONNECTION_POINT_ENTRY(DIID__IAtlRotaryCtl2Events)
END_CONNECTION_POINT_MAP()

BEGIN_MSG_MAP(CAtlRotaryCtl2)
	CHAIN_MSG_MAP(CComControl<CAtlRotaryCtl2>)
	DEFAULT_REFLECTION_HANDLER()
	MESSAGE_HANDLER(WM_LBUTTONDOWN, OnLButtonDown)
END_MSG_MAP()
// Handler prototypes:
//  LRESULT MessageHandler(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled);
//  LRESULT CommandHandler(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);
//  LRESULT NotifyHandler(int idCtrl, LPNMHDR pnmh, BOOL& bHandled);



// ISupportsErrorInfo
	STDMETHOD(InterfaceSupportsErrorInfo)(REFIID riid)
	{
		static const IID* arr[] = 
		{
			&IID_IAtlRotaryCtl2,
		};
		for (int i=0; i<sizeof(arr)/sizeof(arr[0]); i++)
		{
			if (InlineIsEqualGUID(*arr[i], riid))
				return S_OK;
		}
		return S_FALSE;
	}

// IViewObjectEx
	DECLARE_VIEW_STATUS(VIEWSTATUS_SOLIDBKGND | VIEWSTATUS_OPAQUE)

// IAtlRotaryCtl2
public:
	STDMETHOD(get_Ticks)(/*[out, retval]*/ BOOL *pVal);
	STDMETHOD(put_Ticks)(/*[in]*/ BOOL newVal);
	STDMETHOD(get_NumTicks)(/*[out, retval]*/ short *pVal);
	STDMETHOD(put_NumTicks)(/*[in]*/ short newVal);

	HRESULT OnDraw(ATL_DRAWINFO& di)
	{

		RECT& rc = *(RECT*)di.prcBounds;
		CRect rcBounds = rc;
		HDC hdc = di.hdcDraw;
		COLORREF colBack;	// Background color (Stock property)
		COLORREF colFore;	// Foreground color (Custom property)
		COLORREF colFill;	// Fill color (Custom property)
		/* HBRUSH hBrushBack=NULL, hBrushFill=NULL, hBrushStock=NULL; */
		// Translate m_colBack into a COLORREF type
		OleTranslateColor(m_clrBackColor, NULL, &colBack);
		OleTranslateColor(m_clrForeColor, NULL, &colFore);
		OleTranslateColor(m_clrFillColor, NULL, &colFill);

		// ** Set up the background and foreground brushes
		HBRUSH ForeGnd = CreateSolidBrush(m_clrForeColor);
		HBRUSH BackGnd = CreateSolidBrush(m_clrBackColor);
/*		CBrush brForeGnd(m_clrForeColor);
		CBrush brBackGnd(m_clrBackColor); 
        HBRUSH ForeGnd = HBRUSH(brForeGnd);
		HBRUSH BackGnd = HBRUSH(brBackGnd);
*/
		// ** Draw the control background
		FillRect(hdc,rcBounds,BackGnd);

		HBRUSH hOldBrush = (HBRUSH)SelectObject(hdc,ForeGnd);

		// ** Calculate the relative positions and mid point
		CPoint ptRelative = m_ptClicked - rcBounds.TopLeft();
		CPoint ptMid(rcBounds.Width()/2,rcBounds.Height()/2);

		double dRadX = (double)ptMid.x * 0.9;
		double dRadY = (double)ptMid.y * 0.9;
		ptMid = ptMid + rcBounds.TopLeft();

		// ** Finf offset from the middle
		double dRelX = ptRelative.x - ptMid.x;
		double dRelY = ptRelative.y - ptMid.y;

		// ** Use trig to find the angle by T=O/A
		double dAngle = atan2(dRelY, dRelX);
		
		// ** Find a point on the radius of the knob
		int dXPos = ptMid.x + (int)(cos(dAngle) * dRadX);
		int dYPos = ptMid.y + (int)(sin(dAngle) * dRadY);

		// ** Set the notch point position
		CPoint ptKnob = CPoint(dXPos,dYPos) + rcBounds.TopLeft();

		// ** Set a rect and draw the notch circle
		CRect rcPoint(ptKnob-CSize(4,4),CSize(8,8));
		Ellipse(hdc,rcPoint.left,rcPoint.top, rcPoint.right,rcPoint.bottom); // pdc ?
        
		// ** Draw the main rotary circle
		Ellipse(	hdc,ptMid.x-(int)dRadX,ptMid.y-(int)dRadY,
					ptMid.x+(int)dRadX,ptMid.y+(int)dRadY);
		// ** Draw a line from the center to the knotch
		MoveToEx(hdc,ptMid.x,ptMid.y,NULL); // pdc ?
		LineTo(hdc,ptKnob.x,ptKnob.y); // pdc ? 

		SelectObject(hdc,hOldBrush);
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
				MoveToEx(hdc,nXPos,nYPos,NULL);

				// ** Draw a line even further out for a tick mark
				nXPos = ptMid.x + (int)(cos(r) * dRadX * 1.15);
				nYPos = ptMid.y + (int)(sin(r) * dRadY * 1.15);
				LineTo(hdc,nXPos,nYPos);

				// ** Increment the angle
				r += dPi / (m_sNumTicks/2.0);
			}
		}
		return S_OK;
	}
    short m_sNumTicks;
	BOOL m_bTicks;
	double m_dCurrentPosition;
	CPoint m_ptClicked;

	OLE_COLOR m_clrBackColor;
	OLE_COLOR m_clrBorderColor;
	OLE_COLOR m_clrFillColor;
	OLE_COLOR m_clrForeColor;
	LRESULT OnLButtonDown(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled)
	{
		// TODO : Add Code for message handler. Call DefWindowProc if necessary.
		
		WORD xPos = LOWORD(lParam);  // horizontal position of cursor
		WORD yPos = HIWORD(lParam);  // vertical position of cursor
        m_ptClicked.x = xPos;
		m_ptClicked.y = yPos;
		Invalidate();
		Fire_Click_In(xPos, yPos);
        
		return 0;
	}
};

#endif //__ATLROTARYCTL2_H_
