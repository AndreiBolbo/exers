package org.example.UI;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import org.example.Domain.Tranzactie;
import org.example.Service.Service;
import java.util.Comparator;
import java.util.Objects;
public class Ui {
    private Service service;
    private Scanner scanner;

    public Ui(Service s)
    {
        this.service=s;
        this.scanner=new Scanner(System.in);
    }
    public void start()
    {
        int alegere;
        while(true)
        {
            optiuni();
            System.out.println("Optiunea: ");
            alegere=scanner.nextInt();
            scanner.nextLine();
            switch(alegere) {
                case 1 -> System.out.println(cautareTranzactie());
                case 2 -> filtrareDatorie();
                case 3 -> filtrareDatorie100();
                case 4 -> sortareTrimitatorDestinatar();
                case 5 -> sortDescriere();
                case 6 -> sortsuma();

            }
        }
    }
    private void optiuni()
    {
        System.out.println("1.Cautare tranzactie trimisa catree Mitrea Alin lui Barbu Andrei.");
        System.out.println("2.Filtrare tranzactilor cu descrierea datorie.");
        System.out.println("3.Filtrare tranzactilor cu descrierea datorie cu suma mai mare decat 100");
        System.out.println("4.Sortare dupa trimitator si destinatar alfabetic.");
        System.out.println("5.Sortare dupa descriere crescator.");
        System.out.println("6.Sortare dupa suma descrescator.");

    }
    private String cautareTranzactie()
    {
//        String nume=citire("Nume:");
//        String prenume=citire("Prenume:");
        List<Tranzactie> Tranzactiilist =service.getListTranzactii();
        for(int i=0;i<Tranzactiilist.size();i++)
        {
            if(Tranzactiilist.get(i).getTrimitator().equals("Mitrea Alin") &&  Tranzactiilist.get(i).getDestinatar().equals("Barbu Andrei"))
            {
                return Tranzactiilist.get(i).toString();
            }
        }
        return "nu exista";
    }
    private String citire(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }
    private void filtrareDatorie()
    {   /*
        String grupa=citire("Numarul grupei:");

        List<Student> studentslist=service.getListStudenti();
        List<Student> filtrat = new ArrayList<>();

        for(int i=0;i<studentslist.size();i++)
        {
            if(studentslist.get(i).getGrupa().equals(grupa))
                filtrat.add(studentslist.get(i));
        }
        for(int i=0;i<filtrat.size();i++)
        {
            System.out.println(filtrat.get(i).toString());
        }*/
        // String grupa=citire("Numarul grupei:");
        List<Tranzactie> tranzactiilist=service.getListTranzactii();
        List<Tranzactie> filtered_list = (List)tranzactiilist.stream().filter((s) -> s.getDescriere().equals("datorie")).collect(Collectors.toList());
        System.out.println(filtered_list);

    }
    private void filtrareDatorie100()
    {   /*
        String grupa=citire("Numarul grupei:");
        List<Student> studentslist=service.getListStudenti();
        List<Student> filtrat = new ArrayList<>();

        for(int i=0;i<studentslist.size();i++)
        {
            if(studentslist.get(i).getGrupa().equals(grupa) && studentslist.get(i).getMedia()>5.0)
                filtrat.add(studentslist.get(i));
        }
        for(int i=0;i<filtrat.size();i++)
        {
            System.out.println(filtrat.get(i).toString());
        }*/

        List<Tranzactie> pictorilist=service.getListTranzactii();
        List<Tranzactie> filtered_list = (List)pictorilist.stream().filter((s) ->{
            return s.getDescriere().equals("datorie");
        }).collect(Collectors.toList());
        List<Tranzactie> filtered_list1 = (List)filtered_list.stream().filter((s) -> s.getSuma() > 100.0).collect(Collectors.toList());
        System.out.println(filtered_list1);
        System.out.println();
    }

    private void sortareTrimitatorDestinatar()
    {
        List<Tranzactie> lista =service.getListTranzactii();

        List<Tranzactie> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Tranzactie::getTrimitator).thenComparing(Tranzactie::getDestinatar)).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {
            Long var1 = s.getId();
            return "" + var1 + " " + s.getTrimitator() + " " + s.getDestinatar();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();

    }

    private void sortDescriere()
    {
        List<Tranzactie> lista =service.getListTranzactii();

        List<Tranzactie> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Tranzactie::getDescriere)).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {
            return ""+ s.getTrimitator()+ " " + s.getDestinatar() + " " + s.getDescriere();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

    private void sortsuma()
    {
        List<Tranzactie> lista =service.getListTranzactii();

        List<Tranzactie> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Tranzactie::getSuma).reversed()).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {
            Long var1 = s.getId();
            return ""+ var1 + " " + s.getSuma();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

}
