Lancer le programme :
Executer le fichier "Programme.jar"
Ou si l'executable ne fonctionne pas : Ouvrir le fichier "LeMain.java" avec un IDE (ou Geany) et l'executer.

Fenetre Accueil :
Nouvelle Patate : Lance le jeu avec une patate � customiser.
Continuer Patate : Lance un File Reader qui demande � l'utilisateur d'ouvrir un fichier save.objet .
Ce fichier de sauvegarde contient les informations sur le panel. Il permet de continuer � jouer avec une patate d�j� customis�e.

Fenetre Principale : 
Importer Une Image : Permet de rajouter une image dans l'onglet "Images Import�es" pour la session de jeu.
Dessiner Une Forme : Ouvre la Fen�tre Dessin qui permet de cr�er des formes personalis�es.
Exporter Ma Patate : Ouvre une boite de dialogue pour renseigner le nom de sa patate. Sauvegarde la session de jeu dans un fichier nom.objet .
Menu : Retourne � la fen�tre Accueil.

Onglets (Dans Fenetre Principale):
Permettent de selectionner la partie du corps que l'on veut ajouter � sa patate.
L'onglet Paysage change le fond qui n'est pas d�pla�able.
L'onglet Images Importees recense toutes les images import�es cette session et toutes les figures jamais cr��es.

How to play ?
Cliquez sur l'un des boutons repr�sentant une partie du corps. Ils s'affichent au centre de la fen�tre.
Ils sont ainsi d�pla�ables en maintenant le clic gauche de la souris et en la d�pla�ant.
On peut les enlever avec un clic droit.
Les fonds pr�sents dans Paysages sont interchangeables � souhait !
Attention, les formes s�l�ctionn�es se retrouvent en avant et peuvent cacher les autres images.
Pour plus d'esthetisme, n'h�sitez pas � poser la patate par dessus les jambes !

How to use Dessiner Une Forme ?
Apr�s avoir cliqu� sur Dessiner une forme dans la fen�tre principale voici les �tapes � suivre pour obtenir une jolie forme personnalis�e :
- Dessiner dans le rectangle gris � droite de l'image.
- Apr�s avoir fait un dessin (et seulement apr�s, sinon le programme va renvoyer des exceptions)
cliquez sur Analyser. Si votre dessin est de qualit� sup�rieure, l'algorithme de base d'analyse devrait
renvoyer une forme particuli�re (Rectangle / Oval / Triangle). Le bouton correspondant s'illumine ensuite.
- Cliquez sur Cr�er "Forme" (le bouton qui vient de s'illuminer) et une forme de base se dessinera � droite de l'�cran.
Vous pouvez changer son point d'ancrage, sa hauteur, sa largeur. Pour voir les modifications re-cliquez sur cr�er "Forme".

A tout moment vous pouvez cr�er une couleur personnalis�e avec le m�langeur RGB. Apr�s avoir fait votre choix gr�ce aux slider
cliquez sur Selectionner Couleur, et la couleur sera stock�e pour toutes les prochaines formes cr�es.

Vous pouvez aussi choisir de remplir ou non la prochaine forme cr��e en cliquant la checkbox "Remplir".

Apr�s avoir cr�� une forme (qui pourra devenir une des formes de l'image finale) cliquez sur Ajouter.
La forme se copiera � gauche de mani�re d�finitive et restera � droite pour faciliter la cr�ation.

Quand votre forme finale est cr��e, appuyez sur "Exporter". Vous pouvez d�s � pr�sent r�cr�er une forme
ou alors quitter la fen�tre Dessin et revenir sur la fen�tre principale. Votre forme fraichement cr��e vous attend
dans l'onglet : Forme Import�es.