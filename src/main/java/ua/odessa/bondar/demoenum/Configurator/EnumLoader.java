package ua.odessa.bondar.demoenum.Configurator;

import org.hibernate.mapping.PersistentClass;
import ua.odessa.bondar.demoenum.domain.MappedEnum;
import ua.odessa.bondar.demoenum.domain.SystemDictionary;

import javax.websocket.Session;
import java.util.Iterator;

public class EnumLoader implements SessionAction {
    @Override
    public void run(Session session) {
        Iterator<PersistentClass> mappingList = configuration.getClassMapping();
        while (mappingList.hasNext()) {
            PersistentClass mapping = mappingList.next();
            Class<?> targetEnum = mapping.getMappedClass();
            if (!SystemDictionary.class.isAssignableFrom(targetEnum)) {
                continue;
            }
            if (!targetEnum.isAnnotationPresent(MappedEnum))
                continue;
            MappedEnum mappedEnum = targetEnum.getAnnotation(MappedEnum.class);

            updateEnumIdentifiers(session, mappedEnum.enumClass(),(Class<SystemDictionary>) targetEnum);

        }

    }

    private void updateEnumIdentifiers(Session session, Class<? extends Enum> enumClass, Class<? extends SystemDictionary> entityClass ) {

    }
}
