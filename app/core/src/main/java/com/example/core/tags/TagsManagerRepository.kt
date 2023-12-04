package com.example.core.tags

interface TagsManagerRepository {
    fun getTagsNumber(): Int
    fun createTag(): Boolean
}