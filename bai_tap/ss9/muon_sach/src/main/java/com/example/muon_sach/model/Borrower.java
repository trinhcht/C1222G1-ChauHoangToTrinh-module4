package com.example.muon_sach.model;

import javax.persistence.*;

@Entity
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower")
    private Integer idBorrower;

    @Column(name = "name_borrower")
    private String nameBorrower;

    public Borrower() {
    }

    public Borrower(Integer idBorrower, String nameBorrower) {
        this.idBorrower = idBorrower;
        this.nameBorrower = nameBorrower;
    }

    public Integer getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(Integer idBorrower) {
        this.idBorrower = idBorrower;
    }

    public String getNameBorrower() {
        return nameBorrower;
    }

    public void setNameBorrower(String nameBorrower) {
        this.nameBorrower = nameBorrower;
    }
}
