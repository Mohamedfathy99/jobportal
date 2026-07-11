package com.fathy.backend.controller;

import com.fathy.backend.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")
public class UserController {

    @GetMapping({"/{userId}/posts/{postId}", "/{userId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariable(@PathVariable Long userId, @PathVariable(required = false)  Long postId) {
        String response = "";
        if (postId == null) {
            response = "Fetched user with id: " + userId;
        }  else {
            response = "Fetched user with id: " + userId + " and post id: " + postId;
        }
//        return response;
        return ResponseEntity.ok().body(response);
    }


    @GetMapping({"/{userId}/orders/{orderId}"})
    public String searchUserOrderWithMultiPathVariable(@PathVariable(name = "userId") Long customerId, @PathVariable Long orderId) {

            return "Fetched user with id: " + customerId + " and order id: " + orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}"})
    public String searchUserAddressWithMultiPathVariable(@PathVariable Map<String, String> pathVariablesMap) {

        return "Fetched user with id: " + pathVariablesMap.get("userId") + " and address id: " + pathVariablesMap.get("addressId");
    }

    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false, defaultValue = "Guest") String name, @RequestParam String gender) {

        return "Fetched user with query params :" + name + " and gender: " + gender ;
    }

    @GetMapping("/search/map")
    public String searchUserWithMapQueryParams(@RequestParam(required = false, defaultValue = "Guest")  Map<String, String> queryParamsMap) {

        return "Fetched user with query params :" + queryParamsMap.get("name") + " and gender: " + queryParamsMap.get("gender") ;

    }

    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent")  String userAgent,
                                     @RequestHeader(name = "User-Location", required = false, defaultValue = "Giza")   String userLocation ) {

        return "Received request with user-agent: " + userAgent + " and user location: " + userLocation;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader  Map<String, String> headersMap) {

        return "Received request with user-agent: " +  headersMap.get("User-Agent")+ " and user location: " + headersMap.get("User-Location");
    }

    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders httpHeaders) {

        return "Received request with user-agent: " +  httpHeaders.get("User-Agent")+ " and user location: " + httpHeaders.get("User-Location");
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto) {

        return "Created user with name: " + userDto.name() + " , email: " + userDto.email() + " , age: " + userDto.age() + " and gender: " + userDto.gender();
    }

    @PostMapping("request-entity")
        public ResponseEntity<String > createUserWithRequestEntity(RequestEntity<UserDto> requestEntity) {
               HttpHeaders httpHeaders =  requestEntity.getHeaders();
               UserDto userDto = requestEntity.getBody();
               String queryParams = requestEntity.getUrl().getQuery();
               String pathVariables = requestEntity.getUrl().getPath();
//               return "Created User with the data  :" + userDto.toString() ;
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header", "ExampleValue")
                .body("Created User with the data" + userDto.toString());
    }
}
