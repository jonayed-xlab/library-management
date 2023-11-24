package org.jb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "category")
    private String category;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "isbn_number")
    private String isbnNumber;
    @Column(name = "series")
    private String series;
    @Column(name = "status")
    private String status;
    @Column(name = "page_no")
    private String pageNo;
    @Column(name = "limit")
    private String limit;
    @Column(name = "delay_fine")
    private BigDecimal delayFine;
    @Column(name = "photo_key")
    private String photoKey;
    @Column(name = "desc")
    private String desc;
}
