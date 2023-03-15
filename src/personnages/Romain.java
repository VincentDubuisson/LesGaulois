package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(force > 0);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int force1 = force;
		assert(force > 0);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(force < force1);
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Salut");
		minus.recevoirCoup(8);
	}
}