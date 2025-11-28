package tn.essat.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tn.essat.dao.IDepartement;
import tn.essat.dao.IEmploye;
import tn.essat.dao.IProjet;
import tn.essat.dao.IUser;
import tn.essat.model.Departement;
import tn.essat.model.Employe;
import tn.essat.model.Projet;
import tn.essat.model.User;

@Controller
public class AppCRT {
    // nnjecto 4
    @Autowired
    IUser user_dao;
    @Autowired
    IDepartement dao_dept;
    @Autowired
    IProjet dao_proj;
    @Autowired
    IEmploye dao_emp;

    @GetMapping("/login")
    public String f1(Model m) {
        return "page1";
    }

    // mapping y5dmha w mapping yrj3ha
    @PostMapping("/verif")
    public String f2(Model m, HttpServletRequest req, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User u = user_dao.findByUsernameAndPassword(username, password);
        if (u == null) {
            return "redirect:/login";
        } else {
            session.setAttribute("u", u);
            return "redirect:/home";
        }
    }

    @GetMapping("/home")
    public String f3(Model m) {
        List<Departement> liste=dao_dept.findAll();
        m.addAttribute("liste",liste);
        return "page2";
    }

    @GetMapping("/projets/{id}")
    public String f4(Model m, @PathVariable int id) {
        List<Projet> liste=dao_proj.getProjetsDepts(id);
        m.addAttribute("liste",liste);
        Optional<Departement> dept= dao_dept.findById(id);
        m.addAttribute("dept",dept.get());
        return "page3";
    }

    @GetMapping("/employes/dept/{id}")
    public String f5(Model m, @PathVariable int id) {
        List<Employe> liste=dao_emp.getListe2(id);
        Optional<Departement> dept= dao_dept.findById(id);
        m.addAttribute("liste",liste);
        m.addAttribute("dept",dept.get());
        return "page4";
    }

    @GetMapping("/employes/proj/{id}")
    public String f6(Model m, @PathVariable int id) {
        List<Employe> liste=dao_emp.getListe1(id);
        Optional<Projet> proj= dao_proj.findById(id);
        m.addAttribute("liste",liste);
        m.addAttribute("proj",proj.get());
        return "page5";
    }

    @GetMapping("/ajoutProjet")
    public String ajoutProjet(Model m) {
        Projet p = new Projet();  // Bean vide pour binding
        m.addAttribute("projet", p);
        List<Departement> depts = dao_dept.findAll();  // Pour le select
        m.addAttribute("depts", depts);
        return "ajoutProjet";  // Ta JSP Fig.5
    }

    @PostMapping("/saveProjet")
    public String saveProjet(@ModelAttribute Projet p, Model m) {
        System.out.println("Debug: Titre=" + p.getTitre() + ", Etat=" + p.getEtat() + ", Dept ID bindé=" + (p.getDept() != null ? p.getDept().getId() : "NULL"));  // Debug console

        // Fix relation : Fetch Departement par ID bindé et set sur Projet
        if (p.getDept() != null && p.getDept().getId() != null) {
            Optional<Departement> optDept = dao_dept.findById(p.getDept().getId());
            if (optDept.isPresent()) {
                p.setDept(optDept.get());  // Set l'entité complète
            } else {
                // Erreur : Dept inexistant (optionnel, pour prod)
                m.addAttribute("error", "Département invalide !");
                m.addAttribute("depts", dao_dept.findAll());
                return "ajoutProjet";  // Reload form avec erreur
            }
        }

        dao_proj.save(p);  // Sauvegarde OK, dept_id set en DB
        System.out.println("Projet sauvé avec ID=" + p.getId());  // Debug
        return "redirect:/home";  // Redirect Fig.1
    }

    @GetMapping("/ajoutEmploye")
    public String ajoutEmploye(Model m) {
        Employe e = new Employe();
        m.addAttribute("employe", e);
        List<Departement> depts = dao_dept.findAll();
        m.addAttribute("depts", depts);
        List<Projet> projs = dao_proj.findAll();
        m.addAttribute("projs", projs);
        return "ajoutEmploye";
    }

    @PostMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute Employe e, Model m) {
        dao_emp.save(e);
        return "redirect:/home";
    }
    
    
 // ... Autres imports et méthodes existantes ...

    @GetMapping("/logout")  // Mapping pour déconnexion (GET simple)
    public String logout(HttpSession session) {
        session.invalidate();  // Invalide la session (supprime "u")
        return "redirect:/login";  // Redirige vers page de connexion
    }
}