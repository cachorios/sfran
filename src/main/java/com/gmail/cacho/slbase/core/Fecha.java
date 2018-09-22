package com.gmail.cacho.slbase.core;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public abstract class Fecha {
    static public Date toDate(LocalDate localdate) {
        return ((localdate != null) ? java.sql.Date.valueOf(localdate) : null);
    }

    static public LocalDate toLocalDate(Date date) {
        return ((date != null) ? LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)) : null);
    }

    static public Date truncateDate(Date date) {
        return toDate(toLocalDate(date));
    }

    static public Date inicioMes(Date fecha){
        fecha = truncateDate(fecha);
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.set(Calendar.DAY_OF_MONTH,1);
        return c.getTime();
    }

    static public Date finMes(Date fecha){
        fecha = truncateDate(fecha);
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    static public String getNowDateAsString() {
        return (String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1)
                + String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + String
                .valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + String.valueOf(Calendar.getInstance().get(Calendar.MINUTE))
                + String.valueOf(Calendar.getInstance().get(Calendar.SECOND)));
    }
}
