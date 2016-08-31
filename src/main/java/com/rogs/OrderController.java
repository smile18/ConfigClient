package com.rogs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@Component
@RestController
public class OrderController {

    @Value("${cassandra.hostnames}")
    String hostnames;

    @Value("${cassandra.username}")
    String userName;

    @Value("${cassandra.password}")
    String passWord;

    @Value("${graphite.host}")
    String graphiteHost;

    @RequestMapping(value = "/", produces = "application/json")
    public List<String> index(){
        List<String> env = Arrays.asList(
                "userName is: " + userName,
                "passWord is: " + passWord,
                "graphite is: " + graphiteHost
        );
        return env;
    }
}
