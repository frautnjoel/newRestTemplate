package com.example.demo.controller;

import com.example.demo.dto.PrinterDto;
import com.example.demo.service.IntegrationService;
import com.example.demo.service.IntegrationServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiControllerTest {

    ApiController apiController;
    IntegrationService service;


    @Before
    public void setUp() {
        service = mock(IntegrationService.class);
        apiController = new ApiController(service);
    }

    @Test
    public void testreadOk(){
        PrinterDto p=createPrinter();
        List<PrinterDto> list=new ArrayList<>();
        list.add(p);
        when(service.read()).thenReturn(ResponseEntity.ok(list));
        ResponseEntity<List<PrinterDto>> expected=service.read();
        ResponseEntity<List<PrinterDto>> result=apiController.read();
        Assert.assertEquals(expected,result);
    }

    private PrinterDto createPrinter() {
        return PrinterDto.builder().printer("aa").impressions(new ArrayList<>()).build();
    }
}
