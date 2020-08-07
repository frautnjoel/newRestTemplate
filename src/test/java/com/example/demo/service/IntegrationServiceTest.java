package com.example.demo.service;

import com.example.demo.dto.PrinterDto;
import com.example.demo.model.Printer;
import com.example.demo.service.Integration.IntegrationComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IntegrationServiceTest {
    IntegrationService service;

    @Mock
    IntegrationComponent dao;

    @Before
    public void setUp() {
        initMocks(this);
        service = new IntegrationService(dao);
    }

    @Test
    public void testreadOk(){
        when(dao.read()).thenReturn(ResponseEntity.ok(new ArrayList<Printer>()));
        Assert.assertEquals(ResponseEntity.ok(new ArrayList<PrinterDto>()),service.read());
    }
}
