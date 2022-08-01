package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.model.Student;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/student/result")
    public List<Result> getAllStudents() {
        return resultRepository.findAll();
    }

    @PostMapping("/student/resultAdd")
    public List<Result> addStudent(@RequestBody Result result) {
        resultRepository.save(result);
        return resultRepository.findAll();
    }

    @DeleteMapping("/student/resultDaelete/{id}")
    public List<Result> deleteStudent(@PathVariable Integer id) {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    @PutMapping("/student/resultUpdate/{id}")
    public List<Result> updateStudent(@RequestBody Result result, @PathVariable Integer id) {
        Result resultObj = resultRepository.findById(id).get();
        resultObj.setId(result.getId());
        resultObj.setCourseId(result.getCourseId());
        resultObj.setMarks(result.getMarks());
        resultRepository.save(resultObj);
        return resultRepository.findAll();
    }
}
