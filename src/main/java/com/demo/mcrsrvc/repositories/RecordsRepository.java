package com.demo.mcrsrvc.repositories;

import com.demo.mcrsrvc.models.EmployeeRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecordsRepository extends MongoRepository<EmployeeRecord, String> {

    @Query("{name:'?0'}")
    EmployeeRecord findRecordByEmpId(String empId);

    @Query(value="{category:'?0'}", fields="{'firstName' : 1, 'quantity' : 1}")
    List<EmployeeRecord> findAll(String category);

    public long count();

}


