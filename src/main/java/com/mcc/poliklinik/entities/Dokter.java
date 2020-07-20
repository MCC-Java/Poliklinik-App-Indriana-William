/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS-PC
 */
@Entity
@Table(name = "dokter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokter.findAll", query = "SELECT d FROM Dokter d")
    , @NamedQuery(name = "Dokter.findById", query = "SELECT d FROM Dokter d WHERE d.id = :id")
    , @NamedQuery(name = "Dokter.findByNama", query = "SELECT d FROM Dokter d WHERE d.nama = :nama")
    , @NamedQuery(name = "Dokter.findByPoli", query = "SELECT d FROM Dokter d WHERE d.poli = :poli")})
public class Dokter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "poli")
    private String poli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dokter", fetch = FetchType.LAZY)
    private List<Pemeriksaan> pemeriksaanList;

    public Dokter() {
    }

    public Dokter(String id) {
        this.id = id;
    }

    public Dokter(String id, String nama, String poli) {
        this.id = id;
        this.nama = nama;
        this.poli = poli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    @XmlTransient
    public List<Pemeriksaan> getPemeriksaanList() {
        return pemeriksaanList;
    }

    public void setPemeriksaanList(List<Pemeriksaan> pemeriksaanList) {
        this.pemeriksaanList = pemeriksaanList;
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
        if (!(object instanceof Dokter)) {
            return false;
        }
        Dokter other = (Dokter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.poliklinik.entities.Dokter[ id=" + id + " ]";
    }
    
}
