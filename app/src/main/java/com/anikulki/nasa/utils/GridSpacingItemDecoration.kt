package com.anikulki.nasa.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GridSpacingItemDecoration constructor(
    private val spanCount: Int,
    private val spacing: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view) // item position

        val column = position % spanCount // item column

        outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
        outRect.right =
            spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
        if (position >= spanCount) {
            outRect.top = spacing // item top
        }
    }

}