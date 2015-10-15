/* this ALWAYS GENERATED file contains the definitions for the interfaces */


/* File created by MIDL compiler version 5.01.0164 */
/* at Sat Feb 19 18:07:10 2000
 */
/* Compiler settings for C:\teku\kokeilu\kokeilu.idl:
    Oicf (OptLev=i2), W1, Zp8, env=Win32, ms_ext, c_ext
    error checks: allocation ref bounds_check enum stub_data 
*/
//@@MIDL_FILE_HEADING(  )


/* verify that the <rpcndr.h> version is high enough to compile this file*/
#ifndef __REQUIRED_RPCNDR_H_VERSION__
#define __REQUIRED_RPCNDR_H_VERSION__ 440
#endif

#include "rpc.h"
#include "rpcndr.h"

#ifndef __RPCNDR_H_VERSION__
#error this stub requires an updated version of <rpcndr.h>
#endif // __RPCNDR_H_VERSION__

#ifndef COM_NO_WINDOWS_H
#include "windows.h"
#include "ole2.h"
#endif /*COM_NO_WINDOWS_H*/

#ifndef __kokeilu_h__
#define __kokeilu_h__

#ifdef __cplusplus
extern "C"{
#endif 

/* Forward Declarations */ 

#ifndef __IOmaCtl_FWD_DEFINED__
#define __IOmaCtl_FWD_DEFINED__
typedef interface IOmaCtl IOmaCtl;
#endif 	/* __IOmaCtl_FWD_DEFINED__ */


#ifndef ___IOmaCtlEvents_FWD_DEFINED__
#define ___IOmaCtlEvents_FWD_DEFINED__
typedef interface _IOmaCtlEvents _IOmaCtlEvents;
#endif 	/* ___IOmaCtlEvents_FWD_DEFINED__ */


#ifndef __OmaCtl_FWD_DEFINED__
#define __OmaCtl_FWD_DEFINED__

#ifdef __cplusplus
typedef class OmaCtl OmaCtl;
#else
typedef struct OmaCtl OmaCtl;
#endif /* __cplusplus */

#endif 	/* __OmaCtl_FWD_DEFINED__ */


/* header files for imported files */
#include "oaidl.h"
#include "ocidl.h"

void __RPC_FAR * __RPC_USER MIDL_user_allocate(size_t);
void __RPC_USER MIDL_user_free( void __RPC_FAR * ); 

#ifndef __IOmaCtl_INTERFACE_DEFINED__
#define __IOmaCtl_INTERFACE_DEFINED__

/* interface IOmaCtl */
/* [unique][helpstring][dual][uuid][object] */ 


EXTERN_C const IID IID_IOmaCtl;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("A248D58D-E6F3-11D3-B4E3-E93332AC0136")
    IOmaCtl : public IDispatch
    {
    public:
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_BackColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_BackColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_FillColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_FillColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [id][propputref] */ HRESULT STDMETHODCALLTYPE putref_Font( 
            /* [in] */ IFontDisp __RPC_FAR *pFont) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_Font( 
            /* [in] */ IFontDisp __RPC_FAR *pFont) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_Font( 
            /* [retval][out] */ IFontDisp __RPC_FAR *__RPC_FAR *ppFont) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_Caption( 
            /* [in] */ BSTR strCaption) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_Caption( 
            /* [retval][out] */ BSTR __RPC_FAR *pstrCaption) = 0;
        
        virtual /* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE get_kokeiluomin( 
            /* [retval][out] */ long __RPC_FAR *pVal) = 0;
        
        virtual /* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE put_kokeiluomin( 
            /* [in] */ long newVal) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IOmaCtlVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            IOmaCtl __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            IOmaCtl __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            IOmaCtl __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_BackColor )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_BackColor )( 
            IOmaCtl __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_FillColor )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_FillColor )( 
            IOmaCtl __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [id][propputref] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *putref_Font )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ IFontDisp __RPC_FAR *pFont);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_Font )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ IFontDisp __RPC_FAR *pFont);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_Font )( 
            IOmaCtl __RPC_FAR * This,
            /* [retval][out] */ IFontDisp __RPC_FAR *__RPC_FAR *ppFont);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_Caption )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ BSTR strCaption);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_Caption )( 
            IOmaCtl __RPC_FAR * This,
            /* [retval][out] */ BSTR __RPC_FAR *pstrCaption);
        
        /* [helpstring][id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_kokeiluomin )( 
            IOmaCtl __RPC_FAR * This,
            /* [retval][out] */ long __RPC_FAR *pVal);
        
        /* [helpstring][id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_kokeiluomin )( 
            IOmaCtl __RPC_FAR * This,
            /* [in] */ long newVal);
        
        END_INTERFACE
    } IOmaCtlVtbl;

    interface IOmaCtl
    {
        CONST_VTBL struct IOmaCtlVtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IOmaCtl_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IOmaCtl_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IOmaCtl_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IOmaCtl_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define IOmaCtl_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define IOmaCtl_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define IOmaCtl_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)


#define IOmaCtl_put_BackColor(This,clr)	\
    (This)->lpVtbl -> put_BackColor(This,clr)

#define IOmaCtl_get_BackColor(This,pclr)	\
    (This)->lpVtbl -> get_BackColor(This,pclr)

#define IOmaCtl_put_FillColor(This,clr)	\
    (This)->lpVtbl -> put_FillColor(This,clr)

#define IOmaCtl_get_FillColor(This,pclr)	\
    (This)->lpVtbl -> get_FillColor(This,pclr)

#define IOmaCtl_putref_Font(This,pFont)	\
    (This)->lpVtbl -> putref_Font(This,pFont)

#define IOmaCtl_put_Font(This,pFont)	\
    (This)->lpVtbl -> put_Font(This,pFont)

#define IOmaCtl_get_Font(This,ppFont)	\
    (This)->lpVtbl -> get_Font(This,ppFont)

#define IOmaCtl_put_Caption(This,strCaption)	\
    (This)->lpVtbl -> put_Caption(This,strCaption)

#define IOmaCtl_get_Caption(This,pstrCaption)	\
    (This)->lpVtbl -> get_Caption(This,pstrCaption)

#define IOmaCtl_get_kokeiluomin(This,pVal)	\
    (This)->lpVtbl -> get_kokeiluomin(This,pVal)

#define IOmaCtl_put_kokeiluomin(This,newVal)	\
    (This)->lpVtbl -> put_kokeiluomin(This,newVal)

#endif /* COBJMACROS */


#endif 	/* C style interface */



/* [id][propput] */ HRESULT STDMETHODCALLTYPE IOmaCtl_put_BackColor_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IOmaCtl_put_BackColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IOmaCtl_get_BackColor_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IOmaCtl_get_BackColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IOmaCtl_put_FillColor_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IOmaCtl_put_FillColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IOmaCtl_get_FillColor_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IOmaCtl_get_FillColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propputref] */ HRESULT STDMETHODCALLTYPE IOmaCtl_putref_Font_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ IFontDisp __RPC_FAR *pFont);


void __RPC_STUB IOmaCtl_putref_Font_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IOmaCtl_put_Font_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ IFontDisp __RPC_FAR *pFont);


void __RPC_STUB IOmaCtl_put_Font_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IOmaCtl_get_Font_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [retval][out] */ IFontDisp __RPC_FAR *__RPC_FAR *ppFont);


void __RPC_STUB IOmaCtl_get_Font_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IOmaCtl_put_Caption_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ BSTR strCaption);


void __RPC_STUB IOmaCtl_put_Caption_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IOmaCtl_get_Caption_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [retval][out] */ BSTR __RPC_FAR *pstrCaption);


void __RPC_STUB IOmaCtl_get_Caption_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE IOmaCtl_get_kokeiluomin_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [retval][out] */ long __RPC_FAR *pVal);


void __RPC_STUB IOmaCtl_get_kokeiluomin_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE IOmaCtl_put_kokeiluomin_Proxy( 
    IOmaCtl __RPC_FAR * This,
    /* [in] */ long newVal);


void __RPC_STUB IOmaCtl_put_kokeiluomin_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IOmaCtl_INTERFACE_DEFINED__ */



#ifndef __KOKEILULib_LIBRARY_DEFINED__
#define __KOKEILULib_LIBRARY_DEFINED__

/* library KOKEILULib */
/* [helpstring][version][uuid] */ 


EXTERN_C const IID LIBID_KOKEILULib;

#ifndef ___IOmaCtlEvents_DISPINTERFACE_DEFINED__
#define ___IOmaCtlEvents_DISPINTERFACE_DEFINED__

/* dispinterface _IOmaCtlEvents */
/* [helpstring][uuid] */ 


EXTERN_C const IID DIID__IOmaCtlEvents;

#if defined(__cplusplus) && !defined(CINTERFACE)

    MIDL_INTERFACE("A248D58F-E6F3-11D3-B4E3-E93332AC0136")
    _IOmaCtlEvents : public IDispatch
    {
    };
    
#else 	/* C style interface */

    typedef struct _IOmaCtlEventsVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            _IOmaCtlEvents __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            _IOmaCtlEvents __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            _IOmaCtlEvents __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            _IOmaCtlEvents __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            _IOmaCtlEvents __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            _IOmaCtlEvents __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            _IOmaCtlEvents __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        END_INTERFACE
    } _IOmaCtlEventsVtbl;

    interface _IOmaCtlEvents
    {
        CONST_VTBL struct _IOmaCtlEventsVtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define _IOmaCtlEvents_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define _IOmaCtlEvents_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define _IOmaCtlEvents_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define _IOmaCtlEvents_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define _IOmaCtlEvents_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define _IOmaCtlEvents_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define _IOmaCtlEvents_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)

#endif /* COBJMACROS */


#endif 	/* C style interface */


#endif 	/* ___IOmaCtlEvents_DISPINTERFACE_DEFINED__ */


EXTERN_C const CLSID CLSID_OmaCtl;

#ifdef __cplusplus

class DECLSPEC_UUID("A248D58E-E6F3-11D3-B4E3-E93332AC0136")
OmaCtl;
#endif
#endif /* __KOKEILULib_LIBRARY_DEFINED__ */

/* Additional Prototypes for ALL interfaces */

unsigned long             __RPC_USER  BSTR_UserSize(     unsigned long __RPC_FAR *, unsigned long            , BSTR __RPC_FAR * ); 
unsigned char __RPC_FAR * __RPC_USER  BSTR_UserMarshal(  unsigned long __RPC_FAR *, unsigned char __RPC_FAR *, BSTR __RPC_FAR * ); 
unsigned char __RPC_FAR * __RPC_USER  BSTR_UserUnmarshal(unsigned long __RPC_FAR *, unsigned char __RPC_FAR *, BSTR __RPC_FAR * ); 
void                      __RPC_USER  BSTR_UserFree(     unsigned long __RPC_FAR *, BSTR __RPC_FAR * ); 

/* end of Additional Prototypes */

#ifdef __cplusplus
}
#endif

#endif
