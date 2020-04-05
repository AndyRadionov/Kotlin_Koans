import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }
class RepeatedInterval(val interval: TimeInterval, val count: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeInterval: RepeatedInterval): MyDate = addTimeIntervals(timeInterval.interval, timeInterval.count)

operator fun TimeInterval.times(count: Int): RepeatedInterval = RepeatedInterval(this, count)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
