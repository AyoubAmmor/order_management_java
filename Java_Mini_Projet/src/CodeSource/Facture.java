package CodeSource;

import java.sql.Date;

public class Facture {
	
	
		int numFacture;
		Date dateFacture;
		double montant;
		
		public Facture() {}
		
		public Facture(	int numFacture,Date dateFacture, double montant) {
			this.numFacture=numFacture;
			this.dateFacture=dateFacture;
			this.montant=montant;
		}


}
