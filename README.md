# README

Outils utilisés : 
-
- Git pour travailler en simultané sur le même dossier projet.
- phpMyAdmin pour implémenter puis gérer la base de données
- eclipse : pour coder nos servlets,.jsp et .html
- Apache Tomcat 9.0


Améliorations apportées :
-
- annulerVisite => rajout identifiant client pour vérifier que le client annule sa réservation
- base de données => ajout d'un identifiant pour chaque table afin de mettre en place des clés étrangères dans Réservations
- Ajout d'un email et d'un mot de passe pour chaque client => Pour ouvrir une session lié à un et un seul client


Tests effectués :
-
- réserver une visite existante
- ne pas pouvoir réserver une visite n'existant pas
- payer une réservation existante
- ne pas pouvoir payer une réservation n'existant pas
- client qui annule une réservation existante et le concerant uniquement 
- ne pas pouvoir annuler une réservation n'existant pas


Travail effectué :
- 

Laillé Clément
  - java
  - tests
  - wsdl serveur
  - processus pour payer une visite (servlet, jsp)

Le Borgne Clément
  - java
  - tests
  - wsdl client
  - processus pour annuler une visite (servlet, jsp)
  
Tourneur Virgil
  - Menu et réserver, trouver, annuler, payer (html)
  - Processus pour trouver une visite (servlet, jsp)

Vezin Frédéric
  - Login (html et servlet) 
  - Processus de réservation visite (servlet, jsp)
  - Stucture et Mise en place base de donées (+ .pdf et .sql)
  - Mise en page de ce ReadMe
