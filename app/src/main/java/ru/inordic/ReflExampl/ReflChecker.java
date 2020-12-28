package ru.inordic.ReflExampl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Rabbit {
    private String rabbitName = "ghj";
    private String rabbitName1 = "456";
    private String rabbitName2 = "123";

    public String getRabbitName() {
        return rabbitName;
    }

    public void setRabbitName(String rabbitName) {
        this.rabbitName = rabbitName;
    }
}

public class ReflChecker {

    public void showClassName(Object object) {
        Class clazz = object.getClass();
        String name = clazz.getName();
//выводит на экран полное имя класса
        System.out.println(name);
    }

    public void showClassFields(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
//ВЕРНЕТ ВСЕ ПОЛЯ КЛАССА, МАССИВ ОБЪЕКТОВ ТИПА ФИЛД , В ТОМ ЧИСЛЕ ПРИВАТНЫЕ
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public void showClassMethods(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
//        МАССИВ ОБЪЕКТОВ ТИПА МЕТОД, ВЫВОДИТСЯ ОБЪКТЫ КОТОРЫЕ УНАСЛЕД ОТ ОБЖЕКТ
        for (Method method : methods) {
            System.out.println("метод " + method.getName());

        }
    }

    public void showFieldsAnnotations(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
//ИЩЕМ ВСЕ АННОТАЦИИ ПОЛЕЙ ДЛЯ ЭТОГО ВЫЗЫВАЕМ СНАЧАЛА ФИЛДС И ПРОХОДИМСЯ ПО НЕМУ
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
//ВО ВТОРОМ ЦИКЛЕ НАХЛОДИМ ИМЕНА АННОТАЦИЙ , НЕТ МЕТОДА ГЕТ НЕЙМ
            for (Annotation annotation : annotations) {
                System.out.println(field.getName() + "--" + annotation.toString());
            }
        }
    }

    public void getResult(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object s = field.get(object);
            System.out.println(s);
        }
    }


}


class ReflExample {

    public static void main(String[] args) throws IllegalAccessException {
        ReflChecker checker = new ReflChecker();
        Rabbit rabbit = new Rabbit();
//        checker.showClassName(rabbit);
//        checker.showClassFields(rabbit);
//        checker.showClassMethods(checker);
//        checker.showFieldsAnnotations(rabbit);
        checker.getResult(rabbit);


    }
}