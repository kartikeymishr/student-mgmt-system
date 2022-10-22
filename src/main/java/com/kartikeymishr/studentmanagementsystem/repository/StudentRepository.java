package com.kartikeymishr.studentmanagementsystem.repository;

import com.google.cloud.firestore.Firestore;
import com.kartikeymishr.studentmanagementsystem.model.entity.Student;
import com.kartikeymishr.studentmanagementsystem.firestore.AbstractFirestoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends AbstractFirestoreRepository<Student> {

    protected StudentRepository(Firestore firestore) {
        super(firestore, "Student");
    }

}
