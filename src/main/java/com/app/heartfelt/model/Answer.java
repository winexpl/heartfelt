package com.app.heartfelt.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name  =  "answers",  schema  =  "public")
public class Answer {
    @Id
    @Column(name = "a_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "a_q_id", nullable = false)
    private UUID questionId;

    @Column(name = "a_p_id", nullable = false)
    private UUID psychologistId;

    @Column(name = "a_text", nullable = false)
    private String text;

    @Column(name = "a_created_at")
    private ZonedDateTime createdAt;
}
