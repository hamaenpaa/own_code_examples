/* tonitiet.c *//* Malli tietueesta tietueessa */#include<iostream.h>typedef struct {  double pituus;      /* hyppyjen pituudet metrein� */  double tuomarit[5]; /* tuomaripisteet             */  double pisteet;     /* Yhteistulos                */} Kierros_tyyppi;typedef struct {  Kierros_tyyppi kierros[2];  double lopputulos;} Tulos_tyyppi;typedef struct {  char nimi[8];  int  nro;  Tulos_tyyppi tulos;} Kilpailija_tyyppi;void tulosta_kierros( Kierros_tyyppi &kierros ){  int i;  cout << "Pituus:" << kierros.pituus << endl;  cout << "Tuomarien pisteet:";  for(i=0;i<=4;i++) cout << " " << kierros.tuomarit[i];  cout << endl;  cout << "Pisteet:" << kierros.pisteet << endl;  cout << endl;}void tulosta_tulostietue( Tulos_tyyppi &tulos ){  int i;  cout << "Lopputulos: " << tulos.lopputulos << endl;  for(i=0;i<=1;i++) tulosta_kierros( tulos.kierros[i] );}void tulosta_tietue( Kilpailija_tyyppi &henkilo ){  cout << "Nimi: " << henkilo.nimi << endl;  cout << "Nro:  " << henkilo.nro << endl;  tulosta_tulostietue( henkilo.tulos );}int main(void){  Kilpailija_tyyppi toni, matti;  strcpy(toni.nimi,"Toni N");  toni.nro = 3;  toni.tulos.kierros[0].pituus = 107;  toni.tulos.kierros[1].tuomarit[0] = 19;  toni.tulos.kierros[1].tuomarit[1] = 18;  toni.tulos.kierros[1].tuomarit[2] = 19.5;  toni.tulos.kierros[1].tuomarit[3] = 18;  toni.tulos.kierros[1].tuomarit[4] = 20;  strcpy(matti.nimi,"Matti N");  matti.nro = 7;  matti.tulos.kierros[1].pituus = 109;  matti.tulos.kierros[0].pisteet = 125;  matti.tulos.lopputulos = 251;  tulosta_tietue( toni );  tulosta_tietue( matti );  return 0;}