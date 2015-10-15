#!/opt/bin/perl
$param=$ENV{'QUERY_STRING'};
$ind=index($param,"=");
$lomakenro=substr($param,$ind+1);
# $lomakenro=1;
open(TIEDOSTO,"eitoim.htm");
@rivit=<TIEDOSTO>;
close(TIEDOSTO);
print "Content-type:text/html\n\n";
foreach $rivi (@rivit) {
  if (index($rivi,"esikats.cgi")>=0) {
    print "<a href=\x22esikats.cgi?lomakenro=", $lomakenro , "\x22>";
  } else { print $rivi; }
}
