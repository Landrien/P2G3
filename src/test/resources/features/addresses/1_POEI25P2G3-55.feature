@POEI25P2G3-91
@REQ_POEI25P2G3-21
Feature: US 10 - Gérer mes coordonnées
    #En tant qu' Utilisateur
	#
	# Je souhaite Gérer mes coordonnées
	#
	#Afin de De pouvoir gérer mes informations de livraison pour les commandes
	#
	#Règles de gestion :
	#
	#* RG1 : Dans la page "My Account", le site doit afficher un espace "My Address" avec les coordonnées du client (nom prénom, adresse, téléphone)
	#* RG2 : Dans l'espace page "My Address" l'utilisateur doit avoir la possibilité de mettre à jour ses informations
	#* RG3 : Dans l'espace page "My Address" l'utilisateur doit avoir la possibilité de créer d'autres addresses

    #Dans la page "My Account", le site doit afficher un espace "My Adress" avec les coordonnées du client (nom prénom, addresse, téléphone)
    @POEI25P2G3-55 @POEI25P2G3-89 @TNR
    Scenario: Affichage des coordonnées
        Given the user is connected with an account with addresses
        And the user is on the My Addresses page
        Then the page should contain the address details of the user