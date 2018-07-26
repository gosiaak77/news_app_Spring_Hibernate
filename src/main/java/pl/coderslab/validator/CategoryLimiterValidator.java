package pl.coderslab.validator;

import pl.coderslab.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CategoryLimiterValidator implements ConstraintValidator<CategoryLimiter, List<Category>> {
    private int limit;

    @Override
    public void initialize(CategoryLimiter categoryLimiter) {
        this.limit = categoryLimiter.value();
    }

    @Override
    public boolean isValid(List<Category> categories, ConstraintValidatorContext constraintValidatorContext) {
        return categories.size()<this.limit;
    }
}
