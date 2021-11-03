package BackFlix;

public class Main {
    public static void main(String[] args) {
        GradeFilmesProxy proxy = new GradeFilmesProxy(new GradeFilmes());
        proxy.setIp(new IP(29,23,15,18));

        try{
            System.out.println(proxy.getFilme("Homem Aranha").getLink());
        }
        catch (FilmeNaoHabilitadoException e) {
            System.out.println(e);
        }

        try{
            System.out.println(proxy.getFilme("Matrix").getLink());
        }
        catch (FilmeNaoHabilitadoException e) {
            System.out.println(e);
        }

        try{
            System.out.println(proxy.getFilme("Colombiana em Busca de Vingança").getLink());
        }
        catch (FilmeNaoHabilitadoException e) {
            System.out.println(e);
        }
    }
}
