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
                aux = aux.getProximo();
                // o loop while continua até que o aux seja nulo, e percorre todos os nós na lista.
            }
        }
    }

    public void adicionarFim(Integer elemento) {
        No novoNo = new No(elemento);
        if (origem == null) {
            origem = novoNo;
            fim = novoNo;
            // por estar iniciando o primeiro nó na lista, ele será o início e o fim
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
            // com referência no nó fim, adiciona um próximo nó que também assumirá a posição de nó fim
        }
    }

    public void adicionarInicio(Integer elemento) {
        No novoNo = new No(elemento);
        if (origem == null) {
            origem = novoNo;
            fim = novoNo;
            // adiciona o primeiro nó na lista
        } else {
            novoNo.setProximo(origem);
            // atribui que a atual origem será o apontamento próximo do novo nó
            origem.setAnterior(novoNo);
            // insere o novo nó anterior a atual origem
            origem = novoNo;
            // reatribui origem para o novo nó
        }
    }

    public void adicionarPosicao(Integer elemento, int posicao) {
        if (posicao >= 0) {
            int cont = 0;
            No atual = origem;
            No novoNo = new No(elemento);
            if (posicao == 0) {
                adicionarInicio(elemento);
                return;
                // adiciona um novo nó origem
            }
            while (atual != null && cont < posicao) {
            //percorre a lista até que atual receba nulo (o que infica o fim da lista) ou que cont alcance
                // a posição desejada
                atual = atual.getProximo();
                // atualiza o atual para o proximo nó na lista
                cont++;
            }
            if (atual == null) {
                // significa que o final da lista foi alcançado
                if (cont == posicao) {
                    // verifica se o cont coincide com a posição, significando que a posição é o último elemento
                    adicionarFim(elemento);
                } else {
                    System.out.println("Posição indisponível.");
                    // se o cont for diferente de posição, significa que a posição é maior que o tamanho da lista
                }
            } else {
                novoNo.setProximo(atual);
                // faz com que o próximo do novo nó seja o atual, atribuindo ao novo nó ser o atual
                novoNo.setAnterior(atual.getAnterior());
                // define que o novo nó aponte como anterior o mesmo nó que é apontado como anterior do atual
                if (atual.getAnterior() != null) {
                    // verifica se o nó anterior ao nó atual não é nulo, pois caso fosse seria o origenm
                    atual.getAnterior().setProximo(novoNo);
                    // atualiza que o nó anterior ao atual aponte seu próximo para o novo nó, não mais para atual
                }
                atual.setAnterior(novoNo);
                // atualiza que o nó atual aponte o novo nó como seu anterior
            }
        } else {
            System.out.println("Informe uma posição válida.");
            // menor que 0 ou fora do alcance da lista
        }
    }

    public void removerElemento(Integer elemento) {
        System.out.println("Removendo elementos na lista.");
        if (origem != null) {
            // verifica se a lista não está vazia
            No atual = origem;
            // o nó atual começa a partir de origem
            while (atual != null) {
                // percorre toda a lista
                if (atual.getElemento().equals(elemento)) {
                    // verifica se o elemento do nó atual é o mesmo elemento que deve ser removido
                    if (atual == origem) {
                        removerInicio();
                        //se o elemento estiver presente na origem, chama o metodo removerInicio
                    } else if (atual == fim) {
                        removerFim();
                        //se o elemento estiver presente no fim , chama o metodo removerFim
                    } else {
                        atual.getAnterior().setProximo(atual.getProximo());
                        if (atual.getProximo() != null) {
                            atual.getProximo().setAnterior(atual.getAnterior());
                            //se o nó atual é um nó intermediário ajusta os ponteiros anterior e próximo
                            //o ponteiro proximo do nó anterior para pular o nó atual e apontar para o nó seguinte
                            //se o próximo do atual não é nulo, seu anterior aponta para o nó anterior ao atual
                        }

                    }
                }
                atual = atual.getProximo();
                // aponta para o próximo nó na lista
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerInicio() {
        System.out.println("Removendo elementos na lista.");
        if (origem != null) {
            // verifica se a lista não está vazia
            origem = origem.getProximo();
            // a origem se torna o próximo nó da lista
            if (origem != null) {
                // verifica se após a remoção ainda há algum nó, ou se só havia a origem na lista
                origem.setAnterior(null);
                // define o anterior da nova origem para nulo
            } else {
                fim = null;
                // se a lista estiver vazia após a remoção, define fim como nulo
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerFim() {
        System.out.println("Removendo elementos na lista.");
        if (fim != null) {
            // verifica se a lista não está vazia
            fim = fim.getAnterior();
            // atualiza fim para o nó anterior ao atual fim
            if (fim != null) {
                //Verifica se o novo fim não é nulo, ou seja, se a lista ainda contém nós após a remoção do último nó
                fim.setProximo(null);
                // define o ponteiro próximo do fim como nulo
            } else {
                origem = null;
                // se o fim for nulo, define a origem como nulo
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
                cont++;
            //percorre a lista até alcançar a posição atual desejada ou até o final da lista
            }
            if (atual != null) {
                //verifica se o nó da posição atual existe (não é nulo)
                if (atual == origem) {
                    removerInicio();
                    // se o atual for o nó origem, chama o método removerInicio
                } else if (atual == fim) {
                    removerFim();
                    // se o atual for o nó fim, chama o método removerFim
                } else {
                    // se atual é um nó intermediário
                    atual.getAnterior().setProximo(atual.getProximo());
                    if (atual.getProximo() != null) {
                        atual.getProximo().setAnterior(atual.getAnterior());
                        //defina proximo do nó anterior para pular o nó atual e apontar para o nó seguinte
                        //se o nó próximo não é null, seu anterior aponta para o nó anterior ao nó atual.
                    }
                }
            } else {
                // se atual não exite (é nulo)
                System.out.println("A posição não existe na lista dinâmica.");
            }
        } else {
            // se a posição é negativa
            System.out.println("Informe uma posição válida.");
        }
    }

    public Integer maiorElemento() {
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return null;
        }
        No aux = origem;
        Integer maior = aux.getElemento();
        // inicializado o elemento maior como o elemento na origem (assim como o aux)
        while (aux != null) {
            // até o aux se tornar nulo, ou seja, percorrer toda a lista
            if (aux.getElemento() > maior) {
                // se o elemento no atual auxiliar for maior que o ,'maior'
                maior = aux.getElemento();
                // atualiza o maior para este valor
            }
            aux = aux.getProximo();
            // avança para o próximo nó na lista
        }
        return maior;
    }

    public Integer menorElemento() {
        // mesma lógica do maiorElemento
        if (origem == null) {
            System.out.println("Não existem elementos na lista.");
            return null;
        }
        No aux = origem;
        Integer menor = aux.getElemento();
        while (aux != null) {
            if (aux.getElemento() < menor) {
                menor = aux.getElemento();
            }
            aux = aux.getProximo();
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
        // se count (que armazena a quantidade de nós/elementos) for > 0, calcula soma/count e retorna double
        // se count for zero (tecnicamente impossível após a verificação inicial de lista vazia), retornaria null
    }

    public int quantidadeElementos() {
        No aux = origem;
        int count = 0;
        while (aux != null) {
            count++;
            aux = aux.getProximo();
        }
        return count;
        // Após o loop terminar o método retorna o valor de count, que contém o número total de elementos na lista
    }
}
