public class ListaDuplamenteEncadeada {
    private No origem;
    private No fim;

    public ListaDuplamenteEncadeada() {
        this.origem = null;
        this.fim = null;
    }

    public void exibirElementos() {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
        } else {
            No aux = origem;
            while (aux != null) {
                System.out.println(aux.getElemento());
                aux = aux.getProximo(); //o loop continua até o aux = null, e percorre todos os nós na lista.
            }
        }
    }

    public void adicionarFim(Integer elemento) {
        No novoNo = new No(elemento);
        if (origem == null) { // ou seja, ainda não tem nenhum elemento na lista
            origem = novoNo;
            fim = novoNo; //inserindo o primeiro nó na lista, ele será o início e o fim
        } else {
            fim.setProximo(novoNo); //adiciona um próximo do nó fim, um novo nó
            novoNo.setAnterior(fim); //referencia o anterior do novo nó como o atual fim
            fim = novoNo; //atualiza o fim
        }
    }

    public void adicionarInicio(Integer elemento) {
        No novoNo = new No(elemento);
        if (origem == null) { // adiciona o primeiro nó na lista
            origem = novoNo;
            fim = novoNo;
        } else {
            novoNo.setProximo(origem); // atribui que a atual origem será o apontamento próximo do novo nó
            origem.setAnterior(novoNo); // insere o novo nó anterior a atual origem
            origem = novoNo; // reatribui origem para o novo nó
        }
    }

    public void adicionarPosicao(Integer elemento, int posicao) {
        No novoNo = new No(elemento);
        int cont = 0;
        No atual = origem;
        if (posicao < 0) {
            System.out.println("Informe uma posição válida.");
            return;
        }
        if (posicao == 0) {
            adicionarInicio(elemento);
            return;
        }
        while (atual != null && cont < posicao) {
            atual = atual.getProximo();
            cont++; // percorre toda a lista
        }
        if (atual == null) { // chegou ao final da lista
            if (cont == posicao) { // posição desejada é após o último nó na lista
                adicionarFim(elemento);
            } else { // posição maior que tamanho atual da lista
                System.out.println("Posição indisponível.");
            }
        } else { // atual diferente de null, posição intermediária
            novoNo.setProximo(atual); // o próximo nó do novoNo será o nó atual
            novoNo.setAnterior(atual.getAnterior());//anterior do novoNo =  nó que era anterior ao atual
            if (atual.getAnterior() != null) { // verifica se o nó anterior ao atual é diferente nulo
                atual.getAnterior().setProximo(novoNo); // o próximo do nó anterior ao atual aponta para o novoNo
            } else { // se o nó anterior ao atual for nulo, significa que estaremos inserindo um uma nova origem
                origem = novoNo;
            }
            atual.setAnterior(novoNo);
        }
    }

    public void removerElemento(Integer elemento) {
        System.out.println("Removendo elementos na lista.");
        if (origem != null) { // verifica se a lista não está vazia
            No atual = origem; // o nó atual começa a partir de origem
            while (atual != null) { // percorre toda a lista
                if (atual.getElemento().equals(elemento)) { // se o elemento do nó atual = ao ser removido
                    if (atual == origem) {
                        removerInicio(); //se o elemento estiver na origem, chama o metodo removerInicio
                    } else if (atual == fim) {
                        removerFim(); //se o elemento estiver no fim, chama o metodo removerFim
                    } else { // se o nó a remover é intermediário
                        atual.getAnterior().setProximo(atual.getProximo());
                        //anterior ao atual aponta próximo para o mesmo próximo do atual
                        if (atual.getProximo() != null) { // se o próximo do atuam não for null
                            atual.getProximo().setAnterior(atual.getAnterior());
                            //aponta anterior do próximo igual o anterior ao atual
                        }

                    }
                }
                atual = atual.getProximo(); // aponta para o próximo nó na lista
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerInicio() {
        System.out.println("Removendo elementos na lista.");
        if (origem != null) { // verifica se a lista não está vazia
            origem = origem.getProximo();
            // a origem se torna o próximo nó da lista
            if (origem != null) { // verifica se após a remoção ainda há algum nó, ou se só havia a origem na lista
                origem.setAnterior(null);
                // define o anterior da nova origem para nulo
            } else {
                fim = null; // se a lista estiver vazia após a remoção, define fim como nulo
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerFim() {
        System.out.println("Removendo elementos na lista.");
        if (fim != null) { // verifica se a lista não está vazia
            fim = fim.getAnterior(); // atualiza fim para o nó anterior ao atual fim
            if (fim != null) { //verifica se e a lista ainda contém algum elemento após a remoção do último nó
                fim.setProximo(null); // define o ponteiro próximo do fim como nulo
            } else {
                origem = null; // se o fim for nulo, define a origem como nulo
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerPosicao(int posicao) {
        System.out.println("Removendo elementos na lista.");
        if (posicao >= 0) {
            int cont = 0;
            No atual = origem;
            while (atual != null && cont < posicao) {
                atual = atual.getProximo();
                cont++; //percorre a lista até alcançar a posição atual desejada ou até o final da lista
            }
            if (atual != null) { //verifica se o nó da posição atual existe (não é nulo)
                if (atual == origem) {
                    removerInicio(); // se o atual for o nó origem, chama o método removerInicio
                } else if (atual == fim) {
                    removerFim(); // se o atual for o nó fim, chama o método removerFim
                } else { // se atual é um nó intermediário
                    atual.getAnterior().setProximo(atual.getProximo());
                    //o nó anterior ao atual aponta diretamente para o nó que próximo de atual
                    if (atual.getProximo() != null) { // verifica se não é o último nó da lista
                        atual.getProximo().setAnterior(atual.getAnterior()); // o próximo de atual aponta anterior o atual
                    }
                }
            } else { // se atual não exite (é nulo)
                System.out.println("A posição não existe na lista dinâmica.");
            }
        } else { // se a posição é negativa
            System.out.println("Informe uma posição válida.");
        }
    }

    public Integer maiorElemento() {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return null;
        }
        No aux = origem;
        Integer maior = aux.getElemento(); // inicializa maior como origem (assim como o aux)
        while (aux != null) { // percorrer toda a lista
            if (aux.getElemento() > maior) { // se o elemento no atual auxiliar for maior que o 'maior'
                maior = aux.getElemento(); // atualiza o maior para este valor
            }
            aux = aux.getProximo(); // avança para o próximo nó na lista
        }
        return maior;
    }

    public Integer menorElemento() {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return null;
        }
        No aux = origem;
        Integer menor = aux.getElemento(); // inicializa menor na origem (assim como o aux)
        while (aux != null) { // percorre toda a lista
            if (aux.getElemento() < menor) { // se o elemento no atual auxiliar for menor que o 'menor'
                menor = aux.getElemento(); // atualiza menor para este valor
            }
            aux = aux.getProximo(); //avança para o próximo nó na lista
        }
        return menor;
    }

    public Double mediaElementos() {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return null;
        }
        No aux = origem;
        int soma = 0;
        int count = 0;
        while (aux != null) {
            soma += aux.getElemento(); // adiciona o elemento atual a soma
            count++; // incrementa o contador de elementos
            aux = aux.getProximo(); // avança para o próximo nó
        }
        return count > 0 ? (double) soma / count : null;
        // se count (que armazena a quantidade de elementos) for > 0, soma e retorna em double
        // se count for zero, retorna null
    }

    public int quantidadeElementos() {
        No aux = origem;
        int count = 0;
        while (aux != null) { // percorre toda a lista
            count++;
            aux = aux.getProximo();
        }
        return count; // contém o número total de elementos na lista
    }

    public void buscarElemento(Integer elemento) {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return;  // Retorna imediatamente se a lista estiver vazia
        }
        No aux = origem;
        int posicao = 0;
        boolean encontrado = false;
        while (aux != null) { // quando aux == null significa que já percorreu toda a lista
            if (aux.getElemento().equals(elemento)) {// verifica se o elemento do nó atual é = ao desejado
                System.out.println("Elemento " + elemento + " encontrado na posição: " + posicao);
                encontrado = true; // indica que o elemento foi encontrado pelo menos uma vez na lista
            }
            aux = aux.getProximo();
            posicao++;
        }
        if (!encontrado) { // se depois de percorrer toda a lista, o elemento ainda não foi encontrado
            System.out.println("Elemento " + elemento +" não encontrado na lista.");
        }
    }
}
