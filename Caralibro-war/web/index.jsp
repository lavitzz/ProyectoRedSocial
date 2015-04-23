<%-- 
    Document   : index
    Created on : 23-abr-2015, 12:41:47
    Author     : lavitz
--%>
<!--Prueba-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]—>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilo.css" type="text/css"/>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<html>
    <head>
        <title>Iniciar Sesion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="navbar navbar-fixed-center">
    <div class="navbar-inner">
       <div class="container">
         <center>
           <form action="LoginServlet" method="post">
              <h1>CaraLibro</h1>
              <h2>Iniciar Sesion</h2>
                <table>
                  <tr>
                    <td>Usuario</td>
                  <td><input type="text" name="user" /></td>
                  </tr>
                  <tr>
                   	<td>Password</td>
           				<td><input type="password" name="password" /></td>
           				</tr>
                        <tr>
                    <td><button class="btn btn-large btn-primary" type="submit" value= "Login"    name="Login">Login</button></td>
                        </tr>
                    </table>
            </div>
            </form>
            </center>
        </div>
    </div>
    </body>
</html>