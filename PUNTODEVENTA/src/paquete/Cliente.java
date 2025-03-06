package paquete;

    public class Cliente {
        private String claveCliente;
        private String nombre;
        private String direccion;
        private String RFC;
    
        public Cliente(String claveCliente, String nombre, String direccion, String RFC) {
            this.claveCliente = claveCliente;
            this.nombre = nombre;
            this.direccion = direccion;
            this.RFC = RFC;
        }
    
        public String getClaveCliente() {
            return claveCliente;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public String getDireccion() {
            return direccion;
        }
    
        public String getRFC() {
            return RFC;
        }
        public String toString(){
            return "GRACIAS POR COMPRAR CON NOSOTROS"+ "\n" +"\n" 
            +"*Clave Cliente: "  + claveCliente + "\n" +"\n" 
            + "*Nombre: " + nombre + "\n" +"\n" 
            + "*Direccion: " + direccion + "\n" +"\n" 
            + "*RFC:" + RFC +"\n"  +"\n" ;
        }
    }

