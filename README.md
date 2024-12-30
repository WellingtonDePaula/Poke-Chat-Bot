# Poke Chat-Bot

## Para rodar

Este é um projeto maven, portanto para poder rodar o código deverá ter o maven baixado e configurado. Então basta baixar este repositório, abrir o console no projeto e rodar o seguinte comando:

- ***mvn install clean***

Após isso então, dar run na classe Main, e deliciar-se desse projeto lixo. bjs

## Geral

### Este é um projeto de alunos do IFC campus Blumenau na disciplina de WebDesign, com o objetivo de criar um chatbot de um determinado assunto.

##### Alunos:
- Ana
- Milena
- Sofia
- Wellington

O chatbot foi feito para ser uma espécie de pokedéx dos pokémons da primeira geração, ele se utiliza de palavras chaves digitadas no texto, e então reconhece o que se pede.

Exemplo de palavras chave:
- Tipo
- Fraqueza
- Descrição

O chatbot não consegue funcionar se colocar mais de um pokémon por vez, por isso ele retornará uma mensagem de erro.

## Ideias futuras

- Implementar a possibilidade de um "sobre" de cada tipo de pokémon
- Deixar o código melhor e mais "limpo"
- Implementar a possibilidade do chat se lembrar do último pokémon citado
- Possibilitar a entrada de mais de um pokémon por vez, fazendo uma leitura mais detalhada e avançada da entrada
- Trazer mensagens diversificadas
### Opcionais
- Aplicar os conceitos de rest e restful, reestruturando todo o código
- Consumir da [PokéApi](https://pokeapi.co), assim tendo acesso a todos os pokémons disponíveis

## Possíveis inputs

Caso seja informado o nome do pokémon, poderá ser pedido até 3 informações sobre o mesmo sendo elas:
1. Tipos
2. Fraquezas
3. Descrição
Podendo ser pedidas as três ao mesmo tempo ou não.

### 🔴Exemplo:
1. Input: 'Qual o tipo e a fraqueza do charmander?'

Resposta: 'Charmander:

Este é um pokémon de tipo Fogo

É vulnerável a pokémons do tipo Água/Terra/Rocha'

Caso seja informado as palavras chaves tipo ou fraqueza, poderá ser pedido os tipos de pokémons do sistema, e então será retornado os pokémons com as devidas exigências.

### 🔴Exemplos:
1. Input: 'Quais polémons tem o tipo fantasma?'

Resposta: 'Os pokémons que se enquadram nos requisitos, são:

Gastly

Haunter

Gengar'

2. Input: 'Pokémons fracos ao tipo água e planta'

Resposta: 'Os pokémons que se enquadram nos requisitos, são:

Sandshrew

Sandslash

Diglett

Dugtrio

Geodude

Graveler

Golem

Onix

Cubone

Marowak

Rhyhorn

Rhydon'
