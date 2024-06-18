package com.example.calculator.ui.common

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.buildTestTag(string: String, vararg position: Int? = emptyArray()) = this.semantics {
    testTag = string.appendPosition(*position)
    testTagsAsResourceId = true
}

private fun String.appendPosition(vararg position: Int?): String {
    return StringBuilder(this).apply {
        position.forEach { if (it != null) append("_$it") }
    }.toString()
}