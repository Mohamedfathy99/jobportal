package com.fathy.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/versions/{v}")
@RequestMapping("/api/versions")
public class VersionController {


    @GetMapping(version = "1.0")
    public ResponseEntity<String> defaultVersion(){
        return ResponseEntity.ok().body("Version 1.0.0");
    }

    @GetMapping(version = "2.0+")
    // + sign here mean that will support version more than 2.0 which handled in addSupportedVersions Like here if we add 2.1 will be support as example
   //  configurer.useQueryParam("version").addSupportedVersions("1.0", "2.0","3.0").setDefaultVersion("1.0");

    public ResponseEntity<String> v2Version(){
        return ResponseEntity.ok().body("Version 2.0.0");
    }

}
