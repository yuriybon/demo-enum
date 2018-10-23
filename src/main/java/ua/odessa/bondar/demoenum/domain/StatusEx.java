package ua.odessa.bondar.demoenum.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "status")
@SequenceGenerator(name = "entityIdGenerator", sequenceName = "status_id")
@MappedEnum(enumClass = Status.class)
public class StatusEx extends SystemDictionary {
}
