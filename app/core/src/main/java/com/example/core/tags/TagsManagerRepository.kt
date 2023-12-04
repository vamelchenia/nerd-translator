package com.example.core.tags

interface TagsManagerRepository {
    fun getTagCount(): Int
    fun createTag(): Boolean
}