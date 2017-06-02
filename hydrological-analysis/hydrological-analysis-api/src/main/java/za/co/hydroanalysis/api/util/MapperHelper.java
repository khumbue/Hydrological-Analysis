package za.co.jobcreation.api.util;

/**
 * Utility class to handle the IllegalAccessException and InvocationTargetException if thrown during mapping.
 *
 * @author khumbu
 */
public class MapperHelper {
    public static Object copyProperties(Object destination, Object source) {
        return GenericTransformer.transform(source, destination.getClass());
    }
}
