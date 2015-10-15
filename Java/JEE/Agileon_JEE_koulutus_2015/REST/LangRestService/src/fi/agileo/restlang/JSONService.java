package fi.agileo.restlang;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hellojsonservice")
@Consumes(MediaType.APPLICATION_JSON)
public class JSONService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {
		Track track = new Track();
		track.setTitle("Otsikko");
		track.setSinger("Laulaja");
		return track;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		System.out.println("Found " + track.getSinger() + " " + track.getTitle());
		return Response.status(200).entity(result).build();
	}

}
