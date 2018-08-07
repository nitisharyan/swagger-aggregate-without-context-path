package com.person.sam.swagger.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.person.sam.swagger.model.Resource;

@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfiguration {

    private List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}