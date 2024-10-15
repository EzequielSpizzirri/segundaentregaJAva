package proyectoJava.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private int id;

    @ManyToOne // Relación muchos a uno con Cliente
    @JoinColumn(name = "cliente_id") // Nombre de la columna que referencia a Cliente
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL) // Relación uno a muchos con DetalleFactura
    private List<DetalleFactura> detalles;

    // Constructor
    public Factura() { // Constructor vacío requerido por JPA
    }

    public Factura(Cliente cliente, List<DetalleFactura> detalles) {
        this.cliente = cliente;
        this.detalles = detalles;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
}
