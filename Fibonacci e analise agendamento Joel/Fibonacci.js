const n = 4;

// Passo 1: Algoritmo de Divisão e Conquista                                                // divide em subproblemas menores e resolvendo-os de maneira recursiva
function fibonacciDivideAndConquer(n) {
    if (n <= 1) {                                                                           // checa se n é 0 ou 1 se sim o valor retorna (base da recursão qeu tem em todos)
      return n;
    } else {
      return fibonacciDivideAndConquer(n - 1) + fibonacciDivideAndConquer(n - 2);           // divide o problema em duas chamadas recursivas n - 1 e n - 2, somando os resultados
    }
  }
  
  // exemplo
  const resultStep1 = fibonacciDivideAndConquer(n);
  console.log(`Passo 1: ${resultStep1}`);

  
// Passo 2: Algoritmo de Programação Dinâmica (Top-Down)                                    // também é recursivo mas usa a memorização
function fibonacciDynamicTopDown(n, memo = {}) {                                            // a função mantém um objeto memo para armazenar os resultados já calculados
  if (n <= 1) {                                                                             // base da recursão 
    return n;
  }

  if (!memo[n]) {
    memo[n] = fibonacciDynamicTopDown(n - 1, memo) + fibonacciDynamicTopDown(n - 2, memo);  // checa se o valor já foi calculado antes e caso não, calcula recursivamente os termos n-1 e n-2 e armazena o resultado na memoria para não calcular denovo.
  }

  return memo[n];                                                                           // retorna o valor da memória                  
}

// exemplo
const resultStep2 = fibonacciDynamicTopDown(n);
console.log(`Passo 2: ${resultStep2}`);

// Passo 3: Algoritmo de Programação Dinâmica (Bottom-Up)                                   // aborda o Fibonacci de maneira iterativa, pega o caso base e preenche o array fib com os resultados intermediários até chegar ao valor desejado
function fibonacciDynamicBottomUp(n) {  
  if (n <= 1) {                                                                             // (base da recursão)
    return n;
  }

  const fib = [0, 1];                                                                       // inicia a array fib com os valores base do fibonacci.
  for (let i = 2; i <= n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];                                                       //  preenche fib de forma iterativa calculando os termos a partir dos anteriores
  }

  return fib[n];                                                                            // retorna o valor do (n)-ésimo termo calculado
}

// exemplo
const resultStep3 = fibonacciDynamicBottomUp(n);
console.log(`Passo 3: ${resultStep3}`);







/**  Analise Agendamento do vinicius pelo Joel

Ordenar projetos pela data de término em ordem crescente  # .sort = O(n log n) - tempo

projetosSelecionados = []  # O(n) - espaço
projetoAtual = projetos[0]  # O(1) - espaço
Adicionar projetoAtual a projetosSelecionados  # O(1) - tempo

Para i de 1 até o tamanho de projetos - 1:  # O(n) - tempo
    projeto = projetos[i]  # O(1) - espaço
    Se projeto.inicio >= projetoAtual.fim:  # O(1) - tempo
        Adicionar projeto a projetosSelecionados  # O(1) - tempo
        projetoAtual = projeto  # O(1) - espaço

Retornar projetosSelecionados  # O(n) - espaço e tempo

listaProjetos = [Projeto(1, 3, 50), Projeto(2, 5, 20), Projeto(6, 9, 30), Projeto(3, 8, 40)]  # O(1) - espaço
projetosSelecionados = SelecionarProjetos(listaProjetos)  # O(n log n) - tempo

Imprimir "Projetos selecionados:"  # O(1) - tempo
Para cada projeto em projetosSelecionados:  # O(n) - tempo
    Imprimir "Data Inicial: " + projeto.inicio + ", Data Final: " + projeto.fim + ", Lucro: " + projeto.lucro  # O(1) - tempo


R: 
Tempo: O(n log n) 
Espaço: O(n) 
*/