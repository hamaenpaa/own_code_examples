/* this file contains the actual definitions of */
/* the IIDs and CLSIDs */

/* link this file in with the server and any clients */


/* File created by MIDL compiler version 5.01.0164 */
/* at Sat Feb 19 18:07:10 2000
 */
/* Compiler settings for C:\teku\kokeilu\kokeilu.idl:
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

const IID IID_IOmaCtl = {0xA248D58D,0xE6F3,0x11D3,{0xB4,0xE3,0xE9,0x33,0x32,0xAC,0x01,0x36}};


const IID LIBID_KOKEILULib = {0xA248D580,0xE6F3,0x11D3,{0xB4,0xE3,0xE9,0x33,0x32,0xAC,0x01,0x36}};


const IID DIID__IOmaCtlEvents = {0xA248D58F,0xE6F3,0x11D3,{0xB4,0xE3,0xE9,0x33,0x32,0xAC,0x01,0x36}};


const CLSID CLSID_OmaCtl = {0xA248D58E,0xE6F3,0x11D3,{0xB4,0xE3,0xE9,0x33,0x32,0xAC,0x01,0x36}};


#ifdef __cplusplus
}
#endif

