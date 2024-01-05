package aed;

import java.math.BigDecimal;

//import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		// Abre la sesión y realiza operaciones
		Session sesion = HibernateUtil.getSessionFactory().openSession(); // crea

		// Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = sesion.beginTransaction();
			// Aquí irían las operaciones CRUD, por ejemplo:

			// Prueba de inserción de una familia
			Familia familia = new Familia();
			familia.setDenoFamilia("Frutas");
			familia.setCodFamilia(1);
			// No estableces el ID de la familia porque se genera automáticamente
			insertarFamilia(familia);

			// Ahora que la familia está insertada, puedes obtener su ID generado
			//Integer idFamilia = familia.getCodFamilia();

			// Prueba de inserción de un producto
			Producto producto = new Producto();
			producto.setDenoProducto("manzanaaaa");
			producto.setPrecioBase(new BigDecimal("120.00"));
			producto.setCongelado(false);
			// Asociar el producto con la familia
			// Ya no usas 'setCodFamilia' porque la familia es un objeto ahora
			producto.setFamilia(familia);

			// Guardar el producto en la base de datos
			insertarProducto(producto);


			// Prueba de eliminar un producto
			// eliminarProducto(2); // Supone que existe un producto con ID 2

			// Producto productoRecuperado = obtenerProductoPorId(1);
			// System.out.println("Nombre: " + productoRecuperado.getDenoProducto());

			// Prueba de actualizar un producto
			// productoRecuperado.setDenoProducto("Producto2");

			// actualizarProducto(productoRecuperado);

			// System.out.println("Nombre: " + productoRecuperado.getDenoProducto());

			// eliminarProducto(1);

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
			if (sesion != null) {
				sesion.close();
			}
		}

		// HibernateUtil.getSessionFactory().close();
		sesion.close();
	}

	public static void insertarFamilia(Familia familia) {
		// Abrir una nueva sesión
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			// Iniciar una transacción
			Transaction transaction = null;
			try {
				transaction = sesion.beginTransaction();
				// Realizar la operación de persistencia
				sesion.persist(familia);
				// Confirmar la transacción
				transaction.commit();
			} catch (RuntimeException e) {
				// En caso de error, hacer rollback de la transacción
				if (transaction != null) {
					transaction.rollback();
				}
				// Relanzar la excepción o manejarla según sea necesario
				throw e;
			}
		} // La sesión se cierra automáticamente al finalizar el bloque try-with-resources
	}

	public static void insertarProducto(Producto producto) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
	}

	public static void eliminarProducto(Integer idProducto) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
	}

	public static void actualizarProducto(Producto producto) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
	}

	public static Producto obtenerProductoPorId(int idProducto) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

}
