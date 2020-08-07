package com.example.demo.component;

import com.example.demo.dto.PrinterDto;
import com.example.demo.model.Printer;
import com.example.demo.service.Integration.IntegrationComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ComponentTest {

        @Mock
        private RestTemplate restTemplate;

        @InjectMocks
        private IntegrationComponent empService = new IntegrationComponent();


        @Test
        public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
            Printer p = createPrinter();
            List<Printer> list=new ArrayList<>();
            list.add(p);
            Mockito.when(restTemplate.exchange(
                    "http://localhost:8082/printer/", HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Printer>>() {
                    })).thenReturn(new ResponseEntity(list, HttpStatus.OK));

            ResponseEntity<List<Printer>> employee = empService.read();
            Assert.assertEquals( ResponseEntity.ok(list), employee);
        }

        private Printer createPrinter() {
            return Printer.builder().brand("aa").model("b").os("os").impressions(new ArrayList<>()).build();
        }
    }


