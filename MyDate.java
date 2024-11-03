public class MyDate {
        private int year;
        private int month;
        private int day;

        private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public MyDate(int year, int month, int day) {
            setDate(year, month, day);
        }

        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        public static boolean isValidDate(int year, int month, int day) {
            if (year < 1 || year > 9999) return false;
            if (month < 1 || month > 12) return false;
            int daysInMonth = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) daysInMonth = 29;
            return day >= 1 && day <= daysInMonth;
        }

        public static int getDayOfWeek(int year, int month, int day) {
            if (month < 3) {
                month += 12;
                year--;
            }
            int k = year % 100;
            int j = year / 100;
            int dayOfWeek = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
            return (dayOfWeek + 5) % 7;
        }


        public void setDate(int year, int month, int day) {
            if (isValidDate(year, month, day)) {
                this.year = year;
                this.month = month;
                this.day = day;
            } else {
                throw new IllegalArgumentException("Invalid date.");
            }
        }

        public void setYear(int year) {
            if (year >= 1 && year <= 9999) this.year = year;
            else throw new IllegalArgumentException("Invalid year.");
        }

        public void setMonth(int month) {
            if (month >= 1 && month <= 12) this.month = month;
            else throw new IllegalArgumentException("Invalid month.");
        }

        public void setDay(int day) {
            if (isValidDate(this.year, this.month, day)) this.day = day;
            else throw new IllegalArgumentException("Invalid day.");
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public String toString() {
            int dayOfWeek = getDayOfWeek(year, month, day);
            return String.format("%s %d %s %d", DAYS[dayOfWeek], day, MONTHS[month - 1], year);
        }

        public MyDate nextDay() {
            if (isValidDate(year, month, day + 1)) {
                day++;
            } else if (month == 12) {
                day = 1;
                month = 1;
                year++;
            } else {
                day = 1;
                month++;
            }
            return this;
        }

        public MyDate nextMonth() {
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
            if (!isValidDate(year, month, day)) {
                day = DAYS_IN_MONTHS[month - 1];
                if (month == 2 && isLeapYear(year)) {
                    day = 29;
                }
            }
            return this;
        }

        public MyDate nextYear() {
            year++;
            if (month == 2 && day == 29 && !isLeapYear(year)) {
                day = 28;
            }
            return this;
        }

        public MyDate previousDay() {
            if (day > 1) {
                day--;
            } else if (month == 1) {
                month = 12;
                day = 31;
                year--;
            } else {
                month--;
                day = DAYS_IN_MONTHS[month - 1];
                if (month == 2 && isLeapYear(year)) {
                    day = 29;
                }
            }
            return this;
        }

        public MyDate previousMonth() {
            if (month == 1) {
                month = 12;
                year--;
            } else {
                month--;
            }
            if (!isValidDate(year, month, day)) {
                day = DAYS_IN_MONTHS[month - 1];
                if (month == 2 && isLeapYear(year)) {
                    day = 29;
                }
            }
            return this;
        }

        public MyDate previousYear() {
            year--;
            if (month == 2 && day == 29 && !isLeapYear(year)) {
                day = 28;
            }
            return this;
        }
}
