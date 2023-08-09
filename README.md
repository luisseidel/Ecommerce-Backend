# Cadastro de cidadãos
* Sistema backend desenvolvido para disciplina de Projeto Full Stack do curso de Pós Graduação em Desenvolvimento Full Stack da Unyleya.
* É uma API Restful, com os métodos GET, POST, PUT e DELETE.
* Permite o cadastro de produtos em um Ecommerce.


## Tecnologias utilizadas
* Java 17
* Spring Web
* Spring Data
* Spring Security
* JWT
* MongoDB
* Swagger UI

___
## Instalações
1. Instalar o docker-engine e docker-compose pelo snapd
* Documentação: https://snapcraft.io/docker
```shell
sudo snap install docker
```

2. Configurar para rodar o docker como user "normal", sem sudo:
```shell
sudo addgroup --system docker
sudo adduser $USER docker
newgrp docker
sudo snap disable docker
sudo snap enable docker
```

3. Instalar o SDKMAN
* Documentação em: https://sdkman.io/install
```shell
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

4. Após, navegar ao diretório do projeto e instalar o java pelo SDKMAN. Ou, instalar o java v17.
* A versão do java está no arquivo de configuração .sdkmanrc na raiz do projeto
```shell
sdk env install
```

5. Instalar o Maven Wrapper para o projeto:
```shell
mvn wrapper:wrapper
```
___


## Como funciona o Banco de dados:
1. O Banco de dados é inicializado automaticamente via Docker Compose
2. As tabelas são criadas automaticamente
3. São criados dois usuários, um admin e outro comum
4. Você poderá registrar um novo usuário, caso queira, ou utilizar os já cadastrados
5. Usuários previamente cadastrados:
```json
{
  "email": "admin@test.com",
  "name": "Admin admin",
  "password": "$2a$10$EFlWlG4nJfqov6P6NZKfzuTJQw/smkczVqLC0ovaBK3L.L9hnboLm", //teste
  "role": "ADMIN"
}
```
6. Também já foram previamente cadastrados alguns produtos.
7. Utilizar o email e senha para fazer as operações do CRUD.
8. Além do banco, foi adicionado o Mongo Express, que é uma interface visual, para acessar o mongo. Ela está disponível em:
```text
http://localhost:8081/
```
___

## Endpoints:

* URL BASE: http://localhost:8080

### Autenticação / Criação Users:
* **/api/v1/auth/register** - Cadastrar novos usuários
* **/api/v1/auth/authenticate** - Autenticar usuários

1. Para realizar as operações CRUD, inicialmente você deverá se autenticar, usando o email e senha.
2. Após, com o Token fornecido, realizar as operações nos endpoints.

### Produtos:
* **/api/v1/products/** - GET | POST
* **/api/v1/products/{id}** - PUT | DELETE
___

## Swagger Docs:
http://localhost:8080/swagger-ui/index.html
___

## Rodando o projeto (Linux): 
1. Abrir 2 janelas de terminais na pasta raiz do projeto.

2. Em uma delas, rodar o container do banco de dados MongoDB. 
* Ao rodar o container, o banco test_ecommerce também será criado, assim como as tabelas.
```shell
cd ./mongo-container
docker-compose up
```

3. Rodar o projeto com o comando:
```shell
./mvnw spring-boot:run
```

4. Importar no Postman a collection SpringEcommerceBackend_collection.json