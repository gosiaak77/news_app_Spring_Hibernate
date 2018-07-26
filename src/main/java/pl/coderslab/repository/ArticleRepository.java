package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {

    Article findArticleById(Long id);

    @Query("SELECT a FROM Article a WHERE a.draft=true ")
    List<Article> findAllDrafts();

}
