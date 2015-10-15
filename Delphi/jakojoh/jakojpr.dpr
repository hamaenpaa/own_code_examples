program jakojpr;

uses
  Forms,
  valikko in 'valikko.pas' {paalomake},
  etenem in 'etenem.pas' {lomake},
  huom in 'huom.pas' {huomlomake};

{$R *.RES}

begin
  Application.Initialize;
  Application.CreateForm(Tpaalomake, paalomake);
  Application.CreateForm(Tlomake, lomake);
  Application.CreateForm(Thuomlomake, huomlomake);
  Application.Run;
end.
