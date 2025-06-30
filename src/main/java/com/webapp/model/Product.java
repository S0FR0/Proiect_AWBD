package com.webapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele produsului este obligatoriu")
    private String name;

    @NotBlank(message = "Descrierea este obligatorie")
    private String description;

    @NotNull(message = "Prețul este obligatoriu")
    @DecimalMin(value = "0.0", inclusive = false, message = "Prețul trebuie să fie pozitiv")
    private BigDecimal price;

    @NotNull(message = "Stocul este obligatoriu")
    @Min(value = 0, message = "Stocul nu poate fi negativ")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Company> companies;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public Product() {}

    public Product(String name, String description, BigDecimal price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Set<Company> getCompanies() { return companies; }
    public void setCompanies(Set<Company> companies) { this.companies = companies; }

    public Set<Order> getOrders() { return orders; }
    public void setOrders(Set<Order> orders) { this.orders = orders; }
}