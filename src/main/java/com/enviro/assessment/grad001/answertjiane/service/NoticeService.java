package com.enviro.assessment.grad001.answertjiane.service;

import com.enviro.assessment.grad001.answertjiane.DTO.NoticeReportRequest;
import com.enviro.assessment.grad001.answertjiane.DTO.NoticeRequest;
import com.enviro.assessment.grad001.answertjiane.entity.Investor;
import com.enviro.assessment.grad001.answertjiane.entity.Notice;
import com.enviro.assessment.grad001.answertjiane.entity.Product;
import com.enviro.assessment.grad001.answertjiane.repository.InvestorRepository;
import com.enviro.assessment.grad001.answertjiane.repository.NoticeRepository;
import com.enviro.assessment.grad001.answertjiane.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private ProductRepository productRepository;
    private InvestorRepository investorRepository;
    private NoticeRepository noticeRepository;
    boolean ageFlag;

    public String createWithdrawalNotice(NoticeRequest request) {
        Product product = productRepository.findByIdAndProductType(request.getUserId(), request.getProductType()).orElse(null);
        if(product == null){
            return "selected product does not exist";
        }else {
            Investor investor = investorRepository.findById(request.getUserId()).orElse(null);
            if (request.getAmount()> product.getBalance()){
                return "cannot withdraw amount greater than current balance";
            }
            if (request.getAmount()> product.getBalance()*0.9){
                return "cannot withdraw amount greater than 90% of current balance";
            }
            if(request.getProductType().equalsIgnoreCase("retirement") && investor.getAge()<65) {
                return "cannot withdraw on retirement if age is under 65";
            }
            createNotice(request, investor);
            return "Notice created";
            }
    }

    public String retrieveNoticeReport(NoticeReportRequest request) {
        List<Notice> noticeList = noticeRepository.findByDateRange(request.getUserId(), request.getProductType(), request.getStartDate(), request.getEndDate());
        StringBuilder csvString = new StringBuilder();
        csvString.append("id,ProductType,Amount,AccountNumber,UpdatedAt\n");
        for (Notice notice: noticeList) {
            csvString.append(notice.getId()).append(",");
            csvString.append(notice.getProductType()).append(",");
            csvString.append(notice.getAmount()).append(",");
            csvString.append(notice.getAccountNumber()).append(",");
            csvString.append(notice.getUpdatedAt()).append(",").append("\n");
        }

        return csvString.toString();
    }

    private void createNotice(NoticeRequest request, Investor investor) {
        Notice notice = new Notice();
        notice.setAmount(request.getAmount());
        notice.setProductType(request.getProductType());
        notice.setAccountNumber(request.getAccountNumber());
        notice.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        notice.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
        notice.setUser(investor);
        noticeRepository.save(notice);
    }

    @Autowired
    public void setInvestorRepository(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setNoticeRepository(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }
}
