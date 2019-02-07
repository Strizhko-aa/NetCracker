package Person.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class injector {

	public static final String path = "src/main/java/configuration.properties";

	public void inject (Object repo) {
		Properties props = new Properties();
		try {
			FileInputStream finp = new FileInputStream(path);
			props.load(finp);
			Class<?> repoClass = repo.getClass();
			Field[] fields = repoClass.getDeclaredFields();
			for (Field item : fields) {
				if (item.isAnnotationPresent(inject.class) && props.containsKey(item.getType().getName())) {
					item.setAccessible(true);
					Class<?> instance = Class.forName(props.getProperty(item.getType().getName()));
					Constructor<?> constructor = instance.getConstructor();
					Object sort = constructor.newInstance();
					item.set(repo, sort);
				}
			}
		} catch(IOException ex){
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
