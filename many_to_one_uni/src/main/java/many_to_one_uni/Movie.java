package many_to_one_uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int Yor;
	
	@ManyToOne
	private Director director;

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

	public int getYor() {
		return Yor;
	}

	public void setYor(int Yor) {
		this.Yor = Yor;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", Yor=" + Yor + ", director=" + director + "]";
	}
}
