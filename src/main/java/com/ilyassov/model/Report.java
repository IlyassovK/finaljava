package com.ilyassov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "report")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Report {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "product_id")
    private int product_id;

}
