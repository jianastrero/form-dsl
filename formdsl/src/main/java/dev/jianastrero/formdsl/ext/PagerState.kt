package dev.jianastrero.formdsl.ext

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
internal fun PagerState.formPage(page: Int): Int = currentPage - page

@OptIn(ExperimentalFoundationApi::class)
internal fun PagerState.formPageOffset(page: Int): Float {
    return (formPage(page) + currentPageOffsetFraction).absoluteValue
}
