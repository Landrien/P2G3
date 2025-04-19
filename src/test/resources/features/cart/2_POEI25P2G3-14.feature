@POEI25P2G3-94
@REQ_POEI25P2G3-14
Feature: US  9 - Accès panier d'achat
	#En tant qu' Utilisateur 
	#
	#Je souhaite Avoir un accès depuis toutes les pages vers mon panier d'achat (Cart) 
	#
	#Afin de De pouvoir finaliser mes commandes 
	#
	#Règles de gestion : 
	#
	#* RG1 : Le lien du panier doit rediriger le site sur la page "Shopping Cart Summary" 
	#* RG2 : Le lien du panier doit être ancré en entête (présent sur toutes les pages du site)

	#Le lien du panier doit rediriger le site sur la page "Shopping Cart Summary"
	@POEI25P2G3-50 @POEI25P2G3-88 @Confirmation @TNR
	Scenario Outline: Redirection vers Shopping Cart Summary
		Given the user is on the "<page>" page
		When the user clicks on the cart logo
		Then the user is redirected to the 'Shopping Cart Summary' page
		
		  Examples:
		    | page           |
		    | homepage       |
		    | search_results |
		    | article_detail |

	# TESTED : VALID