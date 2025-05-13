package com.project.traffic.domain.model;

import com.project.traffic.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Owner {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(groups = ValidationGroups.OwnerId.class)
    @Size(max = 60)
    @NotBlank
    private String name;
    @NotBlank
    @Size(max = 20)
    private String mail;

    @Column(name = "celphone")
    private String telefone;

}
