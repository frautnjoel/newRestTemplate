package com.example.demo.dto;

import com.example.demo.model.Impressions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrinterDto {
    private String printer;

    List<Impressions> impressions;
}
