public class Executor {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada ListaDuplamenteEncadeada = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada.exibirElementos();
        ListaDuplamenteEncadeada.adicionarInicio(5);
        ListaDuplamenteEncadeada.adicionarFim(6);
        ListaDuplamenteEncadeada.adicionarPosicao(7, 1);
        ListaDuplamenteEncadeada.removerElemento(6);
        ListaDuplamenteEncadeada.exibirElementos();
    }
}
