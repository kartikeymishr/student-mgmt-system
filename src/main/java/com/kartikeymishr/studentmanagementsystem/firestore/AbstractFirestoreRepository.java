package com.kartikeymishr.studentmanagementsystem.firestore;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public abstract class AbstractFirestoreRepository<T> {

    private final CollectionReference collectionReference;
    private final String collectionName;
    private final Class<T> parameterizedType;

    protected AbstractFirestoreRepository(Firestore firestore, String collectionName) {
        this.collectionReference = firestore.collection(collectionName);
        this.collectionName = collectionName;
        this.parameterizedType = getParameterizedType();
    }

    private Class<T> getParameterizedType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * Saves a new document
     *
     * @param model Document to be saved
     * @return true if save was successful, false otherwise
     */
    public boolean save(T model) {
        String documentId = getDocumentId(model);
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).set(model);

        try {
            System.out.println(collectionName + " " + documentId + " saved at " + resultApiFuture.get().getUpdateTime());
            return true;
        } catch (InterruptedException | ExecutionException e) {
//            log.error("Error saving {}={} {}", collectionName, documentId, e.getMessage());
            System.err.println("Error saving " + collectionName + documentId + e.getMessage());
        }

        return false;

    }

    /**
     * Deletes the specified document
     *
     * @param model Document to be deleted
     */
    public void delete(T model) {
        String documentId = getDocumentId(model);
        ApiFuture<WriteResult> resultApiFuture = collectionReference.document(documentId).delete();

    }

    /**
     * Retrieves all Documents from a Collection
     *
     * @return List of all Documents
     */
    public List<T> retrieveAll() {
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.get();

        try {
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();

            return queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(parameterizedType))
                    .collect(Collectors.toList());

        } catch (InterruptedException | ExecutionException e) {
//            log.error("Exception occurred while retrieving all document for {}", collectionName);
            System.err.println("Exception occurred while retrieving all document for " + collectionName);
        }
        return Collections.<T>emptyList();

    }


    /**
     * Fetches a particular Document
     *
     * @param documentId Identifier for the document to be fetched
     * @return Optional object wrapped around Document if found, else empty Optional
     */
    public Optional<T> get(String documentId) {
        DocumentReference documentReference = collectionReference.document(documentId);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();

        try {
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {
                return Optional.ofNullable(documentSnapshot.toObject(parameterizedType));
            }

        } catch (InterruptedException | ExecutionException e) {
//            log.error("Exception occurred retrieving: {} {}, {}", collectionName, documentId, e.getMessage());
            System.err.println("Exception occurred retrieving:" + collectionName + documentId + e.getMessage());
        }

        return Optional.empty();

    }

    protected String getDocumentId(T t) {
        Object key;
        Class clazz = t.getClass();

        do {
            key = getKeyFromFields(clazz, t);
            clazz = clazz.getSuperclass();
        } while (key == null && clazz != null);

        if (key == null) {
            return UUID.randomUUID().toString();
        }

        return String.valueOf(key);
    }

    private Object getKeyFromFields(Class<?> clazz, Object t) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DocumentId.class))
                .findFirst()
                .map(field -> getValue(t, field))
                .orElse(null);
    }

    private Object getValue(Object t, Field field) {
        field.setAccessible(true);

        try {
            return field.get(t);
        } catch (IllegalAccessException ex) {
            // TODO: Logging
            System.err.println("Error in getting Document key " + ex.getMessage());
        }

        return null;
    }

    protected CollectionReference getCollectionReference() {
        return this.collectionReference;
    }

    protected Class<T> getType() {
        return this.parameterizedType;
    }
}
