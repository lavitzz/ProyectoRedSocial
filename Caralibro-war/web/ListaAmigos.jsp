<%-- 
    Document   : ListaAmigos
    Created on : 26-abr-2015, 12:57:00
    Author     : lavitz
--%>
<%@page import="java.util.List"%>
<%@page import="cl.entity.Usuario"%>
<%
    List<Usuario> listaAmigos;
    listaAmigos = (List)request.getAttribute("listaA");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h3><span class="label label-primary">AMIGOS</span></h3> 
            <%
                for (Usuario u:listaAmigos) {
            %>     
                    <a href="/Caralibro-war/CargaMuroPersonal?idamigo=<%=u.getIdUsuario() %>"><h4> <%= u.getNombre() + " " + u.getApellido() %> </h4></a>
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
</html>
