package com.prosigmaka.ProjectBaru.model.dto;


import javax.persistence.Column;

public class MahasiswaDto {
    private Long NIM;
    private String nama;
    private String alamat;

    public Long getNIM() {
        return NIM;
    }

    public void setNIM(Long NIM) {
        this.NIM = NIM;
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
