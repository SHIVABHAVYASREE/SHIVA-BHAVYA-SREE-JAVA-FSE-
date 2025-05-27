import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.print(m.getName() + "(");
            for (Parameter p : m.getParameters()) {
                System.out.print(p.getType().getSimpleName() + " ");
            }
            System.out.println(")");
        }
        Object list = clazz.getConstructor().newInstance();
        Method add = clazz.getMethod("add", Object.class);
        add.invoke(list, "Hello Reflection");
        System.out.println(list);
    }
}

