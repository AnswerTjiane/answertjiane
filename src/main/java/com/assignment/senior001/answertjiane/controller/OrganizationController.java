package com.assignment.senior001.answertjiane.controller;

import com.assignment.senior001.answertjiane.dao.EmissionEntity;
import com.assignment.senior001.answertjiane.dto.Emission;
import com.assignment.senior001.answertjiane.dto.Office;
import com.assignment.senior001.answertjiane.dto.Organization;
import com.assignment.senior001.answertjiane.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create-org")
    public ResponseEntity createEmission(@RequestBody Organization organization) {
        organizationService.createOrg(organization);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get-org-by-name/{orgName}")
    public ResponseEntity getOrgByName(@PathVariable String orgName) {
        return ResponseEntity.ok(organizationService.getOrganizationByName(orgName));
    }

    @PostMapping("/create-office-and-emissions/{orgName}")
    public ResponseEntity createOfficeAndEmissions(@RequestBody Office office, @PathVariable String orgName) {
        organizationService.createOfficeAndEmissions(office, orgName);
        return ResponseEntity.ok("Created");
    }
}
