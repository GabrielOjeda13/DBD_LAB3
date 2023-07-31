package grupo13.LAB3.models;


public class transaccionModel {

    private long id;
    private String correlativo_codigo;
    private String carro_id;
    private String usuario_id;
    private float valor_sin_descuento;
    private float descuento;
    private float valor_total;
    private String fecha;
    private  String folio_boleta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorrelativo_codigo() {
        return correlativo_codigo;
    }

    public void setCorrelativo_codigo(String correlativo_codigo) {
        this.correlativo_codigo = correlativo_codigo;
    }

    public String getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(String carro_id) {
        this.carro_id = carro_id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public float getValor_sin_descuento() {
        return valor_sin_descuento;
    }

    public void setValor_sin_descuento(float valor_sin_descuento) {
        this.valor_sin_descuento = valor_sin_descuento;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFolio_boleta() {
        return folio_boleta;
    }

    public void setFolio_boleta(String folio_boleta) {
        this.folio_boleta = folio_boleta;
    }
}
