package edu.com.iudigital;

import edu.com.iudigital.db.DbConfig;
import edu.com.iudigital.models.Cliente;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        System.out.println("***** Obteniendo lista de clientes *****");
        cliente.printCliente();

        System.out.println("***** Modificando el cliente con id 1 *****");
        cliente=cliente.getCliente(1);
        System.out.println("Se recuperó el cliente con nombre "+ cliente.getNombreCliente());
        cliente.setApellidoCliente("Nuevo apellido");
        cliente.updateCliente(cliente);

        System.out.println("***** Creando nuevo cliente *****");
        Cliente cliente1 = new Cliente();
        cliente1.setCedulaCliente("1036404675")
        cliente1.setNombreCliente("Julián de jesús");
        cliente1.setApellidoCliente("Ramirez");
        cliente1.setDireccion("CRA 30");
        cliente1.setTelefono("3134445567");
        cliente1.createCliente(cliente1);
        cliente1.printCliente();

        System.out.println("***** Eliminando cliente *****");
        cliente1.deleteCliente(3);
        cliente1.printCliente();



    }

}