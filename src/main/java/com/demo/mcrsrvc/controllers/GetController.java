package com.demo.mcrsrvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class GetController {

    RecordsService recordsService;

    @Autowired
    public GetController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @GetMapping
    public EmployeeRecord getRecordById(@RequestParam String empId) {
        return recordsService.getRecordByEmpId(empId);
    }

}
