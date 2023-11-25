package org.jb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_title")
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
    @Column(name = "book_limit")
    private String bookLimit;
    @Column(name = "delay_fine")
    private BigDecimal delayFine;
    @Column(name = "photo_key")
    private String photoKey;
    @Column(name = "description")
    private String description;
}
