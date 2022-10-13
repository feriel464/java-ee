package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao_entities.Produit;

public class GestionProduitImpl implements Igestionproduit {

	@Override
	public List<Produit> getallproducts() {
		// TODO Auto-generated method stub
		Connection cnx=SingletonConnection.getConnection(); 
		List <Produit> liste=new ArrayList<>(); 
		try {
			PreparedStatement ps =cnx.prepareStatement("select* from Produit"); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Produit p=new Produit(); 
				p.setId(rs.getInt(1)); 
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				liste.add(p); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void addproduct(Produit p) {
		// TODO Auto-generated method stub
		Connection cnx= SingletonConnection.getConnection (); 
		try {
			PreparedStatement st=cnx.prepareStatement("insert into Produit(nom, prix, quantite)values(?,?,?)"); 
			st.setString(1, p.getNom());
			st.setDouble(2, p.getPrix());
			st.setInt(3, p.getQuantite());
			st.executeUpdate(); 
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void modifierProd(Produit p) {
		// TODO Auto-generated method stub
		Connection cnx =SingletonConnection.getConnection(); 
		try {
			PreparedStatement st=cnx.prepareStatement("update produit set nom=?,prix=?,quantite=? where id=?"); 
			st.setString(1, p.getNom());
			st.setDouble(2, p.getPrix());
			st.setInt(3, p.getQuantite());
			st.executeUpdate(); 
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
	}

	@Override
	public void SupprimerProd(int id) {
		// TODO Auto-generated method stub
		Connection cnx =SingletonConnection.getConnection(); 
		try {
			PreparedStatement st=cnx.prepareStatement("delete from produit where id=?");
		st.setInt(1, id);
		st.executeUpdate(); 
		}catch(SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public Produit getProduit(int id) {
		Connection cnx =SingletonConnection.getConnection(); 
		Produit p =null;
		try {
			PreparedStatement ps=cnx.prepareStatement("select * from produit where id=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				p=new Produit(); 
				p.setId(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return p;
	}

}
