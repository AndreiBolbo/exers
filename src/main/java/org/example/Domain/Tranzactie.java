package org.example.Domain;

import org.example.Tematica;

import java.lang.*;

public class Tranzactie {
    long id;
    String trimitator;
    String destinatar;
    String descriere;
    Double suma;

    public Tranzactie(long id, String trimitator, String destinatar, String descriere, Double suma) {
        this.id = id;
        this.trimitator = trimitator;
        this.destinatar = destinatar;
        this.descriere = descriere;
        this.suma = suma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriere() {
        return descriere;
    }

    public Double getSuma() {
        return suma;
    }

    public String getDestinatar() {
        return destinatar;
    }

    public String getTrimitator() {
        return trimitator;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setTrimitator(String trimitator) {
        this.trimitator = trimitator;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public void setDestinatar(String destinatar) {
        this.destinatar = destinatar;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "id=" + id +
                ", trimitator='" + trimitator + '\'' +
                ", destinatar='" + destinatar + '\'' +
                ", descriere='" + descriere + '\'' +
                ", suma=" + suma +
                '}';
    }
// @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pictor pictor1 = (Pictor) o;
//        return Objects.equals(titlu, pictor1.titlu) && Objects.equals(pictor, pictor1.pictor) && enumerare == pictor1.enumerare && Objects.equals(celebritate, pictor1.celebritate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(titlu, pictor, enumerare, celebritate);
//    }



}
