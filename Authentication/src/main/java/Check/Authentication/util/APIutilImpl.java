package Check.Authentication.util;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class APIutilImpl implements APIutil {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public <T> ResponseEntity<T> getCall(String url, Class<T> responseType, Map<String, String> headers) {
        HttpHeaders httpHeaders = createHeaders(headers);
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
    }

    @Override
    public <T, R> ResponseEntity<T> postCall(String url, R requestBody, Class<T> responseType, Map<String, String> headers) {
        HttpHeaders httpHeaders = createHeaders(headers);
        HttpEntity<R> entity = new HttpEntity<>(requestBody, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
    }

    @Override
    public <T, R> ResponseEntity<T> putCall(String url, R requestBody, Class<T> responseType, Map<String, String> headers) {
        HttpHeaders httpHeaders = createHeaders(headers);
        HttpEntity<R> entity = new HttpEntity<>(requestBody, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, responseType);
    }

    private HttpHeaders createHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach(httpHeaders::set);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
