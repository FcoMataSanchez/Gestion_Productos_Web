<%@page import="java.util.List"%>
<%@page import="model.negoci.Producte"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#FFFF99" >


        <%@ include file="myHeader.html" %>

        <form action="Productes?accio=modificar2" method="post">            

            <center><b>Dades del producte:</b></center>
            <br><br>
            <table cellspacing="2" cellpadding="2" border="0" align="center">
                
                 <%  Producte p = (Producte) request.getAttribute("modificats");
           
        %>
                
                 <tr>
                    <td align="right">Codi:</td>
                    <td><input type="Text" name="codi_" size="6" value="<%=p.getCodi()%>"></td>
                </tr>
                <tr>
                    <td align="right">Nom:</td>
                    <td><input type="Text" name="nom_" size="30" value="<%=p.getNom()%>"></td>
                </tr>
                <tr>
                    <td align="right">Descripcio:</td>
                    <td><input type="Text" name="descripcio_" size="30" value="<%=p.getDescripcio()%>"></td>
                </tr>
                <tr>
                    <td align="right">Preu:</td>
                    <td><input type="Text" name="preu_" size="5" value="<%=p.getPreu()%>"></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="Modificar"></td>
                </tr>                
               
            </table>   
        </form>
            <% String resposta = (String) request.getAttribute("resmodificar");%>
            <a ><%=(resposta == null) ? "" : resposta%> </a>

        
        <br> <a   href='index.jsp'>TORNAR</a><br>
        <p>&nbsp;</p>
        <%@ include file="myFooter.html" %>

    </body>
</html>
