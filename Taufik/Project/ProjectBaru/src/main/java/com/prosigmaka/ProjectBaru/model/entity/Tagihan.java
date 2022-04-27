package com.prosigmaka.ProjectBaru.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_tagihan")
public class Tagihan {

    @Id
    @Column//pk
    private Long noTagigan;
    @OneToOne//fk
    private Transaksi noTransaksi;
    @ManyToOne
    private User idUser;
    @ManyToOne
    private PenggunaListrik idPenggunaListrik;

    @Column
    private Date tanggal;
    @Column
    private long biaya;
    @Column
    private long kwh;
    @Column
    private String status;
    @Column
    private String metodePembayaran;

}
