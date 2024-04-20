package dev.jianastrero.formdsl

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jianastrero.formdsl.color.FormColors
import dev.jianastrero.formdsl.ext.formPageOffset
import dev.jianastrero.formdsl.form.FormBuilder
import dev.jianastrero.formdsl.form.item.Subtitle
import dev.jianastrero.formdsl.form.item.Title

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalForm(
    modifier: Modifier = Modifier,
    colors: FormColors = FormDefaults.colors(),
    contentPadding: PaddingValues = PaddingValues(32.dp),
    formContent: FormBuilder.() -> Unit,
) {
    val density = LocalDensity.current

    val form by remember(formContent) {
        derivedStateOf {
            FormBuilder().apply(formContent)
        }
    }

    val pagerState = rememberPagerState { form.pages.size + 1 }
    var itemHeight by remember { mutableStateOf(0.dp) }

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(itemHeight),
        pageSpacing = -itemHeight / 4,
        modifier =
            modifier.onGloballyPositioned {
                itemHeight = with(density) { it.size.height.toDp() / 4 * 3 }
            },
    ) { pageIndex ->
        if (pageIndex == form.pages.size) {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(colors.contentColor.copy(alpha = 0.5f))
                    .graphicsLayer {
                    }
            )
            return@VerticalPager
        }

        val page = form.pages[pageIndex]
        val pageOffset = pagerState.formPageOffset(pageIndex)
        val lerp = pageOffset.coerceIn(0f, 1f)

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(
                        lerp(
                            start = colors.containerColor,
                            stop = colors.contentColor.copy(alpha = 0.4f),
                            fraction = lerp
                        )
                    )
                    .graphicsLayer {
                    }
                    .padding(contentPadding),
        ) {
            page.items.forEach { formItem ->
                when (formItem) {
                    is Title -> {
                        Text(
                            text = formItem.text,
                            color = formItem.color,
                            fontSize = formItem.fontSize,
                            fontWeight = formItem.fontWeight,
                            lineHeight = formItem.fontSize,
                        )
                    }
                    is Subtitle -> {
                        Text(
                            text = formItem.text,
                            color = formItem.color,
                            fontSize = formItem.fontSize,
                            fontWeight = formItem.fontWeight,
                            lineHeight = formItem.fontSize,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun VerticalFormPreview() {
    VerticalForm(modifier = Modifier.fillMaxSize()) {
        page {
            title(text = "Title 1")
            subtitle(text = "Subtitle 1")
        }
        page {
            title(text = "Title 2")
            subtitle(text = "Subtitle 2")
        }
        page {
            title(text = "Title 3")
            subtitle(text = "Subtitle 3")
        }
        page {
            title(text = "Title 4")
            subtitle(text = "Subtitle 4")
        }
    }
}
