package com.gmail.cacho.slapi.view.renders;


import com.gmail.cacho.slbase.core.Fecha;
import com.vaadin.flow.data.renderer.BasicRenderer;
import com.vaadin.flow.function.ValueProvider;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateRenderer<SOURCE> extends BasicRenderer<SOURCE, Date> {
    private DateTimeFormatter formatter;
    private String nullRepresentation;

    public DateRenderer(ValueProvider<SOURCE, Date> valueProvider, String formatPattern) {
        super(valueProvider);

        if (formatPattern == null) {
            throw new IllegalArgumentException("format pattern may not be null");
        } else {
            this.formatter = DateTimeFormatter.ofPattern(formatPattern, Locale.getDefault());
            this.nullRepresentation = nullRepresentation;
        }
    }

    protected String getFormattedValue(Date date) {
        try {
            return date == null ? this.nullRepresentation : this.formatter.format(Fecha.toLocalDate(date));
        } catch (Exception var3) {
            throw new IllegalStateException(
                    "Could not format input date '" + date + "' using formatter '" + this.formatter + "'", var3);
        }
    }
}
