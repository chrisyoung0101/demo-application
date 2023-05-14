package com.example.demo.repository;

import com.example.demo.model.CombinedDataEntity;
import com.example.demo.pojo.CombinedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinedDataRepository extends JpaRepository<CombinedDataEntity, Long> {
    //CombinedDataEntity save(CombinedDataEntity combinedDataEntity);
}


// The "unchecked operation" warning occurs when you uncomment the line
// `//CombinedDataEntity save(CombinedDataEntity combinedDataEntity);`
// in your `CombinedDataRepository` interface.
//
// The warning is related to type safety. When you extend the `JpaRepository` interface,
// it provides default implementations for various CRUD operations, including the `save` method.
// The signature of the `save` method in `JpaRepository` is `S save(S entity)`,
// where `S` is the type of the entity being saved.
//
// By uncommenting the line `//CombinedDataEntity save(CombinedDataEntity combinedDataEntity);`,
// you're defining a method with the same name and parameter type as the default `save` method
// in `JpaRepository`. This creates a conflict because the method signatures are identical,
// and it may lead to confusion or unexpected behavior.
//
// To avoid the conflict and the "unchecked operation" warning, you can safely remove
// the line `//CombinedDataEntity save(CombinedDataEntity combinedDataEntity);` from your
// `CombinedDataRepository` interface. The default `save` method provided by `JpaRepository`
// will be used for saving `CombinedDataEntity` instances.


