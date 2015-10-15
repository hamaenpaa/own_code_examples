package fi.agileo;

import javax.persistence.*;

@Entity
@Table(name="SIMPLEENTITY")
@NamedQueries({
	@NamedQuery(name ="selectAll", query ="SELECT a FROM SimpleEntity a"),
	@NamedQuery(name ="selectWithLike", query="SELECT a FROM SimpleEntity a WHERE a.name LIKE :lp"),
	@NamedQuery(name="DeleteWithLike", query="DELETE FROM SimpleEntity a WHERE a.name LIKE :lp")
})
public class SimpleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "SimpleEntity [id=" + id + ", name=" + name + ", desc=" + description + "]";
	}

}
