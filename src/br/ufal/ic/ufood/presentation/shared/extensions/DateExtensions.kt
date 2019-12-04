package br.ufal.ic.ufood.presentation.shared.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToString(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}
