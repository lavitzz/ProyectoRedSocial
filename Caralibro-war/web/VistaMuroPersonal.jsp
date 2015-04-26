<%-- 
    Document   : VistaMuroPersonal
    Created on : 25-abr-2015, 19:04:42
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
            String idamigo;
            idusuario = (String)request.getAttribute("idusuario");
            idamigo = request.getParameter("idamigo");
        %>
        <jsp:include page="header.jsp" >
            <jsp:param name="idusuario" value="<%=idusuario%>" />
        </jsp:include>
        <div class="col-md-8">
            <jsp:include page="ListaPostServlet">
                <jsp:param name="idpost" value="<%=idamigo%>" />
            </jsp:include>
        </div>
        <div class="col-md-4">
            <jsp:include page="ListaAmigosServlet">
                <jsp:param name="idamigo" value="<%=idusuario%>" />
            </jsp:include>
        </div>
    </body>
</html>
