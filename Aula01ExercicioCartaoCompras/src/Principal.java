public class Principal {
    public static void main(String[] args) {
        //instanciando o objeto facade, da classe facedeDesconto
        FacadeDesconto facade = new FacadeDesconto();
        Cartao cartao = new Cartao("123", "Star Bank");
        Produto produto = new Produto("Brigadeiro", "Lata");
        System.out.println("O valor do desconto será " );
    }
}
