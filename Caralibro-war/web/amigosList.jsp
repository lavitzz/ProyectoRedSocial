<%-- 
    Document   : amigosList
    Created on : 23-abr-2015, 13:28:05
    Author     : lavitz
--%>

<%@page import="java.util.List"%>
<%@page import="cl.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%   
    List<Usuario> listaUsuario;
    listaUsuario = (List)request.getAttribute("listaA");
%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3><span class="label label-primary">AMIGOS</span></h3>
            
            <%
                for (Usuario u:listaUsuario) {
            %>
            
            <h4> <%= u.getNombre() %> </h4>
            
            <%
                }
            %>   
        </div>
        <form action="InvitaAmigo" method="post">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Agregar Amigo">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Agregar!</button>
                    </span>
            </div>
        </form>
    </body>
</html>
