package com.demo.mcrsrvc.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.repositories.RecordsRepository;
import com.demo.mcrsrvc.util.exceptions.InvalidRequestException;
import com.demo.mcrsrvc.util.exceptions.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RecordsServiceTests {

    @InjectMocks
    private RecordsService recordsService;

    @Mock
    RecordsRepository recordsRepository;

    @Test
    public void whenValidEmpIdGiven_andEmpIdMatchFound_thenAssertionSucceeds() {

        EmployeeRecord expectedRecord = new EmployeeRecord("123", "John", "Doe", "IT");
        String testEmpId = "123";

        Mockito.when(recordsRepository.findRecordByEmpId(testEmpId)).thenReturn(expectedRecord);

        EmployeeRecord actualRecord = recordsRepository.findRecordByEmpId(testEmpId);

        assertEquals(actualRecord, expectedRecord);

    }

    @Test
    public void whenValidEmpIdGiven_andEmpIdMatchNotFound_andResourceNotFoundExceptionThrown_thenAssertionSucceeds() {

        String testEmpId = "444";

        Mockito.when(recordsRepository.findRecordByEmpId(testEmpId)).thenReturn(null);

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                recordsService.getRecordByEmpId(testEmpId)
        ); // Non-matching empId returns null from RecordsRepository and throws ResourceNotFoundException

        // Exception message should match String below
        String expectedMessage = "No record found under empId: " + testEmpId;
        String actualMessage = exception.getLocalizedMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void whenInvalidEmpIdGiven_andInvalidRequestExceptionThrown_thenAssertionSucceeds() {

        Exception exception_1 = assertThrows(InvalidRequestException.class, () ->
                recordsService.getRecordByEmpId("")
        ); // Empty empId throws InvalidRequestException

        Exception exception_2 = assertThrows(InvalidRequestException.class, () ->
                recordsService.getRecordByEmpId("  ")
        ); // Empty empId w/ spaces throws InvalidRequestException

        Exception exception_3 = assertThrows(InvalidRequestException.class, () ->
                recordsService.getRecordByEmpId(null)
        ); // Null empId throws InvalidRequestException

        // Exception message should match String below
        String expectedMessage = "empId is invalid!";
        String actualMessage_1 = exception_1.getLocalizedMessage();
        String actualMessage_2 = exception_2.getLocalizedMessage();
        String actualMessage_3 = exception_3.getLocalizedMessage();


        assertTrue(actualMessage_1.contains(expectedMessage));
        assertTrue(actualMessage_2.contains(expectedMessage));
        assertTrue(actualMessage_3.contains(expectedMessage));

    }

}
