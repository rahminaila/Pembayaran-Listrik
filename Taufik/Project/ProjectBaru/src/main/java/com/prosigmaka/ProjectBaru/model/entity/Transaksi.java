package com.prosigmaka.ProjectBaru.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_transaksi")
public class Transaksi {
    @Id
    @Column//pk
    private Long noTransaksi;
    @OneToOne//fk
    private Tagihan noTagihan;
    @ManyToOne
    private PenggunaListrik idPenggunaListrik;
    @ManyToOne
    private User idUser;
    @Column
    private Date tanggal;
    @Column
    private Long biaya;
}
