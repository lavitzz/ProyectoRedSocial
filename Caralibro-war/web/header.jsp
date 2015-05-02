<%-- 
    Document   : header
    Created on : 25-abr-2015, 19:15:11
    Author     : lavitz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muro Personal</title>
    </head>
    <body>
        <!-- NAVBAR -->
        <div class="col-md-12">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <img alt="Brand" src="Cl_Logo.png">
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                      <ul class="nav navbar-nav">
                          <%
                              String id = request.getParameter("idusuario");
                          %>
                          <li class="active"><a href="/Caralibro-war/CargaMuroPersonal?idamigo=<%=id%>">Inicio<span class="sr-only">(current)</span></a></li>
                        <li><a href="/Caralibro-war/listadoPostPersonal">Mi Perfil</a></li>
                        <li><a href="/Caralibro-war/VistaNotificaciones.jsp?id=<%=id%>">Notificaciones</a></li>
                      </ul>
                      <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Buscar</button>
                      </form>
                      <ul class="nav navbar-nav navbar-right">
                            <form action="LogOutServlet" method="post">      
                                <button class="btn btn-danger" type="submit">Salir</button>  
                            </form>
                      </ul>
                    </div><!-- /.navbar-collapse -->
                  </div><!-- /.container-fluid -->
                </nav>
        </div>
