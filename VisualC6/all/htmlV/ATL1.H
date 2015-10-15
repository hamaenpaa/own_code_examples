/* this ALWAYS GENERATED file contains the definitions for the interfaces */


/* File created by MIDL compiler version 5.01.0164 */
/* at Fri Jan 28 15:52:35 2000
 */
/* Compiler settings for D:\VisualCkoulutus\kerta3\harjoitus3\atl1\atl1.idl:
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

#ifndef __atl1_h__
#define __atl1_h__

#ifdef __cplusplus
extern "C"{
#endif 

/* Forward Declarations */ 

#ifndef __IKokeilu_FWD_DEFINED__
#define __IKokeilu_FWD_DEFINED__
typedef interface IKokeilu IKokeilu;
#endif 	/* __IKokeilu_FWD_DEFINED__ */


#ifndef __ILuvut_FWD_DEFINED__
#define __ILuvut_FWD_DEFINED__
typedef interface ILuvut ILuvut;
#endif 	/* __ILuvut_FWD_DEFINED__ */


#ifndef __Kokeilu_FWD_DEFINED__
#define __Kokeilu_FWD_DEFINED__

#ifdef __cplusplus
typedef class Kokeilu Kokeilu;
#else
typedef struct Kokeilu Kokeilu;
#endif /* __cplusplus */

#endif 	/* __Kokeilu_FWD_DEFINED__ */


#ifndef __Luvut_FWD_DEFINED__
#define __Luvut_FWD_DEFINED__

#ifdef __cplusplus
typedef class Luvut Luvut;
#else
typedef struct Luvut Luvut;
#endif /* __cplusplus */

#endif 	/* __Luvut_FWD_DEFINED__ */


/* header files for imported files */
#include "oaidl.h"
#include "ocidl.h"

void __RPC_FAR * __RPC_USER MIDL_user_allocate(size_t);
void __RPC_USER MIDL_user_free( void __RPC_FAR * ); 

#ifndef __IKokeilu_INTERFACE_DEFINED__
#define __IKokeilu_INTERFACE_DEFINED__

/* interface IKokeilu */
/* [unique][helpstring][dual][uuid][object] */ 


EXTERN_C const IID IID_IKokeilu;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("E78F35AB-D57D-11D3-A757-00105A72C3E0")
    IKokeilu : public IDispatch
    {
    public:
        virtual /* [helpstring][id] */ HRESULT STDMETHODCALLTYPE LaskeLuvut3( 
            /* [out][retval] */ long __RPC_FAR *lp) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IKokeiluVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            IKokeilu __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            IKokeilu __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            IKokeilu __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            IKokeilu __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            IKokeilu __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            IKokeilu __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            IKokeilu __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        /* [helpstring][id] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *LaskeLuvut3 )( 
            IKokeilu __RPC_FAR * This,
            /* [out][retval] */ long __RPC_FAR *lp);
        
        END_INTERFACE
    } IKokeiluVtbl;

    interface IKokeilu
    {
        CONST_VTBL struct IKokeiluVtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IKokeilu_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IKokeilu_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IKokeilu_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IKokeilu_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define IKokeilu_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define IKokeilu_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define IKokeilu_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)


#define IKokeilu_LaskeLuvut3(This,lp)	\
    (This)->lpVtbl -> LaskeLuvut3(This,lp)

#endif /* COBJMACROS */


#endif 	/* C style interface */



/* [helpstring][id] */ HRESULT STDMETHODCALLTYPE IKokeilu_LaskeLuvut3_Proxy( 
    IKokeilu __RPC_FAR * This,
    /* [out][retval] */ long __RPC_FAR *lp);


void __RPC_STUB IKokeilu_LaskeLuvut3_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IKokeilu_INTERFACE_DEFINED__ */


#ifndef __ILuvut_INTERFACE_DEFINED__
#define __ILuvut_INTERFACE_DEFINED__

/* interface ILuvut */
/* [unique][helpstring][dual][uuid][object] */ 


EXTERN_C const IID IID_ILuvut;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("E78F35AF-D57D-11D3-A757-00105A72C3E0")
    ILuvut : public IDispatch
    {
    public:
    };
    
#else 	/* C style interface */

    typedef struct ILuvutVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *QueryInterface )( 
            ILuvut __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void __RPC_FAR *__RPC_FAR *ppvObject);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *AddRef )( 
            ILuvut __RPC_FAR * This);
        
        ULONG ( STDMETHODCALLTYPE __RPC_FAR *Release )( 
            ILuvut __RPC_FAR * This);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfoCount )( 
            ILuvut __RPC_FAR * This,
            /* [out] */ UINT __RPC_FAR *pctinfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetTypeInfo )( 
            ILuvut __RPC_FAR * This,
            /* [in] */ UINT iTInfo,
            /* [in] */ LCID lcid,
            /* [out] */ ITypeInfo __RPC_FAR *__RPC_FAR *ppTInfo);
        
        HRESULT ( STDMETHODCALLTYPE __RPC_FAR *GetIDsOfNames )( 
            ILuvut __RPC_FAR * This,
            /* [in] */ REFIID riid,
            /* [size_is][in] */ LPOLESTR __RPC_FAR *rgszNames,
            /* [in] */ UINT cNames,
            /* [in] */ LCID lcid,
            /* [size_is][out] */ DISPID __RPC_FAR *rgDispId);
        
        /* [local] */ HRESULT ( STDMETHODCALLTYPE __RPC_FAR *Invoke )( 
            ILuvut __RPC_FAR * This,
            /* [in] */ DISPID dispIdMember,
            /* [in] */ REFIID riid,
            /* [in] */ LCID lcid,
            /* [in] */ WORD wFlags,
            /* [out][in] */ DISPPARAMS __RPC_FAR *pDispParams,
            /* [out] */ VARIANT __RPC_FAR *pVarResult,
            /* [out] */ EXCEPINFO __RPC_FAR *pExcepInfo,
            /* [out] */ UINT __RPC_FAR *puArgErr);
        
        END_INTERFACE
    } ILuvutVtbl;

    interface ILuvut
    {
        CONST_VTBL struct ILuvutVtbl __RPC_FAR *lpVtbl;
    };

    

#ifdef COBJMACROS


#define ILuvut_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define ILuvut_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define ILuvut_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define ILuvut_GetTypeInfoCount(This,pctinfo)	\
    (This)->lpVtbl -> GetTypeInfoCount(This,pctinfo)

#define ILuvut_GetTypeInfo(This,iTInfo,lcid,ppTInfo)	\
    (This)->lpVtbl -> GetTypeInfo(This,iTInfo,lcid,ppTInfo)

#define ILuvut_GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)	\
    (This)->lpVtbl -> GetIDsOfNames(This,riid,rgszNames,cNames,lcid,rgDispId)

#define ILuvut_Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)	\
    (This)->lpVtbl -> Invoke(This,dispIdMember,riid,lcid,wFlags,pDispParams,pVarResult,pExcepInfo,puArgErr)


#endif /* COBJMACROS */


#endif 	/* C style interface */




#endif 	/* __ILuvut_INTERFACE_DEFINED__ */



#ifndef __ATL1Lib_LIBRARY_DEFINED__
#define __ATL1Lib_LIBRARY_DEFINED__

/* library ATL1Lib */
/* [helpstring][version][uuid] */ 


EXTERN_C const IID LIBID_ATL1Lib;

EXTERN_C const CLSID CLSID_Kokeilu;

#ifdef __cplusplus

class DECLSPEC_UUID("E78F35AC-D57D-11D3-A757-00105A72C3E0")
Kokeilu;
#endif

EXTERN_C const CLSID CLSID_Luvut;

#ifdef __cplusplus

class DECLSPEC_UUID("E78F35B0-D57D-11D3-A757-00105A72C3E0")
Luvut;
#endif
#endif /* __ATL1Lib_LIBRARY_DEFINED__ */

/* Additional Prototypes for ALL interfaces */

/* end of Additional Prototypes */

#ifdef __cplusplus
}
#endif

#endif
