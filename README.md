## Desenvolvido através do Programa de Atração e Desenvolvimento de Talentos PUCPR- Visionnaire - Bradesco

# JV: Atividade 5 - Life Potion

### Crie a classe da poção de vida. Como atributo, ela terá um máximo de vida que pode restaurar (defina o valor 10 como padrão)
### Caso o personagem esteja fraco (life <= 25% do inicial ou <= 2), no lugar do ataque, ele irá beber a poção.
### Ao beber, o tamanho do “gole” dele é definido por 1D6 pontos de vida, que serão restaurados.
### Reduza a quantidade bebida do total de pontos da poção.
### Caso o gole seja maior do que o conteúdo da poção, ele restaurará somente o valor da poção
### Já se o tamanho do gole for maior que o life inicial, a vida será restaurada somente até o valor do life inicial.
### Finalmente, se a poção esvaziar, o personagem irá descarta-la.
### Trabalhe com associação! Ou seja, o personagem pode não estar de posse de uma poção (null). Nesse caso, ele nunca tentará bebe-la!
### Altere o programa para que o Goblin seja criado com uma poção
### Se preferir, publique seu código no github e envie o link do repositório


# JV: Atividade 7 - FixedRoll

### Imagine que você precisa testar seu sistema e, para isso, precisa saber exatamente quais serão as rolagens de dados que ocorrerão.
### Ela deverá implementar a interface Rollable
### Crie uma classe de rolagem de dados “fake”. Ela deve possuir os métodos:
### construtor(int ... results): Que cria uma nova fixed roll com um conjunto de valores numéricos.
### roll(): Cada chamada ao método roll() retorna um dos resultados cadastrados no construtor, em ordem. Após retornar um último, uma nova chamada fará o método voltar a retornar o primeiro valor.
### Altere o método da batalha para que o herói sorteie apenas os valores 5, 6 e 7 em seu dano.

# JV: Atividade 9 - Grupos

### Poderá haver dois grupos distintos de personagem (Party). Os grupos podem ter qualquer tamanho
### No início da rodada, os personagens rolam 1D20 para decidir sua iniciativa. A ordem é dada pela maior iniciativa.
### Em seu turno, o personagem pode atacar qualquer adversário
### Faremos a escolha de modo aleatório
### Se um personagem morrer, ele não atacará mais. Nem será atacado.
### O encontro termina quando todos os personagens de um grupo morrerem.
