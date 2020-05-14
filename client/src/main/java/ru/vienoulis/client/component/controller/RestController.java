package ru.vienoulis.client.component.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import ru.vienoulis.client.component.model.Role;
import ru.vienoulis.client.component.model.User;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public RestController(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = "http://localhost:8082";
    }

    public User getUserByName(String name) {
        return restTemplate.exchange(
                serverUrl + "/GET/user?name=" + name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                }
        ).getBody();
    }

    public List<Role> getAllRoles() {
        return restTemplate.exchange(
                serverUrl + "/GET/role/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                }
        ).getBody();
    }

    public List<User> getUsers() {
        return restTemplate.exchange(
                serverUrl + "GET/user_list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        ).getBody();
    }

    public void addUser(User user) {
        restTemplate.postForEntity(
                serverUrl + "/POST/add/user",
                user,
                User.class
        );

    }

    public void update(User user) {
        restTemplate.put(
                serverUrl + "/POST/update",
                user
        );
    }

    public long delete(Long userId) {
        restTemplate.delete(
                serverUrl + "POST/delete?id=" + userId);
        return userId;
    }

    public User getUserById(Long id) {
        HttpEntity<Long> stringHttpEntity = new HttpEntity<>(id);
        return restTemplate.exchange(
                serverUrl + "/GET/user/by_id?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                }
        ).getBody();
    }

    public Role getRoleByName(String name) {
        return restTemplate.exchange(
                serverUrl + "/GET/role/by_name?name=" + name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Role>() {
                }
        ).getBody();
    }
}
