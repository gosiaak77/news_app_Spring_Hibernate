package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager em;

    public void save(Article article){
        if(article.getId() == null) {
            em.persist(article);
        } else {
            em.merge(article);
        }
    }

    public void delete(Article article){
        em.remove(em.contains(article) ? article : em.merge(article));
    }

    public Article findById(Long id){
        return em.find(Article.class, id);
    }

    public List<Article> findAll(){
        Query query = em.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> findLast(Long id){
        Query query = em.createQuery("SELECT a FROM Article a ORDER BY a.created desc");
        query.setMaxResults(5);
        return query.getResultList();
    }


}
