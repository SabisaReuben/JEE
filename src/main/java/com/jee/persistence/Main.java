package com.jee.persistence;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static  void main(String [] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ejbContainer = EJBContainer.createEJBContainer(properties)) {
            Context context = ejbContainer.getContext();

            TxEJB trEjb = (TxEJB) context.lookup("java:global/classes/TxEJB");
            trEjb.deposit(20);
            trEjb.setBalance(25);

            System.out.println("The back balance is "+trEjb.getBalance());
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
