package com.demo.mcrsrvc.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.mcrsrvc.repositories.RecordsRepository;
import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.util.exceptions.InvalidRequestException;
import com.demo.mcrsrvc.util.exceptions.ResourceNotFoundException;

import java.util.Optional;

/**
 * The RecordsService Class is responsible for applying business logic to incoming HTTP Requests from the Controller
 * layer and passing them to the Data Access layer for querying the Employee Records collection.
 */
@Service
public class RecordsService {

    private final RecordsRepository recordsRepository;

    @Autowired
    public RecordsService(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    /**
     * This method verifies the empId is valid/not null and then passes the value to the RecordsRepository. If no record
     * is returned, will throw ResourceNotFoundException.
     * @param empId - employee ID for query.
     * @return - employee record with the employee ID queried.
     */
    public EmployeeRecord getRecordByEmpId(String empId) {

        if(empId == null || empId.trim().isEmpty()) {
            throw new InvalidRequestException("empId is invalid!");
        }

        return Optional.ofNullable(recordsRepository.findRecordByEmpId(empId))
                .orElseThrow(() -> new ResourceNotFoundException("No record found under empId: " + empId));

    }

}
