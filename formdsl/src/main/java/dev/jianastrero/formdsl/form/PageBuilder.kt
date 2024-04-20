package dev.jianastrero.formdsl.form

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import dev.jianastrero.formdsl.form.item.FormItem
import dev.jianastrero.formdsl.form.item.Subtitle
import dev.jianastrero.formdsl.form.item.Title

class PageBuilder {
    internal val items = mutableListOf<FormItem>()

    fun title(
        text: String,
        color: Color = Color.Unspecified,
        fontSize: TextUnit = 24.sp,
        fontWeight: FontWeight = FontWeight.Bold,
    ) {
        items.add(
            Title(
                text = text,
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight,
            ),
        )
    }

    fun subtitle(
        text: String,
        color: Color = Color.Unspecified,
        fontSize: TextUnit = 14.sp,
        fontWeight: FontWeight = FontWeight.Normal,
    ) {
        items.add(
            Subtitle(
                text = text,
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight,
            ),
        )
    }
}
