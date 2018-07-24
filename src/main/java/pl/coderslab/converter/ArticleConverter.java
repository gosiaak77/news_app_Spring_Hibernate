package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;


public class ArticleConverter implements Converter<String,Article> {

    @Autowired
    ArticleDao articleDao;

    @Override
    public Article convert(String id) {
        return articleDao.findById(Long.valueOf(id));
    }

}
