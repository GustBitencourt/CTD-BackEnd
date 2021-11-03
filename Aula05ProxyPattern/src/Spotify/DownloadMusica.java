package Spotify;

public class DownloadMusica implements IDownload{
    @Override
    public void download(Object[] infoUsuario) {
        System.out.println("Usuario com o indentificador: " + infoUsuario[0] + " tem sua conta: " + infoUsuario[1].toString());
    }
}
