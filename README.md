# README

Outils utilisés : 
-
- Git pour travailler en simultané sur le même dossier projet.
- phpMyAdmin pour implémenter puis gérer la base de données
- eclipse : pour coder nos servlets,.jsp, .html, classes java et tests JUnit
- Apache Tomcat 9.0


Améliorations apportées :
-
- annulerVisite => rajout d'un identifiant client en paramètre pour vérifier que le client annule sa réservation et pas celle d'un autre
- base de données => ajout d'un identifiant pour chaque table afin de mettre en place des clés étrangères dans Réservations
- Création de compte => inscription en renseignant un nom, un prénom, une adresse mail et un mot de passe
- Ajout d'un email et d'un mot de passe pour chaque client => Pour ouvrir une session lié à un et un seul client


Tests effectués :
-
  - reserverVisite
    ° réserver une visite existante
    ° ne pas pouvoir réserver une visite n'existant pas
  - payerVisite
    ° payer une réservation existante
    ° ne pas pouvoir payer une réservation n'existant pas
  - annulerVisite
    ° client qui annule une réservation payée existante et le concerant uniquement
    ° client qui annule une réservation non payée existante et le concerant uniquement
    ° ne pas pouvoir annuler une réservation n'existant pas
    ° ne pas pouvoir annuler une réservation exitante mais ne concernant pas le client
  - trouverVisite
    ° ne pas trouver une visite n'existant pas
    ° trouver une visite existante grâce au type de visite
    ° trouver plusieurs visites existantes grâce à la ville
    ° trouver une visite existante grâce à la date
    ° trouver une visite existante grâce au prix
    ° trouver une visite existante grâce à son code


Travail effectué :
- 

Laillé Clément
  - java (classe Réservation et méthodes annulerVisite, payerVisite, reserverVisite)
  - tests (annulerVisite et payerVisite)
  - wsdl serveur
  - processus pour payer une visite (servlet, jsp)

Le Borgne Clément
  - java (classe Visite et méthode trouverVisites)
  - tests (AllTests, trouverVisite et reserverVisite)
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
