package com.example.githubrepoapp.data

import com.example.githubrepoapp.domain.model.IssueState
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun mapToIssueState(state: String): IssueState {
    return when (state.lowercase(Locale.ROOT)) {
        "open" -> IssueState.Open
        else -> IssueState.Closed
    }
}

fun formatDateString(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")

    // Parse the date string into a LocalDateTime object
    val dateTime = LocalDateTime.parse(dateString, formatter)

    // Convert to ZonedDateTime using UTC time zone
    val zonedDateTime = dateTime.atZone(ZoneId.of("UTC"))

    // Extract date and time components
    val year = zonedDateTime.year
    val month = zonedDateTime.monthValue
    val day = zonedDateTime.dayOfMonth
    val hour = zonedDateTime.hour
    val minute = zonedDateTime.minute

    // Determine AM or PM using the hour variable
    val amPm = if (hour >= 12) "PM" else "AM"

    // Return the formatted string
    return "Created At: $year-$month-$day, $hour:$minute $amPm"
}