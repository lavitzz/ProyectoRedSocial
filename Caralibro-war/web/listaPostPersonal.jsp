<%-- 
    Document   : listaPostPersonal
    Created on : 17-abr-2015, 11:23:15
    Author     : lavitz
--%>

<%@page import="cl.entity.Post"%>
<%@page import="java.util.List"%>
<%
    List<Post> lista;
    
    lista = (List)request.getAttribute("listaP");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <%                
                for (Post c:lista) {
            %>        
            <tr>
                <td><%= c.getTitulo() %> </td>
                <td><%= c.getTexto()%> </td>                
            </tr>            
            <%
                }
            %>       
        </table>

    </body>
</html>
