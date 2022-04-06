package com.demo.mcrsrvc.controllers;

import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class GetController {

    RecordsService recordsService;

    @Autowired
    public GetController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

//    @GetMapping("/all")
//    public List<EmployeeRecord> getAllRecords() {
//        // TODO: Implement live data
//        List<EmployeeRecord> employeeRecords = new ArrayList<>();
//        employeeRecords.add(new EmployeeRecord("123", "John", "Doe", "IT"));
//        employeeRecords.add(new EmployeeRecord("321", "Jane", "Doe", "Finance"));
//
//        return employeeRecords;
//    }

    @GetMapping
    @ResponseBody
    public EmployeeRecord getRecordById(@RequestParam String empId) {

        return recordsService.getRecordByEmpId(empId);

    }

}
