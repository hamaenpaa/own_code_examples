package fi.agileo.restlang;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/laskut")
public class LaskuService {
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/suorakulmio/{a}/{b}")
	public String suorakulmioTieto(@PathParam("a") int a, @PathParam("b") int b) {
		return "<?xml version=\"1.0\"?>" + 
			   "<tulos><suorakulmio><kanta>" + a + "</kanta><korkeus>" + b +
			   "</korkeus><pinta-ala>" + (a*b) + "</pinta-ala></suorakulmio></tulos>";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/ympyra/{r}")
	public String ympyra(@PathParam("r") double r) {
		return "<?xml version=\"1.0\"?>" + 
			   "<tulos><ympyra><sade>" + r + "</sade>" +
			   "<pinta-ala>" + String.format("%.2f", (Math.PI * r * r)) + 
			   "</pinta-ala></ympyra></tulos>";
		
	}
}
