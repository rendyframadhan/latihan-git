package com.infosys.training.controller;


import com.infosys.training.model.Mahasiswa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyFirstController {

    @GetMapping("/myFirstAPI")
    public String myFirstAPIService(){
        return "API Pertamaku";
    }

    @GetMapping("/getMahasiswa")
    public ResponseEntity<Mahasiswa> getMahasiswa(){
        Mahasiswa m1 = new Mahasiswa();
        m1.setNpm("201225");
        m1.setNama("Rendy");
        m1.setTglLahir(new Date());


        return new ResponseEntity<>(m1, HttpStatus.OK);
    }

    @GetMapping("/testQueryParam")
    public ResponseEntity<Mahasiswa> testQueryParam(@RequestParam String npm, @RequestParam String nama/*, @RequestParam Date tglLahir*/){
        Mahasiswa m = new Mahasiswa();
        m.setNpm(npm);
        m.setNama(nama);
        m.setTglLahir(new Date());

        return new ResponseEntity<>(m, HttpStatus.OK);

    }

    @GetMapping("/testPathParam/{npm}")
    public String testPathParam(@PathVariable String npm){
        System.out.println("Npm : "+npm);
        return npm;
    }


}
