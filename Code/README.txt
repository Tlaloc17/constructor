Lancer le programme :
Executer le fichier "Programme.jar"
Ou si l'executable ne fonctionne pas : Ouvrir le fichier "LeMain.java" avec un IDE (ou Geany) et l'executer.

Fenetre Accueil :
Nouvelle Patate : Lance le jeu avec une patate à customiser.
Continuer Patate : Lance un File Reader qui demande à l'utilisateur d'ouvrir un fichier save.objet .
Ce fichier de sauvegarde contient les informations sur le panel. Il permet de continuer à jouer avec une patate déjà customisée.

Fenetre Principale : 
Importer Une Image : Permet de rajouter une image dans l'onglet "Images Importées" pour la session de jeu.
Dessiner Une Forme : Ouvre la Fenêtre Dessin qui permet de créer des formes personalisées.
Exporter Ma Patate : Ouvre une boite de dialogue pour renseigner le nom de sa patate. Sauvegarde la session de jeu dans un fichier nom.objet .
Menu : Retourne à la fenêtre Accueil.

Onglets (Dans Fenetre Principale):
Permettent de selectionner la partie du corps que l'on veut ajouter à sa patate.
L'onglet Paysage change le fond qui n'est pas déplaçable.
L'onglet Images Importees recense toutes les images importées cette session et toutes les figures jamais créées.

How to play ?
Cliquez sur l'un des boutons représentant une partie du corps. Ils s'affichent au centre de la fenêtre.
Ils sont ainsi déplaçables en maintenant le clic gauche de la souris et en la déplaçant.
On peut les enlever avec un clic droit.
Les fonds présents dans Paysages sont interchangeables à souhait !
Attention, les formes séléctionnées se retrouvent en avant et peuvent cacher les autres images.
Pour plus d'esthetisme, n'hésitez pas à poser la patate par dessus les jambes !

How to use Dessiner Une Forme ?
Après avoir cliqué sur Dessiner une forme dans la fenêtre principale voici les étapes à suivre pour obtenir une jolie forme personnalisée :
- Dessiner dans le rectangle gris à droite de l'image.
- Après avoir fait un dessin (et seulement après, sinon le programme va renvoyer des exceptions)
cliquez sur Analyser. Si votre dessin est de qualité supérieure, l'algorithme de base d'analyse devrait
renvoyer une forme particulière (Rectangle / Oval / Triangle). Le bouton correspondant s'illumine ensuite.
- Cliquez sur Créer "Forme" (le bouton qui vient de s'illuminer) et une forme de base se dessinera à droite de l'écran.
Vous pouvez changer son point d'ancrage, sa hauteur, sa largeur. Pour voir les modifications re-cliquez sur créer "Forme".

A tout moment vous pouvez créer une couleur personnalisée avec le mélangeur RGB. Après avoir fait votre choix grâce aux slider
cliquez sur Selectionner Couleur, et la couleur sera stockée pour toutes les prochaines formes crées.

Vous pouvez aussi choisir de remplir ou non la prochaine forme créée en cliquant la checkbox "Remplir".

Après avoir créé une forme (qui pourra devenir une des formes de l'image finale) cliquez sur Ajouter.
La forme se copiera à gauche de manière définitive et restera à droite pour faciliter la création.

Quand votre forme finale est créée, appuyez sur "Exporter". Vous pouvez dès à présent récréer une forme
ou alors quitter la fenêtre Dessin et revenir sur la fenêtre principale. Votre forme fraichement créée vous attend
dans l'onglet : Forme Importées.