package dev.jianastrero.formdsl.form

class FormBuilder {
    internal val pages = mutableListOf<PageBuilder>()

    fun page(builder: PageBuilder.() -> Unit) {
        val pageBuilder = PageBuilder().apply(builder)
        pages.add(pageBuilder)
    }
}
