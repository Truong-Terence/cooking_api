package com.tp.cuisine.dao;

import com.tp.cuisine.model.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagDaoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetTagById() {
        TagDao tagDao = new TagDao();

        int tagId = 1;
        Tag tag = tagDao.getTagById(tagId);

        assertNotNull(tag);

        assertEquals(tagId, tag.getId());
        assertEquals("dinner", tag.getName());
    }
}