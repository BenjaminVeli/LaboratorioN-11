package com.tecsup.petclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialtiesTO {
    private Integer id;
    private String name;
    private String office;
    private Integer open;
    private Integer close;
}