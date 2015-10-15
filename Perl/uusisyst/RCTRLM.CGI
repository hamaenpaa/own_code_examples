#!/opt/bin/perl
opendir(HAK,".");
  @tdlista=readdir(HAK);
closedir(HAK);
foreach $td (@tdlista) {
  @rivit=();
  print $td ,"\n";
  open(TIEDOSTO,$td);
  @rivit=<TIEDOSTO>;
  close(TIEDOSTO);
  print "Rivit haettu.\n";
  $indeksi=0;
  foreach $rivi (@rivit) {
    $pituus=length($rivi);$pituus--;
    while( ( substr($rivi,$pituus,1) eq " " ) ||
           ( substr($rivi,$pituus,1) eq "\x0D" ) ) { $pituus--; }
    $pituus++;
    $vaihto=substr($rivi,0,$pituus);
    if ($vaihto eq "") { $vaihto = " "; }
    $rivit[$indeksi] = $vaihto;
    $indeksi++;
  }
  print "Lyhennetty ctrl-m:t ja v{lily|nnit pois.\n";
  $file = ">" . $td;
  open(TIEDOSTO,$file);
  foreach $rivi (@rivit) {
    print TIEDOSTO $rivi , "\n";
  }
  close(TIEDOSTO);
  print "Tallennettu korjattuna.\n";
}
