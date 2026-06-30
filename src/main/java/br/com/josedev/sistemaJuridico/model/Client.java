package br.com.josedev.sistemaJuridico.model;

import br.com.josedev.sistemaJuridico.enums.MaritalStatus;
import br.com.josedev.sistemaJuridico.enums.PersonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    private String fullName;
    private String cpf;
    private String rg;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    private String profession;
    private String nationality;
    private String phone;
    private String secondaryPhone;
    private String email;
    private String whatsapp;
    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String howDidYouMeetUs;
    private String observations;
}
