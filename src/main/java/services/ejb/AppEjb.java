package services.ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import services.interfaces.AppServices;

@Singleton
@ApplicationScoped
public class AppEjb implements AppServices {

    private Gson gson;
    private GsonBuilder builder;

    public AppEjb() {
        builder = new GsonBuilder();
        gson = builder.create();
    }

    @Override
    public Object methodGet(String url, Class clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET, entity, clazz);
            if (response != null) {
                return response.getBody();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List methodListGet(String url, Class clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<Object[]> response = restTemplate.exchange(uri, HttpMethod.GET, entity, clazz);
            if (response != null) {
                return Arrays.asList(response.getBody());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Object methodPost(Object data, String url, Class clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);

            // Convierte el objeto a JSON
            String jsonData = gson.toJson(data);

            HttpEntity<String> entity = new HttpEntity<>(jsonData, headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST, entity, clazz);

            if (response != null) {
                return response.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List methodListPost(Object data, String url, Class clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType((MediaType.APPLICATION_JSON));
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<Object[]> response = restTemplate.exchange(uri, HttpMethod.POST, entity, clazz);
            if (response != null) {
                return Arrays.asList(response.getBody());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
