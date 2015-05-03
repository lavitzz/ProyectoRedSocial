<%-- 
    Document   : ListaNotificaciones
    Created on : 02-may-2015, 13:03:39
    Author     : lavitz
--%>

<%@page import="java.util.List"%>
<%@page import="cl.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Usuario> listaI;
            listaI = (List)request.getAttribute("listaI");
            for(Usuario u: listaI){
        %>
        <div class="alert alert-info" role="alert">El Usuario <%=u.getNombre() %> <%=u.getApellido() %> quiere ser tu amigo. 
            <a href="/Caralibro-war/TramitarInvitacionesServlet?idamigo=<%=u.getIdUsuario() %>&ok=1" > Aceptar  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> </a>
            <a href="/Caralibro-war/TramitarInvitacionesServlet?idamigo=<%=u.getIdUsuario() %>&ok=0" > Rechazar  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></div></a>
        <%
            }
        %>
    </body>
</html>
