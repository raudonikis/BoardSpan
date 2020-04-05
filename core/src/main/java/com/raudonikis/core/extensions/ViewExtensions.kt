package com.raudonikis.core.extensions

import android.view.View
import com.raudonikis.core.DebounceOnClickListener

fun View.setOnDebouncedClickListener(onClick: (View) -> Unit) {
    setOnClickListener(DebounceOnClickListener(onClick))
}

fun View.setOnDebouncedClickListener(interval: Long, onClick: (View) -> Unit) {
    setOnClickListener(DebounceOnClickListener(onClick, interval))
}