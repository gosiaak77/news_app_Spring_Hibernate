package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import pl.coderslab.groupValidator.ValidationArticle;
import pl.coderslab.validator.CategoryLimiter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;


@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @Size(min=4, max = 200, groups = {ValidationArticle.class, Default.class})
    private String title;

    @ManyToOne
    @JoinColumn
    @NotNull(groups = ValidationArticle.class)
    private Author author;

    @Column(columnDefinition = "TEXT")
    @Size(min = 1, max = 500, groups = {ValidationArticle.class, Default.class})
    private String content;

    @ManyToMany(fetch = FetchType.EAGER)
    @CategoryLimiter(value = 3, groups = ValidationArticle.class)
    @NotNull(groups = ValidationArticle.class)
    private List<Category> categories = new ArrayList<>();


    @Column(updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    private boolean draft = false;

    public Article() {
    }

    public boolean getDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
