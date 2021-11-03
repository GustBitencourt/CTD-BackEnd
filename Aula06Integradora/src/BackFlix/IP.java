package BackFlix;

import java.util.Arrays;

public class IP {
    private int[] numeroIp = new int[4];

    //contrutor para pegar os numeros no array
    public IP(int n1, int n2, int n3, int n4) {
        this.numeroIp[0] = n1;
        this.numeroIp[1] = n2;
        this.numeroIp[2] = n3;
        this.numeroIp[3] = n4;
    }

    //Apresentação do Ip
    @Override
    public String toString() {
        return "IP{" + this.numeroIp[0] + "." + this.numeroIp[1] + "." + this.numeroIp[2] + "." + this.numeroIp[3] +'}';
    }

    String getPais(){
        String pais = "";
        if(numeroIp[0] <= 49) {
            pais = "Argentina";
        }
        if ((numeroIp[0] <= 99) && numeroIp[0] >= 50) {
            pais = "Brasil";
        }
        if ((numeroIp[0] <= 149) && numeroIp[0] >= 100) {
            pais = "Colombia";
        }
        return pais;
    }
}
