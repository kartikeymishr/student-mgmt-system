package com.kartikeymishr.studentmanagementsystem.dao.impl;

import com.kartikeymishr.studentmanagementsystem.dao.BatchDao;
import com.kartikeymishr.studentmanagementsystem.model.Batch;
import com.kartikeymishr.studentmanagementsystem.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchDaoImpl implements BatchDao {

    @Autowired
    private BatchRepository repository;

    @Override
    public boolean save(Batch batch) {
        return repository.save(batch);
    }

    @Override
    public Batch get(String batchId) {
        return repository.get(batchId).orElse(null);

    }

    @Override
    public List<Batch> getAllBatches() {
        return repository.retrieveAll();
    }

    @Override
    public void delete(Batch batch) {
        repository.delete(batch);
    }
}
