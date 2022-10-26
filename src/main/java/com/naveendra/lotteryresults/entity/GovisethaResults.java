package com.naveendra.lotteryresults.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "lottery_results")
public class GovisethaResults {

    @Id
    private Integer id;

    @Column(name = "letter")
    private String letter;

    @Column(name = "number_01")
    private Integer number01;

    @Column(name = "number_02")
    private Integer number02;

    @Column(name = "number_03")
    private Integer number03;

    @Column(name = "number_04")
    private Integer number04;
}
