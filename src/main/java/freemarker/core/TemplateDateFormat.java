package freemarker.core;

import java.text.DateFormat;
import java.util.Date;

/**
 * Represents a date/time/dateTime format; used in templates for formatting and parsing with that format.
 * This is similar to Java's {@link DateFormat}, but made to fit the requirements of FreeMarker. Also, it makes
 * easier to define formats that can't be represented with Java's existing {@link DateFormat} implementations.
 * 
 * <p>Implementations need not be thread-safe. Usually, instances are bound to a single {@link Environment}, and
 * {@link Environment}-s are thread-local objects. As the {@link Environment} is recreated for each top-level template
 * processing, constructing these object should be cheap, or else the factory of the instances should do some caching.
 */
// This class meant to become public one day, for allowing user-defined formats
abstract class TemplateDateFormat {
    
    public abstract String format(Date date);
    
    public abstract Date parse(String s) throws java.text.ParseException;

    /**
     * Meant to be used in error messages to tell what format the parsed string didn't fit.
     */
    public abstract String getDescription();
    
    // This isn't used yet, as we don't have markup formatting in the template language.
    ///**
    // * Formats the date to markup instead of to plain text, or return {@code false} that will make FreeMarker call
    // * {@link #format(Date)} and escape its result. It must not write into {@code out} when it returns {@code false}!
    // * It should only write to {@code out} and return {@code true} if the markup format is not the same as the
    // * {@link #format(Date)} escaped.
    // */
    //public boolean formatAsMarkup(Writer out) {
    //    return null;
    //}
    
    /**
     * Tells if this formatter should be re-created if the locale changes.
     */
    public abstract boolean isLocaleBound();
    
    /**
     * Tells if this formatter should be re-created if the time zone changes.
     */
    public abstract boolean isTimeZoneBound();

}