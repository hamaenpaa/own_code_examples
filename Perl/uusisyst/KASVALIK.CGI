#!/opt/bin/perl
 
# !!! Aliohjelmia henkil|kohtaisen lomakkeen muodostusta varten. !!!

sub imj
# Palauttaa kohdan, jolta ensimm{isen parametrina isoksi kirjaimiksi
# muutettuna olevasta merkkijonosta l|ytyy toisena parametrina
# oleva merkkijono.
{ 
  $riso = $_[0];
  $riso =~ tr/a-z/A-Z/;
  $rind = index( $riso , $_[1] );
  $rind;
}

sub eivali
# Etsii ensimm{isen{ parametrina olevasta merkkijonosta toisen parametrin
# osoittamasta kohdasta eteenp{in ensimm{isen merkin, joka ei ole v{lily|nti
# ja palauttaa t{m{n kohdan.
{
  $rivi=$_[0];$ind=$_[1];
  while( ($ind<length($rivi)) && (substr($rivi,$ind,1) eq " ") ) { $ind++; }
  if ($rivi[$ind]!=' ') { $ind=-1; }
  $ind;
}

sub par_nimi
# Palauttaa kohdan, josta ensimm{isen{ parametrina olevan isoksi muutettuna
# olevasta merkkijonosta l|ytyy toisena parametrina oleva merkkijono
# kolmannen parametrin osoittamalta kohdalta alkaen.
{
  $mj = $_[0];
  $mj =~ tr/a-z/A-Z/; 
  $nameind = index( $mj , $_[1] , $_[2] ); 
}

sub par_arvo

{
  $tind = index( $_[0] , "=" , $_[1] );
  $lm = index( $_[0] , "\x22" , $tind );
  $muu = &eivali( $_[0]  , $tind+1 );
  if (( $lm>=0 ) && ( $lm == $muu )) {
    $aind=$lm+1;
    $lind=index($_[0], "\x22" , $aind )-1;$kp=$lind-$aind+3;
  } else {
    $aind=$muu;
    $lind=index($_[0], " " , $muu)-1;
    $lvert=index($_[0], ">" , $muu)-1;
    if ($lind<0) { $lind=$lvert; }
    if ($lvert<$lind) { $lind=$lvert; }
    $lvert=index($_[0],"\n")-1;
    if (($lvert>=0) && ($lvert<$lind)) { $lind=$lvert; }
    $kp = $lind-$aind+1;
  }
  $kn = substr( $_[0] , $aind , $lind-$aind+1 );
  $ki = $aind;
  ( $kn , $ki , $kp );
}

sub analysoi_tagi
{
# Parametrina analysoitava tagi
# Tyypit: 
# input:( text:value; checkbox,radio: CHECKED;) 
# option: teksti per{ss{;
# textarea: teksti alku- ja lopputagin v{liss{. - klaji
  $knimi="";$karvo="";$knind=0;$kaind=0;$onkentta=0;$kapit=0;
  $input=0;$klaji=0;
  $tind=0;
  $tind=&imj( $_[0], "<INPUT" );
  if ($tind==0) { $tind=6;$onkentta=1;$input=1; }
  if ( !$onkentta ) { 
    $tind = &imj( $_[0] , "<TEXTAREA" ); 
    print LOGFILE "tind, textarea: ", $tind , "\n";
    if ($tind==0) { $tind=9;$onkentta=1;$klaji=1; } else { 
      $tind=&imj( $_[0] , "<SELECT" );
      if ($tind==0) { $tind=7;$onkentta=1;$klaji=5; } else {
        $tind=&imj( $_[0] , "<OPTION" );
        if ($tind==0) { $tind=7;$onkentta=1;$klaji=6; } else {
          $tind=&imj( $_[0] , "</TEXTAREA" );
          if ($tind==0) { $tind=10;$onkentta=1;$klaji=7; }
        }
      }
    } 
  }
  if ( $input ) {
    $kind=&imj( $_[0] , "TYPE" , $tind );
    ($tnimi,$tnind,$tnpit) = &par_arvo( $_[0] , $kind+4 );
    $tnimi =~ tr/a-z/A-Z/;
    if ($tnimi eq "CHECKBOX") { $klaji=2; }
    if ($tnimi eq "TEXT") { $klaji=4; }
    if ($tnimi eq "RADIO") { $klaji=3; }
  }
  if ( ($onkentta) && ($klaji!=6) && ($klaji!=7) ) {
    $nameind = &par_nimi( $_[0] , "NAME" , $tind );
    ($knimi,$knind,$knpit) = &par_arvo( $_[0] , $nameind+4 );
  }
  if ( ($onkentta) && ($klaji>=2) && ($klaji<=4) ) {
    $nameind = &par_nimi( $_[0] , "VALUE" , $tind );
    if ( $nameind >=0 ) {
      ($karvo,$kaind,$kapit) = &par_arvo( $_[0] , $nameind+5 );
    }
  }
  ($onkentta,$klaji,$knimi,$karvo,$knind,$kaind,$kapit); 
}

# !!! Varsinainen ohjelma !!!

# 2. Puretaan k{ytt{j{n numero ja valinta auki.
$syotto=<STDIN>;
@lista=split(/&/,$syotto);
$ind=index($lista[0],"=");$nro=substr($lista[0],$ind+1);
$ind=index($lista[1],"=");$valinta=substr($lista[1],$ind+1);
# 4. Jos valinta on lomake, niin haetaan k{ytt{j{{ vastaavat tiedot
# Johdanto erikseen. ( else-osa )
if ( ($valinta ge "2") || (length($valinta)>=2) ) { # lomake
  $lomakenro=$valinta-1;
# 5. Luodaan kysymyslomake
# 5.1. Haetaan lomakekoodi
  $file="lomake". $lomakenro . ".htm";
  open(TIEDOSTO,$file);
  @rivit=<TIEDOSTO>;
  close(TIEDOSTO);
# 5.2. Muodostetaan lomakeriveist{ lomake, jossa on k{ytt{j{n datat
# mik{li t{m{ on t{ytt{nyt jo aikaisemmin ko. lomakkeen.

# !!! haetag.cgi !!!

# Ohjelma etsii tageja listasta @rivit, joka sis{lt{{ HTML-koodin ilman
# rivinvaihtoja ja korvaa niiss{ value-osat listojen @knimi, @ktieto 
# arvoilla. Muutettu HTML-koodi tulee listaan @urivit.

# 5.2.1. Luetaan tavallisten kenttien tietotiedosto
@knimi=();@ktieto=();
$tiedtd="tav" . $lomakenro . "k" . $nro . ".dtx";
if (-e $tiedtd) {
  open(TIEDOT,$tiedtd);
  $tloppu=0;
  while($tloppu==0) {
    $syotto=<TIEDOT>;chop $syotto;
    if ($syotto eq "") { $tloppu=1; } else {
      push(@knimi,$syotto);
      $syotto=<TIEDOT>;chop $syotto;
      push(@ktieto,$syotto);
    }
  }
  close(TIEDOT);
}
# 5.2.2. Luetaan lomakkeen tekstialuekenttien nimet ja niit{ vastaavat
# tiedostonimet listoihin @tknimet,@tktdnimet.
$tiedtd="lomake" . $lomakenro . ".ta";
@tknimet=();@tktdnimet=();
open(TIEDOT,$tiedtd);
$tloppu=0;
while($tloppu==0) {
  $syotto=<TIEDOT>;chop $syotto;
  if ($syotto eq "") { $tloppu=1; } else {
    push(@tknimet,$syotto);
    $syotto=<TIEDOT>;chop $syotto;
    push(@tktdnimet,$syotto);
  }
}
close(TIEDOT);
# 5.2.3. Haetaan tietojen korvauslistat tiedostosta lomake[lomakenro].kss
# listoihin @knimis,@ktietos,@kkorvs. 
$file="lomake" . $lomakenro . ".kss";
@knimis=();@ktietos=();@kkorvs=();
open(TIEDOSTO,$file);
$tloppu=0;
while($tloppu==0) {
  $syotto=<TIEDOSTO>;chop $syotto;
  if ($syotto eq "") { $tloppu=1; } else {
    push(@knimis,$syotto);
    $syotto=<TIEDOSTO>;chop $syotto;
    push(@ktietos,$syotto);
  }    
}
close(TIEDOSTO);
# 5.2.4. Suoritetaan korvaukset listoihin @knimi ja @ktieto
$kind=0;
foreach $kn (@knimi) {
  $kind2=0;
  foreach $kn2 (@knimis) {
    if ( ($kn2 eq $kn) && (index($ktieto[$kind],$ktietos[$kind2])>=0) ) 
      { $ktieto[$kind]= $ktietos[$kind2]; }
    $kind2++;
  }
  $kind++;
}
# 5.2.5. Varsinainen rivien l{pik{ynti
# 5.2.5.1. Alkuparametrit kuntoon
$rivinroa=0;$rinda=0;@urivit=();$option=0;$peraan=0;
while( $rivinro <= $#rivit ) { # rivinro
  $poisto=0; # Jos textarea-loppu on ollut, niin 
             # seuraavalla kerralla ei tagien 
             # v{linen alue j{{ lis{{m{tt{.
# 5.2.5.2. Etsit{{n tagin alku
# rivinroa=rivi, jolta kierros alkaa
# rinda=kohta, jolta kierros alkaa
  $tagion=0;$rind=$rinda;$rivinro=$rivinroa;
  while( ( $tagion==0 ) && ( $rivinro <= $#rivit ) ) {
    $rivi = $rivit[$rivinro];
    $rind = index( $rivi , "<" , $rind );
    if ( $rind >= 0 ) { $tagion=1; } else { $rivinro++; }
  }
  $tagiar = $rivinro;$tagiai = $rind;  
# tagiar=rivi, jolta tagi alkaa; tagiai=kohta, jolta tagi alkaa.
# 5.2.5.3. Etsit{{n tagin loppu
  if ( $tagion ) { # if tagi
    # Etsit{{n lainausmerkki tai tagin loppu 
    $tagloppu=0;
    while( $tagloppu==0 ) { # tagloppu
      $rivi = $rivit[$rivinro];
      $lm = index( $rivi , "\x22" , $rind );
      if ($lm==-1) { $lm = length($rivi)+2; }
      $tagili = index( $rivi , ">" , $rind );
      if ($tagili==-1) { $tagili= length($rivi)+2; }
      if ( ( $lm < $tagili ) && ( $lm !=length($rivi)+2 ) ) { # lm
        # Jos lainausmerkki ensin, etsit{{n toinen lainausmerkki
        $lmloppu=0;$rind=$lm+1;
        while( ( $lmloppu==0 ) && ( $rivinro <= $#rivit ) ) { # lmloppu
          $rivi = $rivit[$rivinro];
          $rind = index( $rivi , "\x22" , $rind );
          if ( $rind >=0 ) { $lmloppu=1;$rind++; # print "lmloppu\n"; 
            } else { $rivinro++;$rind=0; }
        } # lmloppu
      } else { 
        if ( $tagili != length($rivi)+2 ) { 
          # Muuten etsit{{n tagin loppumerkki tai siirryt{{n seuraavan
          # rivin alkuun. Jos tagin loppumerkki l|ytyy, tagi on
          # saavuttanut loppunsa.
          $tagloppu=1;$rind=$tagili; 
        } # lm 
        else { $rind=0;$rivinro++; }
      }
    } # tagloppu
    $tagilr=$rivinro;
    # T{ss{ vaiheessa rivinroa, rinda oli sit{ tekstin kohtaa vastaava 
    # rivi ja sarake, joka tuli edellisen tagin loppumerkin j{lkeen
    # tai eka kerralla tekstin ensimm{ist{ merkki{ vastaava rivi ja sarake.
    # tagiar, tagiai ovat seuraavan tagin alkamiskohdan rivi ja sarake.
    # tagilr, tagili ovat seuraavan tagin loppumiskohdan rivi ja sarake.
# 5.2.5.4. Luodaan tagi merkkijonoon tagi
    $tagi="";
    if ($tagiar==$tagilr) 
      { $tagi=substr($rivit[$tagiar],$tagiai,$tagili-$tagiai+1); }
    else {
      $tagi=substr($rivit[$tagiar],$tagiai);
      $rivinro=$tagiar+1;
      while( $rivinro < $tagilr ) { $tagi = $tagi . "\n" . $rivit[$rivinro]; }
      $tagi = $tagi . substr( $rivit[$tagilr], 0, $tagili+1 );
    }
# Etsit{{n merkkijonosta $tagi kent{n nimi ja arvo
# sek{ niiden paikat siin{.
    ($onkentta,$klaji,$knimi,$karvo,$knind,$kaind,$kapit) =  
    &analysoi_tagi( $tagi );
# 5.2.5.5. K{sitell{{n kentt{tagi sen tyypin klaji mukaisella tavalla  
# 5.2.5.5.1. Jos aikaisemmin on tullut option-tagi, k{sitell{{n se nyt
# seuraavan tagin tultua.
    if ($option) { # option
      $option=0;
      # Etsit{{n merkkijonoon rivialku teksti, mik{ on 
      # edellisen option-tagin ja seuraavan tagin v{liss{.
      # Teksti alkaa kohdalta, josta kierros alkoi ja 
      # ja p{{ttyy kohtaan, josta seuraava tagi alkaa.
      $kind=0;
      if ($tagiar==$rivinroa) 
        { $rivialku=substr( $rivit[$rivinroa] , $rinda , $tagiai-$rinda ); }
      else {
        $rivialku=substr( $rivit[$rivinroa] , $rinda );
        $ri=$rivinroa+1;
        while($ri<$tagiar) {      
          $rivialku = $rivialku . "\n" . $rivit[$ri];$ri++;
        }
        $rivialku = $rivialku . "\n" . 
          substr( $rivit[$tagiar] , 0, $tagiai );
      }
      $rivialku =~ s/&auml;/d/g;
      # katsotaan listasta @rivit, onko siell{ tagin per{ss{ jotain
      # listoihin @knimi ja @ktieto sopivaa. Jos on, lis{t{{n tagiin SELECTED.
      $tagix="<OPTION>";
      foreach $kn (@knimi) { # foreach kn
        if ( ( $name1 eq $kn ) && ( index( $rivialku, $ktieto[$kind] )>=0 ) )
          { $tagix = "<OPTION SELECTED>"; }
        $kind++;
      } # foreach kn
      # Lis{t{{n edellinen lis{{m{t|n option tagi paikalleen
      push(@urivit,$tagix);
    } # option
# 5.2.5.5.2. Jos tagi paljastui kent{ksi, tehd{{n sit{ vastaavat toimenpiteet
    if ($onkentta) { # if onkentta
      if ($klaji==5) { $name1=$knimi; } 
# 5.2.5.5.3. select-alku, name1 k{ytet{{n option-tagien yhteydess{
      if ($klaji==6) { 
# 5.2.5.5.4. option-alku, option=1 p{{lle, jotta seuraavan tagin l|ytyess{
# v{liss{oleva teksti paljastuisi optionista tulevaksi tekstiksi.
# Aikaisemmin ( klaji=5 ) select-tagi on antanut name1:ksi 
# kent{n nimen.
        $option=1;
      }
      if ($klaji==1) { $tagi1=$tagi;$name1=$knimi;
# 5.2.5.5.5. textarea-alku, tagi1=alkutagi, poisto p{{lle, koska
# alku- ja lopputagin v{list{ aluetta ei talleteta, vaan tilalle
# laitetaan tiedostosta l|ytyv{. name1=kent{nnimi, tagi1=tagi.
# Tagi lis{t{{n vasta lopputagin tullessa.
      } 
      if ($klaji==7) { 
# 5.2.5.5.6. textarea loppu, lis{t{{n koko systeemin aloitustagista
# kohtaan ennen lopetustagia. Lopetustagi lis{t{{n tagin lis{ys -kohdassa.
        $poisto=1;
        $tkind=0;$poisto=0;
        # Tutkitaan, jos kent{n nimi vastaa jotain tunnettua
        # tekstialuekent{nnime{. Jos vastaa, niin haetaan sit{
        # vastaavasta tiedostosta teksti alku- ja lopputagin v{liin.
        foreach $tknimi (@tknimet) { # foreach tknimi
          if ($name1 eq $tknimi) { # if name1
            # Tekstikentt{ l|ytyi
            $file=$tktdnimet[$tkind] . $nro . ".txt"; 
            # Jos tiedosto on olemassa lis{t{{n sen sis{lt|
            if (-e $file) { # if efile
              open(TIEDOT,$file); 
              $tloppu=0;
              while( $tloppu==0 ) { # while tloppu         
                $rivi=<TIEDOT>;
                if ($rivi eq "") { $tloppu=1; } else { 
                   push(@urivit,$rivi);
                }
              } # while tloppu
              close(TIEDOT); 
            } # if efile
          } # if name1
          $tkind++;
        } # foreach tknimi
      } # textarea-loppu
      if ( ($klaji==2) || ($klaji==3) ) { # if klaji 2,3 ( radio,checkbox )
        # Etsit{{n, jos radio- tai checkbox-kentt{{ vastaava nimiarvopari
        # l|ytyy tiedostosta haettuihin.
        $loytyi=0;$knind=0;
        foreach $kn (@knimi) { # foreach kn
          if ( ($knimi eq $kn) && ($karvo eq $ktieto[$knind]) ) { $loytyi=1; }
          $knind++;
        } # foreach kn
        # Poistetaan alkuper{isest{ tagista mahdollinen entinen CHECKED.
        $tind=&imj($tagi,"CHECKED");
        if ( $tind>0 ) {  
          $tagi = substr($tagi,0,$tind) . substr($tagi,$tind+7);
        }
        # Jos nimiarvopari l|ytyi, lis{t{{n tagiin paikalleen CHECKED
        if ($loytyi) { 
          $tagi = substr($tagi,0,length($tagi)-1) . " CHECKED>"; 
        } 
      } # if klaji 2,3
      if ( $klaji==4 ) { # if klaji 4 ( text )
        # Etsit{{n l|ytyyk| tiedostosta haetuista nimiarvopareista 
        # tekstikentt{{ vastaavaa nime{. Jos l|ytyy, niin loytyi=1 ja
        # kni=vastaavan kohdan indeksi.
        $loytyi=0;$knind=0;
        foreach $kn (@knimi) { # foreach kn
          if ($kn eq $knimi) { $loytyi=1;$kni=$knind; }
          $knind++;                                                            
        } # foreach kn
        # Poistetaan tagista alkuper{inen VALUE-arvo.
        $tind=&imj($tagi,"VALUE");
        if ( $tind>0 ) { # if tind
          $tpa=$tind;$tind=&eivali($tagi,$tpa);
          if (substr($tagi,$tind,1) eq "=") {
            $tind++;$tind=&eivali($tagi,$tind);
            if (substr($tagi,$tind,1) eq "\x22") { 
              $tind=index($tagi,"\x22",$tind+1);$tind++;
            } else {
              while( (substr($tagi,$tind,1)!=" ") &&
                     (substr($tagi,$tind,1)!=">") ) { $tind++; }
            } # if substr \x22
          } # if substr =
          $tagi=substr($tagi,0,$tpa) . substr($tagi,$tind);
        } # if tind 
        # Lis{t{{n tagiin parametriksi value, tiedostosta
        # kent{n nime{ ( kohta kni ) vastaava arvo.
        if ($loytyi) { # if loytyi
          $tagi=substr($tagi,0,length($tagi)-1) . " VALUE=\x22" . 
          $ktieto[$kni] . "\x22>";
        } # if loytyi
      }
    } # if onkentta
  } # if tagi
  # Lis{t{{n rivit, jotka on kokonaan valmiita listaan @urivit.
  if (!$poisto) { 
    # if !poisto ( Poisto: textarea-loppu,
    # teksti alku- ja lopputagin v{list{ j{tet{{n lis{{m{tt{. )
    # Lis{t{{n teksti ennen tagia.
    $urivi="";
    if ($peraan && ($rinda!=0)) 
      { $urivi=pop(@urivit); }
    if ($tagiar>$rivinroa) {
      $urivi = $urivi . substr( $rivit[$rivinroa] , $rinda );
      push(@urivit,$urivi);$rivinro=$rivinroa+1;
      while($rivinro<$tagiar) {
        push( @urivit, $rivit[$rivinro] );
        $rivinro++;
      }
      if ( $tagiai>0 ) { 
        push( @urivit , substr($rivit[$tagiar], 0, $tagiai ) );
      }      
    } else {
      $urivi = $urivi . substr($rivit[$tagiar] , $rinda , $tagiai-$rinda );
      if (!($urivi eq "")) { 
        push(@urivit,$urivi);
      }
    }
  if ($tagion && (!$option)) { 
    # if tagion ( Jos option, tagi tulee viiveell{. )
    $tagiloppu=0;$tagiind=0;$tagir=0;
    if ($tagili>0) { $peraan=1; }
    while( $tagiloppu==0 ) { # while tagiloppu
      $rv=index($tagi,"\n",$tagiind);
      if ($rv<0) { $rv=length($tagi);$tagiloppu=1; }
      $urivi="";
      if ( ($tagir==0) && ($tagiai>0) ) {
        $urivi=pop(@urivit);
      }
      $urivi=$urivi.substr( $tagi , $tagiind , $rv-$tagiind );
      push(@urivit,$urivi);
      $tagiind=$rv+1;
      $tagir++;
    } # while tagiloppu
  } # if tagion
  } # if !poisto
  # Asetetaan riviselaimet tagin lopun kohdalle seuraavan tagin 
  # etsimist{ varten.
  $rivinroa=$tagilr;$rinda=$tagili+1;
  if ( $rinda >= length($rivit[$rivinroa])) { $rinda=0;$rivinroa++; }
} # rivinro
# 5.3. Tulostetaan lomakekoodi siten, ett{ numero menee piilotettuna
# kentt{n{ heti <form>-rivin j{lkeen ja siihen tulee 
# k{ytt{j{n datat
  print "Content-type:text/html\n\n";
  foreach $rivi (@urivit) {
    print $rivi;
    if (index($rivi,"<form")>=0) {
      print "<input type=\x22hidden\x22 name=\x22ktnro\x22 value=\x22";
      print $nro . "\x22>";
      print "<input type=\x22hidden\x22 name=\x22lomakenro\x22 value=\x22";
      print $valinta-1 , "\x22>";
    }
  } 
} else {
# 6. Muut valinnat ( johdanto )
  open(TIEDOSTO,"johdant2.htm");
  @rivit=<TIEDOSTO>; 
  close(TIEDOSTO);
  print "Content-type:text/html\n\n";
  foreach $rivi (@rivit) {
    print $rivi;
    if (index($rivi,"<form")>=0) { 
      print "<input type=\x22hidden\x22 name=\x22ktnro\x22 value=\x22";
      print $nro . "\x22>";
    }  
  }
}







