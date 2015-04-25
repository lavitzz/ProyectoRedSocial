<%-- 
    Document   : amigosList
    Created on : 23-abr-2015, 13:28:05
    Author     : lavitz
--%>

<%@page import="java.util.List"%>
<%@page import="cl.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                List<Usuario> listaUsuario;
                listaUsuario = (List)request.getAttribute("listaA");
                for (Usuario u:listaUsuario) {
            %>     
                    <a href="/Caralibro-war/PaginaAmigoServlet?idamigo=<%=u.getIdUsuario() %>"><h4> <%= u.getNombre() + " " + u.getApellido() %> </h4></a>
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