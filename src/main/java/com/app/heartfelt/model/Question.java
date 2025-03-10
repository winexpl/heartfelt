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
@Table(name  =  "questions",  schema  =  "public")
public class Question {
    @Id
    @Column(name = "q_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "q_u_id", nullable = false)
    private UUID userId;

    @Column(name = "q_text", nullable = false)
    private String text;

    @Column(name = "q_created_at")
    private ZonedDateTime createdAt;
}