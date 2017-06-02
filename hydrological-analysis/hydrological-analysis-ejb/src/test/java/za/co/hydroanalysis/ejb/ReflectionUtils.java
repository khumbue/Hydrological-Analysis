package za.co.jobcreation.ejb;

import java.lang.reflect.Field;

public class ReflectionUtils {

	public static synchronized void setValueToPrivateField(Object object, String fieldName, Object fieldValue) {

		try {

			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, fieldValue);

		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SecurityException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
