/* this ALWAYS GENERATED file contains the definitions for the interfaces */


/* File created by MIDL compiler version 5.01.0164 */
/* at Sat Mar 11 18:23:09 2000
 */
/* Compiler settings for C:\visualc\rotary\atlrotary2\atlrotary2.idl:
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

#ifndef __atlrotary2_h__
#define __atlrotary2_h__

#ifdef __cplusplus
extern "C"{
#endif 

/* Forward Declarations */ 

#ifndef __IAtlRotaryCtl2_FWD_DEFINED__
#define __IAtlRotaryCtl2_FWD_DEFINED__
typedef interface IAtlRotaryCtl2 IAtlRotaryCtl2;
#endif 	/* __IAtlRotaryCtl2_FWD_DEFINED__ */


#ifndef ___IAtlRotaryCtl2Events_FWD_DEFINED__
#define ___IAtlRotaryCtl2Events_FWD_DEFINED__
typedef interface _IAtlRotaryCtl2Events _IAtlRotaryCtl2Events;
#endif 	/* ___IAtlRotaryCtl2Events_FWD_DEFINED__ */


#ifndef __AtlRotaryCtl2_FWD_DEFINED__
#define __AtlRotaryCtl2_FWD_DEFINED__

#ifdef __cplusplus
typedef class AtlRotaryCtl2 AtlRotaryCtl2;
#else
typedef struct AtlRotaryCtl2 AtlRotaryCtl2;
#endif /* __cplusplus */

#endif 	/* __AtlRotaryCtl2_FWD_DEFINED__ */


#ifndef __AtlRotaryProp_FWD_DEFINED__
#define __AtlRotaryProp_FWD_DEFINED__

#ifdef __cplusplus
typedef class AtlRotaryProp AtlRotaryProp;
#else
typedef struct AtlRotaryProp AtlRotaryProp;
#endif /* __cplusplus */

#endif 	/* __AtlRotaryProp_FWD_DEFINED__ */


/* header files for imported files */
#include "oaidl.h"
#include "ocidl.h"

void __RPC_FAR * __RPC_USER MIDL_user_allocate(size_t);
void __RPC_USER MIDL_user_free( void __RPC_FAR * ); 

#ifndef __IAtlRotaryCtl2_INTERFACE_DEFINED__
#define __IAtlRotaryCtl2_INTERFACE_DEFINED__

/* interface IAtlRotaryCtl2 */
/* [unique][helpstring][dual][uuid][object] */ 


EXTERN_C const IID IID_IAtlRotaryCtl2;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("E119FD9B-F680-11D3-B4E3-9CE8F7073B36")
    IAtlRotaryCtl2 : public IDispatch
    {
    public:
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_BackColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_BackColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_BorderColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_BorderColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_FillColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_FillColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [id][propput] */ HRESULT STDMETHODCALLTYPE put_ForeColor( 
            /* [in] */ OLE_COLOR clr) = 0;
        
        virtual /* [id][propget] */ HRESULT STDMETHODCALLTYPE get_ForeColor( 
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr) = 0;
        
        virtual /* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE get_NumTicks( 
            /* [retval][out] */ short __RPC_FAR *pVal) = 0;
        
        virtual /* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE put_NumTicks( 
            /* [in] */ short newVal) = 0;
        
        virtual /* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE get_Ticks( 
            /* [retval][out] */ BOOL __RPC_FAR *pVal) = 0;
        
        virtual /* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE put_Ticks( 
            /* [in] */ BOOL newVal) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IAtlRotaryCtl2Vtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            IAtlRotaryCtl2 __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            IAtlRotaryCtl2 __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_BackColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_BackColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_BorderColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_BorderColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_FillColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_FillColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_ForeColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ OLE_COLOR clr);
        
        /* [id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_ForeColor )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);
        
        /* [helpstring][id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_NumTicks )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ short __RPC_FAR *pVal);
        
        /* [helpstring][id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_NumTicks )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ short newVal);
        
        /* [helpstring][id][propget] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *get_Ticks )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [retval][out] */ BOOL __RPC_FAR *pVal);
        
        /* [helpstring][id][propput] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *put_Ticks )( 
            IAtlRotaryCtl2 __RPC_FAR * This,
            /* [in] */ BOOL newVal);
        
        END_INTERFACE
    } IAtlRotaryCtl2Vtbl;

    interface IAtlRotaryCtl2
    {
        CONST_VTBL struct IAtlRotaryCtl2Vtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IAtlRotaryCtl2_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IAtlRotaryCtl2_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IAtlRotaryCtl2_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IAtlRotaryCtl2_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define IAtlRotaryCtl2_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define IAtlRotaryCtl2_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define IAtlRotaryCtl2_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)


#define IAtlRotaryCtl2_put_BackColor(This,clr)	\
    (This)->lpVtbl -> put_BackColor(This,clr)

#define IAtlRotaryCtl2_get_BackColor(This,pclr)	\
    (This)->lpVtbl -> get_BackColor(This,pclr)

#define IAtlRotaryCtl2_put_BorderColor(This,clr)	\
    (This)->lpVtbl -> put_BorderColor(This,clr)

#define IAtlRotaryCtl2_get_BorderColor(This,pclr)	\
    (This)->lpVtbl -> get_BorderColor(This,pclr)

#define IAtlRotaryCtl2_put_FillColor(This,clr)	\
    (This)->lpVtbl -> put_FillColor(This,clr)

#define IAtlRotaryCtl2_get_FillColor(This,pclr)	\
    (This)->lpVtbl -> get_FillColor(This,pclr)

#define IAtlRotaryCtl2_put_ForeColor(This,clr)	\
    (This)->lpVtbl -> put_ForeColor(This,clr)

#define IAtlRotaryCtl2_get_ForeColor(This,pclr)	\
    (This)->lpVtbl -> get_ForeColor(This,pclr)

#define IAtlRotaryCtl2_get_NumTicks(This,pVal)	\
    (This)->lpVtbl -> get_NumTicks(This,pVal)

#define IAtlRotaryCtl2_put_NumTicks(This,newVal)	\
    (This)->lpVtbl -> put_NumTicks(This,newVal)

#define IAtlRotaryCtl2_get_Ticks(This,pVal)	\
    (This)->lpVtbl -> get_Ticks(This,pVal)

#define IAtlRotaryCtl2_put_Ticks(This,newVal)	\
    (This)->lpVtbl -> put_Ticks(This,newVal)

#endif /* COBJMACROS */


#endif 	/* C style interface */



/* [id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_BackColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IAtlRotaryCtl2_put_BackColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_BackColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IAtlRotaryCtl2_get_BackColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_BorderColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IAtlRotaryCtl2_put_BorderColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_BorderColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IAtlRotaryCtl2_get_BorderColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_FillColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IAtlRotaryCtl2_put_FillColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_FillColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IAtlRotaryCtl2_get_FillColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_ForeColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ OLE_COLOR clr);


void __RPC_STUB IAtlRotaryCtl2_put_ForeColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_ForeColor_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ OLE_COLOR __RPC_FAR *pclr);


void __RPC_STUB IAtlRotaryCtl2_get_ForeColor_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_NumTicks_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ short __RPC_FAR *pVal);


void __RPC_STUB IAtlRotaryCtl2_get_NumTicks_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_NumTicks_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ short newVal);


void __RPC_STUB IAtlRotaryCtl2_put_NumTicks_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propget] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_get_Ticks_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [retval][out] */ BOOL __RPC_FAR *pVal);


void __RPC_STUB IAtlRotaryCtl2_get_Ticks_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [helpstring][id][propput] */ HRESULT STDMETHODCALLTYPE IAtlRotaryCtl2_put_Ticks_Proxy( 
    IAtlRotaryCtl2 __RPC_FAR * This,
    /* [in] */ BOOL newVal);


void __RPC_STUB IAtlRotaryCtl2_put_Ticks_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IAtlRotaryCtl2_INTERFACE_DEFINED__ */



#ifndef __ATLROTARY2Lib_LIBRARY_DEFINED__
#define __ATLROTARY2Lib_LIBRARY_DEFINED__

/* library ATLROTARY2Lib */
/* [helpstring][version][uuid] */ 


EXTERN_C const IID LIBID_ATLROTARY2Lib;

#ifndef ___IAtlRotaryCtl2Events_DISPINTERFACE_DEFINED__
#define ___IAtlRotaryCtl2Events_DISPINTERFACE_DEFINED__

/* dispinterface _IAtlRotaryCtl2Events */
/* [helpstring][uuid] */ 


EXTERN_C const IID DIID__IAtlRotaryCtl2Events;

#if defined(__cplusplus) && !defined(CINTERFACE)

    MIDL_INTERFACE("E119FD9D-F680-11D3-B4E3-9CE8F7073B36")
    _IAtlRotaryCtl2Events : public IDispatch
    {
    };
    
#else 	/* C style interface */

    typedef struct _IAtlRotaryCtl2EventsVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            _IAtlRotaryCtl2Events __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        END_INTERFACE
    } _IAtlRotaryCtl2EventsVtbl;

    interface _IAtlRotaryCtl2Events
    {
        CONST_VTBL struct _IAtlRotaryCtl2EventsVtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define _IAtlRotaryCtl2Events_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define _IAtlRotaryCtl2Events_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define _IAtlRotaryCtl2Events_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define _IAtlRotaryCtl2Events_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define _IAtlRotaryCtl2Events_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define _IAtlRotaryCtl2Events_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define _IAtlRotaryCtl2Events_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)

#endif /* COBJMACROS */


#endif 	/* C style interface */


#endif 	/* ___IAtlRotaryCtl2Events_DISPINTERFACE_DEFINED__ */


EXTERN_C const CLSID CLSID_AtlRotaryCtl2;

#ifdef __cplusplus

class DECLSPEC_UUID("E119FD9C-F680-11D3-B4E3-9CE8F7073B36")
AtlRotaryCtl2;
#endif

EXTERN_C const CLSID CLSID_AtlRotaryProp;

#ifdef __cplusplus

class DECLSPEC_UUID("850476E2-F76B-11D3-B4E3-A1CAA7050736")
AtlRotaryProp;
#endif
#endif /* __ATLROTARY2Lib_LIBRARY_DEFINED__ */

/* Additional Prototypes for ALL interfaces */

/* end of Additional Prototypes */

#ifdef __cplusplus
}
#endif

#endif
