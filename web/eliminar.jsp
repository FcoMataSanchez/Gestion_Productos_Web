<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#FFFF99" >


        <%@ include file="myHeader.html" %>

        <form action="Productes?accio=eliminar" method="post">            

            <center><b>Elimiar producte:</b></center>
            <br><br>
            <table cellspacing="2" cellpadding="2" border="0" align="center">
                
                 
                <tr>
                    <td align="right">Codi:</td>
                    <td><input type="Text" name="codi_" size="30"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="eliminar"></td>
                </tr>                

            </table>   

            <% String resposta = (String) request.getAttribute("eliminat");%>
            <a ><%=(resposta == null) ? "" : resposta%> </a>

        </form>
        <br> <a   href='index.jsp'>TORNAR</a><br>
        <p>&nbsp;</p>
        <%@ include file="myFooter.html" %>

    </body>
</html>
