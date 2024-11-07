public class EstoqueException extends Exception {
    // Exceção para quando a peça não é encontrada
    static class PecaNaoEncontradaException extends Exception {
        public PecaNaoEncontradaException(String mensagem) {
            super(mensagem);
        }
    }

    // Exceção para quando o item é inválido (exemplo: é um serviço, não uma peça)
    static class ItemInvalidoException extends Exception {
        public ItemInvalidoException(String mensagem) {
            super(mensagem);
        }
    }
}
