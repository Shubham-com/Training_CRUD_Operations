package com.incture.training.subject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("MVC", "spring mvc", "enables to create web applications!!"),
                new Subject("JPA", "spring jpa", "enables to interact with database!!"),
                new Subject("AOP", "spring aop", "enables to implement aspects!!")
        ));

        public List<Subject> getSubjects() {

            //return subjects;
            List<Subject> subjectList = new ArrayList<>();
            for (Subject subject : subjectRepository.findAll()) {
                subjectList.add(subject);
            }
            return subjectList;
        }

        //TODO : Remove stream way of doing and do the normal way of matching the id from the subject list and return
        public Subject getSubject(String id){
            System.out.println("ID is " +id);
            return subjects.stream().filter(subject-> subject.getId().equals(id)).findFirst().get();
        }

        public void createSubject(Subject subject){

            //subjects.add(subject);
            subjectRepository.save(subject);
        }

    public void updateSubject(Subject subject, String id) {
            subjectRepository.save(subject);
//        for(int i=0;i<subjects.size();i++) {
//            Subject lSubject = subjects.get(i);
//            if (lSubject.getId().equals(id)) {
//                subjects.set(i, subject);
//                return;
//
//            }
//        }
        }

    public void deleteSubject(String id) {
        //subjects.removeIf(t->t.getId().equals(id));
        subjectRepository.deleteById(id);
    }
}