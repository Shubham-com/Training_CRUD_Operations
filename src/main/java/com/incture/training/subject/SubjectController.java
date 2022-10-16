package com.incture.training.subject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @RequestMapping("/hello")
    public String greetTrainees() {
        return "Hello!! Welcome to Incture";
    }

    @RequestMapping("/subjects")
    public List<Subject> getSubjects() {

        return subjectService.getSubjects();
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping("/subjects/{id}")
    public Subject getSubject(@PathVariable String id) {
        return subjectService.getSubject(id);
    }
    
      @RequestMapping("/subjects/{name}")
    public Subject getSubject(@PathVariable String name) {
        return subjectService.getSubject(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/subjects")
    public void createSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/subjects/{id}")
    public void updateSubject(@RequestBody Subject subject, @PathVariable String id) {
        subjectService.updateSubject(subject, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/subjects/{id}")
    public void deleteSubject(@PathVariable String id) {
        subjectService.deleteSubject(id);
    }
    
      @RequestMapping(method = RequestMethod.DELETE, value = "/subjects/{name}")
    public void deleteSubject(@PathVariable String name) {
        subjectService.deleteSubject(name);
    }

    @RequestMapping("/admin")
    public String getAdminResponse(){
        return "<H1>Response from Admin</H1>";
    }

    @RequestMapping("/users")
    public String getUsers(){
        return "<H1>Response from one particular users</H1>";
    }

    @RequestMapping("/")
    public String getResponses(){
        return "<H1>Response from every users</H1>";
    }

}
