package villagegaulois;

import java.util.Iterator;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef " + chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom() + " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}

	private static class Marche {
		private Etal[] etals;

		private Marche(int nbEtals) {
			etals = new Etal[nbEtals];
			for (int i = 0; i < etals.length; i++) {
				etals[i]=new Etal();
			}
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			Etal etal = etals[indiceEtal];
			etal.occuperEtal(vendeur, produit, nbProduit);
		}

		private int trouverEtalLibre() {
			int haveEtal = -1;
			for (int i = 0; i < etals.length; i++) {
				if (!etals[i].isEtalOccupe()) {
					haveEtal = i;
				}
			}
			return haveEtal;
		}

		private Etal[] trouverEtals(String produit) {
			Etal[] etalProduit;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i]) {
					etalProduit.append(etals[i]);
				}
			}
		}
		
//		private void name() { test
//			
//		}
		private void afficherMarche() {
			for (int i = 0; i < etals.length; i++) {
				System.out.println(etals[i].afficherEtal());
			}
		}
		
		
		
		
		public static void main(String[] args) {
			Marche marche = new Marche(5);
			Gaulois gaulois = new Gaulois("Gaulois", 6);
			marche.afficherMarche();
			marche.utiliserEtal(4, gaulois, "pomme", 3);
			
			System.out.println(marche.trouverEtalLibre());
			System.out.println("\n ------------APRES------------ \n");
			marche.afficherMarche();
		}

	}


}