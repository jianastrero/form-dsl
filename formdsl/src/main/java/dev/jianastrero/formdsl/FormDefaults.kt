package dev.jianastrero.formdsl

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.jianastrero.formdsl.color.FormColors

object FormDefaults {
    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        primaryColor: Color = MaterialTheme.colorScheme.primary,
        onPrimaryColor: Color = MaterialTheme.colorScheme.onPrimary,
    ) = FormColors(
        containerColor = containerColor,
        contentColor = contentColor,
        primaryColor = primaryColor,
        onPrimaryColor = onPrimaryColor,
    )
}
