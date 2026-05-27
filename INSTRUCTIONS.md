Teste as duas versões da classe Counter (a versão sem sincronização está listada abaixo — modifique-a para produzir a versão com sincronização). Relate os resultados com relação aos efeitos sobre a consistência dos dados em memória. Construa o código testar a classe Counter com pelo menos duas threads concorrentes.

Versão sem sincronização:

```java
class Counter {

    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}
```