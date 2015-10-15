package fi.agileo;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hellojsonservice")
@Consumes(MediaType.APPLICATION_JSON)
public class OppilasService {
	
	private Oppilaat oppilaat;
	
	public OppilasService() {
		oppilaat = new Oppilaat();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/lista")
	public List<Oppilas> getOppilaat() throws SQLException {
		return oppilaat.getOppilaat();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/lisaa/{nimi}/{demo}/{koe}")
	public Oppilas addOppilas(@PathParam("nimi") String nimi, @PathParam("demo") int demo, @PathParam("koe") int koe) {
		System.out.println("addOppilas begin");
		Oppilas oppilas = new Oppilas();
		oppilas.setNimi(nimi);
		oppilas.setDemopisteet(demo);
		oppilas.setKoepisteet(koe);
		try {
			oppilaat.lisaaOppilas(oppilas);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		System.out.println("addOppilas" + oppilas);
		return oppilas;
	}

	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	@Path("/lisaapostxml")
	public Oppilas addOppilas2(OppilasData o) {
		System.out.println("addOppilas2 begin");
		
		Oppilas op = new Oppilas();
		op.setDemopisteet(o.demo);
		op.setKoepisteet(o.koe);
		op.setNimi(o.nimi);
		try {
			oppilaat.lisaaOppilas(op);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		System.out.println("addOppilas2" + op);
		return op;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lisaapostjson")
	public Oppilas addOppilas3(OppilasData o) {
		System.out.println("addOppilas3 begin");
		Oppilas op = new Oppilas();
		op.setDemopisteet(o.demo);
		op.setKoepisteet(o.koe);
		op.setNimi(o.nimi);
		try {
			oppilaat.lisaaOppilas(op);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		System.out.println("addOppilas3" + op);
		return op;
	}
 
}
