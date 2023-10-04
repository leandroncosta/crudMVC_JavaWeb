package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.model.Cliente;

@WebServlet("/update")
public class UpdateAndFindCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateAndFindCliente() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int clienteId = Integer.parseInt(request.getParameter("clienteId"));

		Cliente cliente = ClienteDAO.findByPk(clienteId);

		request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPut(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));

		ClienteDAO.update(cliente);

		response.sendRedirect("find");
		// FindCliente findCliente = new FindCliente();
		// findCliente.doGet(request, response);
	}

}
