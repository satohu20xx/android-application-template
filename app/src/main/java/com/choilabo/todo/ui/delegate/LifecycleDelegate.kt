package com.choilabo.todo.ui.delegate

import android.os.Bundle


/**
 * Created by sato_shinichiro on 2017/12/12.
 */
interface LifecycleDelegate {

    fun onCreate(savedInstanceState: Bundle?) {
    }

    fun onStart() {
    }

    fun onResume() {
    }

    fun onPause() {
    }

    fun onStop() {
    }

    fun onDestroy() {
    }
}