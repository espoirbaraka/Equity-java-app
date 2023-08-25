package controller;

import database.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Client;

public class ClientImplementDAO implements DAO<Client> {

    @Override
    public void ajouter(Client entite) {
         try{
             Connection conn = Db.getConnection();
         String request=
                 "INSERT INTO client"
                 + "(nom,postnom,prenom,sexe,nationalite) "
                 + "VALUES(?,?,?,?,?)";
         PreparedStatement st=conn.prepareStatement(request);
         st.setString(1, entite.getNom());
         st.setString(2, entite.getPostnom());
         st.setString(3, entite.getPrenom());
         st.setString(4, entite.getSexe());
         st.setString(5, entite.getNationalite());
         st.executeUpdate();
         JOptionPane.showMessageDialog(null, "Client ajouté");
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "error");
         }
    }

    @Override
    public void modifier(Client entite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Client entite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> list() {
        List<Client> list= new ArrayList<Client>();
        try{
            Connection conn = Db.getConnection();
            String rqt="SELECT * FROM client";
            PreparedStatement pr=conn.prepareStatement(rqt);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                Client cl=new Client();
                cl.setId(rs.getInt("id"));
                cl.setNom(rs.getString("nom"));
                cl.setPostnom(rs.getString("postnom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setSexe(rs.getString("sexe"));
                cl.setNationalite(rs.getString("nationalite"));
                
                list.add(cl);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    @Override
    public Client get(int id) {
        Client cl=new Client();
        try{
            Connection conn = Db.getConnection();
            String rqt="SELECT * FROM client WHERE id=?";
            PreparedStatement pr=conn.prepareStatement(rqt);
            pr.setInt(1, id);
            ResultSet res=pr.executeQuery();
            if(res.next()){
                cl.setId(res.getInt("id"));
                cl.setNom(res.getString("nom"));
                cl.setPostnom(res.getString("postnom"));
                cl.setPrenom(res.getString("prenom"));
                cl.setSexe(res.getString("sexe"));
                cl.setNationalite(res.getString("nationalite"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return cl;
    }
    
}
