package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village du chef " + chef.getNom() 
		+ " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i ++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		
		Village village;
		village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		/*J'obtiens: Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		Type mismatch: cannot convert from void to Gaulois*/
		
		Chef abra;
		abra = new Chef("Abraracourcix", 6, village);
		Gaulois asterix, obelix;
		asterix = new Gaulois("Astérix", 8);
		obelix = new Gaulois("Obélix", 25);
		
		village.setChef(abra);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//Il s'affiche null car le gaulois astérix est à l'indice 0 et non 1 du tableau villageois
		village.afficherVillage();
		
	}
}
