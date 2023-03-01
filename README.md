# Escola
Este software foi criado com o viés de aplicar meus conhecimentos até então adquiridos em Java e MySql.

Pensei em um software simples de uso geral em um ambiente escola de ensino médio, gravando dados administrativos (alunos, classes, disciplinas e funcionários) e os desempenhos dos alunos (avaliações).

Seu acesso é feito por diretor, coordenador, professor e aluno, sendo que o software se molda a cada usuário restringindo seus acessos da seguinte maneira:
* Diretor: Acesso total com visualização e cadastro, mas com a restrição de apenas poder visualizar as avaliações.
* Coordenador: Acessa avaliações podendo visualizar apenas as disciplinas dentro de sua área de coordenação. Acessa disciplinas podendo interferir apenas no que for de sua área.
* Professor: Acessa apenas as avaliações da própria disciplina, com controle completo dos cadastros.
* Aluno: Acessa apenas as avaliações próprias, sem qualquer controle dos dados.

----------------------------------------------------------

Sugestão de logins para ver o funcionamento do programa (senha '123'):

Diretor: jose

Coordenador: ana

Professor: mar

Aluno: joao

-------------------------------------------------------------
Antes de iniciar o programa importe o arquivo src/Dump20230228.sql em seu MySql para criar a estrutura do banco de dados e adicionar dados.

-------------------------------------------------------------
Seguem algumas telas do software (Conteúdo completo na pasta imagens/prints):

<img src="src/imagens/prints/2 - Menu Principal.png">

<img src="src/imagens/prints/4 - Avaliações - Diretor.png">

<img src="src/imagens/prints/6 - Avaliações - Professor.png">

<img src="src/imagens/prints/9 - Disciplinas - Diretor.png">

<img src="src/imagens/prints/11 - Funcionários.png">

-------------------------------------------------------------
Esquema da estrutura do banco de dados:

<img src="src/imagens/prints/Estrutura do Banco de Dados.jpg">
