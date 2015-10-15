
kokeilups.dll: dlldata.obj kokeilu_p.obj kokeilu_i.obj
	link /dll /out:kokeilups.dll /def:kokeilups.def /entry:DllMain dlldata.obj kokeilu_p.obj kokeilu_i.obj \
		kernel32.lib rpcndr.lib rpcns4.lib rpcrt4.lib oleaut32.lib uuid.lib \

.c.obj:
	cl /c /Ox /DWIN32 /D_WIN32_WINNT=0x0400 /DREGISTER_PROXY_DLL \
		$<

clean:
	@del kokeilups.dll
	@del kokeilups.lib
	@del kokeilups.exp
	@del dlldata.obj
	@del kokeilu_p.obj
	@del kokeilu_i.obj
