package com.konanov.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("http://notification-service")
public interface NotificationVersionResource {
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    String version();
}
