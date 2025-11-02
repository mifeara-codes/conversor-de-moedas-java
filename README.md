# Conversor de Moedas (Challenge Oracle ONE)

Projeto de um conversor de moedas interativo que roda no console.
Foi feito como parte do Challenge Back-End da Alura (ONE - Oracle Next Education).

## O que ele faz
O programa se conecta a uma API de câmbio (ExchangeRate-API) para buscar as taxas de conversão e permite calcular:

* Dólar (USD) para Real (BRL)
* Real (BRL) para Dólar (USD)
* Dólar (USD) para Peso Argentino (ARS)
* Peso Argentino (ARS) para Dólar (USD)
* Dólar (USD) para Peso Colombiano (COP)
* Peso Colombiano (COP) para Dólar (USD)

O programa fica rodando e perguntando por novas conversões até o usuário escolher a opção de sair.
## Tecnologias

* Java 17
* HttpClient (para conectar na API)
* Gson (para ler o JSON da API)
* Maven (para gerenciar o Gson)

## Instruções

1.  Clonar o repositório.
2.  Abrir o projeto em uma IDE de dua preferência(como o IntelliJ).
3.  O Maven deve baixar o Gson automaticamente.
4.  Criar uma chave de API de graça no site [ExchangeRate-API](https://www.exchangerate-api.com).
5.  Colar a sua chave na variável `minhaChaveApi` no arquivo `Main.java`.
6.  Rodar o `Main.java`.

---
*Projeto desenvolvido por Mirella Fernandes.*