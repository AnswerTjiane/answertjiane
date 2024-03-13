package com.enviro.assessment.grad001.answertjiane.controller;

import com.enviro.assessment.grad001.answertjiane.DTO.NoticeReportRequest;
import com.enviro.assessment.grad001.answertjiane.DTO.NoticeRequest;
import com.enviro.assessment.grad001.answertjiane.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/enviro365/investment/v1")
public class NoticeController {

    private NoticeService noticeService;

    @PostMapping("create-withdrawal-notice")
    public ResponseEntity<String> createNotice(@RequestBody NoticeRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(noticeService.createWithdrawalNotice(request));
    }

    @PostMapping("/withdrawal-notice-report")
    public ResponseEntity<byte[]> downloadCSV(@RequestBody NoticeReportRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData("filename", "data.csv");

        try {
            InputStream inputStream = new ByteArrayInputStream(noticeService.retrieveNoticeReport(request).getBytes(StandardCharsets.UTF_8));
            byte[] csvBytes = new byte[inputStream.available()];
            inputStream.read(csvBytes, 0, inputStream.available());

            return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Autowired
    public void setNoticeService(NoticeService noticeService){
        this.noticeService = noticeService;
    }
}
