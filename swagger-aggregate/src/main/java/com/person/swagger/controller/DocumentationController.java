package com.person.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.person.swagger.config.SwaggerConfiguration;
import com.person.swagger.model.Resource;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

    private SwaggerConfiguration swaggerConfiguration;

    @Autowired
    public DocumentationController(SwaggerConfiguration swaggerConfiguration){
        this.swaggerConfiguration = swaggerConfiguration;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        for(Resource resource : this.swaggerConfiguration.getResources()){
            resources.add(createSwaggerResource(resource));
        }

        return resources;
    }

    private SwaggerResource createSwaggerResource(Resource resource) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(resource.getName());
        swaggerResource.setLocation(resource.getUrl());
        swaggerResource.setSwaggerVersion(resource.getVersion());
        return swaggerResource;
    }
}
