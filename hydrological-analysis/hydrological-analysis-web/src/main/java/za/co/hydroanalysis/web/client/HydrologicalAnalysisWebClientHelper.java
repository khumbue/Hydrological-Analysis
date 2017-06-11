package za.co.hydroanalysis.web.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;

/**
 * @author khumbu
 */
public class HydrologicalAnalysisWebClientHelper {

    private static final String ALL_STATIONS_BASE_URL_ = "http://localhost:3000/api/Stations/all/";
    private static final String SINGLE_STATION_BASE_URL = "http://localhost:3000/api/listStation/";
    private static final String JSON_OBJECT_PREFIX = "{stations : ";
    private static final String JSON_OBJECT_SUFFIX = "}";


    public JSONObject getAll(String urlString) {
        Client client = buildClient();
        StringBuilder jsonString = new StringBuilder(JSON_OBJECT_PREFIX);
        WebResource resource = buildWebResourceForAllStations(urlString, client);
        String response = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET in JSON:\n", response);
        jsonString.append(response).append(JSON_OBJECT_SUFFIX);
        JSONObject object = new JSONObject(jsonString.toString());
        return object;
    }

    public JSONObject get(String urlString) {
        Client client = buildClient();
        StringBuilder jsonString = new StringBuilder(JSON_OBJECT_PREFIX);
        WebResource resource = buildWebResourceForOneStation(urlString, client);
        String response = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET in JSON:\n", response);
        jsonString.append(response).append(JSON_OBJECT_SUFFIX);
        JSONObject object = new JSONObject(jsonString.toString());
        return object;
    }

    private Client buildClient() {
        Client client = Client.create();
        client.setFollowRedirects(true); // in case the service redirects
        return client;
    }

    private WebResource buildWebResourceForAllStations(String urlString, Client client) {
        String url = "";
        url = ALL_STATIONS_BASE_URL_ + urlString;
        WebResource resource = client.resource(url);
        return resource;
    }

    private WebResource buildWebResourceForOneStation(String urlString, Client client) {
        String url = "";
        url = SINGLE_STATION_BASE_URL + urlString;
        WebResource resource = client.resource(url);
        return resource;
    }

    private void report(String msg, String response) {
        System.out.println("\n" + msg + response);
    }
}
