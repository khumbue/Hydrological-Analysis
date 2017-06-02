package za.co.jobcreation.api.util;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.*;

//  Only handles transformations of a flat structure - no embedded objects
public class GenericTransformer {

    public static Object transform(Object source, Class<?> target) {
        try {

            Object newTarget = target.newInstance();

            Field[] targetFields = getAllFields(target, null);
            Field[] sourceFields = getAllFields(source.getClass(), null);

            if (source != null) {
                for (Field sourceField : sourceFields) {
                    sourceField.setAccessible(true);
                    for (Field targetField : targetFields) {
                        targetField.setAccessible(true);
                        if (sourceField.getName().equals(targetField.getName())
                                && (sourceField.getType().equals(targetField.getType())
                                || ClassUtils.isAssignable(sourceField.getType(), targetField.getType(), true))) {
                            if (sourceField.get(source) != null
                                    && !(sourceField.get(source) instanceof Collection)
                                    //  This Transformer does not yet support Maps
                                    && !(sourceField.get(source) instanceof Map)
                                    && !Modifier.isFinal(targetField.getModifiers())) {
                                if (ClassUtils.isPrimitiveWrapper(sourceField.getType()) && targetField.getType().isPrimitive()
                                        && !sourceField.getType().equals(Void.class)) {
                                    Object targetObject = sourceField.getType().getMethod(targetField.getType().getSimpleName() + "Value").invoke(sourceField.get(source));
                                    targetField.set(newTarget, targetObject);
                                } else if (ClassUtils.isPrimitiveWrapper(targetField.getType()) && sourceField.getType().isPrimitive()) {
                                    Object targetObject = targetField.getType().getConstructor(sourceField.getType()).newInstance(sourceField.get(source));
                                    targetField.set(newTarget, targetObject);
                                } else {
                                    targetField.set(newTarget, sourceField.get(source));
                                }
                            } else if (sourceField.get(source) instanceof Collection  //  We are working with a Collection - Copy over collection Items
                                    && Collection.class.isAssignableFrom(targetField.getType())) {
                                handleCollectionTransformation(source, newTarget, sourceField, targetField);
                            }
                        }
                    }

                }
            }
            return newTarget;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void assignPrimitiveValue(Field source, Field target) {
        if (!target.getType().isPrimitive()) {
            throw new RuntimeException("Target must be Primitive");
        }
        if (source.getType().equals(Integer.class) && target.getType().equals(int.class)) {

        }
    }

    private static void handleCollectionTransformation(Object source, Object newTarget,
                                                       Field sourceField, Field targetField) throws IllegalAccessException {

        ParameterizedType targetCollectionType = (ParameterizedType) targetField.getGenericType();
        Class<?> targetFieldElementClass = (Class<?>) targetCollectionType.getActualTypeArguments()[0];

        Collection targetFieldCollection = null;
        if (List.class.isAssignableFrom(targetField.getType())) {
            targetFieldCollection = new ArrayList();
        } else if (Set.class.isAssignableFrom(targetField.getType())) {
            targetFieldCollection = new HashSet();
        }
        if (targetFieldCollection == null) {
            throw new RuntimeException("This implementation of Collection is not supported!");
        }
        Collection sourceCollection = (Collection) sourceField.get(source);
        for (Iterator iterator = sourceCollection.iterator(); iterator.hasNext(); ) {
            targetFieldCollection.add(transform(iterator.next(), targetFieldElementClass));
        }
        targetField.set(newTarget, targetFieldCollection);
    }


    protected static Field[] getAllFields(Class objectClass, Field[] fields) {
        Field[] newFields = objectClass.getDeclaredFields();

        for (Field field : newFields) {
            if (field.getType().isPrimitive()) ;
        }

        int fieldsSize = 0;
        int newFieldsSize = 0;

        if (fields != null) {
            fieldsSize = fields.length;
        }

        if (newFields != null) {
            newFieldsSize = newFields.length;
        }

        Field[] totalFields = new Field[fieldsSize + newFieldsSize];

        if (fieldsSize > 0) {
            System.arraycopy(fields, 0, totalFields, 0, fieldsSize);
        }

        if (newFieldsSize > 0) {
            System.arraycopy(newFields, 0, totalFields, fieldsSize, newFieldsSize);
        }

        Class superClass = objectClass.getSuperclass();
        Field[] finalFieldsArray;

        if (superClass != null
                && !superClass.getName().equals("java.lang.Object")) {
            finalFieldsArray = getAllFields(superClass, totalFields);
        } else {
            finalFieldsArray = totalFields;
        }
        return finalFieldsArray;
    }
}

