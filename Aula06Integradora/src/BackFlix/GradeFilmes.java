package BackFlix;

public class GradeFilmes implements IGradeFilmes{

    @Override
    public Filme getFilme(String nomeFilme){
        Filme filme = null;
        switch (nomeFilme){
            case "Homem Aranha":
                filme = new Filme("Homem Aranha", "Brasil", "www.backflix.com.br/HomemAranha");
                break;

            case "Colombiana em Busca de Vingança":
                filme = new Filme("Colombiana em Busca de Vingança", "Colombia", "www.backflix.com.co/ColombianaEmBuscaDeVingança");
                break;

            case "De Volta Para o Futuro":
                filme = new Filme("De Volta Para o Futuro", "Argentina", "www.backflix.com.ar/DeVoltaParaOFuturo");
                break;

            case "Matrix":
                filme = new Filme("Matrix", "Argentina", "www.backflix.com.ar/Matrix");
                break;

            case "Avengers":
                filme = new Filme("Avengers", "Brasil", "www.backflix.com.br/Avengers");
                break;
        }
        return filme;
    }
}
