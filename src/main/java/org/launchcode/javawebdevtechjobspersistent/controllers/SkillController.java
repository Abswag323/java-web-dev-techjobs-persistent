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


    @Autowired
    SkillRepository skillRepository;


    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @GetMapping
    public String getAllSkills(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }

        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkills(Model model, @PathVariable int skillId) {

        Optional<Skill> result = skillRepository.findById(skillId);

        if(!result.isEmpty()) {
            model.addAttribute("skill", result.get());
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

