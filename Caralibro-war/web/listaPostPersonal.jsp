<%-- 
    Document   : listaPostPersonal
    Created on : 17-abr-2015, 11:23:15
    Author     : lavitz
--%>

<%@page import="cl.entity.Usuario"%>
<%@page import="cl.entity.Post"%>
<%@page import="java.util.List"%>
<%
    List<Post> lista;
    lista = (List)request.getAttribute("listaP");
    
    List<Usuario> listaUsuario;
    listaUsuario = (List)request.getAttribute("listaA");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muro Personal</title>
    </head>
    <body>
        <div class="col-md-8">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Insertar Post...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Insertar</button>
                            </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
        <%                
                for (Post c:lista) {
        %>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><%= c.getTitulo() %></h3>
            </div>
            <div class="panel-body">
                <%= c.getTexto()%>
            </div>
        </div>
        <%
                }
        %>     
        </table>
        </div>
        <div class="col-md-4">
            <h2>AMIGOS</h2>
            
            <%
                for (Usuario u:listaUsuario) {
            %>
            
            <h4> <%= u.getNombre() %> </h4>
            
            <%
                }
            %>   
        </div>
    </body>
</html>
