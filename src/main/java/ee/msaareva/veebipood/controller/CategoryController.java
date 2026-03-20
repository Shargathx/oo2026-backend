package ee.msaareva.veebipood.controller;

import ee.msaareva.veebipood.entity.Category;
import ee.msaareva.veebipood.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // ebaturvaline, päris arendustes ei tehta
// @CrossOrigin(origins = "http://localhost:5173") // õige, turvaline viis
// @CrossOrigin(origins = "http://www.arvutitark.ee") // ainult see domeen pääseb ligi
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("categories")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @DeleteMapping("categories/{id}")
    public List<Category> deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id); // kustutan
        return categoryRepository.findAll(); // uuenenud seis
    }

    @PostMapping("categories")
    public List<Category> addCategory(@RequestBody Category category){
        categoryRepository.save(category); // siin salvestab
        return categoryRepository.findAll(); // siin on uuenenud seis
    }

}
