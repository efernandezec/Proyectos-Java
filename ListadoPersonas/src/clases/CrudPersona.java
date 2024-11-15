package clases;

import java.util.ArrayList;
import java.util.List;

public class CrudPersona {

    private List<Persona> personas;

    public CrudPersona(){
        this.personas = new ArrayList<Persona>();
    }
    public Persona getPersona(int id){
        for (Persona persona : personas){
            if(persona.getId() == id){
                return persona;
            }
        }
        System.out.println("No se encontró una persona con el id : " + id);
        return null;
    }

    public void addPersona(String nombre, String apellido, String telefono, String email){
        Persona newPersona = new Persona(nombre,apellido,telefono,email);
        this.personas.add(newPersona);
        System.out.println("Persona registrada con éxito: " + newPersona);
    }

    public Persona updatePersona(int id, Persona persona){
        Persona obj = this.getPersona(id);
        if(obj != null){
            obj.setNombre(persona.getNombre());
            obj.setApellido(persona.getApellido());
            obj.setEmail(persona.getEmail());
            obj.setTelefono(persona.getTelefono());
            System.out.println("Persona con id " + id + " actualizada con éxito");
            return obj;
        }
        return null;
    }

    public Persona deletePersona(int id){
        Persona persona = this.getPersona(id);
        if(persona != null){
            this.personas.remove(persona);
            System.out.println("Persona con id " + id + " eliminada con éxito");
            return persona;
        }

        return null;
    }

    public void  getAllPersona(){
        if(!this.personas.isEmpty()) {
            this.personas.forEach(((persona) -> {
                System.out.println(persona.getId() + "." + persona);
            }));
        }
        else {
            System.out.println("No hay personas en el listado");
        }
    }



}
