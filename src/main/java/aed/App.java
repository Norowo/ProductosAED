package aed;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {

		Funciones funciones = new Funciones();

		// insertar FAMILIA

		Familia familia = new Familia();
		familia.setDenoFamilia("Carnes");
		funciones.insertarFamilia(familia);

		

		// insertar PRODUCTO CON OBSERVACIÓN

		Producto producto = new Producto();
		producto.setDenoProducto("Pollo");
		producto.setPrecioBase(new BigDecimal("10.50"));
		producto.setCongelado(true);
		producto.setFamilia(familia);
		Observacion observacion = new Observacion();
		observacion.setObservacion("Pollo congelado de buena calidad");
		producto.setObservacion(observacion);

		funciones.insertarProducto(producto);

		// insertar PRODUCTO SIN OBSERVACIÓN

		Producto producto2 = new Producto();
		producto2.setDenoProducto("Vaca");
		producto2.setPrecioBase(new BigDecimal("7.50"));
		producto2.setCongelado(true);
		producto2.setFamilia(familia);

		funciones.insertarProducto(producto2);

		// insertar TIENDA

		Tienda nuevaTienda = new Tienda();
		nuevaTienda.setCodTienda("T001");
		nuevaTienda.setDenoTienda("La Laguna");
		nuevaTienda.setCodigoPostal("12345");

		funciones.insertarTienda(nuevaTienda);

		// Insertar STOCK
		Producto producto3 = new Producto();
		producto3.setDenoProducto("Elefante");
		producto3.setPrecioBase(new BigDecimal("155.50"));
		producto3.setCongelado(true);
		producto3.setFamilia(familia);

		funciones.insertarProducto(producto3);

		Stock stock = new Stock();
		stock.setTienda(nuevaTienda);

		stock.setProducto(producto3);
		stock.setUnidades(23);

		funciones.insertarStock(stock);
		
		Producto producto4 = new Producto();
		producto4.setDenoProducto("Nuggets");
		producto4.setPrecioBase(new BigDecimal("3.50"));
		producto4.setCongelado(true);
		producto4.setFamilia(familia);

		funciones.insertarProducto(producto3);

		Stock stock2 = new Stock();
		stock2.setTienda(nuevaTienda);

		stock2.setProducto(producto4);
		stock2.setUnidades(45);

		funciones.insertarStock(stock);
		funciones.insertarStock(stock2);

		// Eliminar PRODUCTO
		funciones.eliminarProductoPorId(1);

		// Actualizar PRODUCTO

		producto.setCodProducto(3);
		producto.setDenoProducto("Mamut");
		producto.setPrecioBase(new BigDecimal("53562.00"));
		producto.setCongelado(true);

		funciones.actualizarProducto(producto);
		
		// Mostrar LISTA PRODUCTOS
		
		funciones.mostrarProductosConObservacion();
		funciones.mostrarProductosConStock();

		
	}

}
