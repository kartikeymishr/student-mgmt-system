package com.kartikeymishr.studentmanagementsystem.service;

import com.kartikeymishr.studentmanagementsystem.model.Batch;
import com.kartikeymishr.studentmanagementsystem.request.BatchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatchService {

    Batch createBatch(Batch batch);

    Batch getBatchById(String batchId);

    List<Batch> getAllBatches();

    void deleteBatch(Batch batch);
}
