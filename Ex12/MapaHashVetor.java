
public class MapaHashVetor {
    private Aluno[] vetor;
    private int tamanho;
    private static final double FATOR_CARGA_MAXIMO = 0.75;

    public MapaHashVetor(int capacidadeInicial) {
        // Garantir que o tamanho seja um número primo para melhor distribuição
        this.vetor = new Aluno[proximoPrimo(capacidadeInicial)];
        this.tamanho = 0;
    }

    // Função hash básica usando módulo
    private int hash(int chave) {
        return chave % this.vetor.length;
    }

    // Função hash com sondagem linear
    private int hash(int chave, int sondagem) {
        return (hash(chave) + sondagem) % this.vetor.length;
    }

    // Método para inserir um aluno no mapa
    public void put(int chave, Aluno valor) {
        // Verificar se precisamos redimensionar o vetor
        if ((double) tamanho / vetor.length >= FATOR_CARGA_MAXIMO) {
            redimensionar();
        }

        int sondagem = 0;
        int hash;
        
        while (sondagem < vetor.length) {
            hash = hash(chave, sondagem);
            
            // Se a posição estiver vazia ou contiver a mesma chave
            if (vetor[hash] == null || vetor[hash].getMatricula() == chave) {
                if (vetor[hash] == null) {
                    tamanho++; // Só incrementa se for uma nova inserção
                }
                vetor[hash] = valor;
                return;
            }
            sondagem++;
        }
        
        // Se chegou aqui, o vetor está cheio (deveria ter sido redimensionado antes)
        throw new IllegalStateException("Tabela hash cheia");
    }

    // Método para buscar um aluno pela matrícula
    public Aluno get(int chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < vetor.length) {
            hash = hash(chave, sondagem);
            
            if (vetor[hash] == null) {
                return null; // Não encontrado
            }
            
            if (vetor[hash].getMatricula() == chave) {
                return vetor[hash]; // Encontrado
            }
            
            sondagem++;
        }
        
        return null; // Não encontrado após percorrer todo o vetor
    }

    // Método para remover um aluno pela matrícula
    public Aluno remove(int chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < vetor.length) {
            hash = hash(chave, sondagem);
            
            if (vetor[hash] == null) {
                return null; // Não encontrado
            }
            
            if (vetor[hash].getMatricula() == chave) {
                Aluno removido = vetor[hash];
                vetor[hash] = null;
                tamanho--;
                return removido;
            }
            
            sondagem++;
        }
        
        return null; // Não encontrado após percorrer todo o vetor
    }

    // Método para redimensionar o vetor quando o fator de carga é atingido
    private void redimensionar() {
        Aluno[] vetorAntigo = vetor;
        vetor = new Aluno[proximoPrimo(vetor.length * 2)];
        tamanho = 0;
        
        // Reinserir todos os elementos no novo vetor (rehash)
        for (Aluno aluno : vetorAntigo) {
            if (aluno != null) {
                put(aluno.getMatricula(), aluno);
            }
        }
    }

    // Método auxiliar para encontrar o próximo número primo
    private int proximoPrimo(int numero) {
        while (true) {
            if (ehPrimo(numero)) {
                return numero;
            }
            numero++;
        }
    }

    // Método auxiliar para verificar se um número é primo
    private boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para visualização do vetor (para fins de depuração)
    public void imprimir() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(i + ": ");
            if (vetor[i] != null) {
                System.out.println(vetor[i]);
            } else {
                System.out.println("null");
            }
        }
    }
}