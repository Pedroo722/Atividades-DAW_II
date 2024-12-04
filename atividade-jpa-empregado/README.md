# Atividade 01 - JPA - Mapeamento Básico (Empregado)

Aluno: Pedro Henrique Alexandre da Rocha

## Descrição

Nesta atividade você deve implementar a classe **Empregado**, que deve ter os atributos e métodos ilustrados no diagrama de classes (ver anexo). Depois disso, faça o devido mapeamento objeto-relacional utilizando JPA. Para fazer essa atividade, use o anexo "template-jpa.zip" como projeto base e implemente também as classes "main" já disponibilizadas, que devem explorar os cenários de CRUD utilizando a(s) entidade(s) implementada(s).

Regras de negócio a serem atendidas:
* Os atributos "nome", "sobrenome", "cpf" e "dataNascimento" devem ser de preenchimento obrigatório;
* O atributo "cpf" deve ter restrição de unicidade (nome da restrição: "**uc_empregado__cpf**");
* O atributo "cpf" deve ter um índice associado para melhorar as buscas a serem realizadas com base neste campo (nome do índice: "**ix_empregado__cpf**");
* Na implementação do "equals" e "hashCode", como temos uma regra de unicidade no atributo "cpf" e o mesmo é de preenchimento obrigatório, considere apenas esse atributo na implementação destes métodos;
* Na implementação do "toString", exiba todos os atributos da classe;
* O atributo "id" deve corresponder a chave primária da tabela e deve ter seu valor atribuído automaticamente pelo SGBD (use a estratégia "**IDENTITY**");

**OBS1**: a atividade deve ser enviada pelo formulário google. Compacte o projeto (zip) e então faça upload no formulário. Antes de anexar, remova a pasta "target" para evitar bloqueio do upload no google forms, além de diminuir também o tamanho do zip;

**OBS2**: no arquivo de configuração "persistence.xml", lembre de atualizar as propriedades JDBC que referenciam o SGBD que você vai utilizar;

**OBS3**: no arquivo de configuração "persistence.xml", lembre de adicionar a referência a entidade que você criou (ver entrada "<class>...</class>" colocada em comentário como exemplo;

**OBS4**: implemente a interface "EmpregadoDAO", assim como a classe "EmpregadoDAOImpl", semelhante a como foi feito na demo "crud-jpa-orm-parte2" (https://github.com/ifpb-es/crud-jpa-orm-parte2);

**OBS5**: deve ser possível executar as classes "Main*" diversas vezes seguidas sem ocorrer problemas de quebra de restrições. Faça com que os valores atribuídos ao atributo CPF sejam distintos em cada execução. Como não temos validação desse campo no momento, o valor atribuído não precisa sequer ser um CPF válido;