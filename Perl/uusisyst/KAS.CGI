#!/opt/bin/perl5
# ****************** ALKUTIETOJEN KYSELY ******************************
# ****************** TAVKAS-ALKUTIEDOT ********************************
# Asetetaan ohjelman optiot valmiiksi EI-asentoon vahinkojen v„ltt„miseksi
$sar=0;$sel=0;$sarj=0;$sarkorv=0;$se=0;$selj=0;$selkorv=0;
# Tulostetaan halutut prosessitiedot tiedostoon tavpros.txt
open(PROSTIED,">pros.txt");
# Kysyt„„n ohjelman optiot
print "Luodaan tavallisista kentist{ t{ydennetyt datat sarakesysteemi{\n";
print "varten K/E";
$m=<STDIN>;chop $m;
if ($m eq "K") { $sar=1; } else { $sar=0; }
if ($sar) { # sar
  print "Suoritetaanko sarakedatoissa korvauksia K/E: ";
  $m=<STDIN>;chop $m;
  if ($m eq "K") { $sarkorv=1; } else { $sarkorv=0; }
} # sar
print "Luodaanko tavallisista kentist{ selitykset henkil|tekstidataa\n";
print "varten K/E";
$m=<STDIN>;chop $m;
if ($m eq "K") { $se=1; } else { $se=0; }
if ($se) { # if se
  print "Suoritetaanko selitysdatoissa korvauksia K/E: ";
  $m=<STDIN>;chop $m;
  if ($m eq "K") { $selkorv=1; } else { $selkorv=0; }
} # if se
if ((!$sar) && (!$se)) { print "Ei ole teht{v{{ !\n";exit(0); }
print PROSTIED "Valinnat; sar: ", $sar, " se: ", $se ,"\n";
print PROSTIED "sarkorv: " , $sarkorv;
print PROSTIED "selkorv: ", $selkorv, "\nsarj: ", $sarj;
print PROSTIED " selj: ", $selj , "\n";
# ******************* YHDISTELY-Alkutietojen kysely ***********************
print "Anna rivin maksimipituus: ";
$maxpit=<STDIN>;chop $maxpit;
print "Mik{ on numeroyhdistelyjen kokoomatiedostojen alku:\n";
$tdalku=<STDIN>;chop $tdalku;
print "Anna henkil”yhdistelyjen kokoomatiedoston alku :\n";
$filealku = <STDIN>;chop $filealku;
print PROSTIED "rivien maksimipituus: ", $maxpit ,"\n";
print PROSTIED "numeroyhdistelyjen kokoomatiedoston alku: ", $tdalku , "\n";
print PROSTIED "henkil”yhdistelyjen kokoomatiedoston alku: ", $filealku ,"\n";
# ******************** SARAKEALKUTIEDOT *************************
print "Anna saraketulostiedostojen alku:\n";
$tulosalku = <STDIN>;chop $tulosalku;
# ******************** PARAMETRITIEDOSTOJEN HAKU *********************
# ************ NUMMUU.CGI - PARAMETRITIEDOSTOT ***********************
# Kaikkien lomakkeiden tiedostonimet listaan @tnimet.
@tnimet=();
print "Vaihe1: Tiedostonimien haku, tiedostoista lomakei.ta.\n";
# 1. Haetaan lomaketta i vastaavat tiedostonimet listaan @tnimeti,i=1..6.
for( $i=1; $i<=4 , $i++ ) { 
$file = "kissa" . $i . ".ta";
  print PROSTIED $file , "\n";
  print $file , "\n";
  open(TIEDOSTO,$file);$tloppu=0;  
  while($tloppu==0) {
    $syotto=<TIEDOSTO>;chop $syotto;
    if ($syotto eq "") { $tloppu=1; } else {
      $syotto=<TIEDOSTO>;chop $syotto; 
      push( @tnimet , $syotto );
    }
  }
  $syotto = "tav" . $i . "k";push(@tnimet,$syotto);
  close(TIEDOSTO);
}
# ******************** YHDKAS-PARAMETRITIEDOSTOT ********************
# Haetaan tiedostonimi„ vastaavat kysymykset tiedostosta lomkys.txt
# listaan @kysyml.
@kysyml=();
print "lomkys.txt\n";
print PROSTIED "lomkys.txt\n";
open(TIEDOSTO,"lomkys.txt");
$tloppu=0;  
while($tloppu==0) {
  $syotto=<TIEDOSTO>;chop $syotto;
  if ($syotto eq "") { $tloppu=1; } else {
    $jloppu=0;$rivi="";
    while($jloppu==0) {
      $syotto=<TIEDOSTO>;chop $syotto;
      if ($syotto eq "") { $jloppu=1; } else 
        { $rivi = $rivi . $syotto . "\n"; } 
    }
    chop $rivi;push( @kysyml , $rivi );
  }
}
close(TIEDOSTO);
# *********************  TAVKAS9.CGI ********************************
# K„yd„„n l„pi kukin kysymyslomake
for( $tiednro=1; $tiednro<=4 , $tiednro++ ) { 
# 1. K{yd{{n l{pi kunkin lomakkeen kaikki tavallisten kenttien vastaukset
# Haetaan t{t{ varten kullekin lomakkeelle vastaava vastauksien m{{r{
# tiedostosta tiedm[tiednro].txt
  print "Tiednro: ", $tiednro , "\n";
  $file = "tiedm" . $tiednro . ".txt";
  print PROSTIED $file , "\n";
  print $file , "\n";
  open( TIEDM , $file );$kmaara = <TIEDM>;chop $kmaara;close( TIEDM );
  print "Lomakkeen ", $tiednro;
  print " tiedostojen m{{r{: ", $kmaara ,"\n";
# 2. Haetaan edelleen t{t{ lomaketta vastaavat checkbox-kenttien
# t{ydet mahdollisuudet listoihin @chnimet ja @charvot 
# tiedostosta lomake[tiednro].chv.
$file="kissa".$tiednro.".chv";
  print PROSTIED , $file , "\n";
  print $file , "\n";
  @chnimet=();@charvot=();
  open( TIEDOSTO , $file );
  $tiedloppu=0;$pmaara=0;
  while($tiedloppu==0)
    { # while tiedloppu
      $syotto=<TIEDOSTO>;chop $syotto;
      if ($syotto eq "") { $tiedloppu=1; } else
        { # if syotto
          push(@chnimet,$syotto);
          $syotto=<TIEDOSTO>;chop $syotto;
          push(@charvot,$syotto);
          $pmaara++;
        } # if syotto
    } # while tiedloppu
  close( TIEDOSTO );
# print PROSTIED "Checkbox-kent{t:\n";
# print PROSTIED "Nimet: ", join ' ',@chknimet , "\n";
# print PROSTIED "Kent{t: ", join ' ',@charvot , "\n";
# 3. Haetaan muiden tavallisten kenttien nimien lista
# listaan @muutavkn tiedostosta lomake[tiednro].mtd
$file="kissa".$tiednro.".mtd";
  print PROSTIED $file , "\n";
  print $file , "\n";
  @muutavkn=();
  open(TIEDOSTO,$file);
  $tloppu=0;
  while( $tloppu==0 )
    { # while tloppu
      $syotto=<TIEDOSTO>;chop $syotto;
      if ($syotto eq "") { $tloppu=1; } else
        { push(@muutavkn,$syotto); } 
    } # while tloppu
  close(TIEDOSTO);
# print PROSTIED "Muut tavalliset kent{t:\n";
# print PROSTIED "Nimet: ", join ' ',@muutavkn , "\n";
# 4. Haetaan sarakej„rjestys tiedostosta lomake[tiednro].sj
# listoihin @knimijarj ja @ktietojarj.
  if ($sar) {
    @knimijarj=();@ktietojarj=();
$file = "kissa" . $tiednro . ".sj";
    open(SARJAR,$file);
    $tiedloppu=0;
    while($tiedloppu==0)
      { # while tiedloppu
        $syotto=<SARJAR>;chop $syotto;
        if ($syotto eq "") { $tiedloppu=1; } else
          { # if syotto
            push(@knimijarj,$syotto);
            $syotto=<SARJAR>;chop $syotto;
            push(@ktietojarj,$syotto);
          } # if syotto
      } # while tiedloppu
    close(SARJAR);
  }
# 5. Haetaan selitekenttien nimij„rjestys tiedostosta
# lomake[tiednro].sej.
  if ($se) {
    @kseljarjn=();
$file = "kissa" . $tiednro . ".sej";
    open(SELJAR,$file);
    $tiedloppu=0;
    while($tiedloppu==0)
      { # while tiedloppu
        $syotto=<SELJAR>;chop $syotto;
        if ($syotto eq "") { $tiedloppu=1; } else
          { push(@kseljarjn,$syotto); } 
      } # while tiedloppu
    close(SELJAR);
  }
# 6. Haetaan korvattavat kentt{nimi,kentt{tietoparit, @knimikorv,
# @ktietokorv sek{ kentt{tietoja korvaavat merkkijonot
# @ktietoudata sarakekorvauksia varten tiedostosta lomake[tiednro].ksa,
# mik„li on valittu sarakekorvaukset (sarkorv).
# N{iden tarkoitus on se, ett{ jos listasta @knimi kentt{nimi osuu
# samaksi kuin listasta @knimikorv ja samalta kohtaa listasta @ktietokorv
# oleva merkkijono l|ytyy samalta kohtaa listasta @ktieto olevasta
# merkkijonosta kuin @knimi oleva kentt{nimi oli, niin @ktieto korvataan
# vastaavalta kohtaa kuin @knimikorv l|ytynyt vertailukentt{nimi oli
# listasta @ktietoudata l|ytyv{ll{ merkkijonolla.
  if ($sarkorv) { # if sarkorv
$file="kissa".$tiednro.".ksa";
    print PROSTIED $file , "\n";
    print $file , "\n";
    @knimikorv=();@ktietokorv=();@ktietoudata=();
    open(TIEDOSTO,$file);
    $tloppu=0;
    while( $tloppu==0 )
      { # while tloppu
        $syotto=<TIEDOSTO>;chop $syotto;
        if ($syotto eq "") { $tloppu=1; } else
          { # if syotto
            push(@knimikorv,$syotto);
            $syotto=<TIEDOSTO>;chop $syotto;
            push(@ktietokorv,$syotto);
            $syotto=<TIEDOSTO>;chop $syotto;
            push(@ktietoudata,$syotto);
          } # if syotto
      } # while tloppu
    close(TIEDOSTO);
#   print PROSTIED "Sarakekorvaukset:\n";
#   print PROSTIED "knimikorv: ", join ' ', @knimikorv , "\n";
#   print PROSTIED "ktietokorv: ", join ' ', @ktietokorv , "\n";
#   print PROSTIED "ktietoudata: ", join ' ', @ktietoudata , "\n";
  } # if sarkorv
# 7. Haetaan vastaavat selitekorvaukset tiedostosta lomake[tiednro].kse,
# mik„li ne on valittu (selkorv).
  if ($selkorv) { # if selkorv
$file="kissa".$tiednro.".kos";
    print PROSTIED $file , "\n";
    print $file , "\n";
    @knimikorvs=();@ktietokorvs=();@ktietoudatas=();
    open(TIEDOSTO,$file);
    $tloppu=0;
    while( $tloppu==0 )
    { # while tloppu
      $syotto=<TIEDOSTO>;chop $syotto;
      if ($syotto eq "") { $tloppu=1; } else
        { # if syotto
          push(@knimikorvs,$syotto);
          $syotto=<TIEDOSTO>;chop $syotto;
          push(@ktietokorvs,$syotto);
          $syotto=<TIEDOSTO>;chop $syotto;
          push(@ktietoudatas,$syotto);
        } # if syotto
    } # while tloppu
    close(TIEDOSTO);
#   print PROSTIED "Selitekorvaukset:\n";
#   print PROSTIED "knimikorvs: ", join ' ', @knimikorvs , "\n";
#   print PROSTIED "ktietokorvs: ", join ' ', @ktietokorvs , "\n";
#   print PROSTIED "ktietoudatas: ", join ' ', @ktietoudatas , "\n";
  } # if selkorv
# 8. Haetaan kent{n nimi{ vastaavat selitykset listoihin
# @knimisel, @ksel tiedostosta lomake[tiednro].kse, mik„li valittu
# selitykset (se). T„ll”in selitenimien korvaus suoritetaan automaattisesti.
  if ($se) { # if se
$file="kissa".$tiednro.".kse";
    print PROSTIED $file , "\n";
    print $file , "\n";
    @knimisel=();@ksel=();
    open(TIEDOSTO,$file);
    $tloppu=0;$lind=0;
    while($tloppu==0) { # while tloppu
      $syotto=<TIEDOSTO>;chop $syotto;
      if ($syotto eq "") { $tloppu=1; } else
        { # if syotto
          push(@knimisel,$syotto);$jloppu=0;
          push(@ksel,"");
          while($jloppu==0)
            { # while jloppu
              $syotto=<TIEDOSTO>;chop $syotto;
              if ($syotto eq "") { $jloppu=1; } else
              { # if syotto
                $syotto = $syotto . "\n";
                $ksel[$lind] = $ksel[$lind] . $syotto;
              } # if syotto
            } # while jloppu
          chop $ksel[$lind];$lind++;
        } # if syotto
    } # while tloppu
    close(TIEDOSTO);
#   print PROSTIED "Selitekenttien nimet: ", join ' ', @knimisel , "\n";
#   print PROSTIED "Selitteet: ", join '\n' , @ksel , "\n";
  } # if se
# 9. K{yd{{n l{pi kunkin k{ytt{j{n vastaukset
  for($kayttaja=1;$kayttaja<=$kmaara+1;$kayttaja++) { # for kayttaja
# 9.1. Haetaan kunkin k{ytt{j{n kaikki tavallisten kenttien vastaukset
# listoihin @knimi ja @ktieto.
    print "Tiedosto :", $kayttaja , "\n";
    print PROSTIED "Tiedosto: ", $kayttaja , "\n";
    $lahto="tav" . $tiednro . "k" . $kayttaja . ".dtx";
    print PROSTIED $lahto , "\n";
    print $lahto , "\n";
    if (-e $lahto) { # if e lahto
                     # Toimenpiteet suoritetaan tietenkin vain, jos
                     # tiedosto on olemassa.
      print "On\n";
      print PROSTIED "On\n";
      open(LAHTO,$lahto);
      $tiedloppu=0;@knimi=();@ktieto=();
      while($tiedloppu==0) { # while tiedloppu
        $syotto=<LAHTO>;chop $syotto;
        if ($syotto eq "") { $tiedloppu=1; } else
        { # if syotto
          push( @knimi , $syotto );
          $syotto=<LAHTO>;chop $syotto;          
          push( @ktieto , $syotto );
        } # if syotto
      } # while tiedloppu
      close(LAHTO);
#     print PROSTIED "Haetut datat:\n";
#     print PROSTIED "knimi: ", join ' ', @knimi , "\n";
#     print PROSTIED "ktieto: ", join ' ', @ktieto , "\n";
# 9.2. Tutkitaan l|ytyyk| listoista @knimi ja @ktieto muitakin
# kuin listoihin @muutavkn tai @chknimet ja @charvot sis{ltyvi{
# tietopareja. Otetaan t{llaiset listan v{list{ ja talletetaan
# listoihin @knimiv ja @ktietov.
      $indeksi=0;@knimiv=();@ktietov=();@knimix=();@ktietox=();
      foreach $kn (@knimi) { # foreach kn
        $loytyi=0;$chind=0;
        while( ( $loytyi==0 ) && ($chind<=$#chknimet) )
          { # while loytyi
            if ( ($kn eq $chknimet[$chind]) &&
                 ($ktieto[$indeksi] eq $charvot[$chind]) ) { $loytyi=1; }
            $chind++;
          } # while loytyi
        if (!($loytyi)) { # if loytyi
          $muuki=0;
          while( ( $loytyi==0 ) && ( $muuki <= $#muutavkn ) )
            { # while loytyi
              if ( $kn eq $muutavkn[$muuki] ) { $loytyi=1; }
              $muuki++;
            } # while loytyi
        } # if loytyi
        if (!($loytyi)) { push(@knimiv,$kn);
                          push(@ktietov,$ktieto[$indeksi]); }
        else { push( @knimix , $kn );
               push( @ktietox , $ktieto[$indeksi] ); }
        $indeksi++;
      } # foreach kn
      @knimi = @knimix;@ktieto = @ktietox;@knimix=();@ktietox=();
#   print PROSTIED "Tiedot ylim{{r{isten kenttien poiston j{lkeen:\n";
#   print PROSTIED "Nimet: ", join ' ',@knimi , "\n";
#   print PROSTIED "Tiedot: ", join ' ',@ktieto , "\n";
#   print PROSTIED "Ylim{{r{iset kent{t:\n";
#   print PROSTIED "Nimet: ", join ' ',@knimiv , "\n";
#   print PROSTIED "Tiedot: ", join ' ',@ktietov , "\n";
# 9.3. Talletetaan n{m{ virheelliset kent{t tiedostoon 
# tav[tiednro]k[kayttaja].vir., jos niit{ on.
      if ($#knimiv>=0) { # if knimiv
        $file = ">tav" . $tiednro . "k" . $kayttaja . ".vir";
        print PROSTIED $file , "\n";
        print $file , "\n";
        open(TIEDOSTO,$file);$indeksi=0;
        foreach $kn (@knimiv) { # foreach kn
          print TIEDOSTO $kn , " " , $ktietov[$indeksi] , "\n";
          $indeksi++;
        } # foreach kn
        close(TIEDOSTO);
      } # if knimiv
# 9.4. Oletetaan, ett„ lomakkeelta tullut data on listoissa @knimi ja @ktieto.
# Oletetaan, ett„ haluttu sarakej„rjestys on listoissa
# @knimijarj ja @ktietojarj siten, ett„ jos listassa @ktietojarj
# on tyhj„, niin kyseess„ on muu kuin checkbox-kentt„ ja
# muutoin siin„ on checkbox-nimi,arvo -paria vastaava
# arvo. Tehd„„n ohjelmap„tk„, joka poimii saadusta datasta
# kent„t t„h„n j„rjestykseen ja lis„„ puuttuvat osat
# tyhjin„ tieto-osiltaan listojen mukaiselle paikalle.
      if ($sar) {
        @knimix=();@ktietox=();
        $indeksi=0;
        foreach $kn (@knimijarj) {
          if ($ktietojarj[$indeksi] eq "") {
            $loytyi=0;$ind2=0;
            while( (!$loytyi) && ($ind2<=$#knimi) ) { 
              if ($knimi[$ind2] eq $kn) { $loytyi=1; } else { $ind2++; }
            }
          } else {
            $loytyi=0;$ind2=0;
            while( (!$loytyi) && ($ind2<=$#knimi) ) { 
              if ( ($knimi[$ind2] eq $kn) && 
                   ($ktieto[$ind2] eq $ktietojarj[$indeksi]) ) 
                { $loytyi=1; } else { $ind2++; }
            }
          }
          push(@knimix,$kn);
          if ($loytyi) {
            if ($ktietojarj[$indeksi] eq "") {
              push(@ktietox,$ktieto[$ind2]);  
            } else { push(@ktieto,"1"); }
          } else {
            if ($ktietojarj[$indeksi] eq "") {
              push(@ktietox,"");  
            } else { push(@ktieto,"0"); }
          }
          $indeksi++;
        }
      }
# 9.5. Jos on valittu selitekenttien muodostus, oletetaan edelleen, 
# ett„ lomakkeelta tullut data on listoissa @knimi ja @ktieto.
# Oletetaan, ett„ checkbox-kenttien mukaantuleva
# nimiarvoparien listat on listoissa
# @chnimet,@charvot siten, ett„ samalla nimell„
# varustetut nimiarvoparit ovat per„kk„in siin„ j„rjestyksess„
# kuin ne on lomakkeella.
# Oletetaan, ett„ selitej„rjestyksen kenttien nimij„rjestys 
# on annettuna listassa @kseljarjn.
# Tehd„„n ohjelmap„tk„, joka luo selitej„rjestyksen
# listoihin @knimiy ja @ktietoy siten, ett„ 
# checkbox-kentist„ tulee yhdelle kohtaa aina kaikki listojen
# @chnimet,@charvot sis„lt„m„t nimiarvoparit,
# joilla on sama nimi, ja sellaisen parin kohdalle tulee 1,
# joka on listoissa @knimi ja @ktieto, muiden kohdalle 0.
      if ($se) {
        $indeksi=0;
        foreach $kn (@kseljarjn) {
          $loytyi=0;$knind=0;
          while( (!$loytyi) && ($knind<=$#chnimet) ) {
            if ($chnimet[$knind] eq $kn) { $loytyi=1; } else { $knind++; }
          }
          push(@knimiy,$kn);push(@ktietoy,"");$knind2=0;
          if ($loytyi) { # Ker„t„„n checkbox-kent„nnime„ vastaavat arvot
            while( $knind2<=$#knimi ) {
              if ( $knimi[$knind2] eq $chnimet[$knind] ) {
                $loytyi3=0; 
# Kelataan checkbox-nimi,arvo -laskuri
# knind l”ytyneeseen nimiarvopariin saakka siten, ett„
# v„liss„ olevien nimiarvoparien kohdalle tulee 0.
                while( ($loytyi3==0) && ($knind<=$#chnimet) ) {
                  if ( ($knimi[$knind2] eq $chnimet[$knind]) &&
                       ($ktieto[$knind2] eq $charvot[$knind]) )
                  { $ktietoy[$indeksi] = $ktietoy[$indeksi] . "1 ";
                    $loytyi3=1; }
                  else { $ktietoy[$indeksi] = $ktietoy[$indeksi] . "0 "; }
                  $knind++;
                }
              }
              $knind2++;
            }
          } else {
            while( ($knind2<=$#knimi) && ($loytyi==0) ) {
              if ($kn eq $knimi[$knind2]) { $loytyi=1; } else { $knind2++; }
            }
            if ($loytyi) { $ktietoy[$indeksi] = $ktieto[$knind2]; }
          }
          $indeksi++;
        }
# 9.6. Jos on valittu selitekenttien muodostus, joihin tulee siis
# vain sellaiset kent„t, joissa on jotakin tietoa, niin
# poistetaan niist{ sellaiset, joissa on tyhj{ tieto-osa
        $kind=0;$loppu=0;
        while( $loppu == 0 ) { # while loppu
          $tyhja=1;$mi=0;
          while( ( $mi <= length($ktietoy[$kind])-1 ) && ($tyhja) )
            { # while mi
              if (!(substr($ktietoy[$kind],$mi,1) eq " ")) { $tyhja=0; }
              $mi++;
            } # while mi
#         $_ = $ktietoy[$kind];
#         if ( /(\W)*/ ) { $tyhja=1; } else { $tyhja=0; }
          if ($tyhja) { # if tyhja
            splice( @knimiy , $kind , 1 );
            splice( @ktietoy , $kind , 1 );
          } else { $kind++; } # if tyhja
          if ($kind > $#knimiy) { $loppu=1; }
        } # while loppu
#       print PROSTIED "Selitedatat poiston j{lkeen:\n";
#       print PROSTIED "knimix : ", join ' ', @knimix , "\n";
#       print PROSTIED "ktietox : ", join ' ', @ktietox , "\n";
# 9.7. Jos on selitekenttien muodostus, hoidetaan korvaus sellaisten 
# nimi,arvo-parien kohdalla, jotka on listoissa 
# @knimikorvs,@ktietokorvs,@ktietoudatas.
        if ($selkorv && ($#knimiy>=0) ) {
#         print PROSTIED "Selitekorvaus:\n";
          $indeksi=0;$lisloppu=0; 
          while( !($lisloppu) ) { # while lisloppu
            $korvind=0;$loytyi=0;
#           print PROSTIED "indeksi: ", $indeksi , "\n";
#           print PROSTIED "knimiy: ", $knimiy[$indeksi] ,"\n";
#           print PROSTIED "ktietoy: ", $ktietoy[$indeksi] , "\n";
            while( ( $korvind <= $#knimikorvs ) && (!$loytyi) ) {
#             print PROSTIED "knimikorvs: ", $knimikorvs[$korvind] , "\n";
#             print PROSTIED "ktietokorvs: ", $ktietokorvs[$korvind] , "\n";
              if ( ($knimiy[$indeksi] eq $knimikorv[$korvind]) && 
                 ( index( $ktietoy[$indeksi] , 
                          $ktietokorvs[$korvind] ) >= 0 ) )
              { $ktietoy[$indeksi] = $ktietoudatas[$korvind];$loytyi=1; }
#             print PROSTIED "loytyi: ", $loytyi , "indeksi: ", $indeksi ,"\n";
              $korvind++;
            } 
            $indeksi++;if ($indeksi==$#khlonimi+1) { $lisloppu=1; }
          } # while lisloppu
#         print PROSTIED "Selitedatat tietojen korvauksen j{lkeen:\n";
#         print PROSTIED "Nimet: ", join ' ',@khlonimi , "\n";
#         print PROSTIED "Tiedot: ", join ' ',@khlotieto , "\n";
        } # if selkorv
# 9.8. Korvataan listan @knimiy kent{n nimet niit{ vastaavilla selityksill{
# listoista @knimisel,@ksel.
        $lind=0;
        foreach $kn (@knimiy) { # foreach kn
          $selind=0;
          foreach $knsel (@knimisel) { # foreach knsel
            if ($knsel eq $kn) { $knimiy[$lind] = $ksel[$selind]; }
            $selind++;
          } # foreach knsel
          $lind++;
        } # foreach kn
#       print PROSTIED "Selitedatan kentt{nimet korvattuna (lopussa):\n";
#       print PROSTIED "Nimet: ", join '\n',@knimiy , "\n";
#       print PROSTIED "Tiedot: ", join ' ',@ktietoy , "\n";
# 9.9.  Tulostetaan se tiedostoon tav[tiednro]k[kayttaja].dth
        $file=">tav" . $tiednro . "k" . $kayttaja . ".dth";
        print PROSTIED $file , "\n";
        print $file , "\n";
        open(TIEDOSTO,$file);
        $kind=0;
        foreach $kn (@knimiy) { # foreach kn
          print TIEDOSTO $kn , "\n";
          print TIEDOSTO $ktietoy[$kind] , "\n";
          $kind++;
        } # foreach kn
        close(TIEDOSTO);
      } # if se
# 9.10. Hoidetaan korvaus sellaisten nimi,arvo-parien kohdalla,
# jotka on listoissa @knimikorv,@ktietokorv,@ktietoudata.
      if ($sarkorv) { # if sarkorv
#       print PROSTIED "Sarkainkorvaus:\n";
        $indeksi=0;$lisloppu=0;
        while( !($lisloppu) ) { # while lisloppu
          $korvind=0;$loytyi=0;
#         print PROSTIED "indeksi: ", $indeksi , "\n";
#         print PROSTIED "knimi: ", $knimi[$indeksi] ,"\n";
#         print PROSTIED "ktieto: ", $ktieto[$indeksi] , "\n";
          while( ( $korvind <= $#knimikorv ) && (!$loytyi) ) {
#           print PROSTIED "knimikorv: ", $knimikorv[$korvind] , "\n";
#           print PROSTIED "ktietokorv: ", $ktietokorv[$korvind] , "\n";
            if ( ($knimi[$indeksi] eq $knimikorv[$korvind]) && 
                 ( index( $ktieto[$indeksi] , $ktietokorv[$korvind] ) >= 0 ) )
            { $ktieto[$indeksi] = $ktietoudata[$korvind];$loytyi=1; }
#           print PROSTIED "loytyi: ", $loytyi , "indeksi: ", $indeksi ,"\n";
            $korvind++;
          } 
          $indeksi++;if ($indeksi==$#knimi+1) { $lisloppu=1; }
        }
#       print PROSTIED "Sarakedatat tietojen korvauksen j{lkeen:\n";
#       print PROSTIED "Nimet: ", join ' ',@knimi , "\n";
#       print PROSTIED "Tiedot: ", join ' ',@ktieto , "\n";
      } # if sarkorv
# 9.11. Talletetaan listat @knimi ja @ktieto muutettuina tiedostoon
# tav [lomakenro ] k [kayttaja] . dtt
    if ($sar) {
      $file = ">tav" . $tiednro . "k" . $kayttaja . ".dtt";
      print PROSTIED $file , "\n";
      print $file , "\n";
      open(TULOS,$file);
      $indeksi=0;
      foreach $kentnimi (@knimi) { # foreach kentnimi
        print TULOS $kentnimi ,"\n";
        print TULOS $ktieto[$indeksi] ,"\n";
        $indeksi++;
      } # foreach kentnimi
      close(TULOS);
    } # if sar
  } # for kayttaja
} # for tiednro
}
# ************************ YHDKAS-PARAMETRITIEDOSTOT ***********************
print "YHDISTELYT\n";
print PROSTIED "YHDISTELYT\n";
$maara = $#knimikertluet+1;
# ******************** PTYHJAT.CGI ***********************************
# Poistetaan sellaiset tekstialuetiedostot, joissa ei ole muuta kuin
# v„lily”nti„.
foreach $tdnimi (@tnimet) { # foreach tdnimi
   for($i=1;$i<=$maara;$i++) { # for i
      $tdinimi = $tdnimi . $i . ".txt";
      if (-e $tdinimi) { # if e tdinimi
        print $tdinimi , " On.\n";print PROSTIED $tdinimi , " On.\n"; 
        open(TIEDOSTO,$tdinimi);@rivit=<TIEDOSTO>;close(TIEDOSTO);
        $tyhja=1;
        foreach $rivi (@rivit) { # foreach rivi
          $rind=0;$rtyhja=1;
          while( ( $rind < length($rivi)-1 ) && ($rtyhja) ) { # while
            if (!(substr($rivi,$rind,1) eq " ")) { $rtyhja=0; }
            $rind++;
          } # while
          if (!($rtyhja)) { $tyhja=0; }
        } # foreach rivi
        if ($tyhja) { # if tyhja
          print "poistui !\n";print PROSTIED "poistui !\n";
          @komlist=("rm",$tdinimi);
          system @komlist;
        } # if tyhja
      } # if e tdinimi
   } # for i 
} # for tdnimi 
# *************************** YHDKYS.CGI ****************************
# Luodaan kutakin kysymyst„ vastaava yhdistelytiedosto tdnimi.yhd
foreach $tdnimi (@tnimet) {
   $file = $tdnimi.".yhd";
   @komlist=("rm",$file);
   system @komlist;
   for($i=1;$i<=$maara;$i++) {
      $tdinimi = $tdnimi . $i . ".txt";
      if (-e $tdinimi) {
        @rivit=();
        push(@rivit,$knimikertluet[$i-1]);
        push(@rivit," ");
        print $tdinimi , " On.\n";
        open(TIEDOSTO,$tdinimi);
          @lisrivit=<TIEDOSTO>;
        close(TIEDOSTO);
        $indeksi=0;
        foreach $rivi (@lisrivit) {
          chop $rivi;$lisrivit[$indeksi]=$rivi;$indeksi++;
        }
        # Lyhennet{{n rivit listaan @lislyhrivit.
        @lislyhrivit=();
        foreach $rivi (@lisrivit) {
          while( length($rivi) > $maxpit ) {
            $rind=$maxpit-1;
            while( !(substr($rivi,$rind,1) eq " ") ) { $rind--; }  
            push( @lislyhrivit, substr($rivi,0,$rind) );
            $rivi = substr( $rivi, $rind+1 );
          }
          push( @lislyhrivit , $rivi );
        }
        push(@rivit,@lislyhrivit);
        push(@rivit," ");
        $tdtulnimi = ">>" . $tdnimi . ".yhd";
        open(TIEDOSTO,$tdtulnimi);
          foreach $rivi (@rivit) { print TIEDOSTO $rivi ,"\n"; }
        close(TIEDOSTO);
      }
    }
}
# **************************** YHDYHD.CGI *******************
# Luodaan tiedosto yhd.yhd, johon tulee kysymyksitt„in yhdistettyn„
# tiedostojen sis„ll”t
$file = "yhd.yhd";
system ("rm",$file);
$kohde = ">>yhd.yhd";
$tdlajind=0;
foreach $tdnimi (@tnimet) {
  $lahto = $tdnimi . ".yhd";
  if (-e $lahto) { print $lahto , "\n";print PROSTIED $lahto , "\n"; 
  @rivit=();push(@rivit,$kysyml[$tdlajind]);
  push(@rivit," ");
  open(TIEDOSTO,$lahto);
    @lisrivit = <TIEDOSTO>;$rivinro=0;
    foreach $rivi (@lisrivit) {
      chop $rivi;$lisrivit[$rivinro] = $rivi;$rivinro++;
    }
  close(TIEDOSTO);
  push(@rivit,@lisrivit);push(@rivit," ");
  print $kohde ,"\n";print PROSTIED $kohde , "\n";
  open(TIEDOSTO,$kohde);
  foreach $rivi (@rivit) {
    print TIEDOSTO $rivi , "\n";
  }
  close(TIEDOSTO);
  }
  $tdlajind++;
}
# ********************* YHDNRO.CGI ***********************
# Luodaan tiedostot tdalku [tiedostonro].dat, joissa on
# numeroa vastaavat tiedot koottuna
for($i=1;$i<=$maara;$i++) {
  $file=$tdalku . $i . ".yhd";
  @komlist=("rm",$file);system @komlist;
  $tdtulnimi = ">>" . $tdalku . $i . ".yhd";
  $tdlajind=0;
  foreach $tdnimi (@tnimet) {
    if (substr($tdnimi,0,3) eq "tav") { $tdinimi = $tdnimi . $i . ".dth" }
      else { $tdinimi = $tdnimi . $i . ".txt"; }
    if (-e $tdinimi) {
      print $tdinimi , "\n";print PROSTIED $tdinimi , "\n";
      @rivit=();
      if (!(substr($tdnimi,0,3) eq "tav")) 
         { push( @rivit , $kysyml[$tdlajind] ); }
      push( @rivit , " " );
      open(TIEDOSTO,$tdinimi);
      @lisrivit=<TIEDOSTO>;
      close(TIEDOSTO);
      $indeksi=0;
      foreach $rivi (@lisrivit) {
         chop $rivi;$lisrivit[$indeksi]=$rivi;
         $indeksi++;
      }
        # Lyhennet{{n rivit listaan @lislyhrivit.
        @lislyhrivit=();
        foreach $rivi (@lisrivit) {
          while( length($rivi) > $maxpit ) {
            $rind=$maxpit-1;
            while( !(substr($rivi,$rind,1) eq " ") ) { $rind--; }  
            push( @lislyhrivit, substr($rivi,0,$rind) );
            $rivi = substr( $rivi, $rind+1 );
          }
          push( @lislyhrivit , $rivi );
        }
        push(@rivit,@lislyhrivit);
      push( @rivit , " " );
      print $tdtulnimi , "\n";print PROSTIED $tdtulnimi , "\n";
      open(TIEDOSTO,$tdtulnimi);
        foreach $rivi (@rivit) { print TIEDOSTO $rivi ,"\n"; }
      close(TIEDOSTO);
    }
    if (!(substr($tdnimi,0,3) eq "tav")) { $tdlajind++; }
  }
}
# ********************** YHDNROYHD.CGI *****************************
# Luodaan tiedosto tdalku.yhd, jossa on numeroita vastaavat tiedot koottuna
$file= $tdalku.".yhd";
system ("rm",$file);
for($i=1;$i<=$maara;$i++) {
      $tdinimi = $tdalku . $i . ".yhd";
      @rivit=();push(@rivit,$knimikertluet[$i-1]);
      push(@rivit," ");
      if (-e $tdinimi) {
        print $tdinimi , "\n";
        print PROSTIED $tdinimi , "\n";
        open(TIEDOSTO,$tdinimi);
        @lisrivit= <TIEDOSTO>;
        close(TIEDOSTO);
        $indeksi=0;
        foreach $rivi (@lisrivit) {
          chop $rivi;$lisrivit[$indeksi]=$rivi;$indeksi++;
        }
        push(@rivit,@lisrivit);
      }
      push(@rivit," ");
      $tdtulnimi = ">>" . $tdalku . ".yhd";
      print $tdtulnimi , "\n";
      print PROSTIED $tdtulnimi , "\n";
      open(TIEDOSTO,$tdtulnimi);
        foreach $rivi (@rivit) { print TIEDOSTO $rivi ,"\n"; }
      close(TIEDOSTO);
 }
# *************************  YHDHLO.CGI ************************* 
# Luodaan henkil|kohtaiset yhdistelyt vastaten hlolista.txt:n j{rjestyst{
# siten, ett{ tiedostolle tulee k{ytt{j{tunnuksen paikkaa tiedostossa
# hlolista.txt vastaava rivin numero numeroksi tiedostonimeen.
$indeksi=0;
foreach $kt (@knimiluet) {
  $tdind = $indeksi+1;
  $file = $filealku . $tdind . ".yhd";
  @komlist = ("rm",$file);system @komlist;
  $alkuind=0;for($i=0;$i<=$indeksi-1;$i++)
    { $alkuind=$alkuind+$esiintmaar[$i]; }
  $alkuind++;
  $tdlajind=0;
  foreach $tdnimi (@tnimet) {
    for($i=0;$i<=$esiintmaar[$indeksi]-1;$i++) {
      $tdind = $alkuind + $i;
      if (substr($tdnimi,0,3) eq "tav") 
        { $file = $tdnimi . $tdind . ".dth"; } 
      else { $file = $tdnimi . $tdind . ".txt"; }
      print $file , "\n";@lisrivit=();
      @rivit=();
      if (!(substr($file,0,3) eq "tav")) 
        { push(@rivit,$kysyml[$tdlajind] ); }
      push(@rivit," ");
      if (-e $file) { 
        print $file , "\n";
        print PROSTIED $file , "\n";
        open(TIEDOSTO,$file);
        @lisrivit=<TIEDOSTO>;
        close(TIEDOSTO);
        $igh=0;foreach $rivi (@lisrivit) {
           chop $rivi;$lisrivit[$igh]=$rivi;$igh++; }
      }
        # Lyhennet{{n rivit listaan @lislyhrivit.
        @lislyhrivit=();
        foreach $rivi (@lisrivit) {
          while( length($rivi) > $maxpit ) {
            $rind=$maxpit-1;
            while( !(substr($rivi,$rind,1) eq " ") ) { $rind--; }  
            push( @lislyhrivit, substr($rivi,0,$rind) );
            $rivi = substr( $rivi, $rind+1 );
          }
          push( @lislyhrivit , $rivi );
        }
      push( @rivit , @lislyhrivit );push(@rivit," ");
      $tdind= $indeksi+1;
      $file = ">>" . $filealku . $tdind . ".yhd";
      open(TIEDOSTO,$file);
      foreach $rivi (@rivit) {
        print TIEDOSTO $rivi , "\n";
      }
      close(TIEDOSTO);
    }
    if (!(substr($file,0,3) eq "tav")) { $tdlajind++; }
  }
  $indeksi++;
}
# *********************** YHDHLOYHD.CGI ************************
# Luodaan tiedosto filealku.yhd, johon tulee henkil”kohtaiset tiedot koottuna
$file=$filealku . ".yhd";
system ("rm",$file);
for($i=1;$i<=$maara;$i++) {
      $tdinimi = $filealku . $i . ".yhd";
      @rivit=();push(@rivit,$knimiluet[$i-1]);
      push(@rivit," ");
      if (-e $tdinimi) {
        print $tdinimi , "\n";
        print PROSTIED $tdinimi , "\n";
        open(TIEDOSTO,$tdinimi);
        @lisrivit= <TIEDOSTO>;
        close(TIEDOSTO);
        $indeksi=0;
        foreach $rivi (@lisrivit) {
          chop $rivi;$lisrivit[$indeksi]=$rivi;$indeksi++;
        }
        push(@rivit,@lisrivit);
      }
      push(@rivit," ");
      $tdtulnimi = ">>" . $filealku . ".yhd";
      print $tdtulnimi , "\n";
      print PROSTIED $tdtulnimi , "\n";
      open(TIEDOSTO,$tdtulnimi);
        foreach $rivi (@rivit) { print TIEDOSTO $rivi ,"\n"; }
      close(TIEDOSTO);
}
# ************************  SAR2.CGI ***************************
# Luodaan sarakematriisit eri lomakkeille
# 2. Tehd„„n kaikki toimenpiteet erikseen kullekin lomakkeelle.
for( $lomakenro=1; $lomakenro<=4 , $lomakenro++ ) { 
# for lomakenro
# 2.1. Haetaan kent{t tiedostoista tav[lomakenro]k[tiedostonro].dtt
# listaan @kentat sill{ tavoin, ett{ kunkin tiedostonumeron
# eri lomakkeiden kent{t tulevat per{kk{in.
# Kunkin tiedoston olemassaolo merkit{{n listaan @fexist
# ja kenttien m{{r{ listaan @kmaara.
  @kentat=();@fexist=();@kmaara=();
  for($tiedosto=1;$tiedosto<=$maara;$tiedosto++) 
    { # for tiedosto
      $lahto = "tav" . $lomakenro . "k" . $tiedosto . ".dtt";    
      $kmaara=0;    
      if (-e $lahto) { # if e lahto
        print $lahto , "\n";
        print PROSTIED $lahto , "\n";
        open(TIEDOSTO,$lahto);
        $tloppu=0;
        while( $tloppu==0 ) 
        { # while tloppu
          $syotto=<TIEDOSTO>;chop $syotto;
          if ($syotto eq "") { $tloppu=1; } else 
            { # if syotto
              $syotto=<TIEDOSTO>;chop $syotto;
              push( @kentat , $syotto );
              $kmaara++;
            } # if syotto
        } # while tloppu
      close(TIEDOSTO);
      $fexist=1;
      } else { $fexist=0; } # if e lahto
    push(@kmaara,$kmaara);push(@fexist,$fexist);  
  } # for tiedosto
# 2.2. Ker{t{{n kunkin lomakkeen kullekin kent{lle maksimipituudet
# listoihin @pituudet.
  @pituudet=();
  $indeksi=0;$tindeksi=0;
  for($tiedosto=1;$tiedosto<=$maara;$tiedosto++) 
    { # for tiedosto
      for($kentta=1;$kentta<=$kmaara[$tindeksi];$kentta++) 
      { # for kentta
        if ( length( $kentat[$indeksi] ) > $pituudet[$kentta-1] )
          { $pituudet[$kentta-1] = length($kentat[$indeksi]); }
        $indeksi++;
      } # for kentta
      $tindeksi++;
    } # for tiedosto
# 2.3. Tulostetaan kunkin tiedostonumeron kent{t yhdelle riville
# tiedostoon lomake.sar siten, ett{ kullekin sen kent{lle tulee 
# maksimipituuden ilmoittama m{{r{ tilaa ja kent{t tulevat
# t{ydennetty{ maksimim{{riin asti.
  $file = ">" . $tulosalku . $lomakenro . ".sar";
  print $file , "\n";
  print PROSTIED $file , "\n";
  open(TIEDOSTO,$file);
  $indeksi=0;$tindeksi=0;
  for($tiedosto=1;$tiedosto<=$maara;$tiedosto++) 
    { # for tiedosto
      for( $kenttanro=1; $kenttanro<=$kmaara[$tindeksi]; $kenttanro++ ) 
        { # for kenttanro
          $format = "%" . $pituudet[$kenttanro-1] . "s";
          printf TIEDOSTO $format, $kentat[$indeksi];
          print TIEDOSTO " ";
          $indeksi++;
        } # for kenttanro
      for( $kenttanro=$kmaara[tindeksi]+1; $kenttanro<=$#pituudet+1; 
           $kenttanro++ ) 
        { # for kenttanro
          $format = "%" . $pituudet[$kenttanro-1] . "s";
          printf TIEDOSTO $format," ";
          print TIEDOSTO " ";
        } # for kenttanro    
      $tindeksi++;
      print TIEDOSTO "\n";
    } # for tiedosto
} # for lomakenro
close(PROSTIED);





 


