
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#FFFF99" >


        <%@ include file="myHeader.html" %>

        <form action="Productes?accio=afegir" method="post">            

            <center><b>Dades del producte:</b></center>
            <br><br>
            <table cellspacing="2" cellpadding="2" border="0" align="center">
                
                 <tr>
                    <td align="right">Codi:</td>
                    <td><input type="Text" name="codi_" size="6"></td>
                </tr>
                <tr>
                    <td align="right">Nom:</td>
                    <td><input type="Text" name="nom_" size="30"></td>
                </tr>
                <tr>
                    <td align="right">Descripcio:</td>
                    <td><input type="Text" name="descripcio_" size="30"></td>
                </tr>
                <tr>
                    <td align="right">Preu:</td>
                    <td><input type="Text" name="preu_" size="5"></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="Afegir"></td>
                </tr>                

            </table>   

            <% String resposta = (String) request.getAttribute("afegit");%>
            <a ><%=(resposta == null) ? "" : resposta%> </a>

        </form>
        <br> <a   href='index.jsp'>TORNAR</a><br>
        <p>&nbsp;</p>
        <%@ include file="myFooter.html" %>

    </body>
</html>
