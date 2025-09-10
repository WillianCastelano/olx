package com.mvpolx.olx.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Long number;
    private String complement;
    private String district;
    private String city;
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private Uf uf; // RJ, SP, MG

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
