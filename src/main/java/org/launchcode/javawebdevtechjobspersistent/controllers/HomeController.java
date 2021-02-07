package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    // Add a field employerRepository annotated with @Autowired.
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        return "add";
    }
    // In processAddJobForm, add a parameter to the method to pass in the template variable you just found.
    // You’ll need to use the @RequestParam annotation on this parameter.
    // @RequestParam List<Integer> skills to add back to parameters
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
            return "add";
        }
        // add code inside of this method to select the employer object that has been chosen to be affiliated with the new job.
        // You will need to select the employer using the request parameter you’ve added to the method.
        Optional optEmployer = employerRepository.findById(employerId);
        Employer employer = (Employer) optEmployer.get();
        newJob.setEmployer(employer);
        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional optJob = jobRepository.findById(jobId);
        Job job = (Job) optJob.get();
        model.addAttribute("job", job);
        return "view";
    }


}
