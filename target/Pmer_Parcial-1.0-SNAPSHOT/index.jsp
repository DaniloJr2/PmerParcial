<%@page import="com.emergentes.modelo.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Estudiante> Product = (ArrayList<Estudiante>)session.getAttribute("listaProducto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><table border ="5">
            <tr>
                <th>PRIMER PARCIAL TEM-742<br>Nombre: Dalilo Marca Perez<br>Carnet: 10943552 L.P.</th>    
            </tr>
        </table></center>
    <center><h1>Registro de Calificaciones</h1></center>
    <a href="NuevoEstudiante?op=nuevo">Nuevo</a> <br>
    <br>
    <table border ="1">
            <tr>
                <th>Id</th>    
                <th>Nombre</th>    
                <th>P1(30)</th>    
                <th>P2(30)</th>    
                <th>EF(40)</th>
                <th>Nota</th>
                <th></th>    
                <th></th>    
            </tr>
            <%
                if (Product != null) {
                        for (Estudiante p: Product) {
                                %>
            <tr>
                <th><%= p.getId()%></th>
                <th><%= p.getNombre()%></th>
                <th><%= p.getP1()%></th>
                <th><%= p.getP2()%></th>
                <th><%= p.getEF()%></th>
                <th><%= p.getNota()%></th>
                
                
                <th><a href="NuevoEstudiante?op=editar&id=<%= p.getId()%>">Editar</th>
                <th><a href="NuevoEstudiante?op=eliminar&id=<%= p.getId()%> ">Eliminar</a></th>
            </tr>
            <%
                            }
                    }
            %>
        </table>
</body>
