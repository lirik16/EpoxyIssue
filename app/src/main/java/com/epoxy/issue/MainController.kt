package com.epoxy.issue

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController

data class Item(val value: Int)

class MainController(private val valueClickListener: (value: Int) -> Unit) : TypedEpoxyController<List<Item>>() {
    override fun buildModels(data: List<Item>?) {
        if (data == null) {
            return
        }

        data.forEachIndexed { index, item ->
            cardWithSingleLineText {
                id(index)
                itemText(item.value.toString())
                clickListener { _: View -> valueClickListener(item.value) }
            }
        }
    }
}