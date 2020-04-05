package com.raudonikis.core

import android.os.SystemClock
import android.view.View
import java.util.*

/**
 * A Debounced OnClickListener
 * Rejects clicks that are too close together in time.
 * This class is safe to use as an OnClickListener for multiple views, and will debounce each one separately.
 *
 *  * @param [minimumInterval] - The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
 */
class DebounceOnClickListener(
    private val onClick: (view: View) -> Unit,
    private val minimumInterval: Long = 1000L
) : View.OnClickListener {
    private val lastClickMap: MutableMap<View, Long> = WeakHashMap()

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()

        if (previousClickTimestamp == null || currentTimestamp - previousClickTimestamp.toLong() > minimumInterval) {
            onClick.invoke(clickedView)
            lastClickMap[clickedView] = currentTimestamp
        }
    }
}