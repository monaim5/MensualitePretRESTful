import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class MensualitePretSerevice {
    @GET
    @Path("hello")
    public String sayHello() {
        return "hello worldd";
    }
}
