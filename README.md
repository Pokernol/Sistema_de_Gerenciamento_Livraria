# Sistema de Gerenciamento de Livraria Java

## Descrição
Este projeto é um Sistema de Gerenciamento de Livraria desenvolvido em Java, voltado para facilitar o gerenciamento de clientes, pedidos e acervo de livros. O sistema foi projetado para oferecer aos clientes um acesso fácil ao catálogo de livros, possibilitando a realização de pedidos. Para os funcionários, o sistema oferece ferramentas de administração de usuários e controle do acervo, tornando o processo de gestão mais eficiente e organizado.

## Características Principais

### Funcionalidades para Clientes
- **Consulta de Livros**: Acesso ao catálogo completo de livros disponíveis na livraria, com detalhes como título, autor, gênero, preço e disponibilidade.
- **Pedidos**: Ferramenta para realização de pedidos, onde clientes podem escolher livros e acompanhar o status de seus pedidos, desde o processamento até a entrega.

### Funcionalidades para Funcionários
- **Administração de Usuários**: Controle completo dos clientes cadastrados e de seus pedidos. Funcionários podem criar, atualizar e remover registros de clientes, bem como visualizar e gerenciar pedidos em andamento.
- **Controle de Acervo**: Gestão do acervo de livros da livraria, com possibilidade de adicionar novos livros, remover livros do sistema e atualizar informações de itens já cadastrados (preço, quantidade, descrição etc.).

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
