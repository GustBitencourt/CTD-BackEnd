package Spotify;

public class DownloadProxy implements IDownload{

    @Override
    public void download(Object[] infoUsuario) {
        if (infoUsuario[1].equals("Premium")){
            DownloadMusica baixar = new DownloadMusica();
            baixar.download(infoUsuario);

        } else {
            System.out.println("Você não é um usuário Premium, por favor cadastre-se para usufruir de nossas vantagens!");
        }
    }
}
