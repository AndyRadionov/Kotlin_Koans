class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> =
            object : Iterator<MyDate> {
                private var current = start

                override fun hasNext(): Boolean = current <= end

                override fun next(): MyDate {
                    if (!hasNext()) throw NoSuchElementException()
                    val next = current
                    current = current.followingDate()
                    return next
                }
            }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}