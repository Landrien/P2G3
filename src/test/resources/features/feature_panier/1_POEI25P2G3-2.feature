@POEI25P2G3-94
@REQ_POEI25P2G3-2
Feature: Cart Erreur
	#Le lien du panier "Cart" renvoie à une erreur.
	#En cliquant sur le lien "Cart un message d'erreur s'affiche
	#
	#!image-20250414-080743.png|width=342,height=46,alt="image-20250414-080743.png"!
	#
	#Sans accés au panier aucune commande n'est possible

	#Le lien du panier doit rediriger le site sur la page "Shopping Cart Summary"
	@POEI25P2G3-50 @POEI25P2G3-88 @Confirmation @TNR
	Scenario Outline: Redirection vers Shopping Cart Summary
		Given the user is on the "<page>" page
		When the user clicks on the cart logo
		Then the user is redirected to the 'Shopping Cart Summary' page
		
		Examples:
			| page           |
			| homepage       |
			| authentication |
			| search_results |
			| article_detail |
		
