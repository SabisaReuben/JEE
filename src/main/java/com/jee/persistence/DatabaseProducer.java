package com.jee.persistence;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:global/jdbc/customerDs",
        databaseName = "Customer",
        properties = {"connectionAttribute;create=true"},
        user = "root",
        password = ""
)
public class DatabaseProducer {
    @Produces
   /* @PersistenceContext(unitName = "bookPU")*/
    public EntityManager entityManager;

}
