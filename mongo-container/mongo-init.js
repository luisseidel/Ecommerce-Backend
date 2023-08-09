db.createUser(
    {
        user: "root",
        pwd: "example",
        roles: [
            {
                role: "readWrite",
                db: "test_ecommerce"
            }
        ]
    }
);

// Criar Tabelas
db.createCollection("users", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            title: "Validation of User Object",
            required: ["email", "name", "password"],
            properties: {
                email: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                name: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                password: {
                    bsonType: "string",
                    description: "must be a string and is required"
                }
            }
        }
    }
});
db.createCollection("products", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            title: "Validation of Product Object",
            required: ["name", "price"],
            properties: {
                name: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                price: {
                    bsonType: "double",
                    description: "must be a string and is required"
                },
            }
        }
    }
});


// Insert Usuários
db.users.insertOne({
    "email": "admin@test.com",
    "name": "Admin admin",
    "password": "$2a$10$EFlWlG4nJfqov6P6NZKfzuTJQw/smkczVqLC0ovaBK3L.L9hnboLm",
    "role": "ADMIN"
});

// Insert Produtos
db.products.insertOne({
    "name": "Produto Teste",
    "price": Double(123.55)
});

db.products.insertOne({
    "name": "Produto Teste 2",
    "price": Double(0.55)
});

db.products.insertOne({
    "name": "Produto Teste",
    "price": Double(123123.99)
});