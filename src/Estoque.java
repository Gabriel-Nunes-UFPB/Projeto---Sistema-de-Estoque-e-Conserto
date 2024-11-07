import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private final Map<ENUMPecasEServicos, Integer> estoque = new HashMap<>();

    // Inicializa o estoque com quantidades iniciais
    public void instanciarEstoque() {
        for (ENUMPecasEServicos item : ENUMPecasEServicos.values()) {
            if(item.getCategoria() == ENUMPecasEServicos.Categoria.PECA) {
                estoque.put(item, 5);
            }
        }
    }

    public void adicionarAoEstoque(ENUMPecasEServicos item, int quantidade) throws EstoqueException.ItemInvalidoException, EstoqueException.PecaNaoEncontradaException {
        if(item.getCategoria() == ENUMPecasEServicos.Categoria.PECA) {
            estoque.put(item, estoque.getOrDefault(item, 0) + quantidade);
        } else if (item.getCategoria() == ENUMPecasEServicos.Categoria.SERVICO) {
            throw new EstoqueException.ItemInvalidoException("Serviço não pode ser adicionado ao estoque");
        }else {
            throw new EstoqueException.PecaNaoEncontradaException("Peça não encontrada");
        }
    }

    public void removerDoEstoque(ENUMPecasEServicos item, int quantidadeRemovida) throws EstoqueException.ItemInvalidoException, EstoqueException.PecaNaoEncontradaException {
        if(item.getCategoria() == ENUMPecasEServicos.Categoria.PECA) {
            int estoqueAtual = estoque.getOrDefault(item, 0);
            if (estoqueAtual >= quantidadeRemovida) {
                estoque.put(item, estoqueAtual - quantidadeRemovida);
            } else {
                throw new EstoqueException.PecaNaoEncontradaException("Peça não disponível no estoque");
            }
        } else if (item.getCategoria() == ENUMPecasEServicos.Categoria.SERVICO) {
            throw new EstoqueException.ItemInvalidoException("Serviço não pode ser removido do estoque");
        }else {
            throw new EstoqueException.PecaNaoEncontradaException("Peça não encontrada");
        }
    }

    public void setPecaEstoque(ENUMPecasEServicos peca, int quantidade) throws EstoqueException.ItemInvalidoException, EstoqueException.PecaNaoEncontradaException {
        for(Map.Entry<ENUMPecasEServicos, Integer> entry : estoque.entrySet()) {
            if(entry.getKey().equals(peca)) {
                entry.setValue(quantidade);
                return;
            } else if (peca.getCategoria() == ENUMPecasEServicos.Categoria.SERVICO) {
                throw new EstoqueException.ItemInvalidoException("Serviço não pode ser adicionado ao estoque");

            } else{
                throw new EstoqueException.PecaNaoEncontradaException("Peça não encontrada");
            }
        }
    }

    public void exibirEstoque() {
        System.out.println("Estoque:");
        for (Map.Entry<ENUMPecasEServicos, Integer> entry : estoque.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<ENUMPecasEServicos, Integer> getEstoque() {
        return estoque;
    }

}
