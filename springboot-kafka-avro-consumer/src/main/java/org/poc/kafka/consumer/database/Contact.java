package org.poc.kafka.consumer.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contact")
@NoArgsConstructor
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
  @SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @OneToOne(mappedBy = "contact")
  private Student student;

  @jakarta.validation.constraints.Size(max = 50)
  @jakarta.validation.constraints.NotNull
  @Column(name = "email_id", nullable = false, length = 50)
  private String emailId;

  @jakarta.validation.constraints.Size(max = 10)
  @jakarta.validation.constraints.NotNull
  @Column(name = "mobile_number", nullable = false, length = 10)
  private String mobileNumber;

  Contact(String emailId, String mobileNumber) {
    this.emailId = emailId;
    this.mobileNumber = mobileNumber;
  }
}
