package com.soft.rtemplate.web.rest;

import com.soft.rtemplate.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RTemplateResource {

    private final Logger log = LoggerFactory.getLogger(RTemplateResource.class);

    private static final String ENTITY_NAME = "rTemplate";

    private RestTemplate restTemplate;
    Map<String, String> uriParams;

    @GetMapping(value = "/demo")
    public String getIndex() {
        String url = "http://localhost:8203/api/enlace";
        RestTemplate restTemplate = new RestTemplate();

        UserDTO userDTO = new UserDTO();
        userDTO.setAmount(new BigDecimal(5));
        userDTO.setCardCode("1984-11");
        userDTO.setPassword("Password1!");
        userDTO.setStatus(Boolean.FALSE);
        userDTO.setUser("ston");

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDTO> requestEntity = new HttpEntity<UserDTO>(userDTO, headers);
        ResponseEntity<UserDTO> uri = restTemplate.exchange(url, HttpMethod.POST, requestEntity, UserDTO.class);

        System.out.println(uri.getBody());

        return "hola";
    }
}
