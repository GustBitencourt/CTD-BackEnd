package SerieFlix;

public interface ISerie {
    Serie getSerie(String nomeSerie) throws SerieNaoHabilitadaException;
}
