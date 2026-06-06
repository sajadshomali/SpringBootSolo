package com.example.springbootpractice.model;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationTime;

    private LocalDateTime deleted;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }


}