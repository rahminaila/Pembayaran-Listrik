package com.prosigmaka.ProjectBaru.model.entity;
import javax.persistence.*;

@Entity
@Table(name="t_plistrik")
public class PenggunaListrik {
    @Id
    @Column
    private String idPengguna;
    @Column
    private String namaPengguna;
    @Column
    private String alamat;
    @Column
    private String golonganDaya;
    @Column
    private Long kwh;
    @Column
    private Long biaya;
}
