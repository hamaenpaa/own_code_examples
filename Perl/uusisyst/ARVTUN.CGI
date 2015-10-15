#!/opt/bin/perl
print "Content-type:text/html\n\n";
$param=$ENV{QUERY_STRING};
$ind=index($param,"=");
$lomakenro=substr($param,$ind+1);$lomakenro=3-$lomakenro;
open(TIEDOSTO,"register.htm");
@rivit=<TIEDOSTO>;
close(TIEDOSTO);
@kayttiks=();@salas=();
open(TIEDOSTO,"nimilist.txt");
$tloppu=0;while( $tloppu==0 ) {
  $syotto=<TIEDOSTO>;chop $syotto;
  if ($syotto eq "") { $tloppu=1; } else {
    push(@kayttiks,$syotto);
    $syotto=<TIEDOSTO>;chop $syotto;
    push(@salas,$syotto);
  }
}
close(TIEDOSTO);
$eisama=0;
srand(time|$$);
while($eisama==0) { 
  $sec=""; 
  for($i=1;$i<=8;$i++) { 
    $dg=pack( "c", 65+int(rand(24)) ); 
    $sec = $sec . $dg;
  }
  $eisama=1;
  $ind=0;while( ( $ind <= $#salas ) && ( $eisama ) ) {
    $xf = $salas[$ind];
    $purku = unpack( "u", $xf );
    if ($purku eq $sec) { $eisama=0; } else { $ind++; }
  } 
}
foreach $rivi (@rivit) {
  if ( index($rivi,"type=text") > 0 ) {
    $rv=substr($rivi,0,length($rivi)-3) . " value=\x22" . $sec . "\x22>\n";
    print $rv;
  } else { 
    if ( index($rivi,"<a href=\x22arvtun")==0 ) {
      $rivi = "<a href=\x22arvtun.cgi?v=". $lomakenro .
              "\x22>Arvo tunnus</a>\n";
    }
    print $rivi; 
  }
}




