// Passo 1: Algoritmo de Divisão e Conquista (Complexidade Θ(2^n))
function fibonacciDivideAndConquer(n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacciDivideAndConquer(n - 1) + fibonacciDivideAndConquer(n - 2);
    }
  }
  
  // exemplo
  const resultStep1 = fibonacciDivideAndConquer(10);
  console.log(`Passo 1: ${resultStep1}`);

  
// Passo 2: Algoritmo de Programação Dinâmica (Top-Down) (Complexidade Θ(n))
function fibonacciDynamicTopDown(n, memo = {}) {
  if (n <= 1) {
    return n;
  }

  if (!memo[n]) {
    memo[n] = fibonacciDynamicTopDown(n - 1, memo) + fibonacciDynamicTopDown(n - 2, memo);
  }

  return memo[n];
}

// exemplo
const resultStep2 = fibonacciDynamicTopDown(10);
console.log(`Passo 2: ${resultStep2}`);

// Passo 3: Algoritmo de Programação Dinâmica (Bottom-Up) (Complexidade Θ(n))
function fibonacciDynamicBottomUp(n) {
  if (n <= 1) {
    return n;
  }

  const fib = [0, 1];
  for (let i = 2; i <= n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }

  return fib[n];
}

// exemplo
const resultStep3 = fibonacciDynamicBottomUp(10);
console.log(`Passo 3: ${resultStep3}`);