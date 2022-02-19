Esse é uma api springboot onde é criado um CRUD básico de controle de usuários, onde é permitido cadastrar, consultar, alterar e excluir. Para testar a api é necessário usar um programa como o postman para fazer as requisições colocando o endereço seguintes para cada ação:
- localhost:8080/usuarios: retorna todos os usuários cadastrados
- localhost:8080/usuario/salvar: cadastra um novo usuário
- localhost:8080/usuario/excluir/{id}: remove um usuário de acordo com o seu id
- localhost:8080/usuario/{id}: retornar um usuário cadastrado de acordo com o id
- localhost:8080/usuario/editar/{id}: altera os dados do usuário de acordo com o id informado
- localhost:8080/usuario/listar/{parte do nome}: retorna todos os usuários com parte do nome informado
