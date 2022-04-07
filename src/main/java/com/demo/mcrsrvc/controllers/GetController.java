package com.demo.mcrsrvc.controllers;

import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping
    @ResponseBody
    public EmployeeRecord getRecordById(@RequestParam String empId) {
        return recordsService.getRecordByEmpId(empId);
    }

}
