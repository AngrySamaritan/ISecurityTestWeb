package com.ibadsamaritan.examination.isecuritytest.model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long resultId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    Test test;

}
