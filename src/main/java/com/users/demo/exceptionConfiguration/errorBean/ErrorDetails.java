package com.users.demo.exceptionConfiguration.errorBean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Builder
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String details;


}
