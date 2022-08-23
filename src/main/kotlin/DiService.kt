import java.lang.reflect.Field
import kotlin.reflect.KClass

class DiService {
    companion object {
        fun <T> getObject(clazz: Class<T>): T {
            val instance: T = createInstance(clazz)
            clazz.declaredFields.forEach { field ->
                if (field.existsAnnotation(Di::class)) {
                    val fieldInstance = createInstance(field.type)
                    field.trySetAccessible()
                    field.set(instance, fieldInstance)
                }
            }

            return instance
        }

        private fun <T> createInstance(clazz: Class<T>): T {
            return clazz.getConstructor().newInstance()
        }
    }
}

fun Field.existsAnnotation(annotationClass: KClass<*>): Boolean {
    this.declaredAnnotations.iterator().forEach {
        if (it.annotationClass == annotationClass) {
            return true;
        }
    }
    return false
}