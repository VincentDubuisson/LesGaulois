package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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
	
//	public void recevoirCoup(int forceCoup) {
//		int force1 = force;
//		assert(force > 0);
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert(force < force1);
//	}
	
	public void sEquiper(Equipement eqmt) {
        switch (nbEquipement) {
            case 0:
                equipements[0] = eqmt;
                nbEquipement++;
                System.out.println("Le soldat "+ nom + " s'équipe avec un " + eqmt + ".");
                break;
            case 1:
                if (equipements[0].equals(eqmt)) {
                	System.out.println("Le soldat "+ nom + " possède déjà un " + eqmt + " !");
                } else {
                    equipements[1] = eqmt;
                    nbEquipement++;
                    System.out.println("Le soldat "+ nom + " s'équipe avec un " + eqmt + ".");
                }
                break;
            case 2:
            	System.out.println("Le soldat "+ nom + " est déjà bien protégé !");
                break;
        }
    }
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
				parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null &&equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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