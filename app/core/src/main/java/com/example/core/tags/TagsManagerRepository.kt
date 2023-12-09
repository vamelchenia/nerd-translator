package com.example.core.tags

interface TagsManagerRepository {
    fun createTag(): Boolean
    fun getTags(): Boolean
    fun getTagsNumber(): Int
    fun areTagsExisting(): Boolean
    fun isFirstTag (): Boolean
}