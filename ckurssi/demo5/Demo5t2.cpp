#include <iostream.h>#include <conio.h>class tPaivam {    int paiva;    int kuukausi;    int vuosi;  public :    tPaivam( char ipaiva, char ikuukausi , int ivuosi );    void tulosta();};tPaivam :: tPaivam( char ipaiva, char ikuukausi , int ivuosi ){  paiva = ipaiva;  kuukausi = ikuukausi;  vuosi = ivuosi;}void tPaivam :: tulosta(){  cout << "Paivamaara on " << paiva << "." << kuukausi << "." << vuosi << endl;}int main(){  tPaivam Paiva(1,1,1998);  Paiva.tulosta();  getch();  return 0;}