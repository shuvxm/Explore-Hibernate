package many_to_one_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMovieByDirectorId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		int did = 1;
//		Director d = em.find(Director.class, did);

		Query q = em.createQuery("from Movie");

		List<Movie> list = q.getResultList();

		for (Movie m : list) {
			if (m.getDirector().getId() == did) {
				System.out.println(m);
			}
		}
//	Q. Based on Movie ID , delete Director

	}
}
