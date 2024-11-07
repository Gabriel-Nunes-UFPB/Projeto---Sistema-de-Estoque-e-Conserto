public enum ENUMPecasEServicos {
    //PECAS
    HD(250.0, Categoria.PECA),
    FONTE(180.0, Categoria.PECA),
    PLACA_MAE(500.0, Categoria.PECA),
    MEMORIA(120.0, Categoria.PECA),
    DRIVE_OPTICO(150.0, Categoria.PECA),
    CONTROLADOR_REDE(75.0, Categoria.PECA),
    VENTOINHA(50.0, Categoria.PECA),

    //SERVICOS
    PROBLEMA_HD(50, Categoria.SERVICO),
    LIMPEZA_PREVENTIVA(50, Categoria.SERVICO),
    RESTAURACAO(150, Categoria.SERVICO),
    LIMPEZA_TOTAL(70, Categoria.SERVICO),
    MANUTENCAO_PREVENTIVA(100, Categoria.SERVICO),
    CONTROLE_NAO_CONECTA(75, Categoria.SERVICO),
    SUPERAQUECIMENTO(80, Categoria.SERVICO);


    private final double preco;
    private final Categoria categoria;

    ENUMPecasEServicos(double preco, Categoria categoria) {
        this.preco = preco;
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public enum Categoria {
        PECA, SERVICO
    }

}
