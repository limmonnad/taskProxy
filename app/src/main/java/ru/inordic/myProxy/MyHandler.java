package ru.inordic.myProxy;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;   //результат
        Object holder = objects[0];  // объект

        Class clazz = holder.getClass(); //клазз
        String name = method.getName(); // метод интерфейса
        if (name.startsWith("extract")) {    //поиск метода экстракт
            String nameField = name.substring("extract".length());
            String nameFieldLowFirst = nameField.replace(nameField.charAt(0), nameField.toLowerCase().charAt(0));
            Field[] declaredFields = clazz.getDeclaredFields();  //все поля класса
            for (Field declaredField : declaredFields) {  // все поля
                if (declaredField.getName().equals(nameFieldLowFirst)) {  // если  имя поля совпадает с именем метода
                    declaredField.setAccessible(true); // (доступ к приватным полям)
                    result = declaredField.get(holder); // то результат = значение поля ResultHolder
                    return result; // результат
                }
            }
        }
        throw new Exception(); // или ошибка
    }
}






