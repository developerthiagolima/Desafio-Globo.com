## Considerações gerais

A escolha da linguagem é deixada para você, utilize **a que você se sente mais confortável**. A entrada deverá ser por `STDIN` (*standard input*) e a saída por `STDOUT` (*standard output*) na linguagem que você escolher. 

Forneça as instruções de instalação e execução do seu sistema, observaremos **principalmente seu *design* de código**. Aspectos como coesão, baixo acoplamento e legibilidade são os principais pontos.

Escolha abaixo um desafio a ser feito.

## 1 - Conversão de medidas

Você terá que criar um sistema que **formate a saída** de uma **dada entrada** para as três unidades de dados: **tempo, bytes e porcentagem**.

### Regras para formatação

#### Tempo

A entrada provida deve ser no formato `<numero> <ms>`, ex: `1340 ms`. A unidade usada para entrada será milisegundo.
* Quando a entrada for menor que 1 segundo a saída deve continuar em milisegundos `ms`.
* Quando a entrada for menor que 60 segundos a saída deve ser em segundos `s`.
* Quando a entrada for menor que 60 minutos a saída deve ser em minutos `min`.
* Quando a entrada for maior ou igual a 60 minutos a saída deve ser em horas `h`.

#### *Bytes*

A entrada provida deve ser no formato `<numero> <bytes>`, ex: `16 B`. A unidade usada para entrada será bytes (8 bits).
* Quando a entrada for menor que 1000 bytes a saída deve continuar em `B`.
* Quando a entrada for menor que 1000 elevado a 2 a saída deve ser em kilobyte `kB`.
* Quando a entrada for maior ou igual a 1000 elevado a 2 a saída deve ser em megabyte `MB`.

#### Porcentagem

A entrada provida deve ser no formato `<numero flutuante>`, ex: `0.16`. A unidade usada para entrada será um número flutuante onde, por exemplo, `0.1` significa `10%` e `0.98` significa `98%`.

### Exemplos de entradas e saídas esperadas pelo seu programa

| Entrada | Saída |
| ------ | ------ |
| 30 ms | `30 ms` |
| 5000 ms | `5 s` |
| 5400000 ms | `1.5 h` |
| 0.14 | `14%` |
| 50 B | `50 B` |
| 2000 B | `2 kB` |

## 2 - Grade de programação

O sinal da TV Globo é geolocalizado, dependendo de onde você está um programa
diferente está passando. Um exemplo disso são os jornais locais: RJTV, SPTV,
DFTV etc.

Quando não existe um programa regional é utilizado o sinal nacional, logo,
alguns programas passam em todo o território.

Para este desafio você deverá escrever um programa que recebe os dados da grade
de programação e responde a algumas perguntas. O formato de entrada/saída e os
tipos de pergunta são definidos abaixo.

### Input

- Cada registro é dado em uma única linha
- Só existem dois tipos de registro: Cadastro de grade e consulta de grade.
- Cadastro de grade: `S <região> <nome do programa> <início> <fim>`
- Consulta de grade: `Q <região> <hora>`
- Regiões são as abreviações de cada estado (SP, RJ) e BR para todo o brasil

### Output

- Cada resposta é dada em uma única linha
- A resposta deverá ser no seguinte formato `A <Q_região> <hora> <S_região> <nome do programa>`
- Quando não houver programaçao disponível `A <Q_região> <hora> noise`

### Exemplos

| Input | Output |
| :---- | :----- |
| `S "GO" "Hora Um" 05:00 06:00`<br/>`S "BR" "Globo Rural" 05:00 06:00`<br/>`Q "GO" 05:30`<br/>`Q "SP" 05:28` | `A "GO" 05:30 "GO" "Hora Um"`<br>`A "SP" 05:28 "BR" "Globo Rural"` |
| `S "DF" "Bom dia DF" 06:01 07:29`<br/>`S "RJ" "Bom dia RJ" 06:01 07:29`<br/>`S "SP" "Bom dia SP" 06:01 07:29`<br/>`Q "RJ" 07:00`<br/>`Q "GO" 06:50` | `A "RJ" 07:00 "RJ" "Bom dia RJ"`<br/>`A "GO" 06:50 noise`|
