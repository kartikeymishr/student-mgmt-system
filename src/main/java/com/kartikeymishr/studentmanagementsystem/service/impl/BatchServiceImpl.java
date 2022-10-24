package com.kartikeymishr.studentmanagementsystem.service.impl;

import com.kartikeymishr.studentmanagementsystem.dao.impl.BatchDaoImpl;
import com.kartikeymishr.studentmanagementsystem.model.Batch;
import com.kartikeymishr.studentmanagementsystem.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchDaoImpl batchDao;

    @Override
    public Batch createBatch(Batch batch) {
        batchDao.save(batch);
        return batch;
    }

    @Override
    public Batch getBatchById(String batchId) {
        return batchDao.get(batchId);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchDao.getAllBatches();
    }

    @Override
    public void deleteBatch(Batch batch) {
        batchDao.delete(batch);
    }
}
