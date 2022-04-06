import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

public class JavaReflection {
    public static void main(String[] args) {
        List<Alumno> lista1 = new ArrayList<Alumno>();
        List<Profesor> lista2 = new ArrayList<Profesor>();
        List<Punto> lista3 = new ArrayList<Punto>();

        lista1.add(new Alumno("Alvaro","Bacareza","C"));
        lista1.add(new Alumno("Diana","Erazo","T"));

        lista2.add(new Profesor("Franco","Ezeiza",12.34));
        lista2.add(new Profesor("Wilson","Salgado",22.34));

        lista3.add(new Punto(0,0));
        lista3.add(new Punto(3,2));


        /**for(alumno a: lista1){
            system.out.print("nombre estudiante: "+a.getnombre());
            system.out.println(" "+a.getapellido());
        }
        for(profesor p: lista2){
            system.out.println(p.getnombre());
            system.out.println(p.getapellido());
        }**/
        imprimirLista(lista1);
        imprimirLista(lista2);
        imprimirLista(lista3);
    }

    public static void imprimirLista(List lista) {

        //Se obtiene cualquier objeto dentro de la lista (Profesores || Alumnos)
        for (Object c: lista){

            //Extrae todos los métodos que hay dentro de la clase a la que pertenece el objeto
            Method[] methods= c.getClass().getMethods();
            for (Method m: methods){
                //System.out.println(m.getName());

                if (m.getName().equals("getNombre") || m.getName().equals("getApellido")){
                    try {
                        String cadena = (String) m.invoke(c,null);
                        System.out.println(cadena);
                    }catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                        //catch block autogenerado
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
