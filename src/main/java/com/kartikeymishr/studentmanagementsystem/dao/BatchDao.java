package com.kartikeymishr.studentmanagementsystem.dao;

import com.kartikeymishr.studentmanagementsystem.model.Batch;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BatchDao {

    boolean save(Batch batch);

    Batch get(String batchId);

    List<Batch> getAllBatches();

    void delete(Batch batch);
}
