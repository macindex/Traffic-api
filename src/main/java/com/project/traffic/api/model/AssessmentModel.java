package com.project.traffic.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AssessmentModel {

    private Long id;
    private String description;
    private BigDecimal fineAmount;
    private OffsetDateTime dateOccurrence;
}
