package aed;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Funciones {

	public void insertarProducto(Producto producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(producto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void insertarFamilia(Familia familia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(familia);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void insertarTienda(Tienda tienda) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.persist(tienda);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void insertarStock(Stock stock) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(stock.getTienda());
			session.saveOrUpdate(stock.getProducto());
			session.save(stock);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void actualizarProducto(Producto producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(producto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void eliminarProductoPorId(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Producto producto = session.get(Producto.class, id);
			if (producto != null) {
				session.remove(producto);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void mostrarProductosConObservacion() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List<Producto> productos = session.createQuery("FROM Producto", Producto.class).list();
            for (Producto producto : productos) {
                System.out.println("ID: " + producto.getCodProducto());
                System.out.println("Nombre: " + producto.getDenoProducto());
                System.out.println("Precio Base: " + producto.getPrecioBase());
                System.out.println("Congelado: " + producto.getCongelado());
                
                // Verificar si el producto tiene una observación
                Observacion observacion = producto.getObservacion();
                if (observacion != null) {
                    System.out.println("Observación: " + observacion.getObservacion());
                } else {
                    System.out.println("Observación: No hay observación para este producto");
                }
                
                System.out.println("----------------------------------------");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
	
	public void mostrarProductosConStock() {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        List<Object[]> results = session.createQuery("SELECT p, s, t, f " +
	                                                      "FROM Producto p " +
	                                                      "JOIN Stock s ON p.codProducto = s.producto.codProducto " +
	                                                      "JOIN Tienda t ON s.tienda.codTienda = t.codTienda " +
	                                                      "JOIN Familia f ON p.familia.codFamilia = f.codFamilia")
	                                         .list();
	        for (Object[] result : results) {
	            Producto producto = (Producto) result[0];
	            Stock stock = (Stock) result[1];
	            Tienda tienda = (Tienda) result[2];
	            Familia familia = (Familia) result[3];
	            
	            System.out.println("Producto:");
	            System.out.println("ID: " + producto.getCodProducto());
	            System.out.println("Nombre: " + producto.getDenoProducto());
	            System.out.println("Precio Base: " + producto.getPrecioBase());
	            System.out.println("Congelado: " + producto.getCongelado());
	            System.out.println("Familia: " + familia.getDenoFamilia());
	            System.out.println("Tienda: " + tienda.getDenoTienda());
	            System.out.println("Stock: " + stock.getUnidades());
	            System.out.println("----------------------------------------");
	        }
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

}
