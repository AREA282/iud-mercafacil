package edu.com.iudigital.models;

import edu.com.iudigital.db.DbConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {



    private int cedula;
    private String nombreCliente;
    private String apellidoCliente;
    private String Direccion;
    private String Telefono;

    public void printCliente() {
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = "SELECT * FROM clientes";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+ " ");
                System.out.print(resultSet.getString(2)+ " ");
                System.out.print(resultSet.getString(3)+ " ");
                System.out.print(resultSet.getString(4)+ " ");
                System.out.print(resultSet.getString(5)+ " ");
                System.out.println("");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.print(e);
        }

    }

    public Cliente getCliente(int cedulaCliente){
        Cliente cliente = new Cliente();
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("SELECT * FROM clientes WHERE cedulaclientes=%d", cedulaCliente);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                cliente.setCedula(Integer.parseInt(resultSet.getString(1)));
                cliente.setNombreCliente(resultSet.getString(2));
                cliente.setApellido(resultSet.getString(3));
                cliente.setDireccion(resultSet.getString(4));
                cliente.setTelefono(resultSet.getString(5));
            }else{
                System.out.println("No se ha encontrado registros");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.print(e);
        }

        return cliente;
    };

    public void updateCliente(Cliente cliente){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("UPDATE clientes set " +
                "cedula='%s', " +
                "nombre='%s', " +
                "apellido='%s', " +
                "direccion='%s', " +
                "telefono='%s' ", cliente.getCedulaCliente(), cliente.getNombreCliente(), cliente.getApellidoCliente(),
                cliente.getDireccion(), cliente.getTelefono());
        try {
            Statement statement = connection.createStatement();
            System.out.println("Actualizando");
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("Cliente Actualizado");
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public void deleteCliente(int cedulaCliente){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("DELETE FROM clientes WHERE cedulaclientes=%d",cedulaCliente);
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("Cliente Eliminado");
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public void createCliente(Cliente cliente){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("INSERT INTO clientes (cedula, nombre, apellido, direccion, telefono) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s') ",cliente.getCedulaCliente(), cliente.getNombreCliente(), cliente.getApellidoCliente(), cliente.getDireccion(), cliente.getTelefono());
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("Cliente Creado");
        }catch (Exception e){
            System.out.print(e);
        }
    }


}
