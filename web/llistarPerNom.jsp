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
        
        <form action="Productes?accio=llistarPerNom" method="post">            

            <center><b>Nom del producte:</b></center>
            <br><br>
            <table cellspacing="2" cellpadding="2" border="0" align="center">
                
                <tr>
                    <td align="right">Nom:</td>
                    <td><input type="Text" name="nom_" size="30"></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="Aceptar"></td>
                </tr>                

            </table>   

            <% String resposta = (String) request.getAttribute("llistatPerNom");%>
            <a ><%=(resposta == null) ? "" : resposta%> </a>

        </form>
        
        

<center><br> <a href='index.jsp'>TORNAR</a><br></center>
<p>&nbsp;</p>
<%@ include file="myFooter.html" %>
</body>
</html>