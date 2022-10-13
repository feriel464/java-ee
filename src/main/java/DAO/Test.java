package DAO;

import java.sql.Connection;

import Dao_entities.Produit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection cnx=SingletonConnection.getConnection(); 
		if(cnx !=null)
			System.out.println("ok");
		Igestionproduit produit;
		Produit p=new Produit("ferfer", 11.1,3); 
		Produit p1=new Produit("feriel", 1545.1,5); 

		produit = new GestionProduitImpl();
		System.out.println(produit.getallproducts());
		produit.addproduct(p);
		produit.addproduct(p1);
		produit.SupprimerProd(2);
		produit.getProduit(5);

	}

}
