public class Executor {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada listaDuplamenteEncadeada = new ListaDuplamenteEncadeada();

        // Testando a exibição inicial dos elementos
        listaDuplamenteEncadeada.exibirElementos();

        // Adicionando elementos
        listaDuplamenteEncadeada.adicionarInicio(5);
        listaDuplamenteEncadeada.adicionarFim(6);
        listaDuplamenteEncadeada.adicionarPosicao(7, 1);
        listaDuplamenteEncadeada.adicionarFim(10);
        listaDuplamenteEncadeada.adicionarInicio(2);
        listaDuplamenteEncadeada.exibirElementos();

        // Removendo elementos
        listaDuplamenteEncadeada.removerElemento(6);
        listaDuplamenteEncadeada.exibirElementos();

        // Exibindo o maior elemento
        System.out.println("Maior elemento: " + listaDuplamenteEncadeada.maiorElemento());

        // Exibindo o menor elemento
        System.out.println("Menor elemento: " + listaDuplamenteEncadeada.menorElemento());

        // Exibindo a média dos elementos
        System.out.println("Média dos elementos: " + listaDuplamenteEncadeada.mediaElementos());

        // Exibindo a quantidade de elementos
        System.out.println("Quantidade de elementos: " + listaDuplamenteEncadeada.quantidadeElementos());
    }
}
