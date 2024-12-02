package com.upc.talkiaBackend.entities;

import com.upc.talkiaBackend.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suscriptions_history")
public class SuscriptionsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suscriptions_history_id", nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payments_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name ="suscriptions_id")
    private Suscription suscription;

    @ManyToOne
    @JoinColumn(name ="users_id")
    private User user;
}
