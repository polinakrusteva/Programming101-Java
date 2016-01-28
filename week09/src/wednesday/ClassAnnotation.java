package wednesday;

import java.lang.annotation.Annotation;

@ClassInfo(author = "Polina", revision = 9, checked = true, classes = { ClassAnnotation.class })
public class ClassAnnotation {
	public static void main(String[] args) {
		Class<?> a = ClassAnnotation.class;
		Annotation[] annotations = a.getAnnotations();

		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		ClassAnnotation e = new ClassAnnotation();
		ClassInfo ann = e.getClass().getAnnotation(ClassInfo.class);

		System.out.println(ann.author());
		System.out.println(ann.checked());
		System.out.println(ann.revision());
	}
}
