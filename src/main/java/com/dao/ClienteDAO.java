package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.Database;
import com.model.Cliente;
import com.utils.Colors;

public class ClienteDAO implements CRUD {

	private static Connection connection = Database.createConnection();
	private static String sql;

	public static void create(Cliente cliente) {
		sql = "INSERT INTO cliente(id, nome, cpf, nascimento, situacao)  VALUES (null, ? , ? , ? , ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());

			preparedStatement.executeUpdate();

			System.out.println(Colors.GREEN + "--correct insert on database" + Colors.RESET);
		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. Message: " + e.getMessage());
		}
	}

	public static void delete(int clienteId) {
		sql = "DELETE FROM cliente WHERE id = ? LIMIT 1";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();

			System.out.println(Colors.GREEN + "--correct delete on database" + Colors.RESET);
		} catch (SQLException e) {
			System.out.println("--incorrect delete on database. Message: " + e.getMessage());
		}

	}

	public static List<Cliente> find(String pesquisa) {

		sql = String.format("SELECT * FROM cliente WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%'", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				clientes.add(cliente);
			}

			System.out.println(Colors.GREEN + "--correct find on database" + Colors.RESET);

			return clientes;
		} catch (SQLException e) {
			System.out.println("--incorrect find on database. Message: " + e.getMessage());
			return null;
		}
	}

	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM cliente WHERE id = %d", clienteId);
		Cliente cliente = new Cliente();

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
			}

			System.out.println(Colors.GREEN + "--correct find by pk on database" + Colors.RESET);

			return cliente;
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk on database. Message: " + e.getMessage());
			return null;
		}

	}

	public static void update(Cliente cliente) {
		sql = "UPDATE cliente SET nome = ?, cpf = ?, nascimento = ?, situacao = ? WHERE id = ? LIMIT 1";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			preparedStatement.setInt(5, cliente.getId());

			preparedStatement.executeUpdate();

			System.out.println(Colors.GREEN + "--correct update on database" + Colors.RESET);

		} catch (SQLException e) {
			System.out.println("--incorrect update on database. Message: " + e.getMessage());

		}

	}

}
