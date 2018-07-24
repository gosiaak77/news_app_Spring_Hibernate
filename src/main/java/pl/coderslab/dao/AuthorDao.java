package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ArticleDao articleDao;

    public void save(Author author){
        if (author.getId() == null){
            em.persist(author);
        } else {
            em.merge(author);
        }
    }

    public void delete(Long id){
        Author author = findById(id);
        List<Article> articles = author.getArticles();
        for(Article article:articles){
            article.setAuthor(null);
            articleDao.save(article);
        }
        em.remove(em.contains(author) ? author : em.merge(author));
    }

    public Author findById(Long id){
        return em.find(Author.class, id);
    }

    public List<Author> findAll(){
        Query query = em.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }
}
