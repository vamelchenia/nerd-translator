package com.example.core.tags

import com.example.core.shared_preferences.PreferencesConstant
import com.example.core.shared_preferences.PreferencesManager

class TagsManagerRepositoryImpl(
    private var preferencesManager: PreferencesManager,
    private var tagsNumber: Int = 0
) : TagsManagerRepository {

    override fun createTag(tagName: String?): Boolean {
        preferencesManager.put(
            tagName,
            PreferencesConstant.TEST_TEXT
        )
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