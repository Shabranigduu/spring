package com.example.springstarter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;
}
