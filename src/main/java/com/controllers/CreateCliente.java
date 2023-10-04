package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.model.Cliente;

@WebServlet("/create")
public class CreateCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response.getWriter().append(":(").append(request.getContextPath());
		response.getWriter().append("<h1> :( </h1>");
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.print("<h1>Ola mundo</h1>"
				//+ "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));

		ClienteDAO.create(cliente);

		FindCliente findCliente = new FindCliente();
		findCliente.doGet(request, response);
	}

}
