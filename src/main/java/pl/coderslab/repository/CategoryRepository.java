package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(Long id);



}
