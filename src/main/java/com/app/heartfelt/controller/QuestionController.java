package com.app.heartfelt.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.heartfelt.dto.QuestionDTO;
import com.app.heartfelt.service.QuestionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<QuestionDTO> findAllQuestions() {
        return questionService.findAllQuestions();
    }
    
    @GetMapping("/{userId}")
    public List<QuestionDTO> findQuestionByUserId(@PathVariable UUID userId) {
        return questionService.findQuestionByUserId(userId);
    }

    @GetMapping("/{id}")
    public QuestionDTO findQuestionById(@PathVariable UUID id) {
        return questionService.findQuestionById(id);
    }
    
    @PostMapping
    public ResponseEntity<QuestionDTO> ask(@RequestBody QuestionDTO questionDTO) {
        QuestionDTO newQuestionDTO = questionService.ask(questionDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newQuestionDTO.getId())
            .toUri();
        return ResponseEntity.created(location).body(newQuestionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable UUID id, @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ofNullable(questionService.updateQuestion(id, questionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable UUID id) {
        return ResponseEntity.noContent().build();
    }
}