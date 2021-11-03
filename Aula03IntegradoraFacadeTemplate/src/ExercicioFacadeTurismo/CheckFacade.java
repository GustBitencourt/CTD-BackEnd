package ExercicioFacadeTurismo;

public class CheckFacade implements ICheckFacade{
    //armazenar instancia de cada Api
    private VooApi vooApi;
    private HotelApi hotelApi;

    //construtor do Facade | Notar diferença pro construtor normal | ele inicializa as instancias
    public CheckFacade() {
        vooApi = new VooApi();
        hotelApi = new HotelApi();
    }

    @Override
    public void buscar(String dataPartida, String dataRetorno, String origem, String destino) {
        vooApi.buscarVoos(dataPartida, dataRetorno, origem, destino);
        hotelApi.buscarHoteis(dataPartida, dataRetorno, destino);
    }
}
