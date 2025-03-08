package Check.Authentication.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

public interface APIutil {

    <T> ResponseEntity<T> getCall(String url, Class<T> responseType, Map<String, String> headers);

    <T, R> ResponseEntity<T> postCall(String url, R requestBody, Class<T> responseType, Map<String, String> headers);

    <T, R> ResponseEntity<T> putCall(String url, R requestBody, Class<T> responseType, Map<String, String> headers);



}
