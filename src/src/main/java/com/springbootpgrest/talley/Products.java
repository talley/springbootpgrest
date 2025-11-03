package com.springbootpgrest.talley;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private boolean available;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Products() {
    }

    public Products(String name, double price, boolean available, Date created_at, Date updated_at, Date deleted_at) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
