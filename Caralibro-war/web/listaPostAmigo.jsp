<%-- 
    Document   : listaPostAmigo
    Created on : 24-abr-2015, 14:18:17
    Author     : lavitz
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="cl.entity.Usuario"%>
<%@page import="cl.entity.Post"%>
<%@page import="java.util.List"%>
<%
    List<Post> lista;
    lista = (List)request.getAttribute("listaP");
    
    List<Usuario> listaUsuario;
    listaUsuario = (List)request.getAttribute("listaA");
    
    request.getAttribute("id");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post de Amigo</title>
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
                        <li class="active"><a href="http://localhost:8080/Caralibro-war/listadoPostPersonal">Inicio<span class="sr-only">(current)</span></a></li>
                        <li><a href="http://localhost:8080/Caralibro-war/listadoPostPersonal">Mi Perfil</a></li>
                        <li><a href="http://localhost:8080/Caralibro-war/">Notificaciones</a></li>
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
        <div class="col-md-8">
            
        <%          
                for (Post p:lista) {
                    Date d = p.getFecha();
                    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
                    String fecha = "Fecha: " + formatoFecha.format(d) + " Hora: " + formatoHora.format(d);
        %>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h5 class="panel-title">Autor: <%= p.getAutor().getNombre() %> <%= fecha %></h5>
            </div>
            <div class="panel-body">
                <%= p.getTexto()%>
            </div>
        </div>
        <%
                }
        %>     
        </table>
        </div>
        <div class="col-md-4">
            <% if(listaUsuario == null ){ %>
           <jsp:include page="ListaAmigosServlet" />
           <% } 
            else{
           %>
           <jsp:include page="amigosList.jsp" />
           <% } %>
        </div>
    </body>
</html>
