package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact 
{
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/ContactBD";
	
	
	public String addContact(final long id, final String firstName, final String lastName, final String adresse, final String email, final String autre) 
	{
		try 
		{
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // adding a new contact
			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement
					("INSERT INTO CONTACT(ContactId, ContactNom, ContactPrenom, ContactAdresse, ContactMail, ContactAutre) VALUES(?, ?, ?, ?, ?, ?)");
			lPreparedStatementCreation.setLong(1, id)
			; lPreparedStatementCreation.setString(2, firstName);
			lPreparedStatementCreation.setString(3, lastName);
			lPreparedStatementCreation.setString(4, adresse);
			lPreparedStatementCreation.setString(5, email);
			lPreparedStatementCreation.setString(6, autre);
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
