package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

//@Schema(description = "Paciente Model")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

//    @Schema(description = "nombres del paciente")
    @Size(min = 3, message = "{nombres.size}")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @NotNull
    @Size(min = 3, message = "{apellidos.size}")
    //@JsonProperty("json_apellidos")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
    @Column(name = "direccion", nullable = true, length = 150)
    private String direccion;

    @Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
    @Column(name = "telefono", nullable = true, length = 9)
    private String telefono;

   //@Email
    //@Pattern(regexp = "")
    @Column(name = "email", nullable = true, length = 55)
    private String email;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
