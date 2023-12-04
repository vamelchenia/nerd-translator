package com.example.core.tags

class TagsManagerRepositoryImpl(
    private var tagCount: Int = 0
) : TagsManagerRepository {
    override fun getTagCount(): Int {
        return tagCount
    }

    override fun createTag(): Boolean {
        tagCount += 1
        return true
    }
}