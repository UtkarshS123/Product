package com.io.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.processing.Exclude;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long p_id;
    @Column
    private String p_name;
    @Column
    private Integer p_quantity;

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Integer getP_quantity() {
        return p_quantity;
    }

    public void setP_quantity(Integer p_quantity) {
        this.p_quantity = p_quantity;
    }
}
