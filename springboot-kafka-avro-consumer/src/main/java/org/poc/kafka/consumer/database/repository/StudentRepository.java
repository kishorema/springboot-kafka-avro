package org.poc.kafka.consumer.database.repository;

import org.poc.kafka.consumer.database.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {}
