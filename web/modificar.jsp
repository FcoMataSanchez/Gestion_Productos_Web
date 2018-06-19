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
        <%  List<Producte> pers = (List<Producte>) request.getAttribute("llistaDeProductos");
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
    
     <form action="Productes?accio=modificar" method="post">            

            <center><b>Codi del producte a modificar:</b></center>
            <br><br>
            <table cellspacing="2" cellpadding="2" border="0" align="center">
                
                 <tr>
                    <td align="right">Codi:</td>
                    <td><input type="Text" name="codi_" size="6"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="Modificar"></td>
                </tr>                

            </table>   

        </form>

<center><br> <a href='index.jsp'>TORNAR</a><br></center>
<p>&nbsp;</p>
<%@ include file="myFooter.html" %>
</body>
</html>


