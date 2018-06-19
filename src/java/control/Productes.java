package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dades.ConfiguracioConnexio;
import model.dades.DaoProducte;
import model.negoci.Producte;

public class Productes extends HttpServlet {
    private ConfiguracioConnexio configCon;
    private DaoProducte daoProd;
    private Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        configCon = new ConfiguracioConnexio();
        con = configCon.getConnexio();
        daoProd = new DaoProducte(con);
        System.out.println("CONNEXIÓ: " + configCon.esOberta());
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accio");
        switch (action) {
            case "llistar":
                List<Producte> pers = daoProd.cercarTots();
                request.setAttribute("llistat", pers);
                request.getRequestDispatcher("llistatProductes.jsp").forward(request, response);
                break;
            case "afegir":
                String resposta = afegir(request, response);
                request.setAttribute("afegit", resposta);
                anarAPagina("afegir.jsp", request, response);
                break;
            case "mostrarParaCodigo":
               List<Producte> productos = daoProd.cercarTots();
                request.setAttribute("llistaDeProductos", productos);
                request.getRequestDispatcher("modificar.jsp").forward(request, response);
                break;
             case "modificar":
               Producte nom = mostrarPorCodigo(request, response);
                request.setAttribute("modificats", nom);
                 anarAPagina("modificar2.jsp",request,response);
                break;
             case "modificar2":
               String resposta3 = modificar3(request, response);
                request.setAttribute("resmodificar", resposta3);
                
                List<Producte> pers3 = daoProd.cercarTots();
                request.setAttribute("llistat", pers3);
                request.getRequestDispatcher("llistatProductes.jsp").forward(request, response);
                
                break;
            case "eliminar":
                String eliminat = eliminar(request, response);
                request.setAttribute("eliminat", eliminat);
                anarAPagina("eliminar.jsp", request, response);
                break;
            case "llistarPerNom":
                List<Producte> nombre = llistarPerNom(request, response);
                request.setAttribute("llistat", nombre);
                 request.getRequestDispatcher("llistatProductes.jsp").forward(request, response);
                break;
        }

    }
    
    private List<Producte> llistarPerNom(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nom;
        List<Producte> prod= new ArrayList<>();;
        if ((nom = req.getParameter("nom_"))==null){
           prod=null;
        } else {
            prod=daoProd.cercarPerNom(nom);
               }
        return prod;    
    }
    
    private List<Producte> llistarPerCodi(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String codi;
        List<Producte> prod= new ArrayList<>();;
        if ((codi = req.getParameter("codi_"))==null){
           prod=null;
        } else {
            prod=daoProd.cercarPerCodi(codi);
               }
        return prod;    
    }
    
    private Producte mostrarPorCodigo(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String codi;
       Producte prod;
        if ((codi = req.getParameter("codi_"))==null){
           prod=null;
        } else {
            prod=daoProd.mostrarPorCodigo(codi);
               }
        return prod;    
    }
    
     private String modificar3(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String codi,nom, descripcio, preuS;
        double preu;
        boolean validar = true;
        Producte p=null;
        
        String resposta = "El producte s'ha modificat correctament";
        if ((nom = req.getParameter("nom_"))==null||(codi = req.getParameter("codi_")) == null
        || (preuS = req.getParameter("preu_")) == null || (descripcio = req.getParameter("descripcio_"))== null){
             resposta = "s'han d'emplenar tots els camps";
            validar = false;
        } else if(!(codi = req.getParameter("codi_")).matches("[0-9]{6}")) {
             resposta = "Codi incorrecta";
            validar = false;
        }else {
            preuS = req.getParameter("preu_");
            preu =Double.parseDouble(preuS);
            p=new Producte(req.getParameter("codi_"),nom,descripcio,preu);
            validar=daoProd.modificar3(p);
            if(!validar){resposta="No s'ha modificat el producte";}
        }
        return resposta;    
    }
    
    
     private String afegir(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String codi,nom, descripcio, preuS;
        double preu;
        boolean validar = true;

        String resposta = "El producte s'ha afegit correctament";
        if ((nom = req.getParameter("nom_"))==null||(codi = req.getParameter("codi_")) == null
        || (preuS = req.getParameter("preu_")) == null){
             resposta = "s'han d'emplenar tots els camps";
            validar = false;
        } else if(!(codi = req.getParameter("codi_")).matches("[0-9]{6}")) {
             resposta = "Codi incorrecta";
            validar = false;
        }else {
            preuS = req.getParameter("preu_");
            preu =Double.parseDouble(preuS);
            descripcio = req.getParameter("descripcio_");
            validar=daoProd.afegir(new Producte(codi,nom, descripcio, preu));
            if(!validar){resposta="No s'ha afegit el producte";}
        }
        return resposta;    
    }
    
    private String eliminar(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String codi;
       
        boolean validar = true;

        String resposta = "El producte s'ha eliminat correctament";
        if(!(codi = req.getParameter("codi_")).matches("[0-9]{4}")) {
             resposta = "Codi incorrecta";
            validar = false;
        }else {
            validar=daoProd.eliminar(codi);
            if(!validar){resposta="No s'ha eliminat el producte";}
        }
        return resposta;    
    }
    
    
    /**
     * Redirecciona la petició(Request) a una altra pàgina
     *
     * @param pagina
     * @param req
     * @param res
     * @throws IOException
     * @throws ServletException
     */
    private void anarAPagina(String pagina, HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
        if (dispatcher != null) {
            dispatcher.forward(req, res);
        }
    }

    @Override
    public void destroy() {
        configCon.tancar();
        super.destroy(); //To change body of generated methods, choose Tools | Templates.        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
