package otus.gpb.homework.fragments

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

const val COLOR_REQUEST_KEY = "request_key"
const val COLOR_RESULT_KEY = "result_key"

fun Fragment.sendResult(data: Int, isTablet: Boolean = false) {
    if (isTablet) {
        requireActivity().supportFragmentManager.setFragmentResult(COLOR_REQUEST_KEY, bundleOf(COLOR_RESULT_KEY to data))
    } else {
        setFragmentResult(COLOR_REQUEST_KEY, bundleOf(COLOR_RESULT_KEY to data))
    }
}

fun Fragment.observeResult(isTablet: Boolean = false, callback: (Int) -> Unit) {
    if (isTablet) {
        requireActivity().supportFragmentManager.setFragmentResultListener(COLOR_REQUEST_KEY, viewLifecycleOwner) { _, bundle ->
            val data = bundle.getInt(COLOR_RESULT_KEY)
            callback(data)
        }
    } else {
        setFragmentResultListener(COLOR_REQUEST_KEY) { _, bundle ->
            val data = bundle.getInt(COLOR_RESULT_KEY)
            callback(data)
        }
    }
}