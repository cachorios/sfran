package com.gmail.cacho.backend.jpa;


import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.view.excepciones.DataErrorException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;

public class PersistenceExceptionUtil {
    /**
     * Checks if the given exception is caused by an optimistic locking problem.
     *
     * @param exception the exception to check
     * @return <code>true</code> if the exception chain contains an optimistic
     * locking exception, <code>false</code> otherwise
     */
    public static boolean isOptimisticLockingException(Exception exception) {
        return ((ExceptionUtils.indexOfThrowable(exception, javax.persistence.OptimisticLockException.class) != -1) || (
                ExceptionUtils.indexOfThrowable(exception, org.apache.openjpa.persistence.OptimisticLockException.class)
                        != -1));
    }

    /**
     * Checks if the given exception is caused by a constraint violation problem.
     *
     * @param exception the exception to check
     * @return <code>true</code> if the exception chain contains a constraint
     * violation exception, <code>false</code> otherwise
     */
    public static boolean isConstraintViolationException(Exception exception) {
        return (ExceptionUtils.indexOfThrowable(exception, ConstraintViolationException.class) != -1);
    }

    /**
     * Checks if the given exception is caused by a invocation target problem.
     *
     * @param exception the exception to check
     * @return <code>true</code> if the exception chain contains a constraint
     * violation exception, <code>false</code> otherwise
     */
    public static boolean isInvocationTargetException(Exception exception) {
        return (ExceptionUtils.indexOfThrowable(exception, InvocationTargetException.class) != -1);
    }

    /**
     * Checks if the given exception is caused by a invocation target problem.
     *
     * @param exception the exception to check
     * @return <code>true</code> if the exception chain contains a constraint
     * violation exception, <code>false</code> otherwise
     */
    public static boolean isPSQLException(Exception exception) {
        return ((ExceptionUtils.getThrowableList(exception).stream()
                               .filter(ex -> ex.getMessage().contains("org.postgresql.util.PSQLException")).count()) > 0);
    }

    /**
     * Genera el mensaje que causa una excepcion if the given exception is caused
     * by a constraint violation problem, sino devuelve null.
     *
     * @param exception the exception to check
     * @return <code>String</code> with the message exception chain if contains a constraint
     * violation exception, <code>null String</code> otherwise
     */
    public static String genMensajeConstraintViolationException(Exception exception) {
        try {
            String str = ExceptionUtils.getThrowableList(exception).stream()
                                       .filter(ex -> ex instanceof ConstraintViolationException)
                                       .map(cve -> ((ConstraintViolationException) cve).getConstraintViolations().stream()
                                                                                       .map(cv -> cv.getMessage()
                                                                                                    .concat(Constantes.SYS_CAD_OPENTYPE)
                                                                                                    .concat(((cv
                                                                                                            .getInvalidValue()
                                                                                                            != null) ? cv
                                                                                                                     .getInvalidValue()
                                                                                                                     .toString()
                                                                                                                     : C.SYS_CAD_SPACE))
                                                                                                    .concat(Constantes.SYS_CAD_CLOSETPE))
                                                                                       .collect(Collectors.joining(
                                                                                               Constantes.SYS_CAD_CRLF)))
                                       .collect(Collectors.joining(Constantes.SYS_CAD_CRLF));
            return C.MSJ_ERR_CONSTRAINTVIOLATION.concat(C.SYS_CAD_LOGSEP).concat(C.SYS_CAD_SPACE).concat(str);
        } catch (Exception e) {
            throw new DataErrorException(C.MSJ_ERR_VRFYCVEXCEPTION, exception.getMessage());
        }
    }

    /**
     * Genera el mensaje que causa una excepcion if the given exception is caused
     * by a invocation target problem, sino devuelve null.
     *
     * @param exception the exception to check
     * @return <code>String</code> with the message exception chain if contains a constraint
     * target invocation exception, <code>null String</code> otherwise
     */
    public static String genMensajeInvocationTargetException(Exception exception) {
        try {
            String str = ExceptionUtils.getThrowableList(exception).stream()
                                       .filter(ex -> ex instanceof InvocationTargetException)
                                       .map(ite -> ((InvocationTargetException) ite).getTargetException().getMessage())
                                       .collect(Collectors.joining(Constantes.SYS_CAD_CRLF));
            return C.MSJ_ERR_TARGETINVOCATION.concat(C.SYS_CAD_LOGSEP).concat(C.SYS_CAD_SPACE).concat(str);
        } catch (Exception e) {
            throw new DataErrorException(C.MSJ_ERR_VRFYTIEXCEPTION, exception.getMessage());
        }
    }

    /**
     * Genera el mensaje que causa una excepcion if the given exception is caused
     * by a fatal PSQL problem, sino devuelve null.
     *
     * @param exception the exception to check
     * @return <code>String</code> with the message exception chain if contains a constraint
     * a fatal PSQL exception, <code>null String</code> otherwise
     */
    public static String genMensajePSQLException(Exception exception) {
        try {
            String str = ExceptionUtils.getThrowableList(exception).stream()
                                       .filter(ex -> ex.getMessage().contains("org.postgresql.util.PSQLException"))
                                       .map(Throwable::getMessage).collect(Collectors.joining(Constantes.SYS_CAD_CRLF));
            return C.MSJ_ERR_SQLEXEC.concat(C.SYS_CAD_LOGSEP).concat(C.SYS_CAD_SPACE).concat(str);
        } catch (Exception e) {
            throw new DataErrorException(C.MSJ_ERR_VRFYTIEXCEPTION, exception.getMessage());
        }
    }

    /**
     * Verifica distintos tipos de errores y enera el mensaje que causa una excepcion if
     * the given exception is caused by a persistent problem, sino devuelve null.
     *
     * @param exception the exception to check
     * @return <code>String</code> with the message exception chain if contains a constraint
     * violation exception, <code>null String</code> otherwise
     */
    public static String verifyAndGenMessagePersistException(Exception exception) {
        try {
            String mensaje;

            if (isOptimisticLockingException(exception)) {
                mensaje = C.MSJ_ERR_OPTIMISTLOCK;
            } else if (isConstraintViolationException(exception)) {
                mensaje = genMensajeConstraintViolationException(exception);
            } else if (isInvocationTargetException(exception)) {
                mensaje = genMensajeInvocationTargetException(exception);
            } else if (isPSQLException(exception)) {
                mensaje = genMensajePSQLException(exception);
            } else {
                mensaje = C.MSJ_ERR_GENERICEXCEPTION.concat(Constantes.SYS_CAD_CRLF)
                                                    .concat(ExceptionUtils.getRootCauseMessage(exception));
            }

            return C.SYS_CAD_OPENTYPE.concat(mensaje).concat(C.SYS_CAD_CLOSETPE);
        } catch (Exception e) {
            throw new DataErrorException(C.MSJ_ERR_VERIFYEXCEPTION, e.getMessage());
        }
    }
}
