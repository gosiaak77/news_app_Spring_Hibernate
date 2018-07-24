package pl.coderslab.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.print.Book;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ArticleDao articleDao;

    public void save(Category category){
        if (category.getId() == null){
            em.persist(category);
        } else em.merge(category);
    }

    public void delete(Long id){
        Category category = findById(id);
        List<Article> articles = category.getArticles();
        for(Article article:articles){
            article.getCategories().remove(category);
            articleDao.save(article);
        }
        em.remove(em.contains(category) ? category : em.merge(category));
    }

    public Category findById(Long id){
        return em.find(Category.class, id);
    }

    public List<Category> findAll(){
        Query query = em.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }
}
