/*
Java Module System Example

To create and use Java modules, follow these steps:

1. Create the directory structure:
   ModuleExample/
   ├── com.utils/
   │   ├── src/
   │   │   ├── module-info.java
   │   │   └── com/
   │   │       └── utils/
   │   │           └── StringUtils.java
   └── com.greetings/
       ├── src/
       │   ├── module-info.java
       │   └── com/
       │       └── greetings/
       │           └── HelloWorld.java

2. Create the module-info.java for com.utils:
```java
module com.utils {
    exports com.utils;
}
```

3. Create StringUtils.java:
```java
package com.utils;

public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
```

4. Create the module-info.java for com.greetings:
```java
module com.greetings {
    requires com.utils;
}
```

5. Create HelloWorld.java:
```java
package com.greetings;

import com.utils.StringUtils;

public class HelloWorld {
    public static void main(String[] args) {
        String name = "world";
        String capitalizedName = StringUtils.capitalize(name);
        System.out.println("Hello, " + capitalizedName + "!");
    }
}
```

6. Compile the modules:
```
javac -d mods/com.utils com.utils/src/module-info.java com.utils/src/com/utils/StringUtils.java
javac --module-path mods -d mods/com.greetings com.greetings/src/module-info.java com.greetings/src/com/greetings/HelloWorld.java
```

7. Run the application:
```
java --module-path mods -m com.greetings/com.greetings.HelloWorld
```
*/