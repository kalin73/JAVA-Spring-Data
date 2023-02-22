import java.util.List;

import javax.persistence.*;

import entities.Town;

public class ChangeCasing {
	private static final String DATABASE_NAME = "soft_uni";
//	private static final String UPDATE_ALL_TOWNS_WITH_LENGTH_NAME_MORE_THAN_5 = "UPDATE Town t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) <= 5";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);
		final EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		final Query query = entityManager.createQuery("SELECT t FROM Town t", Town.class);

		final List<Town> resultList = query.getResultList();

		for (Town town : resultList) {
			final String townName = town.getName();
			if (townName.length() <= 5) {
				town.setName(townName.toUpperCase());
				entityManager.persist(town);
			}
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
