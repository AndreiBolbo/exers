package org.example.Repository;
import org.example.Domain.Tranzactie;
import org.example.Tematica;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class TranzactieDbRepository {
    private String url;
    private String username;
    private String password;

    public TranzactieDbRepository(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Iterable<Tranzactie> findAll() {
        Set<Tranzactie> users = new HashSet<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from tranzactie");
            ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String trimitator = resultSet.getString("trimitator");
                String destinatar = resultSet.getString("destinatar");
                String  descriere=resultSet.getString("descriere");
                Double suma=resultSet.getDouble("suma");
                Tranzactie utilizator = new Tranzactie(id,trimitator,destinatar,descriere,suma);
                utilizator.setId(id);
                users.add(utilizator);
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}

