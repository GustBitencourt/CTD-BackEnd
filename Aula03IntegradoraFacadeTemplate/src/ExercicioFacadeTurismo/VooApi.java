package ExercicioFacadeTurismo;

//vai procurar voos de acordo com a data pre-definida
public class VooApi {
    public void buscarVoos(String dataPartida, String dataRetorno, String origem, String destino){
        System.out.println("-------------------------------------");
        System.out.println("Voos encontrados para: " + destino + " partindo de: " + origem);
        System.out.println("Data de ida: " + dataPartida + ". \nData de volta: " + dataRetorno);
    }
}
