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
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrow_id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "from_date")
    private String fromDateTime;
    @Column(name = "to_date")
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
    @Column(name = "description")
    private String description;
}
