package hu.thesis.timetableplanner.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * 
 * @author gabesz
 *A MappedSuperClass szolgál arra hogy a spring tudja ez nem egy entitás lesz de szkennelnie kell
 *mikor az entitásokat szkennelni és az subclass-okhoz fogja hozzá venni.
 * 
 */
@MappedSuperclass
public class BaseEntity implements AbstractEntity<Long>{
	@Id
	@GeneratedValue
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
