package aed;

import java.math.BigDecimal;

//import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	private static SessionFactory sessionFactory; // Declarar como variable estática a nivel de clase

	static {
		// Inicializar la SessionFactory en un bloque estático
		Configuration cfg = new Configuration();
		cfg.configure(); // Busca y usa el archivo hibernate.cfg.xml
		sessionFactory = cfg.buildSessionFactory();
	}

	public static void main(String[] args) {

		// Abre la sesión y realiza operaciones
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			// Aquí irían las operaciones CRUD, por ejemplo:

			// Prueba de inserción de una familia
			//Familia familia = new Familia();
			//familia.setDenoFamilia("Frutas");
			//familia.setCodFamilia(1);
			// No estableces el ID de la familia porque se genera automáticamente
			//insertarFamilia(familia);

			// Ahora que la familia está insertada, puedes obtener su ID generado
			// Integer idFamilia = familia.getCodFamilia();

			// Prueba de inserción de un producto
			Producto producto = new Producto();
			producto.setDenoProducto("manzanaaaa");
			producto.setPrecioBase(new BigDecimal("10.00"));
			producto.setCodFamilia(1); // Suponiendo que ya existe una familia con ID 1
			producto.setCongelado(false);

			insertarProducto(producto);

			// Prueba de eliminar un producto
			// eliminarProducto(2); // Supone que existe un producto con ID 2

			//Producto productoRecuperado = obtenerProductoPorId(1);
			//System.out.println("Nombre: " + productoRecuperado.getDenoProducto());

			// Prueba de actualizar un producto
			//productoRecuperado.setDenoProducto("Producto2");

			//actualizarProducto(productoRecuperado);
			
			//System.out.println("Nombre: " + productoRecuperado.getDenoProducto());
			
			//eliminarProducto(1);

			// Recuperar y mostrar el producto con ID 1
			Producto productoRecuperado = obtenerProductoPorId(1);
			if (productoRecuperado != null) {
				System.out.println("Producto recuperado: ");
				System.out.println("ID: " + productoRecuperado.getCodProducto());
				System.out.println("Nombre: " + productoRecuperado.getDenoProducto());
				System.out.println("Precio Base: " + productoRecuperado.getPrecioBase());
				System.out.println("Congelado: " + productoRecuperado.getCongelado());
				// Y así sucesivamente para el resto de los campos
			} else {
				System.out.println("No se encontró el producto con ID: " + 1);
			}

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		sessionFactory.close();
		// System.out.println("Hello World!");

	}

	public static void insertarFamilia(Familia familia) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(familia);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void insertarProducto(Producto producto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(producto);
			transaction.commit();
			System.out.println("Producto introducido con ID " + producto.getCodProducto());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void eliminarProducto(Integer idProducto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Producto producto = session.get(Producto.class, idProducto);
			if (producto != null) {
				session.delete(producto);
			}
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void actualizarProducto(Producto producto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
		
			session.update(producto);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static Producto obtenerProductoPorId(int idProducto) {
		Session session = sessionFactory.openSession();
		Producto producto = null;
		try {
			producto = session.get(Producto.class, idProducto);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return producto;
	}

}
