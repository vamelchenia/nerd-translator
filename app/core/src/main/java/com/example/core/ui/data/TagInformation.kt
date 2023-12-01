package com.example.core.ui.data

import java.time.LocalDate

data class TagInformation(
    val tagId: Long,
    val tagName: String,
    val tagCount: Int,
    val creationDate: LocalDate,
    val modificationDate: LocalDate
) {
}