package controller;

import java.util.List;

public interface DAO<Table> {
    public void ajouter(Table entite);
    public void modifier(Table entite);
    public void supprimer(Table entite);
    public List<Table> list();
    public Table get(int id);
}
