package com.soft.rtemplate.web.rest;

import com.soft.rtemplate.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class RTemplateResource {

    private final Logger log = LoggerFactory.getLogger(RTemplateResource.class);

    private static final String ENTITY_NAME = "rTemplate";

    @GetMapping(value = "/demo")
    public String getIndex() {
        String url = "http://localhost:8202/api/enlace";


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserDTO> greeting = restTemplate.getForEntity(url, UserDTO.class);
        // LOGGER.info(greeting.getBody().getValue());


        UserDTO userDTO = new UserDTO();
        userDTO.setAmount(new BigDecimal(10));
        userDTO.setCardCode("1984-11");
        userDTO.setPassword("Password1!");
        userDTO.setStatus(Boolean.FALSE);
        userDTO.setUser("ston");

        //myGreeting.setValue("Hey ho!");
        HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(userDTO);
        restTemplate.exchange(url, HttpMethod.PUT, entity, UserDTO.class);

        return "hola";
    }
}
