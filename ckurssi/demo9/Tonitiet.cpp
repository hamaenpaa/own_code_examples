/* tonitiet.cpp */// Malli sis�kk�isist� olioista /vl-96#include <iostream.h>#include <iomanip.h>#include <string>#define TUOMAREITA 5#define KIERROKSIA 2#define K_PISTE    60.0/****************************************************************************/double paras(const double luvut[],int lkm){  int i; double ehdokas=luvut[0];  for (i=1; i<lkm; i++) if ( luvut[i] > ehdokas ) ehdokas = luvut[i];  return ehdokas;}/****************************************************************************/double huonoin(const double luvut[],int lkm){  int i; double ehdokas=luvut[0];  for (i=1; i<lkm; i++) if ( luvut[i] < ehdokas ) ehdokas = luvut[i];  return ehdokas;}/****************************************************************************/double summa(const double luvut[],int lkm){  int i; double summa=0;  for (i=0; i<lkm; i++) summa += luvut[i];  return summa;}double summa_huonoin_ja_paras_pois(const double luvut[],int lkm){  if ( lkm <= 2 ) return 0;  return summa(luvut,lkm) - huonoin(luvut,lkm) - paras(luvut,lkm);}/****************************************************************************/// Luokka tulostustarkkuuden asettamiseksiclass cStreamPre {  ostream &os;  long oldf;  int  oldp;public:  cStreamPre(ostream &aos=cout,int npre=1) : os(aos) {    oldf = os.setf(ios::showpoint | ios::fixed);    oldp = os.precision(npre);  }  ~cStreamPre() { os.flags(oldf); os.precision(oldp); }};/****************************************************************************/class cKierros {  double pituus;               /* hyppyjen pituudet metrein� */  double tuomarit[TUOMAREITA]; /* tuomaripisteet             */public:  cKierros();  double pisteet() const {    double summa = summa_huonoin_ja_paras_pois(tuomarit,TUOMAREITA);    return summa ? pituus - K_PISTE + summa : 0;  }  void Pituus(double pit) { pituus = pit; }  void Tuomari(int i,double pist) {    if ( 1 <= i && i <= TUOMAREITA && 0 <= pist && pist <= 20.0 )      tuomarit[i-1] = pist;  }  void tulosta(ostream &os=cout) const;};ostream &operator<<(ostream &os,const cKierros &kierros){  kierros.tulosta(os);  return os;                                          }cKierros::cKierros(){ pituus = 0;  for (int i=0; i<TUOMAREITA; i++) tuomarit[i] = 0;             }void cKierros::tulosta(ostream &os) const{  cStreamPre cp(os,1);  os << setw(6) << pituus << " m. Tuomarit: ";  for (int i=0; i<TUOMAREITA; i++)    os << setw(5) << tuomarit[i];  os << " = " << setw(5) << pisteet() << " pistett�" << endl;}/****************************************************************************/class cTulos {  cKierros kierros[KIERROKSIA];public:  void tulosta(ostream &os=cout) const;  void Pituus(int k,double pit) {    if ( 1 <= k && k <= KIERROKSIA ) kierros[k-1].Pituus(pit);  }  void Tuomari(int k,int i,double pist) {    if ( 1 <= k && k <= KIERROKSIA ) kierros[k-1].Tuomari(i,pist);  }  double yhteensa() const;  int vertaa(const cTulos &t2) const;  int operator<(const cTulos &t2)  const { return vertaa(t2) <  0; }  int operator<=(const cTulos &t2) const { return vertaa(t2) <= 0; }  int operator==(const cTulos &t2) const { return vertaa(t2) == 0; }  int operator!=(const cTulos &t2) const { return vertaa(t2) != 0; }  int operator>=(const cTulos &t2) const { return vertaa(t2) >= 0; }  int operator>(const cTulos &t2)  const { return vertaa(t2) >  0; }};int cTulos::vertaa(const cTulos &t2) const {  double y1 = yhteensa(), y2 = t2.yhteensa();  if ( y1 < y2-0.05 ) return -1;  if ( y1 > y2+0.05 ) return  1;  return 0;}ostream &operator<<(ostream &os,const cTulos &tulos){  tulos.tulosta(os);  return os;                                            }double cTulos::yhteensa() const{  double summa=0;  for (int k=0; k<KIERROKSIA;k++) summa += kierros[k].pisteet();  return summa;}void cTulos::tulosta(ostream &os) const{  cStreamPre cp(os,1);  for (int k=0; k<KIERROKSIA; k++)    os << "Kierros " << (k+1) << kierros[k];  os << "Yhteens�: " << setw(5) << yhteensa() << " pistett�." << endl;}/****************************************************************************/class cKilpailija {  string nimi;  int  nro;  cTulos tulos;public:  cKilpailija(const string &animi ="", int anro = 0) {    nimi = animi; nro = anro;  }  void tulosta(ostream &os=cout) const {    os << setw(3) << nro << ": " << nimi  << '\n' << tulos << endl;  }  void Tuomari(int k,int i,double pist) { tulos.Tuomari(k,i,pist); }  void Pituus(int k,double pit)         { tulos.Pituus(k,pit);     }  int vertaa(const cKilpailija &k2) const { return tulos.vertaa(k2.tulos); }  int operator<(const cKilpailija &k2)  const { return vertaa(k2) <  0; }  int operator<=(const cKilpailija &k2) const { return vertaa(k2) <= 0; }  int operator==(const cKilpailija &k2) const { return vertaa(k2) == 0; }  int operator!=(const cKilpailija &k2) const { return vertaa(k2) != 0; }  int operator>=(const cKilpailija &k2) const { return vertaa(k2) >= 0; }  int operator>(const cKilpailija &k2)  const { return vertaa(k2) >  0; }};ostream &operator<<(ostream &os,const cKilpailija &kilpailija){  kilpailija.tulosta(os);  return os;                                       }/****************************************************************************/int main(void){  cKilpailija toni("Toni",3), matti("Matti",7);  cout << toni   << endl;  cout << matti  << endl;  toni.Pituus(1,107);  toni.Pituus(2,100);  toni.Tuomari(2,1,19.0);  toni.Tuomari(2,2,18.0);  toni.Tuomari(2,3,19.5);  toni.Tuomari(2,4,18.0);  toni.Tuomari(2,5,20.0);  matti.Pituus(1,125);  matti.Tuomari(1,1,20.0);  matti.Tuomari(1,2,20.0);  matti.Tuomari(1,3,20.0);  matti.Tuomari(1,4,20.0);  matti.Pituus(2,109);  matti.Tuomari(2,1,20.0);  matti.Tuomari(2,2,20.0);  matti.Tuomari(2,3,20.0);  matti.Tuomari(2,4,20.0);  cout << toni   << endl;  cout << matti  << endl;  if ( matti > toni  ) cout << "Matti voitti!" << endl;  if ( matti == toni ) cout << "Tasapeli!"     << endl;  if ( matti < toni  ) cout << "Toni voitti!"  << endl;  return 0;}