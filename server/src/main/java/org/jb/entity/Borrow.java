package org.jb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "from")
    private String fromDateTime;
    @Column(name = "to")
    private String toDateTime;
    @Column(name = "total_day")
    private String totalDay;
    @Column(name = "checkin")
    private String checkinDateTime;
    @Column(name = "checkout")
    private String checkoutDateTime;
    @Column(name = "return_total_day")
    private String returnTotalDay;
    @Column(name = "delay_fine")
    private BigDecimal delayFine;
    @Column(name = "status")
    private String status;
    @Column(name = "desc")
    private String desc;
}
