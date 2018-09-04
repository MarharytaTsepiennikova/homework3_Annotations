import java.lang.annotation.*;

/**
 * Создать аннотацию, которая принимает параметры для метода.
 * Написать код, который вызовет метод, помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
 *
 * @Test(a=2, b=5)
 * public void test(int a, int b) {...}
 */

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Test {
    int a();
    int b();
}


public class Task1 {

    public static void main(String[] args) throws Exception{
        final Class<?> cls = Test.class;
        if(cls.isAnnotationPresent(Test.class)){
            System.out.println("Annotation is present");
        }
        Test an = cls.getAnnotation(Test.class);
        System.out.println("First parameter is: " + an.a() + ", second parameter is: " + an.b());
        int result = amount(an.a(), an.b());
        System.out.println(result);
    }

    @Test (a = 2, b = 5)
    public static int amount(int a, int b){
        int result = 0;
        result = a + b;
        return result;
    }
}
