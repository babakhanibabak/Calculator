package com.example.calculator.ui.menu

import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.Build
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme
import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId


@Composable
fun DateScreen() {
    DateScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateScreenContent(modifier: Modifier = Modifier) {
    val datePickerState = rememberDatePickerState(
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        yearRange = 1900..2024,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val dayOfWeek = Instant.ofEpochMilli(utcTimeMillis).atZone(ZoneId.of("UTC"))
                        .toLocalDate().dayOfWeek
                    dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY
                } else {
                    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    calendar.timeInMillis = utcTimeMillis
                    calendar[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY &&
                            calendar[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY
                }
            }

            override fun isSelectableYear(year: Int): Boolean {
                return true
            }
        }
    )
    DatePickerDialog(onDismissRequest = { /*TODO*/ },
        confirmButton = { /*TODO*/ },
        dismissButton = {},
        content = { DatePicker(state = datePickerState)}
    )
        

}

@Preview
@Composable
private fun DateScreenContentPreview() {
    CalculatorTheme {
        DateScreenContent()
    }

}