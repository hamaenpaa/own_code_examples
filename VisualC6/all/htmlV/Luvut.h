// Luvut.h : Declaration of the CLuvut

#ifndef __LUVUT_H_
#define __LUVUT_H_

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CLuvut
class ATL_NO_VTABLE CLuvut : 
	public CComObjectRootEx<CComSingleThreadModel>,
	public CComCoClass<CLuvut, &CLSID_Luvut>,
	public IDispatchImpl<ILuvut, &IID_ILuvut, &LIBID_ATL1Lib>
{
public:
	CLuvut()
	{
	}

DECLARE_REGISTRY_RESOURCEID(IDR_LUVUT)

DECLARE_PROTECT_FINAL_CONSTRUCT()

BEGIN_COM_MAP(CLuvut)
	COM_INTERFACE_ENTRY(ILuvut)
	COM_INTERFACE_ENTRY(IDispatch)
END_COM_MAP()

// ILuvut
public:
};

#endif //__LUVUT_H_
