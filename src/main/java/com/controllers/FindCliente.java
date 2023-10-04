package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.model.Cliente;

@WebServlet("/find")
public class FindCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindCliente() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Cliente> clientes = ClienteDAO.find(pesquisa);

	
		request.setAttribute("clientes", clientes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaClientes.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
