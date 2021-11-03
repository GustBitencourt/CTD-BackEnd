package ExercicioFacadeTurismo;

//procurar os hoteis de acordo com data pré-definida
public class HotelApi {
    public void buscarHoteis(String dataEntrada, String dataSaida, String cidade){
        System.out.println("-------------------------------------");
        System.out.println("Hoteis encontrados na cidade: " + cidade);
        System.out.println("Data de entrada: " + dataEntrada + ". \nData de saída: " + dataSaida);
    }
}
