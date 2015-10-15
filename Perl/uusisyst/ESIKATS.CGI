#!/opt/bin/perl
$param=$ENV{'QUERY_STRING'};
$ind=index($param,"=");
$lomakenro=substr($param,$ind+1);
# $lomakenro=1;
$file = "lomake" . $lomakenro . ".htm";
open(TIEDOSTO,$file);
@rivit=<TIEDOSTO>;
close(TIEDOSTO);
open(TIEDOSTO,"ots.txt");
@ots=<TIEDOSTO>;
close(TIEDOSTO);
print "Content-type:text/html\n\n";
foreach $rivi (@rivit) {
  if (index($rivi,"<form")>=0) {
    print "<h2>Seuraavasta p&auml;&auml;see katselemaan kyselyn muita ";
    print "osia:</h2><font size=4><br><br>\n";
    for($i=1;$i<=$#ots+1;$i++) {
      if ($i!=$lomakenro) {
        print "<a href=\x22esikats.cgi?lomakenro=" , $i , ">";
        print $ots[$i-1] , "</a><br>\n";
      }
    }    
    print "<br><br>\n";
    print "<a href=\x22lomake.htm\x22>Paluu johdantoon</a><br>\n";
    print "<a href=\x22register.htm\x22>Rekister&ouml;ityminen uudeksi";
    print "kyselyyn vastaajaksi</a><br>\n";
    print "<a href=\x22kirj.htm\x22>Kirjautuminen kyselylomakkeelle</a>\n";
    print "<br><br>\n";
    print "<form method=POST action=\x22eitoim.cgi?lomakenro=" , $lomakenro;
    print "\x22>\n";
  } else { print $rivi; }
}
