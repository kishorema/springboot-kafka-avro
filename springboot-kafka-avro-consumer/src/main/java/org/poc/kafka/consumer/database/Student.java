package org.poc.kafka.consumer.database;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student implements Serializable {
  private static final long serialVersionUID = -3490500519219939026L;

  @Id
  @jakarta.validation.constraints.Size(max = 36)
  @Column(name = "id", nullable = false, length = 36)
  private String id;

  @jakarta.validation.constraints.NotNull
  @Column(name = "roll_number", nullable = false)
  private Integer rollNumber;

  @jakarta.validation.constraints.Size(max = 50)
  @jakarta.validation.constraints.NotNull
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @jakarta.validation.constraints.Size(max = 50)
  @jakarta.validation.constraints.NotNull
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @jakarta.validation.constraints.Size(max = 50)
  @jakarta.validation.constraints.NotNull
  @Column(name = "class_name", nullable = false, length = 50)
  private String className;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id", referencedColumnName = "id")
  private Contact contact;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
  private Set<Score> scores = new LinkedHashSet<>();
}
