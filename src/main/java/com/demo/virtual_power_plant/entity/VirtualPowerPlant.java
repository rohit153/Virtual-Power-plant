package com.demo.virtual_power_plant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vertual_power_plant")
public class VirtualPowerPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vertual_power_plant_seq_gen")
    @SequenceGenerator(name = "vertual_power_plant_seq_gen", sequenceName = "seq_vertual_power_plant", initialValue = 1, allocationSize = 1)

    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "post_code", nullable = false, columnDefinition = "VARCHAR(250)")
    private String postcode;

    @Column(name = "capacity", nullable = false)
    private int capacity;
}
