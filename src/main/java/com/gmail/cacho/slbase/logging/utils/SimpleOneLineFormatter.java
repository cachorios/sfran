package com.gmail.cacho.slbase.logging.utils;

import org.apache.juli.OneLineFormatter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.LogRecord;

/**
 * Esta es una clase helper que implementa un formateador de salida para logging en base a las
 * consideraciones del esquema de java.util.logging, las cuales a su vez son tomadas como base
 * por la implementacion de TOMEE (juli), pero modificado para simplificar aun mas la salida
 * del texto.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public class SimpleOneLineFormatter extends OneLineFormatter {
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final String ST_SEP = LINE_SEP + " ";
    private static final String timeFormat = "dd-MMM-yyyy HH:mm:ss";

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        // Timestamp
        addTimestamp(sb, record.getMillis());

        // Source
        //sb.append(' ');
        //sb.append(record.getSourceClassName());
        //sb.append('.');
        //sb.append(record.getSourceMethodName());

        // Message
        sb.append(' ');
        sb.append(formatMessage(record));

        // Stack trace
        if (record.getThrown() != null) {
            sb.append(ST_SEP);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            pw.close();
            sb.append(sw.getBuffer());
        }

        // New line for next record
        sb.append(LINE_SEP);

        return sb.toString();
    }
}
