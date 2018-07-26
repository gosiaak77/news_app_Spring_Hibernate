package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Article;
import pl.coderslab.repository.ArticleRepository;


public class ArticleConverter implements Converter<String,Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article convert(String id) {
        return articleRepository.findArticleById(Long.valueOf(id));
    }

}
