package dev.jianastrero.formdsl.form.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

internal sealed interface FormItem {
    @Composable
    fun Composable()
}

internal sealed class TextFormItem : FormItem {
    abstract val text: String
    abstract val color: Color
    abstract val fontSize: TextUnit
    abstract val fontWeight: FontWeight

    @Composable
    override fun Composable() {
        Text(
            text = text,
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            lineHeight = fontSize,
        )
    }
}

internal data class Title(
    override val text: String,
    override val color: Color = Color.Unspecified,
    override val fontSize: TextUnit = 24.sp,
    override val fontWeight: FontWeight = FontWeight.Bold,
) : TextFormItem()

internal data class Subtitle(
    override val text: String,
    override val color: Color = Color.Unspecified,
    override val fontSize: TextUnit = 14.sp,
    override val fontWeight: FontWeight = FontWeight.Normal,
) : TextFormItem()

@Preview
@Composable
private fun TitlePreview() {
    Title(
        text = "Title",
    ).Composable()
}

@Preview
@Composable
private fun SubtitlePreview() {
    Subtitle(
        text = "Subtitle",
    ).Composable()
}
