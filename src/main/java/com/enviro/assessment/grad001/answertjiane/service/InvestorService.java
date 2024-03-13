package com.enviro.assessment.grad001.answertjiane.service;

import com.enviro.assessment.grad001.answertjiane.DTO.InvestorDTO;
import com.enviro.assessment.grad001.answertjiane.DTO.ProductDTO;
import com.enviro.assessment.grad001.answertjiane.entity.Investor;
import com.enviro.assessment.grad001.answertjiane.entity.Product;
import com.enviro.assessment.grad001.answertjiane.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorService {

    private InvestorRepository investorRepository;

//    public InvestorService(){
//        Mapper
//    }

    public InvestorDTO retrieveInvestorData(String name) {
        Investor investor = investorRepository.findByName(name).orElse(null);

        return mapInvestor(investor);
    }

    private InvestorDTO mapInvestor(Investor investor){
        if (investor != null) {
            List<ProductDTO> products = new ArrayList<>();
            for(Product product: investor.getProducts()) {
                ProductDTO productDTO = new ProductDTO(product.getId(), product.getProductType(), product.getBalance(),
                        product.getCreatedAt(), product.getUpdatedAt());
                products.add(productDTO);
            }
            InvestorDTO investorDTO = new InvestorDTO(investor.getName(), investor.getSurname(), investor.getContactNumber(), investor.getCreatedAt(), investor.getUpdatedAt(),
                    investor.getLine1(), investor.getLine2(),
                    investor.getSuburb(), investor.getCity(), investor.getPostalCode(), products);
            investorDTO.setProducts(products);

            return investorDTO;
        }else {
            return null;
        }
    }


    @Autowired
    public void setInvestorRepository(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }
}