package com.demo.mcrsrvc.controllers;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GetControllerTests {

    @InjectMocks
    GetController getController;

    @Mock
    RecordsService recordsService;

    @Test
    public void getRecordById_whenEmpIdGiven_returnsEmployeeRecord_thenAssertionSucceeds() {

        EmployeeRecord expectedRecord = new EmployeeRecord("123", "John", "Doe", "IT");
        String testEmpId = "123";

        Mockito.when(recordsService.getRecordByEmpId(testEmpId)).thenReturn(expectedRecord);

        EmployeeRecord actualRecord = getController.getRecordById(testEmpId);

        assertEquals(actualRecord, expectedRecord);

    }

}
