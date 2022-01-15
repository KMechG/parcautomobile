package com.parc.rest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Automobile {
    @Id
    private String id;
    private String matricule;
    private String categorie;
    private String marque;
    private String model;
    private String etat;

}
