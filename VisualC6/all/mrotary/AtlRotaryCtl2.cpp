// AtlRotaryCtl2.cpp : Implementation of CAtlRotaryCtl2

#include "stdafx.h"
#include "Atlrotary2.h"
#include "AtlRotaryCtl2.h"

/////////////////////////////////////////////////////////////////////////////
// CAtlRotaryCtl2


STDMETHODIMP CAtlRotaryCtl2::get_NumTicks(short *pVal)
{
	AFX_MANAGE_STATE(AfxGetStaticModuleState())

	// TODO: Add your implementation code here
   
	*pVal = m_sNumTicks;
	return S_OK;
}

STDMETHODIMP CAtlRotaryCtl2::put_NumTicks(short newVal)
{
	AFX_MANAGE_STATE(AfxGetStaticModuleState())

	// TODO: Add your implementation code here

	m_sNumTicks = newVal;
	return S_OK;
}

STDMETHODIMP CAtlRotaryCtl2::get_Ticks(BOOL *pVal)
{
	AFX_MANAGE_STATE(AfxGetStaticModuleState())

	// TODO: Add your implementation code here
    *pVal = m_bTicks;
	return S_OK;
}

STDMETHODIMP CAtlRotaryCtl2::put_Ticks(BOOL newVal)
{
	AFX_MANAGE_STATE(AfxGetStaticModuleState())

	// TODO: Add your implementation code here
    m_bTicks = newVal;
	return S_OK;
}
