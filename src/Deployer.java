import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("/deploy/{component}")
public class Deployer {
    @GET
    @Produces("text/plain")
    public String deploy(@PathParam("component") String component) {
        switch (component){
            case "justForex":
                deployJustForex();
                break;
            case "javaAppServer":
                deployJavaMicroservices();
                break;
            default:
                return "something didn't work";
        }
        return "success";
    }

    private void deployJavaMicroservices() {
        try {
            Runtime.getRuntime().exec("/root/deploy_java_microservices.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deployJustForex() {
        try {
            Runtime.getRuntime().exec("/root/deploy_justForex.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
