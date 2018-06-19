<%-- 
    Document   : llistarPersones
    Created on : May 17, 2018, 7:18:41 PM
    Author     : j
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="myError.jsp" %>
<%@page import="model.negoci.Producte, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#FFFF99" >
        <%@ include file="myHeader.html" %>
        <h1>LLISTAT:</h1>
    <table cellspacing="2" cellpadding="2" border="2" align="center">
        <tr>
            <td><b>CODI</b></td>
            <td><b>NOM</b></td>
            <td><B>DESCRIPCIO</b></td>
            <td><b>PREU</b></td>
        </tr>
        <%  List<Producte> pers = (List<Producte>) request.getAttribute("llistat");
            for (Producte p : pers) {
        %>

        <tr>
            <td><%=p.getCodi()%></td>
            <td><%=p.getNom()%></td>
            <td><%=p.getDescripcio()%></td>
            <td><%=p.getPreu()%></td>
        </tr>  

        <%    }%>

    </table>

<center><br> <a href='index.jsp'>TORNAR</a><br></center>
<p>&nbsp;</p>
<%@ include file="myFooter.html" %>
</body>
</html>


