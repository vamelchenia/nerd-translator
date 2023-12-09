package com.example.core.tags

class TagsManagerRepositoryImpl(
    private var tagsNumber: Int = 0
) : TagsManagerRepository {

    override fun createTag(): Boolean {
        tagsNumber += 1
        return true
    }

    override fun getTagsNumber(): Int {
        return tagsNumber
    }

    override fun getTags(): Boolean {
        return true
    }

    override fun areTagsExisting(): Boolean {
        return tagsNumber > 0
    }

    override fun isFirstTag(): Boolean {
        return tagsNumber == 1
    }
}