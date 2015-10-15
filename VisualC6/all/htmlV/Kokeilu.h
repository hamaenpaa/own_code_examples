// Kokeilu.h : Declaration of the CKokeilu

#ifndef __KOKEILU_H_
#define __KOKEILU_H_

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CKokeilu
class ATL_NO_VTABLE CKokeilu : 
	public CComObjectRootEx<CComSingleThreadModel>,
	public CComCoClass<CKokeilu, &CLSID_Kokeilu>,
	public IDispatchImpl<IKokeilu, &IID_IKokeilu, &LIBID_ATL1Lib>
{
public:
	CKokeilu()
	{
	}

DECLARE_REGISTRY_RESOURCEID(IDR_KOKEILU)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(CKokeilu)
	COM_INTERFACE_ENTRY(IKokeilu)
	COM_INTERFACE_ENTRY(IDispatch)
END_COM_MAP()

// IKokeilu
public:
	STDMETHOD(LaskeLuvut3)(/*[retval, out]*/ long *lp);
	STDMETHOD(LaskeLuvut2)(/*[retval, out]*/ long *lparam);
	STDMETHOD(LaskeLuvut)(/*[retVal, out]*/ long *tulos);
};

#endif //__KOKEILU_H_
