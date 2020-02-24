package es.api.atw.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.api.atw.model.UserEntity;

public class HibernateConfiguration {

	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory init() {
		final Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(UserEntity.class);

		HibernateConfiguration.serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		HibernateConfiguration.factory = config.buildSessionFactory(HibernateConfiguration.serviceRegistry);

		return HibernateConfiguration.factory;
	}

}
