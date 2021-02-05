package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    //Add a private field of EmployerRepository type called employerRepository to EmployerController.
    // Give this field an @Autowired annotation.
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }
    //processAddEmployerForm already takes care of sending the form back if any of the submitted employer object information is invalid.
    // However, it does not yet contain the code to save a valid object.
    // Use employerRepository and the appropriate method to do so.
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill); //ks added to save new employers
        return "redirect:";
    }
    // displayViewEmployer will be in charge of rendering a page to view the contents of an individual employer object.
    // It will make use of that employer object’s id field to grab the correct information from employerRepository.
    // optEmployer is currently initialized to null.
    // Replace this using the .findById() method with the right argument to look for the given employer object from the data layer.
    @GetMapping("view/{skillID}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        //Optional optEmployer = null; KS Replaced by following line
        Optional optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            Skill skill = (Skill) optionalSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
