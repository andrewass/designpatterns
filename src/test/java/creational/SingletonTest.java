package creational;

import creational.singleton.LazySingleton;
import creational.singleton.Singleton;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SingletonTest {

    @Test
    void singletonObjectShouldNotBeNull() {
        Singleton singleton = Singleton.getInstance();
        assertNotNull(singleton);
    }

    @Test
    void lazySingletonObjectShouldBeLazyInitialized() throws NoSuchFieldException, IllegalAccessException {
        Class lazySingletonClass = LazySingleton.class;
        Field field = lazySingletonClass.getDeclaredField("lazySingleton");
        field.setAccessible(true);

        assertNull(field.get(this));

        LazySingleton lazySingleton = LazySingleton.getInstance();

        assertNotNull(lazySingleton);
        assertNotNull(field.get(this));
    }
}
