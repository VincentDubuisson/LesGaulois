package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	
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
	
	public void sEquiper(Equipement eqmt) {
        switch (nbEquipement) {
            case 0:
                equipement[0] = eqmt;
                nbEquipement++;
                System.out.println("Le soldat "+ nom + " s'équipe avec un " + eqmt + ".");
                break;
            case 1:
                if (equipement[0].equals(eqmt)) {
                	System.out.println("Le soldat "+ nom + " possède déjà un " + eqmt + " !");
                } else {
                    equipement[1] = eqmt;
                    nbEquipement++;
                    System.out.println("Le soldat "+ nom + " s'équipe avec un " + eqmt + ".");
                }
                break;
            case 2:
            	System.out.println("Le soldat "+ nom + " est déjà bien protégé !");
                break;
        }
    }
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Salut");
		minus.recevoirCoup(8);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
}