package nfa032.td.td3;

public class Stock {
	private Produit[] pTab;
	
	public Stock() {
		this.pTab = new Produit[0];
	}
	
	public void ajout (Produit p) {
		if(this.pTab.length == 0) {
			this.pTab = new Produit[1];
			this.pTab[0] = p;
		}
		else {
			Produit[] pTabTemp = new Produit[this.pTab.length+1];
			int i = 0;
			for(i =0; i<this.pTab.length;i++) {
				if(this.pTab[i].getRef() < p.getRef()) {
					pTabTemp[i] = this.pTab[i];
				}
				else {
					pTabTemp[i]=p;
				}
			}
			
			if(i == this.pTab.length) {
				pTabTemp[i]=p;
			}
			this.pTab = new Produit[this.pTab.length+1];
			this.pTab = pTabTemp;
		}
	}
	
	public void afficher() {
		System.out.println("Affichage du stock de produit :");
		for(int i = 0; i<this.pTab.length;i++) {
			System.out.println("********************************");
			this.pTab[i].afficher();
		}
	}
	
	public void afficher(int ref) {
		int i = 0;
		for(i = 0; i<this.pTab.length;i++) {
			if(this.pTab[i].getRef() == ref) {
				this.pTab[i].afficher();
			}
		}
		if(i == this.pTab.length-1) {
			System.out.println("Produit non trouvé");
		}
	}
}
