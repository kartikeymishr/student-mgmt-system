package com.kartikeymishr.studentmanagementsystem.controller;

import com.kartikeymishr.studentmanagementsystem.model.Batch;
import com.kartikeymishr.studentmanagementsystem.service.impl.BatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BatchController {

    @Autowired
    private BatchServiceImpl batchService;

    @PostMapping("/batch/create")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.createBatch(batch));
    }

    @GetMapping("/batch/get/{batchId}")
    public ResponseEntity<Batch> getBatch(@PathVariable String batchId) {
        return ResponseEntity.ok(batchService.getBatchById(batchId));
    }

    @GetMapping("batch/get/all")
    public ResponseEntity<List<Batch>> getBatches() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @DeleteMapping("batch/delete/{batchId}")
    public ResponseEntity<String> deleteBatch(@PathVariable String batchId) {
        batchService.deleteBatch(batchService.getBatchById(batchId));

        return ResponseEntity.ok("Delete successful");
    }
}
