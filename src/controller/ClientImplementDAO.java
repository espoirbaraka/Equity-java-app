package controller;

import database.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import model.Client;

public class ClientImplementDAO implements DAO<Client> {

    @Override
    public void ajouter(Client entite) {
         try{
             Connection conn = Db.getConnection();
         String request="INSERT INTO client(nom,postnom,prenom,sexe,nationalite) VALUES(?,?,?,?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
