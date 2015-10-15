/* this file contains the actual definitions of */
/* the IIDs and CLSIDs */

/* link this file in with the server and any clients */


/* File created by MIDL compiler version 5.01.0164 */
/* at Sat Mar 11 18:23:09 2000
 */
/* Compiler settings for C:\visualc\rotary\atlrotary2\atlrotary2.idl:
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

const IID IID_IAtlRotaryCtl2 = {0xE119FD9B,0xF680,0x11D3,{0xB4,0xE3,0x9C,0xE8,0xF7,0x07,0x3B,0x36}};


const IID LIBID_ATLROTARY2Lib = {0xE119FD8E,0xF680,0x11D3,{0xB4,0xE3,0x9C,0xE8,0xF7,0x07,0x3B,0x36}};


const IID DIID__IAtlRotaryCtl2Events = {0xE119FD9D,0xF680,0x11D3,{0xB4,0xE3,0x9C,0xE8,0xF7,0x07,0x3B,0x36}};


const CLSID CLSID_AtlRotaryCtl2 = {0xE119FD9C,0xF680,0x11D3,{0xB4,0xE3,0x9C,0xE8,0xF7,0x07,0x3B,0x36}};


const CLSID CLSID_AtlRotaryProp = {0x850476E2,0xF76B,0x11D3,{0xB4,0xE3,0xA1,0xCA,0xA7,0x05,0x07,0x36}};


#ifdef __cplusplus
}
#endif

