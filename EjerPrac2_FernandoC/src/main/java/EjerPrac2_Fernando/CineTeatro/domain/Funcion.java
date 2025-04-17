/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.domain;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ferna
 */

@Entity
@Table(name = "funciones")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    private LocalDate fecha;
    private LocalTime hora;
    private String sala;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
}

