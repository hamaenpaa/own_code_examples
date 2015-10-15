// AtlRotaryProp.h : Declaration of the CAtlRotaryProp

#ifndef __ATLROTARYPROP_H_
#define __ATLROTARYPROP_H_

#include "resource.h"       // main symbols
#include "atlrotary2.h"

EXTERN_C const CLSID CLSID_AtlRotaryProp;

/////////////////////////////////////////////////////////////////////////////
// CAtlRotaryProp
class ATL_NO_VTABLE CAtlRotaryProp :
	public CComObjectRootEx<CComSingleThreadModel>,
	public CComCoClass<CAtlRotaryProp, &CLSID_AtlRotaryProp>,
	public IPropertyPageImpl<CAtlRotaryProp>,
	public CDialogImpl<CAtlRotaryProp>
{
public:
	CAtlRotaryProp() 
	{
		m_dwTitleID = IDS_TITLEAtlRotaryProp;
		m_dwHelpFileID = IDS_HELPFILEAtlRotaryProp;
		m_dwDocStringID = IDS_DOCSTRINGAtlRotaryProp;
	}

	enum {IDD = IDD_ATLROTARYPROP};

DECLARE_REGISTRY_RESOURCEID(IDR_ATLROTARYPROP)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(CAtlRotaryProp) 
	COM_INTERFACE_ENTRY(IPropertyPage)
END_COM_MAP()

BEGIN_MSG_MAP(CAtlRotaryProp)
	CHAIN_MSG_MAP(IPropertyPageImpl<CAtlRotaryProp>)
	COMMAND_HANDLER(IDC_NOTICKMARKS, EN_CHANGE, OnChangeNotickmarks)
	COMMAND_HANDLER(IDC_SHOWTICKMARKS, BN_CLICKED, OnClickedShowtickmarks)
END_MSG_MAP()
// Handler prototypes:
//  LRESULT MessageHandler(UINT uMsg, WPARAM wParam, LPARAM lParam, BOOL& bHandled);
//  LRESULT CommandHandler(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled);
//  LRESULT NotifyHandler(int idCtrl, LPNMHDR pnmh, BOOL& bHandled);

	STDMETHOD(Apply)(void)
	{
	    USES_CONVERSION;
		ATLTRACE(_T("CAtlRotaryProp::Apply\n"));
		for (UINT i = 0; i < m_nObjects; i++)
		{
			CComQIPtr<IAtlRotaryCtl2, &IID_IAtlRotaryCtl2> pAtlRotary(m_ppUnk[i]);
			BOOL EnableTicks = (BOOL)GetDlgItemInt(IDC_SHOWTICKMARKS);
            if (FAILED(pAtlRotary->put_Ticks(EnableTicks)))
            {
              CComPtr<IErrorInfo> pError;
              CComBSTR strError;
			  GetErrorInfo(0,&pError);
			  pError->GetDescription(&strError);
              MessageBox(OLE2T(strError), _T("Error"), MB_ICONEXCLAMATION);
              return E_FAIL;
			}
			short TickNo = (short)GetDlgItemInt(IDC_NOTICKMARKS);
            if (FAILED(pAtlRotary->put_NumTicks(TickNo)))
            {
              CComPtr<IErrorInfo> pError;
              CComBSTR strError;
			  GetErrorInfo(0,&pError);
			  pError->GetDescription(&strError);
              MessageBox(OLE2T(strError), _T("Error"), MB_ICONEXCLAMATION);
              return E_FAIL;
			}
			// Do something interesting here
			// ICircCtl* pCirc;
			// m_ppUnk[i]->QueryInterface(IID_ICircCtl, (void**)&pCirc);
			// pCirc->put_Caption(CComBSTR("something special"));
			// pCirc->Release();
		}
		m_bDirty = FALSE;
		return S_OK;
	}
	LRESULT OnChangeNotickmarks(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled)
	{
		// TODO : Add Code for control notification handler.
		SetDirty(TRUE);
		return 0;
	}
	LRESULT OnClickedShowtickmarks(WORD wNotifyCode, WORD wID, HWND hWndCtl, BOOL& bHandled)
	{
		// TODO : Add Code for control notification handler.
		SetDirty(TRUE);
		return 0;
	}
};

#endif //__ATLROTARYPROP_H_
