/* jasenet.h */#ifndef __JASENET_H#define __JASENET_H#include <string>using namespace std;#include "jasen.h"//----------------------------------------------------------------------------// Vakiota//----------------------------------------------------------------------------#define MAX_JASENIA    5//----------------------------------------------------------------------------// J�senist�n m��rittely://----------------------------------------------------------------------------class cJasenet {  int    max_lkm;  int    lkm;  int    muutettu;  string tiedoston_nimi;  string koko_nimi;  string bak_nimi;  cJasen apualkio;  cJasen **alkiot;  void  poista_kaikki()     { poista_alkiot(); poista_taulukko();            }  void  poista_alkiot();  void  poista_taulukko();  const char *luo_taulukko(int koko=MAX_JASENIA);  const char *kasvata_kokoa();  void alusta()             { koko_nimi = ""; tiedoston_nimi = "";                              max_lkm = 0;  lkm = 0; muutettu = 0;           }  int rajoihin(int i) const { if ( i<0 || max_lkm <= i ) i = 0; return i;    }public:  cJasenet(int koko=0)      { alusta(); luo_taulukko(koko);                  }  ~cJasenet()               { if ( muutettu ) talleta(); poista_kaikki();    }  const char *lisaa(const cJasen &jasen);  const cJasen &anna(int i) const  {    if ( lkm == 0 ) return apualkio;    return *alkiot[rajoihin(i)];  }  const char *luo(const string &tied,const string &nimi,int max_koko);  const char *lue_tiedostosta(const string &tied);  const char *talleta(const string &tied);  const char *talleta()                { return talleta("");                 }  const string &Koko_nimi()    const   { return koko_nimi;                   }  int Lkm()                    const   { return lkm;                         }  const string &Tiedoston_nimi() const { return tiedoston_nimi;              }  const string &Bak_nimi()       const { return bak_nimi;                    }  int   Muutettu() const               { return muutettu;                    }  int   TeeBak(const string &bak_tark);};#endif