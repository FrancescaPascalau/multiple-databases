package com.francesca.pascalau.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "schema")
    private String schema;
}
