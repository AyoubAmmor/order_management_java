package CodeSource;

public class Produit {
	int numProduit,quantite;
	String nomProduit;
	double prix;
	
	public Produit() {
		
	}
	
	public Produit(int numProduit,String nomProduit,int quantite , double prix) {
		this.numProduit=numProduit;
		this.nomProduit=nomProduit;
		this.quantite=quantite;
		this.prix=prix;
	}

}
