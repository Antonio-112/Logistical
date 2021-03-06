package com.latam.JPAcrud.vo;
import java.util.List;
import com.latam.JPAcrud.modelo.Productos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductoVO extends GenericVO {
	
	private List<Productos> producto;
	
	public ProductoVO(String mensaje, String codigo, List<Productos> producto) {
		super(mensaje, codigo);
		this.producto = producto;
	}
	public List<Productos> getProducto() {
		return producto;
	}
	public void setProducto(List<Productos> producto) {
		this.producto = producto;
	}
	
	
}

