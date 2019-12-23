package com.springApp.user;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
}
