package com.intern_api.controller;

import com.intern_api.model.Mark;
import com.intern_api.repository.StudentMark;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SecurityRequirement(name = "basicAuth")
@RestController
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    private StudentMark studentMark;

@PostMapping("/add")
    public Mark insertMark(@RequestBody Mark mark)
    {
        return  studentMark.save(mark);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mark>> getMarks()
    {
       List<Mark> result= studentMark.findAll();
       return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mark> getById(@PathVariable int id) {
        return studentMark.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id)
    {
        if(studentMark.existsById(id))
        {
            studentMark.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mark> update(@PathVariable int id,@RequestBody Mark newMark)
    {
        return studentMark.findById(id).map(existingmark->{
            existingmark.setMark1(newMark.getMark1());
            existingmark.setMark2(newMark.getMark2());
            existingmark.setMark3(newMark.getMark3());
            studentMark.save(existingmark);
            return ResponseEntity.ok(existingmark);
        })
                .orElse(ResponseEntity.notFound().build());

    }
}
