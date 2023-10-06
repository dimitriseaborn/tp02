/*  420-201 - TP2
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */

import java.util.Scanner;

public class TP2G3SeabornD2351867 {
    public TP2G3SeabornD2351867() {
        tester_calculerRabaisEscalier();
        afficherCalculerMoyenne();
        tester_estProche();
        tester_afficherDroite();
    }

    private void tester_afficherDroite() {
        afficherDroite(1, 0, 6);
        afficherDroite(.5, 0, 10);
        afficherDroite(-2, 6, 10);
        afficherDroite(-1, 6, 10);
    }

    private void afficherDroite(double pente, double ordoneeALOrigine, int dimensionQuadrant) {
        String str = "Pente = " + pente + "; Ordonnée à l'origine = " + ordoneeALOrigine + "; Dim quadrant = " + dimensionQuadrant + '\n';

        //Les lignes s'affichent de haut en bas, on inverse donc l'ordre de leur itération
        for (int ligne = dimensionQuadrant - 1; ligne >= 0; ligne--) {
            for (int colonne = 0; colonne < dimensionQuadrant; colonne++) {
                double y = pente * colonne + ordoneeALOrigine;
                if (estProche(colonne, ligne, colonne, y, 0.49)) {
                    //Si la différence entre le y du caractère et le y de la pente est ≤ 0.49, c'est donc une étoile
                    str += '*';
                } else if (colonne == 0 || ligne == 0) {
                    //On ne colorie les axes que si la droite n'y passe pas
                    str += '+';
                } else {
                    //Espace vide
                    str += ' ';
                }
            }
            str += '\n';
        }
        System.out.println(str);
    }

    private void tester_estProche() {
        System.out.println(estProche(2, 3, 4, 5, 2.83));
        System.out.println(estProche(0, 0, 1, -1, 1.5));
        System.out.println(estProche(10, 10, 10, 10, 0));
        System.out.println(estProche(3, 4, 1, 2, 2.83));
        System.out.println(estProche(3, 4, 1, 2, 2.82) == false);
    }

    private boolean estProche(double x1, double y1, double x2, double y2, double distanceProche) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance <= distanceProche;
    }

    private void afficherCalculerMoyenne() {
        double somme = 0;
        int nombreLu;
        int i = 0;

        System.out.println("** Calculer la moyenne de nombres positifs. **");
        System.out.println("Entrez un nombre négatif pour arrêter");
        do {
            nombreLu = lireEntier("Entrez le nombre #" + (i + 1) + ":");
            if (nombreLu >= 0) {
                somme += nombreLu;
            }
            i++;
        } while (nombreLu >= 0);

        if (i > 1) {
            System.out.println("La moyenne des " + (i - 1) + " nombres est : " + somme / (i - 1));
        } else {
            System.out.println("Il faut entrer au moins un nombre pour calculer une moyenne.");
        }
    }

    private void tester_calculerRabaisEscalier() {
        System.out.println(calculerRabaisEscalier(100, 1) == 0);
        System.out.println(calculerRabaisEscalier(100, 2) == 0);
        System.out.println(calculerRabaisEscalier(100, 3) == 3);
        System.out.println(calculerRabaisEscalier(100, 5) == 3);
        System.out.println(calculerRabaisEscalier(100, 6) == 10);
        System.out.println(calculerRabaisEscalier(100, 11) == 10);
        System.out.println(calculerRabaisEscalier(100, 12) == 15);
        System.out.println(calculerRabaisEscalier(100, 13) == 15);
        System.out.println(calculerRabaisEscalier(1000, 13) == 150);
    }

    private double calculerRabaisEscalier(double prixTotal, int nbArticle) {
        double rabais;

        if (nbArticle <= 2) {
            rabais = 0;
        } else if (nbArticle <= 5) {
            rabais = 0.03 * prixTotal;
        } else if (nbArticle <= 11) {
            rabais = 0.1 * prixTotal;
        } else {
            rabais = 0.15 * prixTotal;
        }
        return rabais;
    }

    private String lireString(String question) {
        Scanner sc;
        String reponse;

        sc = new Scanner(System.in);
        System.out.print(question + ' '); //Éviter que la réponse soit collée à la question
        reponse = sc.nextLine();
        return reponse;
    }

    private int lireEntier(String question) {
        int reponse;

        reponse = Integer.parseInt(lireString(question));
        return reponse;
    }

    public static void main(String[] args) {
        new TP2G3SeabornD2351867();
    }
}
