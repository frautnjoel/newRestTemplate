package com.example.demo.service;

import com.example.demo.dto.PrinterDto;
import com.example.demo.model.Printer;
import com.example.demo.service.Integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegrationService {
    IntegrationComponent integrationComponent;
@Autowired
    public IntegrationService(IntegrationComponent integrationComponent) {
        this.integrationComponent = integrationComponent;
    }


    public ResponseEntity<List<PrinterDto>> read() {
    List<PrinterDto> list=new ArrayList<>();
    List<Printer> result= integrationComponent.read().getBody();
    for(Printer e: result){
     list.add(new PrinterDto(e.getBrand()+e.getModel(),e.getImpressions()));
    }
    return  ResponseEntity.ok(list);
    }
}
