package model.dades;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.negoci.*;

public class DaoProducte {

    private Connection con;

    public DaoProducte(Connection con) {
        this.con = con;
    }

    public boolean eliminar(String e) {
        boolean eliminat = true;
        Statement st = null;
        String sentencia = "DELETE FROM PRODUCTE WHERE CODI="+e;
        try {
            st = con.createStatement();
            if (st.executeUpdate(sentencia) == 0) {
                eliminat = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            eliminat = false;
        }
        return eliminat;
    }
    
     public boolean modificar3(Producte p) {
        boolean modificado = true;
        PreparedStatement pst = null;
        //por aqui
       // String sentencia = "UPDATE PRODUCTE SET NOM ='"+p.getNom()+"', DESCRIPCIO = '"+p.getDescripcio()+"', PREU = "+p.getPreu()+" WHERE CODI = '"+p.getCodi()+"'";
       String sentencia = "UPDATE PRODUCTE SET NOM = '" + p.getNom() + "', DESCRIPCIO = '" + p.getDescripcio() + "', PREU = " + p.getPreu() + " WHERE CODI = '" + p.getCodi() + "'";
        try {
           
              pst = con.prepareStatement(sentencia);// con esta sentencia se insertan los datos en la base de datos
             if (pst.executeUpdate() == 0){
                  modificado = false;
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            modificado = false;
        }finally {
            tancarRecurs(pst);
        }
        return modificado;
    }
     
      public boolean afegir2(Producte p) {
        boolean afegit = true;
        PreparedStatement pt = null;
        String sentencia = "INSERT INTO PRODUCTE(CODI,NOM,DESCRIPCIO,PREU)"
                + " VALUES(?,?,?,?)";
        try {
            pt = con.prepareStatement(sentencia);
            pt.setString(1, p.getCodi());
            pt.setString(2, p.getNom());
            pt.setString(3, p.getDescripcio());
            pt.setDouble(4, p.getPreu());

            if (pt.executeUpdate() == 0) {
                afegit = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            afegit = false;
        } finally {
            tancarRecurs(pt);
        }

        return afegit;
    }
    
    public boolean afegir(Producte p) {
        boolean afegit = true;
        Statement st = null;
        String sentencia = "INSERT INTO PRODUCTE(CODI,NOM,DESCRIPCIO,PREU)"
                + " VALUES('" +p.getCodi()+"','" + p.getNom() + "','" + p.getDescripcio() + "'," + p.getPreu() + ")";
        try {
            st = con.createStatement();
            if (st.executeUpdate(sentencia) == 0) {
                afegit = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            afegit = false;
        }
        return afegit;
    }

   

    public List<Producte> cercarTots() {
        String consulta = "SELECT * FROM PRODUCTE";
        Statement st;
        ResultSet rs;
        List<Producte> llista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                llista.add(new Producte(rs.getString(1),rs.getString(2),
                        rs.getString(3), rs.getDouble(4)));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }
    
    public List<Producte> cercarPerNom(String nom) {
        String consulta = "SELECT * FROM PRODUCTE WHERE NOM='"+nom+"'";
        Statement sts;
        ResultSet rsr;
        List<Producte> llista = new ArrayList<>();
        try {
            sts = con.createStatement();
            rsr = sts.executeQuery(consulta);
            while (rsr.next()) {
                llista.add(new Producte(rsr.getString(1),rsr.getString(2),
                        rsr.getString(3), rsr.getDouble(4)));
            }
            rsr.close();
            sts.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }
    
    public List<Producte> cercarPerCodi(String codi) {
        String consulta = "SELECT * FROM PRODUCTE WHERE CODI='"+codi+"'";
        Statement sts;
        ResultSet rsr;
        List<Producte> llista = new ArrayList<>();
        try {
            sts = con.createStatement();
            rsr = sts.executeQuery(consulta);
            while (rsr.next()) {
                llista.add(new Producte(rsr.getString(1),rsr.getString(2),
                        rsr.getString(3), rsr.getDouble(4)));
            }
            rsr.close();
            sts.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }
    
     public Producte mostrarPorCodigo(String codi) {
        String consulta = "SELECT * FROM PRODUCTE WHERE CODI='"+codi+"'";
        Producte p=null;
        Statement sts;
        ResultSet rsr;
        
        try {
            sts = con.createStatement();
            rsr = sts.executeQuery(consulta);
            while (rsr.next()) {
                p=(new Producte(rsr.getString(1),rsr.getString(2),
                        rsr.getString(3), rsr.getDouble(4)));
            }
            rsr.close();
            sts.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    private void tancarRecurs(AutoCloseable r) {
        try {
            r.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(DaoProducte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
