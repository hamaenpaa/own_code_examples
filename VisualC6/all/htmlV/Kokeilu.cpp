// Kokeilu.cpp : Implementation of CKokeilu
#include "stdafx.h"
#include "Atl1.h"
#include "Kokeilu.h"
#include "OwnDialog.h"

/////////////////////////////////////////////////////////////////////////////
// CKokeilu


STDMETHODIMP CKokeilu::LaskeLuvut(long *tulos)
{
	// TODO: Add your implementation code here

	COwnDialog dialog;
	*tulos = dialog.DoModal();
    

	return S_OK;
}

STDMETHODIMP CKokeilu::LaskeLuvut2(long *lparam)
{
	// TODO: Add your implementation code here

	return S_OK;
}

STDMETHODIMP CKokeilu::LaskeLuvut3(long *lp)
{
	// TODO: Add your implementation code here
	COwnDialog dialog;
	*lp = dialog.DoModal();
	
	return S_OK;
}
