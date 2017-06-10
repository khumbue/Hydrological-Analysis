package za.co.hydroanalysis.web.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.representation.Form;

/**
 * @author khumbu
 */
public class JerseyClient {
    private static final String baseUrl = "http://localhost:3000/api/stations/all";

    public static void main(String[] args) {
        new JerseyClient().demo();
    }

    private void demo() {
        String url = "";
        Client client = Client.create();
        client.setFollowRedirects(true); // in case the service redirects
        url = baseUrl + "/VaalRGC";
        WebResource resource = client.resource(url);
        getAllDemo(resource);
        postDemo(resource); // same resource but different verb
        url = baseUrl + "/VaalRGC&C1H005";
        resource = client.resource(url);
        getOneDemo(resource);
    }

    private void getAllDemo(WebResource resource) {
// GET all XML
        String response =
                resource.accept(MediaType.APPLICATION_XML_TYPE).get(String.class);
        report("GET all in XML:\n", response);
        // GET all JSON
        response =
                resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET all in JSON:\n", response);
    }

    private void getOneDemo(WebResource resource) {
        String response =
                resource.accept(MediaType.APPLICATION_XML_TYPE).get(String.class);
        report("GET one in XML:\n", response);
        response =
                resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET one in JSON:\n", response);
    }

    private void postDemo(WebResource resource) {
        Form form = new Form(); // HTTP body, a simple hash
        form.add("who", "William Butler Yeats");
        form.add("what", "I know that I shall meet my fate");
        String response =
                resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                        .accept(MediaType.TEXT_PLAIN_TYPE)
                        .post(String.class, form);
        report("POST:\n", response);
    }

    private void report(String msg, String response) {
        System.out.println("\n" + msg + response);
    }
}
