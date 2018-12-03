package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOGroupe {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/ContactBD";
	
	public String addGroupe(String name)
	{
		String idGroupeAll = "1";
		try 
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // adding a new contact
			
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("INSERT INTO groupeName(GroupeNom) VALUES(?)");
			lPreparedStatementCreation.setString(1, name);
			lPreparedStatementCreation.executeUpdate();
			return null;
		}
		catch (NamingException e)
		{
			System.out.println("Erreur dans l'ajout de la BDD : " + e.getMessage());
			return "Erreur dans l'ajout de la BDD : " + e.getMessage();
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
			return "Erreur dans la requete SQL: " + e.getMessage();
		} 
	}
	
	public String addContactAllGroupe(String idContact)
	{
		String idGroupeAll = "1";
		try 
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // adding a new contact
			
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("INSERT INTO GROUPE(FKGroupeContactId, FKGroupeNameId) VALUES(?, ?)");
			lPreparedStatementCreation.setString(1, idContact);
			 lPreparedStatementCreation.setString(2, idGroupeAll);
			lPreparedStatementCreation.executeUpdate();
			return null;
		}
		catch (NamingException e)
		{
			System.out.println("Erreur dans l'ajout de la BDD : " + e.getMessage());
			return "Erreur dans l'ajout de la BDD : " + e.getMessage();
		}
		catch (SQLException e)
		{
			System.out.println("Erreur dans la requete SQL: " + e.getMessage());
			return "Erreur dans la requete SQL: " + e.getMessage();
		} 
	}

}