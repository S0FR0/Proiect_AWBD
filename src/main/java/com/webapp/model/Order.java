package com.webapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numărul comenzii este obligatoriu")
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    private String status;

    @NotNull(message = "Totalul este obligatoriu")
    @DecimalMin(value = "0.0", inclusive = false, message = "Totalul trebuie să fie pozitiv")
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Clientul este obligatoriu")
    private Person customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public Order() {
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Order(String orderNumber, Person customer, BigDecimal totalAmount) {
        this();
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public Person getCustomer() { return customer; }
    public void setCustomer(Person customer) { this.customer = customer; }

    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }
}