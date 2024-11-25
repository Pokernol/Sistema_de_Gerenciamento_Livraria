# Sistema de Gerenciamento de Livraria Java

## Descrição
Este projeto é um Sistema de Gerenciamento de Livraria desenvolvido em Java, voltado para facilitar o gerenciamento de clientes, pedidos e acervo de livros. O sistema foi projetado para oferecer aos clientes um acesso fácil ao catálogo de livros, possibilitando a realização de pedidos. Para os funcionários, o sistema oferece ferramentas de administração de usuários e controle do acervo, tornando o processo de gestão mais eficiente e organizado.

## Características Principais

### Funcionalidades para Clientes
- **Consulta de Livros**: Os clientes podem acessar o catálogo completo de livros disponíveis na livraria. Cada livro é detalhado com informações como título, autor, gênero, preço e disponibilidade, facilitando a escolha do que comprar.
- **Pedidos**: Os clientes têm a possibilidade de realizar pedidos de livros, escolhendo entre os itens disponíveis no catálogo. Após realizar um pedido, é possível acompanhar o status, desde o processamento até a entrega.

### Funcionalidades para Funcionários
- **Gestão de Funcionários**: O sistema permite o gerenciamento completo dos registros de funcionários. É possível adicionar novos funcionários, visualizar a lista de funcionários cadastrados, atualizar informações como cargo ou status, e excluir registros quando necessário.
- **Administração de Usuários**: Os funcionários podem gerenciar os dados de clientes cadastrados. Isso inclui adicionar novos clientes ao sistema, visualizar os detalhes de cada cliente e seus pedidos, atualizar informações como endereço ou telefone, e remover registros caso necessário. Além disso, os funcionários podem acompanhar e organizar os pedidos em andamento para garantir um atendimento eficiente.
- **Gerenciamento do Acervo de Livros**: A equipe da livraria tem controle total sobre o catálogo de livros. Eles podem adicionar novos títulos ao sistema, com informações detalhadas como título, autor, gênero, preço e quantidade em estoque. É possível consultar todos os livros disponíveis, atualizar os dados de um livro, como descrição ou preço, e remover livros que não estão mais disponíveis.


## Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Frameworks e Bibliotecas**: Lombok
- **IDE**: IntelliJ IDEA, Eclipse, VSCode

## Estrutura do Projeto

Este sistema segue o padrão MVC:

1. **Model (Modelo)**: Responsável pela estrutura e manipulação dos dados, incluindo as interações com o banco de dados e as regras de negócio.
2. **View (Visão)**: Interface de usuário que permite o acesso ao sistema e oferece uma experiência intuitiva para clientes e funcionários.
3. **Service (Serviço)**: Contém a lógica de negócios mais complexa e as operações de manipulação de dados, servindo como intermediário entre o Controller e o Model para manter uma separação de responsabilidades.
4. **Validator (Validador)**: Realiza a validação dos dados de entrada para garantir que as informações estejam no formato e estrutura corretos antes de serem processadas
5. **Repository (Repositório)**: Para simular a persistência dos dados, utilizamos classes Repository. Estas classes atuam como um banco de dados simulado, sem a necessidade de integrar um banco de dados real, facilitando os testes e a implementação inicial do sistema.

