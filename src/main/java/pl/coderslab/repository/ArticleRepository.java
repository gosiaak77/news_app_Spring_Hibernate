package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM articles WHERE id = :id", nativeQuery = true)
    Article findArticleById(@Param("id")Long id);

    @Query("SELECT a FROM Article a WHERE a.draft=true ")
    List<Article> findAllDrafts();

}
