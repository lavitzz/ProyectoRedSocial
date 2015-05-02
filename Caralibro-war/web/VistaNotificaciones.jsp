<%-- 
    Document   : VistaNotificaciones
    Created on : 02-may-2015, 12:59:41
    Author     : lavitz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caralibro</title>
    </head>
    <body>
        <% 
            String idusuario;
            //Parametro por URL
            idusuario = request.getParameter("id");
        %>
        <jsp:include page="header.jsp" >
            <jsp:param name="idusuario" value="<%=idusuario%>" />
        </jsp:include>
        <div class="col-md-8">
            <jsp:include page="ListaNotificacionesServlet">
                <jsp:param name="idusuario" value="<%=idusuario%>" />
            </jsp:include>
        </div>
        <div class="col-md-4">
            <jsp:include page="ListaAmigosServlet">
                <jsp:param name="idamigo" value="<%=idusuario%>" />
            </jsp:include>
        </div>
    </body>
</html>

