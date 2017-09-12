package com.exam.common;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class DDLGenerator {
	public static void main(String args[]) throws Exception {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		propertiesMap.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE); 
		propertiesMap.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "sql-script"); 
		propertiesMap.put(PersistenceUnitProperties.CREATE_JDBC_DDL_FILE, "resource/create.sql"); 
		propertiesMap.put(PersistenceUnitProperties.DROP_JDBC_DDL_FILE, "resource/drop.sql");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA", propertiesMap);
		emf.createEntityManager();
		System.out.println(emf.getProperties().get(PersistenceUnitProperties.JDBC_CONNECTOR));
		emf.close();
	}
}
