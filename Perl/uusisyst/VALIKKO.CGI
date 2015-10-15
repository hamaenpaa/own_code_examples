#!/opt/bin/perl
$param=$ENV{'QUERY_STRING'};
$ind=index($param,"=");
$kutsuja=substr($param,$ind+1);
# $kutsuja="4";
open(TIED,">param.txt");
print TIED "kutsuja: ", $kutsuja , "\n";
close(TIED);
# 1. Jos kutsuja on lomakkeellekirjaaja ( kutsuja=1 ) tai
# uudeksi k{ytt{j{ksi kirjaaja (kutsuja=2) , niin haetaan tunnus ja salasana;
# sek{ tiedostosta jo olemassaolevat tunnukset ja salasanat.
$muutoiminto=0;
if ( ($kutsuja eq "1") || ($kutsuja eq "2") ) {
# 1.1. Tunnus ja salasana
  $syotto=<STDIN>;
  @kentat=split(/&/,$syotto);
  $tul = join(',',@kentat);
  $ind=index($kentat[0],"=");
  $kt=substr($kentat[0],$ind+1);
  $ind=index($kentat[1],"=");
  $sal=substr($kentat[1],$ind+1);
# 1.2. Jo olemassaolevat tunnukset ja salasanat.
  @kayttiks=();@sala=();
  open(TIEDOSTO,"nimilist.txt");
  $maara=0;
  $tloppu=0;while( $tloppu==0 ) { # while tloppu
    $syotto=<TIEDOSTO>;chop $syotto;
    if ($syotto eq "") { $tloppu=1; } else { # if
      push(@kayttiks,$syotto);
      $syotto=<TIEDOSTO>;chop $syotto;
      push(@sala,$syotto);$maara++;
    } # if
  } # while tloppu
  close(TIEDOSTO);
}
# 2. Jos kutsuja on johdantolomake ( kutsuja=3 ), haetaan k{ytt{j{n numero
if ($kutsuja eq "3") { # if
  $syotto=<STDIN>;
  $ind=index($syotto,"=");$nro=substr($syotto,$ind+1);
} # if
# 3. Jos kutsuja on lomakkeen datojen sy|tt| ( kutsuja=4 ) ker{t{{n
#  datat tiedostoihin.
if ($kutsuja eq "4") { # if kutsuja=4
  $loppu=0;@knimi=();@ktieto=();
  while( $loppu==0 ) { # while loppu
    $syotto=<STDIN>;chop $syotto;
    if ($syotto eq "") { $loppu=1; } else { # if syotto
      @kentat=split(/&/,$syotto);
      $indeksi=0;@knimij=();@ktietoj=();
      foreach $word (@kentat) { # foreach
        $_=$word;
        s/%(..)/pack("c",hex($1))/ge; # Korvataan .. vastaavalla ascii-merkill{
        s/\+/\x20/g; # Korvataan + v{lily|nnill{
        $word=$_;
        $knimij[$indeksi] = substr( $word , 0 , index( $word , "=" ) );
        $ktietoj[$indeksi] = substr( $word , index( $word , "=" )+1 );
        $indeksi++;  
      } # foreach
      @knimi  = ( @knimi , @knimij );
      @ktieto = ( @ktieto , @ktietoj );
    } # if syotto
  } # while loppu
  ($nro,$lomakenro)=splice(@ktieto,0,2);
  splice(@knimi,0,2);
  $file="lomake". $lomakenro . ".ta";
  open(TIEDOSTO,$file); 
  $loppu=0;@tekstitied=();@textknimi=();
  while( $loppu==0 ) { # while loppu
    $syotto=<TIEDOSTO>;chop $syotto;   
    if ($syotto eq "") { $loppu=1 } else { # if syotto
      push( @textknimi , $syotto );
      $syotto=<TIEDOSTO>;chop $syotto;
      push( @tekstitied , $syotto );
    } # if syotto
  } # while loppu
  close(TIEDOSTO);
  $indeksi=0;
  foreach $word (@tekstitied) { # foreach
    $tekstitied[$indeksi] = ">" . $word . $nro . ".txt";
    $indeksi++;
  } # foreach
# Varsinainen kirjoittaminen tiedostoihin tavkent[nro] !!!!
  $indeksi=0;$texttied=0;
  $file = ">tav". $lomakenro. "k". $nro . ".dtx";
  open( tavkentat , $file );
  foreach $word (@knimi) { # foreach word
    $ontext=0; 
    foreach $knim (@textknimi) { # foreach knim
      if ( $word eq $knim )  # Jos tekstitiedosto, tiedot vastaavan numeroituun
                           # tiedostoon
        { # if word
          open(TIEDOSTO,$tekstitied[$texttied]);
          print TIEDOSTO $ktieto[$indeksi];
          close(TIEDOSTO);
          @komlist=("chmod","ugo+rw",$tekstitied[$texttied]);
          system @komlist;
          $texttied++;$ontext=1;
        } # if word
    } # foreach knim
    if ($ontext==0)  # muutoin tiedostoon tavkent.txt jatkoksi 
     { print tavkentat $knimi[$indeksi] , "\n" , $ktieto[$indeksi] , "\n"; }
    $indeksi++;
  } # foreach word
  close( tavkentat );
  @komlist=("chmod","ugo+rw",$file);
  system @komlist;
} # if kutsuja=4
# 4. Jos kutsuja on uudeksi k{ytt{j{ksi kirjaaja, tutkitaan, onko
# tunnus jo olemassa. Jos on, luodaan sit{ vastaava ilmoitus. 
# Jos ei ole, kirjataan tunnus uutena tiedostoon ja p{{st{{n eteenp{in
if ($kutsuja eq "2") { # if kutsuja=2
  $loytyi=0;$ind=0;
  while( ( $ind <= $#kayttiks ) && (!$loytyi) ) { # while ind
    if ( $kt eq $kayttiks[$ind] ) { $loytyi=1; } else { $ind++; }
  } # while ind
  if ($loytyi) { # if loytyi
    $muutoiminto=1;
    open(TIEDOSTO,"onjosala.htm");
    @rivit=<TIEDOSTO>;
    close(TIEDOSTO);
    print "Content-type:text/html\n\n";
    foreach $rivi (@rivit) { print $rivi; }
  } else { # else lyotyi
    open(TIEDOSTO,">nimilist.txt");
    $ind=0;
    foreach $kr (@kayttiks) { # foreach
      print TIEDOSTO $kr , "\n";
      print TIEDOSTO $sala[$ind] , "\n";
      $ind++;
    } # foreach
    $su=pack("u",$sal);
    print TIEDOSTO $kt, "\n", $su , "\n";
    close(TIEDOSTO);
    $nro=$#kayttiks+2;
  } # else loytyi
} # if kutsuja=2
# 5. Jos kutsuja on lomakkeellekirjaaja, tutkitaan, onko tunnus ja 
# salasana kirjattuna. Jos ei ole, annetaan sit{ vastaava ilmoitus.
# Muutoin p{{st{{n eteenp{in.
if ($kutsuja eq "1") { # if kutsuja=1
  $loytyi=0;$ind=0;
  while( ( $loytyi==0 ) && ( $ind <= $#kayttiks ) ) { # while
    $df= $sala[$ind];
    $sf = unpack( "u" , $df );
    $xf=$kayttiks[$ind];
    if ( ( $xf eq $kt ) && ( $sal eq $sf ) ) 
      { $loytyi=1;$nro=$ind; } else { $ind++; }
  } # while
  if ($loytyi==0) { # if loytyi
    $muutoiminto=1; 
    open(TIEDOSTO,"virhekir.htm");
    @rivit=<TIEDOSTO>;
    close(TIEDOSTO);
    print "Content-type:text/html\n\n";
    foreach $rivi (@rivit) { print $rivi; }
  } # if loytyi
} # if kutsuja=1
# 6. Luodaan valikko siten, ett{ siihen tulee ensimm{isiksi piilotettuna
# kentt{n{ k{ytt{j{n numero.
if (!$muutoiminto) { # if muutoiminto
  $file="valik". $kutsuja . ".htm";
  open(TIEDOSTO,$file);
  @rivit=<TIEDOSTO>;
  close(TIEDOSTO);
  print "Content-type:text/html\n\n";
  foreach $rivi (@rivit) {
  print $rivi;
  if ( index($rivi,"<form") >=0 ) { # if
    print "<input type=\x22hidden\x22 name=\x22ktnro\x22 value=\x22";    
    print $nro . "\x22>";
  } # if
} # muutoiminto
}




