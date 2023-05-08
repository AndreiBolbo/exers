package org.example;

import org.example.Domain.Tranzactie;
import org.example.Repository.TranzactieDbRepository;
import org.example.Service.Service;
import org.example.UI.Ui;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/Tranzactii";
        String user="postgres";
        String parola="postgres";

        Service service = new Service(new TranzactieDbRepository(url, user, parola));
        for(Tranzactie t : service.getListTranzactii())
                System.out.println(t);
        //List<Tranzactie> pictorilist= (List<Tranzactie>) service.getListTranzactii().stream().collect(Collectors.toList());
        //System.out.println(pictorilist);
        Ui ui = new Ui(service);
        ui.start();
    }
}