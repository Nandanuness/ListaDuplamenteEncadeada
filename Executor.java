public class Executor {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        // Teste dos métodos de adição
        lista.adicionarFim(5);
        lista.adicionarInicio(1);
        lista.adicionarPosicao(3, 1);
        lista.adicionarFim(6);
        lista.adicionarFim(6);
        lista.exibirElementos();

        // Teste dos métodos de remoção
        lista.removerElemento(3);
        lista.exibirElementos();
        lista.removerInicio();
        lista.exibirElementos();
        lista.removerFim();
        lista.exibirElementos();
        lista.removerPosicao(2);
        lista.exibirElementos();

        // Exibindo o maior elemento
        System.out.println("Maior elemento: " + lista.maiorElemento());

        // Exibindo o menor elemento
        System.out.println("Menor elemento: " + lista.menorElemento());

        // Exibindo a média dos elementos
        System.out.println("Média dos elementos: " + lista.mediaElementos());

        // Exibindo a quantidade de elementos
        System.out.println("Quantidade de elementos: " + lista.quantidadeElementos());
    }
}