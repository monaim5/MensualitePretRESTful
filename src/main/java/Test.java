import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ext.RuntimeDelegate;

public class Test {
    public static void main(String[] args) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(MensualitePretSerevice.class);

        HttpHandler handler = RuntimeDelegate.getInstance()
                .createEndpoint(resourceConfig, HttpHandler.class);

        HttpServer server = HttpServer.createSimpleServer(null, 8080);
        server.getServerConfiguration().addHttpHandler(handler);

        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
