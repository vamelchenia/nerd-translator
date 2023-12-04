package com.example.core.tags

class TagsManagerRepositoryImpl(
    private var tagsNumber: Int = 0
) : TagsManagerRepository {
    override fun getTagsNumber(): Int {
        return tagsNumber
    }

    override fun createTag(): Boolean {
        tagsNumber += 1
        return true
    }
}