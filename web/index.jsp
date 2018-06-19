<%-- 
    Document   : index
    Created on : May 16, 2018, 7:14:21 PM
    Author     : j
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat</title>
    </head>
    <body bgcolor="#FFFF99" >
        <%@ include file="myHeader.html" %>
         <center> <a  href='afegir.jsp'>AFEGIR NOU PRODUCTE</a><br><br> </center> 
         <center>  <a href='llistarPerNom.jsp'>CERCAR PRODUCTE PER NOM</a><br><br>  </center>
         <center>  <a href='Productes?accio=llistar'>LLISTAR TOTS ELS PRODUCTES</a><br><br>  </center>
         <center>  <a href='Productes?accio=mostrarParaCodigo'>MODIFICAR</a><br><br>  </center>
         <center>  <a href='eliminar.jsp'>ELIMINAR</a><br><br>  </center>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <%@ include file="myFooter.html" %>
    </body>
</html>
