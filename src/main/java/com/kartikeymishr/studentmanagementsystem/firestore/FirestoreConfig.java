package com.kartikeymishr.studentmanagementsystem.firestore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirestoreConfig {

    @Bean
    public Firestore getFirestore() throws IOException {
        FileInputStream serviceAccount = new FileInputStream(
                "E:\\Workspaces\\Builds\\SMS\\Student Management System\\student-mgmt-system-e4091-firebase-adminsdk-ghtf4-efd91b5301.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirestoreOptions options = FirestoreOptions.newBuilder().setCredentials(credentials).build();

        return options.getService();
    }
}
