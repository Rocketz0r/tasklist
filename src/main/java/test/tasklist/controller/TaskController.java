package test.tasklist.controller;


import java.util.List;


import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import test.tasklist.repos.Rep;
import test.tasklist.domen.EntityPr;

@RestController
@RequestMapping("tasklist")
public class TaskController {
    @Autowired
    private final Rep rep;

    @Autowired
    public TaskController(Rep rep) {
        this.rep = rep;
    }

    @GetMapping
    public List<test.tasklist.domen.EntityPr> list() {
        return rep.findAll();
    }

    @GetMapping("{id}")
    public Rep getOne(@PathVariable("id") Rep rep) {
        return rep;
    }

    @PostMapping
    public EntityPr create(@RequestBody EntityPr tasklist) {
        return rep.save(tasklist);
    }

    @PutMapping("{id}")
    public EntityPr update(
            @PathVariable("id") EntityPr tasklistFromDb,
            @RequestBody EntityPr tasklist
    ) {
        BeanUtils.copyProperties(tasklist, tasklistFromDb, "id");

        return rep.save(tasklistFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") test.tasklist.domen.EntityPr tasklist) {
        rep.delete(tasklist);
    }
}