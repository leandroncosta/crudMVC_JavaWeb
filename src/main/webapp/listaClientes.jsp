<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> <%@ taglib uri='http://java.sun.com/jsp/jstl/core'
prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CRUD | Lista de Clientes</title>
        <!-- CSS only -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous" />
        <link rel="stylesheet" href="./css/styles.css" />
    </head>
    <body>
    <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark p-3">
            <div class="container-fluid">
                <a class="navbar-brand crud" href="#">CRUD</a>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div
                    class="collapse navbar-collapse"
                    id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a
                                class="nav-link active"
                                aria-current="page"
                                href="index.html"
                                >Home</a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="find"
                                >Clientes</a
                            >
                        </li>
                    </ul>
                    <form action="find" method="GET" class="d-flex">
                        <input
                            name="pesquisa"
                            class="form-control me-2"
                            type="search"
                            placeholder="Digite o Nome ou CPF"
                            aria-label="Search" />
                        <button class="btn btn-outline-success" type="submit">
                            Buscar
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <br />
        <div class="container">
            <div class="row">
                <div class="cold-md-7">
                    <hr />
                    <h3>Clientes Cadastrados</h3>
                    <hr />
                    <div class="table-responsive-sm">
                        <table class="table table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Nascimento</th>
                                    <th>Situação</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${clientes}" var="cliente">
                                    <tr>
                                        <td>${cliente.id}</td>
                                        <td>${cliente.nome}</td>
                                        <td>${cliente.cpf}</td>
                                        <td>${cliente.nascimento}</td>
                                        <td class="${cliente.situacao}">
                                            ${cliente.situacao}
                                        </td>
                                        <td>
                                            <a
                                                class="delete"
                                                href="delete?clienteId=${cliente.id}"
                                                >&#10006; deletar</a
                                            >
                                            |
                                            <a
                                                href="update?clienteId=${cliente.id}"
                                                >&#x270E; atualizar</a
                                            >
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br>
                <h5>
                    <a href="index.html"> &#10094; Cadastro Clientes</a>
                </h5>
            </div>
        </div>
        <!-- JavaScript Bundle with Popper -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    </body>
</html>
