package com.ps.ccms.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
@Setter
public class Card {

    @Column
    @Pattern(regexp = "^[a-zA-Z0-9 ,.-]{1,40}$")
    @NotNull
    private String name;

    @Id
    @Pattern(regexp = "^[0-9]{16,19}$")
    @NotNull
    private String ccNumber;

    @Column
    private Double balance = Double.valueOf(0);

    @Column
    @NotNull
    @JsonProperty("limit")
    private Double amountLimit;
}
