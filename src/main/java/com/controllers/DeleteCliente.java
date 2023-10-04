package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;

@WebServlet("/delete")
public class DeleteCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doDelete(request, response);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));

		ClienteDAO.delete(clienteId);

		response.sendRedirect("find");
		// FindCliente findCliente = new FindCliente();
		// findCliente.doGet(request, response);
	}
}
