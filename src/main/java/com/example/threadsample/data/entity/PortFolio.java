package com.example.threadsample.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "portfolio", indexes = {
        @Index(name = "idx_portfolio_idx", columnList = "idx")
})
public class PortFolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String deadline;

    @Column(nullable = false)
    private String header;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image_path;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PortFolio portFolio = (PortFolio) o;
        return idx != null && Objects.equals(idx, portFolio.idx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
