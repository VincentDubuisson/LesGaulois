package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force; 
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
		
	}
	
	private String prendreParole() {
		return ("Le gaulois " + nom + " : ");
		
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0) {
			String txt = "";
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this ,trophees[i]);
				txt += "- " + trophees[i];
			}
			parler(txt);
		}
	}


	
	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		Romain minus;
		minus = new Romain("Minus", 5);
		asterix.frapper(minus);
		asterix.boirePotion(3);
		asterix.frapper(minus);
	}
}