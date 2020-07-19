/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ASUS-PC
 */
@Entity
@Table(name = "pemeriksaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pemeriksaan.findAll", query = "SELECT p FROM Pemeriksaan p")
    , @NamedQuery(name = "Pemeriksaan.findById", query = "SELECT p FROM Pemeriksaan p WHERE p.id = :id")
    , @NamedQuery(name = "Pemeriksaan.findByTanggal", query = "SELECT p FROM Pemeriksaan p WHERE p.tanggal = :tanggal")
    , @NamedQuery(name = "Pemeriksaan.findByDokter", query = "SELECT p FROM Pemeriksaan p WHERE p.dokter = :dokter")
    , @NamedQuery(name = "Pemeriksaan.findByDeskripsi", query = "SELECT p FROM Pemeriksaan p WHERE p.deskripsi = :deskripsi")})
public class Pemeriksaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dokter")
    private String dokter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "deskripsi")
    private String deskripsi;
    @JoinColumn(name = "pasien", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pasien pasien;

    public Pemeriksaan() {
    }

    public Pemeriksaan(Integer id) {
        this.id = id;
    }

    public Pemeriksaan(Integer id, Date tanggal, String dokter, String deskripsi) {
        this.id = id;
        this.tanggal = tanggal;
        this.dokter = dokter;
        this.deskripsi = deskripsi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPasien() {
        return pasien.getNama();
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pemeriksaan)) {
            return false;
        }
        Pemeriksaan other = (Pemeriksaan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.poliklinik.entities.Pemeriksaan[ id=" + id + " ]";
    }
    
}
