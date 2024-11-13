package clases;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    static int numeroPersonas = 0;

    public Persona(){
        this.id = ++Persona.numeroPersonas;
    }

    public Persona(String nombre, String apellido, String telefono, String email){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}' + " con dirección en memoria:  " + super.toString();
    }
}
