package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findArticleById(Long id);

    @Query("SELECT a FROM Article a WHERE a.draft=true ")
    List<Article> findAllDrafts();

    @Query(value = "SELECT * FROM articles ORDER BY created LIMIT 5", nativeQuery = true)
    List<Article> findLastFiveArticles();

}
