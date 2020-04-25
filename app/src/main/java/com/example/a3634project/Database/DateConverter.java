package com.example.a3634project.Database;

import androidx.room.TypeConverter;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverter {

    public static String dateToSqliteDateString(Date date) {
        // The format is the same as CURRENT_TIMESTAMP: "YYYY-MM-DD HH:MM:SS"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date != null) {
            return sdf.format(date);
        }
        return null;
    }
        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value);
        }

        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }


}