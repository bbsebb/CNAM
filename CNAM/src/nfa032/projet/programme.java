package nfa032.projet;

public class programme {
	public static void main(String[] args) {
			String path = "src/nfa032/projet/img/chouette2.ppm";
			Image img = new Image(path);
			System.out.println("test");
			
			img.enregistrerImg("src/nfa032/projet/img/test3.ppm");
			img.foncerImg("bleu");
			img.foncerImg("bleu");
			img.foncerImg("bleu");
			img.enregistrerImg("src/nfa032/projet/img/testbleu.ppm");
			img.chargerImg(path);
			img.foncerImg("rouge");
			img.foncerImg("rouge");
			img.foncerImg("rouge");
			img.enregistrerImg("src/nfa032/projet/img/testrouge.ppm");
			img.chargerImg(path);
			img.foncerImg("vert");
			img.foncerImg("vert");
			img.foncerImg("vert");
			img.enregistrerImg("src/nfa032/projet/img/testvert.ppm");
			img.chargerImg(path);
			img.mettreEnNB();
			img.enregistrerImg("src/nfa032/projet/img/testNB.ppm");
			img.chargerImg(path);
			Image img2 = img.recadrer(10,150,20,100);
			img2.enregistrerImg("src/nfa032/projet/img/testRec.ppm");
	}
	
}
