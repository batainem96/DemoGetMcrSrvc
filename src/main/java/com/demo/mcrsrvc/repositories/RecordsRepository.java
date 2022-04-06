package com.demo.mcrsrvc.repositories;

import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.repository.Query;
import com.demo.mcrsrvc.models.EmployeeRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Component
public interface RecordsRepository extends MongoRepository<EmployeeRecord, String> {

    @Query("{empId:'?0'}")
    EmployeeRecord findRecordByEmpId(String empId);

    @Query(value="{category:'?0'}", fields="{'firstName' : 1, 'quantity' : 1}")
    List<EmployeeRecord> findAll(String category);

    public long count();

}


