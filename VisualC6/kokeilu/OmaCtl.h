// OmaCtl.h : Declaration of the COmaCtl

#ifndef __OMACTL_H_
#define __OMACTL_H_

#include "resource.h"       // main symbols
#include <atlctl.h>


/////////////////////////////////////////////////////////////////////////////
// COmaCtl
class ATL_NO_VTABLE COmaCtl : 
	public CComObjectRootEx<CComSingleThreadModel>,
	public CStockPropImpl<COmaCtl, IOmaCtl, &IID_IOmaCtl, &LIBID_KOKEILULib>,
	public CComControl<COmaCtl>,
	public IPersistStreamInitImpl<COmaCtl>,
	public IOleControlImpl<COmaCtl>,
	public IOleObjectImpl<COmaCtl>,
	public IOleInPlaceActiveObjectImpl<COmaCtl>,
	public IViewObjectExImpl<COmaCtl>,
	public IOleInPlaceObjectWindowlessImpl<COmaCtl>,
	public ISupportErrorInfo,
	public IConnectionPointContainerImpl<COmaCtl>,
	public IPersistStorageImpl<COmaCtl>,
	public ISpecifyPropertyPagesImpl<COmaCtl>,
	public IQuickActivateImpl<COmaCtl>,
	public IDataObjectImpl<COmaCtl>,
	public IProvideClassInfo2Impl<&CLSID_OmaCtl, &DIID__IOmaCtlEvents, &LIBID_KOKEILULib>,
	public IPropertyNotifySinkCP<COmaCtl>,
	public CComCoClass<COmaCtl, &CLSID_OmaCtl>
{
public:
	COmaCtl()
	{
	}

DECLARE_REGISTRY_RESOURCEID(IDR_OMACTL)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(COmaCtl)
	COM_INTERFACE_ENTRY(IOmaCtl)
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
END_COM_MAP()

BEGIN_PROP_MAP(COmaCtl)
	PROP_DATA_ENTRY("_cx", m_sizeExtent.cx, VT_UI4)
	PROP_DATA_ENTRY("_cy", m_sizeExtent.cy, VT_UI4)
	PROP_ENTRY("BackColor", DISPID_BACKCOLOR, CLSID_StockColorPage)
	PROP_ENTRY("Caption", DISPID_CAPTION, CLSID_NULL)
	PROP_ENTRY("FillColor", DISPID_FILLCOLOR, CLSID_StockColorPage)
	PROP_ENTRY("Font", DISPID_FONT, CLSID_StockFontPage)
	// Example entries
	// PROP_ENTRY("Property Description", dispid, clsid)
	// PROP_PAGE(CLSID_StockColorPage)
END_PROP_MAP()

BEGIN_CONNECTION_POINT_MAP(COmaCtl)
	CONNECTION_POINT_ENTRY(IID_IPropertyNotifySink)
END_CONNECTION_POINT_MAP()

BEGIN_MSG_MAP(COmaCtl)
	CHAIN_MSG_MAP(CComControl<COmaCtl>)
	DEFAULT_REFLECTION_HANDLER()
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
			&IID_IOmaCtl,
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

// IOmaCtl
public:
	STDMETHOD(get_kokeiluomin)(/*[out, retval]*/ long *pVal);
	STDMETHOD(put_kokeiluomin)(/*[in]*/ long newVal);

	HRESULT OnDraw(ATL_DRAWINFO& di)
	{
		RECT& rc = *(RECT*)di.prcBounds;
		Rectangle(di.hdcDraw, rc.left, rc.top, rc.right, rc.bottom);

		SetTextAlign(di.hdcDraw, TA_CENTER|TA_BASELINE);
		LPCTSTR pszText = _T("ATL 3.0 : OmaCtl");
		TextOut(di.hdcDraw, 
			(rc.left + rc.right) / 2, 
			(rc.top + rc.bottom) / 2, 
			pszText, 
			lstrlen(pszText));

		return S_OK;
	}
	OLE_COLOR m_clrBackColor;
	CComBSTR m_bstrCaption;
	OLE_COLOR m_clrFillColor;
	CComPtr<IFontDisp> m_pFont;
};

#endif //__OMACTL_H_
