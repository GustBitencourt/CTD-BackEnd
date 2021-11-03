package SerieFlix;

public class GradeSerie implements ISerie{

    @Override
    public Serie getSerie(String nomeSerie) throws SerieNaoHabilitadaException {
        Serie link = null;

        switch (nomeSerie) {
            case "The Big Bang Theory":
                link = "www.bigbang.com";
                break;

            case "Breaking Bad":
                link = "www.breakingbad.com";
                break;

            case "What if":
                link = "www.whatif.com";
                break;

            case "The Mandalorian":
                link = "www.mandalorian.com";
                break;

            case "I May Destroy You":
                link = "www.destroyyou.com";
                break;

            case "Dark":
                link = "www.dark.com";
                break;
        }
        return link;
    }
}
