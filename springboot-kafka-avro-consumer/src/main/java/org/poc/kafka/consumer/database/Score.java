package org.poc.kafka.consumer.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "score")
@NoArgsConstructor
public class Score {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq_gen")
  @SequenceGenerator(name = "score_seq_gen", sequenceName = "score_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private int id;

  @jakarta.validation.constraints.Size(max = 25)
  @jakarta.validation.constraints.NotNull
  @Column(name = "subject", nullable = false, length = 25)
  private String subject;

  @jakarta.validation.constraints.NotNull
  @Column(name = "marks", nullable = false)
  private Integer marks;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  private Student student;

  Score(String subject, Integer marks) {
    this.subject = subject;
    this.marks = marks;
  }
}
