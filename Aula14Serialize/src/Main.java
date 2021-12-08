import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro();
        cachorro1.setNome("Plutao");
        cachorro1.setIdade(3);

        Cachorro cachorro2 = new Cachorro();
        cachorro1.setNome("TucTuc");
        cachorro2.setIdade(1);

        Cachorro cachorro3 = new Cachorro();
        cachorro1.setNome("Arcanine");
        cachorro2.setIdade(9);

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);
        cachorros.add(cachorro3);

        //Salvando coleção em arquivo
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(cachorros);

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        //Recuperando Arquivos
        List<Cachorro> cachorros2 = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("Outputfile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            cachorros2 = (ArrayList) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }


    }
}
