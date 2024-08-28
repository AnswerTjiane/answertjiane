package com.assignment.senior001.answertjiane.controller;

import com.assignment.senior001.answertjiane.dto.Emission;
import com.assignment.senior001.answertjiane.helper.ObjectMapper;
import com.assignment.senior001.answertjiane.service.EmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emissions")
public class EmissionController {

        private final ObjectMapper mapper;
        private EmissionService emissionService;

        public EmissionController(ObjectMapper mapper, EmissionService emissionService) {
            this.mapper = mapper;
            this.emissionService = emissionService;
        }

        @PostMapping("/create-emission-for-office/{officeName}")
        public ResponseEntity createEmission(@RequestBody Emission emission, @PathVariable String officeName) {
            return ResponseEntity.ok(emissionService.createEmission(emission, officeName));
        }


        @GetMapping
        public List<Emission> getAllEmissions() {
            return emissionService.getAllEmissions();
        }

        @GetMapping("/office/{officeName}")
        public List<Emission> getEmissionsByOffice(@PathVariable String officeName) {
            return emissionService.getEmissionsByOffice(officeName);
        }

        @GetMapping("/source/{emissionSource}")
        public List<Emission> getEmissionsBySource(@PathVariable String emissionSource) {
            return emissionService.getEmissionsBySource(emissionSource);
        }

//        @GetMapping("/total")
//        public double calculateTotalEmissions() {
//            return emissionService.calculateTotalEmissions();
//        }

        @GetMapping("/total/{officeId}")
        public double calculateTotalEmissionsForOffice(@PathVariable String officeName) {
            return emissionService.calculateTotalEmissionsForOffice(officeName);
        }

        @GetMapping("/average/{emissionSource}")
        public double calculateAverageEmissionsForSource(@PathVariable String emissionSource) {
            return emissionService.calculateAverageEmissionsForSource(emissionSource);
        }
}
