package com.example.core.tags

interface TagsManagerRepository {
    fun createTag(tagName: String?): Boolean
    fun getTags(): Boolean
    fun getTagsNumber(): Int
    fun areTagsExisting(): Boolean
    fun isFirstTag(): Boolean
}