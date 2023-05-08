package org.example.Service;

import org.example.Domain.Tranzactie;
import org.example.Repository.TranzactieDbRepository;

import java.util.ArrayList;
import java.util.List;

public class Service {
    TranzactieDbRepository repoTranzactie;


    public Service(TranzactieDbRepository repoTranzactie){
        this.repoTranzactie=repoTranzactie;
    }

    public Iterable<Tranzactie> getAll(){
        return repoTranzactie.findAll();
    }


    public List<Tranzactie> getListTranzactii(){
        Iterable<Tranzactie> utilizatorIterable = repoTranzactie.findAll();
        List<Tranzactie> listaTranzactilor = new ArrayList<>();
        utilizatorIterable.forEach(listaTranzactilor::add);
        return listaTranzactilor;
    }

}


