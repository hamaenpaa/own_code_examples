
atlrotary2ps.dll: dlldata.obj atlrotary2_p.obj atlrotary2_i.obj
	link /dll /out:atlrotary2ps.dll /def:atlrotary2ps.def /entry:DllMain dlldata.obj atlrotary2_p.obj atlrotary2_i.obj \
		kernel32.lib rpcndr.lib rpcns4.lib rpcrt4.lib oleaut32.lib uuid.lib \

.c.obj:
	cl /c /Ox /DWIN32 /D_WIN32_WINNT=0x0400 /DREGISTER_PROXY_DLL \
		$<

clean:
	@del atlrotary2ps.dll
	@del atlrotary2ps.lib
	@del atlrotary2ps.exp
	@del dlldata.obj
	@del atlrotary2_p.obj
	@del atlrotary2_i.obj
