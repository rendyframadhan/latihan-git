package com.infosys.training.model;

import lombok.Data;

import java.util.Date;


@Data
public class Mahasiswa {
    private String npm;
    private String nama;
    private Date tglLahir;
}
