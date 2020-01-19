package com.ibadsamaritan.examination.isecuritytest.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "question_id")
    Question question;

    @Column(name = "is_right")
    private Boolean isRight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean isRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }
}
