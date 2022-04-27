package com.prosigmaka.ProjectBaru.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mahasiswa {

    @Id
    @Column(unique =true)
    private Long NIM;
    @Column(unique = true)
    private String nama;
    @Column(unique = true)
    private String username;
    @Column()
    private String password;
    @Column
    private String alamat;

    public Long getNIM() {
        return NIM;
    }

    public void setNIM(Long NIM) {
        this.NIM = NIM;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
