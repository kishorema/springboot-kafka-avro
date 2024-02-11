package org.poc.kafka.consumer.database.builder;

import java.util.List;
import org.poc.kafka.avro.model.Contact;
import org.poc.kafka.consumer.database.Score;
import org.poc.kafka.consumer.database.Student;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class StudentBuilder {

  public Student mapStudentAvroToEntity(org.poc.kafka.avro.model.Student avroStudent) {

    Student studentEntity = new Student();
    studentEntity.setId(avroStudent.getId());
    studentEntity.setFirstName(avroStudent.getFirstName());
    studentEntity.setLastName(avroStudent.getLastName());
    studentEntity.setRollNumber(avroStudent.getRollNumber());
    studentEntity.setClassName(avroStudent.getClassName());

    Contact avroContact = avroStudent.getContact();
    org.poc.kafka.consumer.database.Contact contact = new org.poc.kafka.consumer.database.Contact();
    contact.setMobileNumber(avroContact.getMobile());
    contact.setEmailId(avroContact.getEmailId());
    contact.setStudent(studentEntity);
    studentEntity.setContact(contact);

    Score score = null;
    List<org.poc.kafka.avro.model.Score> scoresList = avroStudent.getScores();
    if (!ObjectUtils.isEmpty(scoresList)) {
      for (org.poc.kafka.avro.model.Score score1 : scoresList) {
        score = new Score();
        score.setMarks(score1.getMarks());
        score.setSubject(score1.getSubject());
        score.setStudent(studentEntity);
        studentEntity.getScores().add(score);
      }
    }

    return studentEntity;
  }
}
