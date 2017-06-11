package za.co.hydroanalysis.web.client;

import com.sun.jersey.api.client.WebResource;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.representation.Form;
import org.json.JSONObject;

/**
 * @author khumbu
 */
public class HydrologicalAnalysisWebClient {

    @Inject
    private HydrologicalAnalysisWebClientHelper hydrologicalAnalysisWebClientHelper;

    public JSONObject getAllStationsData(String urlString) {
        return hydrologicalAnalysisWebClientHelper.getAll(urlString);
    }

    public JSONObject getForStation(String urlString) {
        return hydrologicalAnalysisWebClientHelper.get(urlString);
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
