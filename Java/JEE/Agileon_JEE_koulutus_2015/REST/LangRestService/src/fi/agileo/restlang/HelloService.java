package fi.agileo.restlang;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//KANTAURL/helloservice/plain
//KANTAURL/helloservice/xml
//KANTAURL/helloservice/html


@Path("/helloservice")
public class HelloService {
	@GET
	@Path("/plain")
	@Produces(MediaType.TEXT_PLAIN)
	public String tekstiViesti() {
		return "Hei REST­asiakas";
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)
	public String xmlViesti() {
		return "<?xml version=\"1.0\"?>" + "<service><message> Moi REST­asiakas" + "</message></service>";
	}

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String htmlViesti() {
		return "<html> " + "<body><h1>" + "Moi REST­HTML asiakas" + "</body></h1>" + "</html> ";
	}
}

