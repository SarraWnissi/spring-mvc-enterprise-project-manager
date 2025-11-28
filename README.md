# spring-mvc-enterprise-project-manager

[![Java](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/) [![SpringMVC](https://img.shields.io/badge/SpringMVC-5.x-green)](https://spring.io/projects/spring-framework) [![Maven](https://img.shields.io/badge/Maven-3.x-red)](https://maven.apache.org/) [![MySQL](https://img.shields.io/badge/MySQL-8.x-yellow)](https://www.mysql.com/) [![Tomcat](https://img.shields.io/badge/Tomcat-9%2B-orange)](https://tomcat.apache.org/) [![License](https://img.shields.io/badge/License-MIT-yellow)](./LICENSE)

---

## Description

**spring-mvc-enterprise-project-manager** est une application web développée avec **SpringMVC 5.x**, permettant la gestion des projets d'une entreprise structurée par départements. L'app utilise JPA pour les relations (ManyToOne), Spring Data pour les DAOs, et JSP/Bootstrap pour les vues dynamiques.

Le service expose des opérations pour consulter les départements, projets, employés, et ajouter de nouveaux éléments, avec authentification basique et navigation sidebar.

---

## Fonctionnalités

- **Liste des départements )**  
  Affiche tous les départements avec liens vers listes projets/employés.
- **Liste des projets par département**  
  Flux de projets filtrés par département sélectionné.
- **Liste des employés par département **  
  Affiche employés (ID, nom, fonction) d'un département.
- **Liste des employés par projet **  
  Affiche employés (ID, nom, fonction) d'un projet.
- **Ajout d'un projet **  
  Crée un projet avec titre, état (non lancé/active/achevé), et département.
- **Ajout d'un employé **  
  Crée un employé avec nom, fonction (manager/ingénieur/technicien), département, et projet optionnel.
- **🛠️ Authentification & Logout** : Login simple + invalidation session.
- **Navigation** : Sidebar cohérente sur toutes les pages.

---

## Technologies utilisées

- **Java 11+**
- **SpringMVC 5.x**
- **Spring Data JPA + Hibernate**
- **MySQL 8.x**
- **Maven**
- **JSP + JSTL + Bootstrap 5**

---

## Structure du projet

```
spring-mvc-enterprise-project-manager
│
├── src/main/java/tn/essat
│ ├── model/     # Classes JPA (Departement, Projet, Employe,User)
│ ├── dao/       # Interfaces Spring Data (IDepartement, IProjet, IEmploye,IUser)
│ └── controller/# AppCRT.java
│
├── src/main/resources
│ └── application.properties  # Config DB/JPA
│
├── src/main/webapp/WEB-INF
│ └── views/     # JSPs 
│
├── pom.xml
└── README.md
```

---

## Installation & Exécution

1. **Clone le repo** :
   ```
   git clone https://github.com/votre-user/spring-mvc-enterprise-project-manager.git
   cd spring-mvc-enterprise-project-manager
   ```

2. **Configure la DB** (MySQL) :
   - Crée la DB : `CREATE DATABASE tp3db;`
   - Exécute le script SQL pour données test :
     ```sql
     USE tp3db;
     INSERT INTO departement (nom) VALUES ('Développement'), ('Réseaux');
     INSERT INTO projet (titre, etat, dept_id) VALUES ('App Stock ERM', 'active', 1), ('P.Angular6', 'achevé', 1);
     INSERT INTO employe (nom, fonction, dept_id, proj_id) VALUES ('Chaker BM', 'ingénieur', 1, 2);
      -- Insert admin test (change password en prod !)
INSERT INTO user (nom, username, password) VALUES ('Admin User', 'admin', 'admin');
3. **Déploiement** :

   - Démarre Tomcat (port 8080).
   - Accède : `http://localhost:8080/AppTp3/login` (login: admin/admin → `/home` pour Fig.1).

4. **Test** :
   - `/home` :
   - Sidebar : Ajouts Figs 5-6.
   - Logout : "(Déconnexion)".

---

## Limites & Améliorations

- **Sécurité** : Login basique (plain text) ; ajoute Spring Security pour prod.
- **Validation** : Ajoute `@Valid` + erreurs JSP.

- **Figures** : UI match Figs 1-6 (Bootstrap pour tables/forms).



- [Votre Nom] – Étudiant ESSAT 3ème GL.

Questions ? Contactez-moi ! 🚀
