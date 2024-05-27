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
            }
        }
    }

    public void adicionarFim(Integer elemento) {
        System.out.println("Adicionando elementos na lista.");
        No novoNo = new No(elemento);
        if (origem == null) {
            // Estou adicionando o primeiro nó na lista
            origem = novoNo;
            fim = novoNo;
        } else {
            // Já possui nó na lista
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
    }

    public void adicionarInicio(Integer elemento) {
        System.out.println("Adicionando elementos na lista.");
        No novoNo = new No(elemento);
        if (origem != null) {
            novoNo.setProximo(origem);
            origem.setAnterior(novoNo);
            origem = novoNo;
        } else {
            origem = novoNo;
            fim = novoNo;
        }
    }

    public void adicionarPosicao(Integer elemento, int posicao) {
        System.out.println("Adicionando elementos na lista.");
        if (posicao >= 0) {
            int cont = 0;
            No atual = origem;
            No novoNo = new No(elemento);
            if (posicao == 0) {
                adicionarInicio(elemento);
                return;
            }
            while (atual != null && cont < posicao) {
                atual = atual.getProximo();
                cont++;
            }
            if (atual == null) {
                if (cont == posicao) {
                    adicionarFim(elemento);
                } else {
                    System.out.println("Posição indisponível.");
                }
                return;
            } else {
                novoNo.setProximo(atual);
                novoNo.setAnterior(atual.getAnterior());
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(novoNo);
                }
                atual.setAnterior(novoNo);
            }
        } else {
            System.out.println("Informe uma posição válida.");
        }
    }

    public void removerElemento(Integer elemento) {
        System.out.println("Removendo elementos na lista.");
        if (origem != null) {
            No atual = origem;
            while (atual != null) {
                if (atual.getElemento().equals(elemento)) {
                    if (atual == origem) {
                        removerInicio();
                    } else if (atual == fim) {
                        removerFim();
                    } else {
                        atual.getAnterior().setProximo(atual.getProximo());
                        if (atual.getProximo() != null) {
                            atual.getProximo().setAnterior(atual.getAnterior());
                        }
                    }
                }
                atual = atual.getProximo();
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerInicio() {
        if (origem != null) {
            origem = origem.getProximo();
            if (origem != null) {
                origem.setAnterior(null);
            } else {
                fim = null;
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerFim() {
        if (fim != null) {
            fim = fim.getAnterior();
            if (fim != null) {
                fim.setProximo(null);
            } else {
                origem = null;
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public void removerPosicao(int posicao) {
        if (posicao >= 0) {
            int cont = 0;
            No atual = origem;
            while (atual != null && cont < posicao) {
                atual = atual.getProximo();
                cont++;
            }
            if (atual != null) {
                if (atual == origem) {
                    removerInicio();
                } else if (atual == fim) {
                    removerFim();
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    if (atual.getProximo() != null) {
                        atual.getProximo().setAnterior(atual.getAnterior());
                    }
                }
            } else {
                System.out.println("A posição não existe na lista dinâmica.");
            }
        } else {
            System.out.println("Informe uma posição válida.");
        }
    }
}
