package com.cg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalserviceTest {
    private CalculatorService service;

    @BeforeEach
    public void init(){
        ICalculator cal = Mockito.mock(ICalculator.class);
        service = new CalculatorService(cal);
        when(cal.calculate(20,5)).thenReturn(25);

    }
    @Test
    void addServiceTest(){
        assertEquals(25,service.addService(20,5));
    }
}
