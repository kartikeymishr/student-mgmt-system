package com.kartikeymishr.studentmanagementsystem.repository;

import com.google.cloud.firestore.Firestore;
import com.kartikeymishr.studentmanagementsystem.firestore.AbstractFirestoreRepository;
import com.kartikeymishr.studentmanagementsystem.model.Batch;
import org.springframework.stereotype.Repository;

@Repository
public class BatchRepository extends AbstractFirestoreRepository<Batch> {

    public BatchRepository(Firestore firestore) {
        super(firestore, "Batch");
    }
}
