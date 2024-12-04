# Atividade 02 - JPA - Mapeamento Básico (Corrida)

Aluno: Pedro Henrique Alexandre da Rocha

## Descrição

Nesta atividade você deve implementar a classe Corrida e enumeração StatusCorrida, de acordo com o diagrama de classes (ver anexo). O atributo "gridLargada" é um mapa cuja chave é a posição do piloto (1, 2, 3, 4...) no grid de largada, enquanto o valor é o nome do respectivo piloto a largar naquela posição. Depois disso, faça o devido mapeamento objeto-relacional utilizando JPA. Para fazer essa atividade, use o anexo "template-jpa.zip" como projeto base e implemente também as classes "Main*" já disponibilizadas, que devem explorar os cenários de CRUD utilizando a(s) entidade(s) implementada(s) (*atribua valores a todos os atributos, não apenas os obrigatórios*).


Regras de negócio a serem atendidas:
* Os atributos "nome", "dataRealizacao" e "status" devem ser de preenchimento obrigatório;
* Os atributos "nome" e "dataRealizacao" (os dois em conjunto) devem ter restrição de unicidade (nome da restrição: "**uc_corrida__nome_e_dataRealizacao**");
* O atributo "nome" e "dataRealizacao" (os dois em conjunto) devem ter um índice associado para melhorar as buscas a serem realizadas com base neste campo (nome do índice: "**ix_corrida__nome_e_dataRealizacao**");
* Na implementação do "equals" e "hashCode", como temos uma regra de unicidade nos atributos "nome" e "dataRealizacao", e os mesmos são de preenchimento obrigatório, considere apenas esses atributos na implementação destes métodos;
* Na implementação do "toString", exiba todos os atributos da classe;
* O atributo "id" deve corresponder a chave primária da tabela e deve ter seu valor atribuído automaticamente pelo SGBD (use a estratégia "IDENTITY");
* O nome da tabela para armazenar as informações do grid de largada deve ser "GRIDS_LARGADA";
* Na tabela "GRIDS_LARGADA", a coluna "POSICAO" deve ser utilizada para armazenar a posição do piloto no grid de largada;
* Na tabela "GRIDS_LARGADA", a coluna "NOME_PILOTO" deve ser utilizada para armazenar o nome do piloto que vai largar na respectiva posição do grid de largada.

**OBS1**: a atividade deve ser enviada pelo formulário google. Compacte o projeto (zip) e então faça upload no formulário. Antes de anexar, remova a pasta "target" para evitar bloqueio do upload no google forms, além de diminuir também o tamanho do zip;

**OBS2**: no arquivo de configuração "persistence.xml", lembre de atualizar as propriedades JDBC que referenciam o SGBD que você vai utilizar;

**OBS3**: no arquivo de configuração "persistence.xml", lembre de adicionar a referência a entidade que você criou (ver entrada "<class>...</class>" colocada em comentário como exemplo;

**OBS4**: implemente a interface "CorridaDAO", assim como a classe "CorridaDAOImpl", semelhante a como foi feito na demo "crud-jpa-orm-parte2" (https://github.com/ifpb-es/crud-jpa-orm-parte2);

**OBS5**: deve ser possível executar as classes "Main*" diversas vezes seguidas sem ocorrer problemas de quebra de restrições. Faça com que os valores atribuídos ao atributo "nome" sejam distintos em cada execução.