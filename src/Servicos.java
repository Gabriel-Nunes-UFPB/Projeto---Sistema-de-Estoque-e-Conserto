import java.util.Map;

public class Servicos {
    private final ENUMPecasEServicos servicos;
    private final Map<ENUMPecasEServicos, Integer> pecasUsadas;

    public Servicos(ENUMPecasEServicos servicos, Map<ENUMPecasEServicos, Integer> pecasUsadas) {
        this.servicos = servicos;
        this.pecasUsadas = pecasUsadas;

        if(servicos.getCategoria() !=  ENUMPecasEServicos.Categoria.SERVICO) {
            throw new IllegalArgumentException("O serviço selecionado não é um serviço");

        } else {
            throw new IllegalArgumentException("O serviço não pode ser adicionado ao estoque");
        }
    }

    public double calcularPrecoFinalComPeca() throws EstoqueException.PecaNaoEncontradaException {
        double precoFinal = servicos.getPreco();

        for (Map.Entry<ENUMPecasEServicos, Integer> entry : pecasUsadas.entrySet()) {
            ENUMPecasEServicos peca = entry.getKey();
            int quantidade = entry.getValue();

            if(peca.getCategoria() != ENUMPecasEServicos.Categoria.PECA) {
                throw new EstoqueException.PecaNaoEncontradaException("A peça " + peca + " não pode ser adicionada ao estoque");
            } else {
                precoFinal += peca.getPreco() * quantidade;
            }
        }
        return precoFinal;
    }

    public double calcularPrecoFinalSemPeca() {
        return servicos.getPreco();
    }

    public void exibirDetalhesServico() throws EstoqueException.PecaNaoEncontradaException {
        System.out.println("Serviço: " + servicos);
        System.out.println("Preço: " + servicos.getPreco());

        if (!pecasUsadas.isEmpty()) {
            System.out.println("Peças usadas:");
            for (Map.Entry<ENUMPecasEServicos, Integer> entry : pecasUsadas.entrySet()) {
                ENUMPecasEServicos peca = entry.getKey();
                int quantidade = entry.getValue();
                System.out.println(peca + ": " + quantidade);
            }
            System.out.println("Preço final: " + calcularPrecoFinalComPeca());
        }
    }

}