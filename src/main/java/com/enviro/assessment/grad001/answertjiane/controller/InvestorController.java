package com.enviro.assessment.grad001.answertjiane.controller;

import com.enviro.assessment.grad001.answertjiane.DTO.InvestorDTO;
import com.enviro.assessment.grad001.answertjiane.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enviro365/investment/v1")
public class InvestorController {

    private InvestorService investorService;

    @GetMapping(value = "/get-investor-data-by-name/{name}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<InvestorDTO> getInvestorDataByName(@PathVariable String name) throws InterruptedException {


        return ResponseEntity.status(HttpStatus.OK).body(investorService.retrieveInvestorData(name));
    }

    @Autowired
    public void setInvestorService(InvestorService investorService) {
        this.investorService = investorService;
    }
}
