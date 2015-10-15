unit owngrid;interfaceuses  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs;const maxcol = 100;      maxrow = 100;type { TDirections = (vertical,horizontal,both); }     TLine = record       Width : integer;       Color : TColor;       Visible : Boolean;     end;     TLineSquare = record       LeftLine,RightLine,TopLine,BottomLine : TLine;     end;     TLineRow = array[1..maxcol] of TLineSquare;     TLineTable = array[1..maxrow] of TLineRow;     TStringRow = array[1..maxcol] of string;     TStringTable = array[1..maxrow] of TStringRow;     TRowHeights = array[1..maxrow] of integer;     TColWidths = array[1..maxcol] of integer;     TColorRow = array[1..maxcol] of TColor;     TColorTable = array[1..maxrow] of TColorRow;     TMaxLineWidthsOnRows = array[0..maxrow] of integer;     TMaxLineWidthsOnCols = array[0..maxcol] of integer;  TOwnGrid = class(TGraphicControl)  private    alkuas : Boolean;    maalaa,maalaakaikki : Boolean;    pohjavari : TColor;    pohjavarilla : Boolean;    perusviivanpaksuus : integer;    perusviivanvari : TColor;    perusviivannakyvyys : Boolean;    fontti : TFont;    perussolunleveys,perussolunkorkeus : integer;    rivimaara, sarakemaara : integer;    sarakeleveydet : TColWidths;    rivikorkeudet : TRowHeights;    maksimiviivankorkeudet : TMaxLineWidthsOnRows;    maksimiviivanleveydet : TMaxLineWIdthsOnCols;    viivataulukko : TLineTable;    varitaulukko : TColorTable;    stringitaulukko : TStringTable;    function CalcWidth : integer;    function CalcHeight : integer;    function CalcMaxWidth( Col : integer ) : integer;    function CalcMaxHeight( Row : integer ) : integer;    procedure laskesoluxy( var xtop,ytop : integer; i,j : integer );    procedure piirraviivat( var xtop,ytop : integer; i,j : integer );    procedure piirrateksti( xtop,ytop,i,j : integer );    procedure SetBasicLineWidth( Value : integer );    procedure SetBasicLineColor( Value : TColor );    procedure SetBasicLineVisible( Value : Boolean );    procedure SetFont( Value : TFont );    procedure SetBasicCellWidth( Value : integer );    procedure SetBasicCellHeight( Value : integer );    procedure SetCells( Row,Col : integer ; Value : string );    function  GetCells( Row,Col : integer ) : string;    procedure SetLines( Row,Col : integer ; Value : TLineSquare );    function  GetLines( Row,Col : integer ) : TLineSquare;    procedure SetRowHeights( Row : integer ; Value : integer );    function  GetRowHeights( Row : integer ) : integer;    procedure SetColWidths( Col : integer ; Value : integer );    function  GetColWidths( Col : integer ) : integer;    procedure SetColors( Row, Col : integer ; Value : TColor );    function GetColors( Row, Col : integer ) : TColor;    procedure SetColAmount( Value : integer );    procedure SetRowAmount( Value : integer );    procedure SetBgColor( Value : TColor );    procedure SetBounds(ALeft, ATop, AWidth, AHeight: Integer); override;    procedure SetPaintOnChange( Value : Boolean );    procedure SetPaintAllOnCellChange( Value : Boolean );  protected    procedure Paint; override;  public    constructor Create( AOwner : TComponent ); override;    destructor Destroy; override;{   procedure SetLineOnRow( Row : integer ;      LineWidth : integer; LineColor : TColor; LineOn : Boolean );    procedure SetLineOnCol( Col : integer ;      LineWidth : integer; LineColor : TColor; LineOn : Boolean );    procedure SetLineOnTable( LineWidth : integer; LineColor : TColor;      LineOn : Boolean ; Directions : TDirections );    procedure SetLineOnArea( area : TGridRect ;      LineWidth : integer; LineColor : TColor; LineOn : Boolean ;      Directions : TDirections );    procedure SetIntervalLineOnCol( Col,BeginRow,EndRow : integer ;      LineWidth : integer; LineColor : TColor; LineOn : Boolean );    procedure SetIntervalLineOnRow( Col,BeginRow,EndRow : integer ;      LineWidth : integer; LineColor : TColor; LineOn : Boolean );    procedure SetColorOnCol( Col : integer ; Color : TColor );    procedure SetColorOnRow( Row : integer ; Color : TColor );    procedure SetColorOnTable( Color : TColor );    procedure SetColorOnArea( area : TGridRect ; Color : TColor );    procedure SetIntervalColorOnCol( Col,BeginRow,EndRow : integer;      Color : TColor );    procedure SetIntervalColorOnRow( Row,BeginCol,EndCol : integer ;      TLineSquare );    procedure SetEqualColWidth( ColWidth : integer );    procedure SetEqualRowHeight( RowHeight : integer );    procedure SetIntervalColWidht( BeginCol,EndCol,ColWidth : integer );    procedure SetIntervalRowHeight( BeginCol,EndCol,ColWidth : integer ); }  published    property Font : TFont read fontti      write SetFont;    property BgColor : TColor read pohjavari      write SetBgColor;    property BasicLineWidth : integer read perusviivanpaksuus      write SetBasicLineWidth;    property BasicLineColor : TColor read perusviivanvari      write SetBasicLineColor;    property BasicLineVisible : Boolean read perusviivannakyvyys      write SetBasicLineVisible;    property BasicCellWidth : integer read perussolunleveys      write SetBasicCellWidth;    property BasicCellHeight : integer read perussolunkorkeus      write SetBasicCellHeight;    property Cells[ARow,ACol : integer] : string read      GetCells write SetCells;    property Lines[ARow,ACol : integer] : TLineSquare read      GetLines write SetLines;    property RowHeights[ARow : integer] : integer      read GetRowHeights write SetRowHeights;    property ColWidths[ACol : integer] : integer      read GetColWidths write SetColWidths;    property RowAmount : integer read      rivimaara write SetRowAmount;    property ColAmount : integer read      sarakemaara write SetColAmount;    property Colors[Row,Col : integer] : TColor      read GetColors write SetColors;    property PaintOnChange : Boolean read maalaa write SetPaintOnChange;    property PaintAllOnCellChange : boolean read maalaakaikki      write SetPaintAllOnCellChange;    property Align;    property DragCursor;    property DragMode;    property Enabled;    property ParentShowHint;    property Visible;    property OnDragDrop;    property OnDragOver;    property OnEndDrag;    property OnMouseDown;    property OnMouseMove;    property OnMouseUp;    property OnStartDrag;  end;procedure Register;implementationconstructor TOwnGrid.Create( AOwner : TComponent );var i,j : integer;    perusviiva : TLine;    perusviivanelio : TLineSquare;begin  inherited;  alkuas := true;  pohjavari := ClWhite;  maalaa := true;maalaakaikki := true;  fontti := TFont.Create;  fontti.size := 8;  fontti.Color := clBlack;  pohjavarilla := false;  perusviivanpaksuus := 1;perusviivanvari := clBlack;  perusviivannakyvyys := true;  perusviiva.Width := 1;perusviiva.Color := clBlack;  perusviiva.Visible := true;  perusviivanelio.LeftLine := perusviiva;  perusviivanelio.RightLine := perusviiva;  perusviivanelio.TopLine := perusviiva;  perusviivanelio.BottomLine := perusviiva;  rivimaara := 4;sarakemaara := 5;  perussolunleveys := 50;  perussolunkorkeus := 25;  maksimiviivanleveydet[0] := 1;  maksimiviivankorkeudet[0] := 1;  for i := 1 to maxrow do begin    rivikorkeudet[i] := 25;    maksimiviivankorkeudet[i] := 1;    for j := 1 to maxcol do begin      viivataulukko[i,j] := perusviivanelio;      stringitaulukko[i,j] := '';      varitaulukko[i,j] := fontti.Color;    end;  end;  for j := 1 to maxcol do begin    sarakeleveydet[j] := 50;    maksimiviivanleveydet[j] := 1;  end;  width := CalcWidth;  height := CalcHeight;  alkuas := false;end;destructor TOwnGrid.Destroy;begin  inherited;  fontti.free;end;procedure TOwnGrid.SetBounds(ALeft, ATop, AWidth, AHeight: Integer);var leveys,korkeus : integer;begin  if (not alkuas) then begin    leveys := CalcWidth;    korkeus := CalcHeight;    inherited SetBounds(ALeft, Atop,leveys,korkeus);  end else inherited SetBounds(ALeft, Atop, AWidth, AHeight);end;procedure TOwnGrid.laskesoluxy( var xtop,ytop : integer; i,j : integer );var ilask,jlask : integer;begin  xtop := 0;ytop := 0;  for ilask := 1 to (i-1) do   ytop := ytop+maksimiviivankorkeudet[ilask-1]+rivikorkeudet[ilask];  for jlask := 1 to (j-1) do   xtop := xtop+maksimiviivanleveydet[jlask-1]+sarakeleveydet[jlask];end;procedure TOwnGrid.piirraviivat( var xtop,ytop : integer; i,j : integer );var xviivaalku,yviivaalku,xviivaloppu,yviivaloppu : integer;begin  if pohjavarilla then Canvas.Pen.Color := pohjavari;  { yl�reuna }  xviivaalku := xtop+round(maksimiviivanleveydet[j-1]/2);  xviivaloppu := xtop+maksimiviivanleveydet[j-1]+sarakeleveydet[j]    +round(maksimiviivanleveydet[j]/2);  yviivaalku := ytop+round(maksimiviivankorkeudet[i-1]/2);  yviivaloppu := yviivaalku;  if (viivataulukko[i,j].TopLine.Visible) then begin    Canvas.Pen.Width := viivataulukko[i,j].TopLine.Width;    if not pohjavarilla then      Canvas.Pen.Color := viivataulukko[i,j].TopLine.Color;    Canvas.MoveTo(xviivaalku,yviivaalku);    Canvas.LineTo(xviivaloppu,yviivaloppu);  end;  { oikea reuna }  { yviivaalku kuten edellisess� }  xviivaalku := xviivaloppu; { edellisest� }  xviivaloppu := xviivaalku;  yviivaloppu := ytop+maksimiviivankorkeudet[i-1]+     rivikorkeudet[i]+round(maksimiviivankorkeudet[i]/2)+1;  if (viivataulukko[i,j].RightLine.Visible) then begin    Canvas.Pen.Width := viivataulukko[i,j].RightLine.Width;    if not pohjavarilla then      Canvas.Pen.Color := viivataulukko[i,j].RightLine.Color;    Canvas.MoveTo(xviivaalku,yviivaalku);    Canvas.LineTo(xviivaloppu,yviivaloppu);  end;  { alareuna }  Dec(yviivaloppu);  { yviivaloppu kuten edellisess� }  yviivaalku := yviivaloppu;  { xviivaloppu kuten edellisess� }  xviivaalku := xtop+round(maksimiviivanleveydet[j-1]/2);  if (viivataulukko[i,j].BottomLine.Visible) then begin    Canvas.Pen.Width := viivataulukko[i,j].BottomLine.Width;    if not pohjavarilla then      Canvas.Pen.Color := viivataulukko[i,j].BottomLine.Color;    Canvas.MoveTo(xviivaalku,yviivaalku);    Canvas.LineTo(xviivaloppu,yviivaloppu);  end;  { vasen reuna }  { xviivaalku kuten edell� }  xviivaloppu := xviivaalku;  yviivaloppu := yviivaalku; { edellisest� }  yviivaalku := ytop+round(maksimiviivankorkeudet[i-1]/2);  if (viivataulukko[i,j].LeftLine.Visible) then begin    Canvas.Pen.Width := viivataulukko[i,j].LeftLine.Width;    if not pohjavarilla then      Canvas.Pen.Color := viivataulukko[i,j].LeftLine.Color;    Canvas.MoveTo(xviivaalku,yviivaalku);    Canvas.LineTo(xviivaloppu,yviivaloppu);  end;  { xtop ja ytop lis�ykset }  xtop := xtop+maksimiviivanleveydet[j-1];end;procedure TOwnGrid.piirrateksti( xtop,ytop,i,j : integer );var xteksti,yteksti : integer;    tekstipituus,tekstikorkeus : integer;begin  Canvas.Font.Assign(fontti);  if not pohjavarilla then    Canvas.Font.Color := varitaulukko[i,j]  else Canvas.Font.Color := pohjavari;  ytop := ytop+maksimiviivankorkeudet[i-1];  tekstipituus := Canvas.TextWidth(stringitaulukko[i,j]);  tekstikorkeus := Canvas.TextHeight(stringitaulukko[i,j]);  xteksti := xtop+round((sarakeleveydet[j]-tekstipituus)/2);  yteksti := ytop+round((rivikorkeudet[i]-tekstikorkeus)/2);  Canvas.Brush.Color := pohjavari;  Canvas.Brush.Style := bssolid;  Canvas.FillRect(Rect(xtop,ytop,xtop+sarakeleveydet[j],ytop+rivikorkeudet[i]));  Canvas.TextOut(xteksti,yteksti,stringitaulukko[i,j]);end;procedure TOwnGrid.Paint;var i,j : integer;    xtop,ytop : integer;begin  Canvas.Brush.Color := pohjavari;  Canvas.Brush.Style := bssolid;  Canvas.FloodFill(width div 2,height div 2,pohjavari,fsBorder);  ytop := 0;  for i:= 1 to rivimaara do begin    xtop := 0;    for j := 1 to sarakemaara do begin      piirraviivat( xtop,ytop,i,j );      piirrateksti( xtop,ytop,i,j );      xtop := xtop+sarakeleveydet[j];    end;    ytop := ytop+rivikorkeudet[i]            +maksimiviivankorkeudet[i-1];  end;end;function TOwngrid.CalcWidth : integer;var i : integer;begin  result := maksimiviivanleveydet[0];  for i:=1 to sarakemaara do result := result+sarakeleveydet[i]+    maksimiviivanleveydet[i];end;function TOwnGrid.CalcHeight : integer;var i : integer;begin  result := maksimiviivankorkeudet[0];  for i:=1 to rivimaara do result := result+rivikorkeudet[i]+    maksimiviivankorkeudet[i];end;function TOwnGrid.CalcMaxWidth( Col : integer ) : integer;var i : integer;begin  result := 0;  with Canvas Do begin    Font.Assign(fontti);    for i := 1 to rivimaara do begin       if (result<TextWidth(stringitaulukko[i,Col])) then         result := TextWidth(stringitaulukko[i,Col]);    end;  end;end;function TOwnGrid.CalcMaxHeight( Row : integer ) : integer;var i : integer;begin  result := 0;  with Canvas Do begin    Font.Assign(fontti);    for i := 1 to sarakemaara do begin       if (result<TextHeight(stringitaulukko[Row,i])) then         result := TextHeight(stringitaulukko[Row,i]);    end;  end;end;procedure TOwnGrid.SetBasicLineWidth( Value : integer );begin  if (Value>0) then perusviivanpaksuus := Value;end;procedure TOwnGrid.SetBgColor( Value : TColor );begin  pohjavari := Value;  InValidate;end;procedure TOwnGrid.SetBasicLineColor( Value : TColor );begin  if (Value>0) then perusviivanvari := Value;end;procedure TOwnGrid.SetBasicLineVisible( Value : Boolean );begin  perusviivannakyvyys := Value;end;procedure TOwnGrid.SetFont( Value : TFont );var laskuri,maxarvo : integer;begin  fontti.Assign(Value);  for laskuri := 1 to sarakemaara do begin    maxarvo := CalcMaxWidth(laskuri);    if (sarakeleveydet[laskuri]<maxarvo) then      sarakeleveydet[laskuri] := maxarvo;  end;  for laskuri := 1 to rivimaara do begin    maxarvo := CalcMaxHeight(laskuri);    if (rivikorkeudet[laskuri]<maxarvo) then      rivikorkeudet[laskuri] := maxarvo;  end;  width := CalcWidth;  height := CalcHeight;  if maalaa then InValidate;end;procedure TOwnGrid.SetBasicCellWidth( Value : integer );begin  if (Value>0) then perussolunleveys := Value;end;procedure TOwnGrid.SetBasicCellHeight( Value : integer );begin  if (Value>0) then perussolunkorkeus := Value;end;procedure TOwnGrid.SetCells( Row,Col : integer ; Value : string );var leveys, korkeus : integer;    xtop, ytop : integer;begin  leveys := Canvas.TextWidth(Value);  korkeus := Canvas.TextHeight(Value);  if (sarakeleveydet[Col]<leveys) then sarakeleveydet[Col] := leveys;  if (rivikorkeudet[Row]<korkeus) then rivikorkeudet[Row]  := korkeus;  if maalaa and not maalaakaikki then begin    laskesoluxy( xtop,ytop,Row,Col );    pohjavarilla := true;    xtop := xtop+maksimiviivanleveydet[Col-1];    piirrateksti( xtop,ytop,Row,Col );    stringitaulukko[Row,Col] := Value;    pohjavarilla := false;    piirrateksti( xtop,ytop,Row,Col );  end else begin    stringitaulukko[Row,Col] := Value;    if maalaa then InValidate;  end;end;function  TOwnGrid.GetCells( Row,Col : integer ) : string;begin  result := stringitaulukko[Row,Col];end;procedure TOwnGrid.SetLines( Row,Col : integer ; Value : TLineSquare );var xtop,ytop : integer;begin  if maalaa and not maalaakaikki then begin    pohjavarilla := true;    laskesoluxy( xtop,ytop,Row,Col );    piirraviivat( xtop,ytop,Row,Col );    if (Row>1) then begin      laskesoluxy(xtop,ytop,Row-1,Col);      piirraviivat(xtop,ytop,Row-1,Col);    end;    if (Row<maxrow) then begin      laskesoluxy(xtop,ytop,Row+1,Col);      piirraviivat(xtop,ytop,Row+1,Col);    end;    if (Col>1) then begin      laskesoluxy(xtop,ytop,Row,Col-1);      piirraviivat(xtop,ytop,Row,Col-1);    end;    if (Col<maxcol) then begin      laskesoluxy(xtop,ytop,Row,Col+1);      piirraviivat(xtop,ytop,Row,Col+1);    end;  end;  viivataulukko[Row,Col] := Value;  { Tutkitaan maksimiviivanleveydet ja korkeudet }  if (Value.LeftLine.Width>maksimiviivanleveydet[Col-1]) then    maksimiviivanleveydet[Col-1] := Value.LeftLine.Width;  if (Value.TopLine.Width>maksimiviivankorkeudet[Row-1]) then    maksimiviivankorkeudet[Row-1] := Value.TopLine.Width;  if (Value.RightLine.Width>maksimiviivanleveydet[Col]) then    maksimiviivanleveydet[Col] := Value.RightLine.Width;  if (Value.BottomLine.Width>maksimiviivankorkeudet[Row]) then    maksimiviivankorkeudet[Row] := Value.BottomLine.Width;  { Asetetaan ymp�r�iv�t viivanpaksuudet }  if (Col>1) then viivataulukko[Row,Col-1].RightLine := Value.LeftLine;  if (Col<sarakemaara) then    viivataulukko[Row,Col+1].LeftLine := Value.RightLine;  if (Row>1) then viivataulukko[Row-1,Col].BottomLine := Value.TopLine;  if (Row<rivimaara) then viivataulukko[Row+1,Col].TopLine := Value.BottomLine;  { Lasketaan leveys ja korkeus koko taulukolle }  width := Calcwidth;  height := CalcHeight;  if maalaa and not maalaakaikki then begin    pohjavarilla := false;    if (Row>1) then begin      laskesoluxy(xtop,ytop,Row-1,Col);      piirraviivat(xtop,ytop,Row-1,Col);    end;    if (Row<maxrow) then begin      laskesoluxy(xtop,ytop,Row+1,Col);      piirraviivat(xtop,ytop,Row+1,Col);    end;    if (Col>1) then begin      laskesoluxy(xtop,ytop,Row,Col-1);      piirraviivat(xtop,ytop,Row,Col-1);    end;    if (Col<maxcol) then begin      laskesoluxy(xtop,ytop,Row,Col+1);      piirraviivat(xtop,ytop,Row,Col+1);    end;    laskesoluxy( xtop,ytop,Row,Col );    piirraviivat( xtop,ytop,Row,Col );  end else if maalaa then InValidate;end;function  TOwnGrid.GetLines( Row,Col : integer ) : TLineSquare;begin  result := viivataulukko[Row,Col];end;procedure TOwnGrid.SetRowHeights( Row : integer ; Value : integer );var maxkorkeus : integer;begin  maxkorkeus := CalcMaxHeight( Row );  if (Value>=maxkorkeus) then rivikorkeudet[Row] := Value;  height := CalcHeight;  if maalaa then InValidate;end;function  TOwnGrid.GetRowHeights( Row : integer ) : integer;begin  result := rivikorkeudet[Row];end;procedure TOwnGrid.SetColWidths( Col : integer ; Value : integer );var maxleveys : integer;begin  maxleveys := CalcMaxWidth( Col );  if (Value>=maxleveys) then sarakeleveydet[Col] := Value;  width := CalcWidth;  if maalaa then InValidate;end;function  TOwnGrid.GetColWidths( Col : integer ) : integer;begin  result := sarakeleveydet[Col];end;procedure TOwnGrid.SetColors( Row, Col : integer ; Value : TColor );var xtop,ytop : integer;begin  varitaulukko[Row,Col] := Value;  if maalaa then begin    if maalaakaikki then InValidate else begin        laskesoluxy( xtop,ytop,Row,Col );        xtop := xtop+maksimiviivanleveydet[Col-1];        piirrateksti( xtop,ytop,Row,Col );    end;  end;end;function TOwnGrid.GetColors( Row, Col : integer ) : TColor;begin  result := varitaulukko[Row,Col];end;procedure TOwnGrid.SetColAmount( Value : integer );begin  if (Value>0) and (Value<=maxcol) then sarakemaara := Value;  width := CalcWidth;  if maalaa then InValidate;end;procedure TOwnGrid.SetRowAmount( Value : integer );begin  if (Value>0) and (Value<=maxrow) then rivimaara := Value;  height := CalcHeight;  if maalaa then InValidate;end;procedure TOwnGrid.SetPaintOnChange( Value : Boolean );begin  maalaa := Value;end;procedure TOwngrid.SetPaintAllOnCellChange( Value : Boolean );begin  maalaakaikki := Value;end;procedure Register;begin  RegisterComponents('Opetusohjelma', [TOwnGrid]);end;end.