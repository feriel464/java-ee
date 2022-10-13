package DAO;

import java.util.List;

import Dao_entities.Produit;

public interface Igestionproduit {
	List<Produit>getallproducts ();
	 void addproduct(Produit p);
	void modifierProd(Produit p); 
	void SupprimerProd(int id);
	public Produit getProduit(int id); 

}

