package com.demo.mcrsrvc.repositories;

import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.repository.Query;
import com.demo.mcrsrvc.models.EmployeeRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

@Component
public interface RecordsRepository extends MongoRepository<EmployeeRecord, String> {

    @Query("{empId:'?0'}")
    EmployeeRecord findRecordByEmpId(String empId);

}


