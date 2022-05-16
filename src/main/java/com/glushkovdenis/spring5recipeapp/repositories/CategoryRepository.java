package com.glushkovdenis.spring5recipeapp.repositories;

import com.glushkovdenis.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
