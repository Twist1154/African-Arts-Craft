package za.ac.cput.factory;

import za.ac.cput.domain.Categories;
import za.ac.cput.util.Helper;

/**
 * CategoryFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class CategoriesFactory {

    public static Categories buildCategory(Long id, String name, String description) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description)
        ) return null;

        return new Categories.Builder()
                .setCategoryId(id)
                .setName(name)
                .setDescription(description)
                .build();
    }
}
