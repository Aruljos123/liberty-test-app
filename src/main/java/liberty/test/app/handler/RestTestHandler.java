package liberty.test.app.handler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calcs")
public class RestTestHandler {
	@GET
	@Path("calc1")
	@Produces(MediaType.APPLICATION_JSON)
	public String calcTest1() {
		return Integer.toString(20*20*20);
	}
	
	@GET
	@Path("calc2")
	@Produces(MediaType.APPLICATION_JSON)
	public String calcTest2() {
		long ans=1L;
		for(long i=1L;i<=60;i++) {
			//System.out.println("******  " + i + " - " + ans);
			ans=ans*i;
		}
		System.out.println("********** " + ans);
		return Long.toString(ans);
	}
}
