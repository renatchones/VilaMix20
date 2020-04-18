package br.com.qintess.vilamix20.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.qintess.vilamix20.model.CasaShow;
import br.com.qintess.vilamix20.model.Evento;
import br.com.qintess.vilamix20.model.Ingresso;
import br.com.qintess.vilamix20.model.ItemPedido;
import br.com.qintess.vilamix20.model.Papel;
import br.com.qintess.vilamix20.model.PapelUsuario;
import br.com.qintess.vilamix20.model.Pedido;
import br.com.qintess.vilamix20.model.Usuario;



public class HibernateConfig {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory(){

		if(sessionFactory==null) {

			try {

				Configuration configuration = new Configuration();

				Properties prop = new Properties();

				prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");

				prop.put(Environment.URL, "jdbc:mysql://localhost:3307/vilamix20?useTimezone=true&serverTimezone=UTC");

				prop.put(Environment.USER, "root");

				prop.put(Environment.PASS, "");

				//Prestar atenção nisso em banco de dados de produção

				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

				prop.put(Environment.SHOW_SQL, "true");

				//Principalmente nessa linha que pode F#der tudo.

				prop.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(prop);

				configuration.addAnnotatedClass(Usuario.class);

				configuration.addAnnotatedClass(Pedido.class);
				
				configuration.addAnnotatedClass(PapelUsuario.class);
				
				configuration.addAnnotatedClass(Papel.class);

				configuration.addAnnotatedClass(CasaShow.class);
				
				configuration.addAnnotatedClass(Evento.class);
				
				configuration.addAnnotatedClass(Ingresso.class);
				
				configuration.addAnnotatedClass(ItemPedido.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return sessionFactory;

	}

}	