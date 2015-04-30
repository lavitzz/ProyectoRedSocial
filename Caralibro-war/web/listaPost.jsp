<%-- 
    Document   : listaPost
    Created on : 26-abr-2015, 12:13:04
    Author     : lavitz
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="cl.entity.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Post> listaPost;
    listaPost = (List)request.getAttribute("listaP");
    String iddest = (String)request.getAttribute("iddest");
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-6">
                <form action="PostCreateServlet?iddest=<%=iddest%>" method="post">
                    <div class="input-group">
                        <input type="text" name="textoP" class="form-control" placeholder="Insertar Post...">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit"> Insertar </button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
        <%          
            for (Post p:listaPost) {
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
    </body>
</html>
