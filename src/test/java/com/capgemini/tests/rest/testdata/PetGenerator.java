package com.capgemini.tests.rest.testdata;

import com.capgemini.tests.rest.model.Category;
import com.capgemini.tests.rest.model.Pet;
import com.capgemini.tests.rest.model.Tag;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;

public class PetGenerator {

    public static Pet getPet() {
        Category category = new Category();
        category.setId(Integer.valueOf(RandomStringUtils.randomNumeric(5)));
        category.setName("CategoryName_" + RandomStringUtils.randomAlphabetic(5));

        Pet pet = new Pet();
        pet.setId(Long.valueOf(RandomStringUtils.randomNumeric(6)));
        pet.setCategory(category);
        pet.setName("burek" + RandomStringUtils.randomAlphabetic(5));

        Faker faker = new Faker();
        String url = faker.internet().url();
        pet.setPhotoUrls(Collections.singletonList(url));

        Tag tag = new Tag();
        tag.setId(Integer.valueOf(RandomStringUtils.randomNumeric(5)));
        tag.setName(faker.funnyName().name());
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus(PetStatusEnum.AVAILABLE.getStatus());

        return pet;

    }
}
