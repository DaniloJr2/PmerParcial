<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante p = (Estudiante)request.getAttribute("miEstudiante");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><h1>Registro de Calificaciones</h1></center>
        <form action="NuevoEstudiante" method="POST">
            <input type="hidden" name="id" value="<%= p.getId() %>"/>
            <table>
                <tr>
                <td>Nombre</td>
                <td><input type = "text" name ="nombre" value="<%= p.getNombre()%>"></td>
            </tr>
            
            <tr>
                <td>P1</td>
                <td><input type = "number" min="0" max="30" name ="p1" value="<%= p.getP1()%>"></td>
            </tr>
            
            <tr>
                <td>P2</td>
                <td><input type = "number" min="0"  max="30" name ="p2" value="<%= p.getP2()%>"></td>
            </tr>
            <br>
            <tr>
                <td>EF</td>
                <td><input type = "number" min="0" max="40" name ="ef" value="<%= p.getEF()%>"></td>
            </tr>
            
            <br>
            <tr>
                <td></td>
                <td><input type="submit" value="Agregar"></td>
            </tr>
            </table>      
        </form>
    </body>
</html>
