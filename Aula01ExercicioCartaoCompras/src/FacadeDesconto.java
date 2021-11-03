public class FacadeDesconto implements IFacadeDesconto{

    //criar variavel que armazena a instancia de cada api
    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    //construtor que cria as instancias
    public FacadeDesconto() {
        apiCartao = new ApiCartao();
        apiProduto = new ApiProduto();
        apiQuantidade = new ApiQuantidade();
    }

    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0;
        desconto = desconto + apiQuantidade.desconto(quantidade);
        desconto = desconto + apiProduto.desconto(produto);
        desconto = desconto + apiCartao.desconto(cartao);

        return desconto;
    }
}
