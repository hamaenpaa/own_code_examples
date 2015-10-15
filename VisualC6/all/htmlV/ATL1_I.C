/* this file contains the actual definitions of */
/* the IIDs and CLSIDs */

/* link this file in with the server and any clients */


/* File created by MIDL compiler version 5.01.0164 */
/* at Fri Jan 28 15:52:35 2000
 */
/* Compiler settings for D:\VisualCkoulutus\kerta3\harjoitus3\atl1\atl1.idl:
    Oicf (OptLev=i2), W1, Zp8, env=Win32, ms_ext, c_ext
    error checks: allocation ref bounds_check enum stub_data 
*/
//@@MIDL_FILE_HEADING(  )
#ifdef __cplusplus
extern "C"{
#endif 


#ifndef __IID_DEFINED__
#define __IID_DEFINED__

typedef struct _IID
{
    unsigned long x;
    unsigned short s1;
    unsigned short s2;
    unsigned char  c[8];
} IID;

#endif // __IID_DEFINED__

#ifndef CLSID_DEFINED
#define CLSID_DEFINED
typedef IID CLSID;
#endif // CLSID_DEFINED

const IID IID_IKokeilu = {0xE78F35AB,0xD57D,0x11D3,{0xA7,0x57,0x00,0x10,0x5A,0x72,0xC3,0xE0}};


const IID IID_ILuvut = {0xE78F35AF,0xD57D,0x11D3,{0xA7,0x57,0x00,0x10,0x5A,0x72,0xC3,0xE0}};


const IID LIBID_ATL1Lib = {0xE78F359F,0xD57D,0x11D3,{0xA7,0x57,0x00,0x10,0x5A,0x72,0xC3,0xE0}};


const CLSID CLSID_Kokeilu = {0xE78F35AC,0xD57D,0x11D3,{0xA7,0x57,0x00,0x10,0x5A,0x72,0xC3,0xE0}};


const CLSID CLSID_Luvut = {0xE78F35B0,0xD57D,0x11D3,{0xA7,0x57,0x00,0x10,0x5A,0x72,0xC3,0xE0}};


#ifdef __cplusplus
}
#endif

