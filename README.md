# reward
Retailer reward App

#Technologies used 
- Java 17
- Spring boot version 2.7.5
- Lombok
- H2 database (in-memory)

#REST base URl 
- http://localhost:8080/api

#Endpoint to obtain reward of customer from last 3 month
- path: /reward
- method: GET
- request payload: {
  "customerEmail":"omotayo@outlook.com"
  }
- response payload: [
  {
  "rewardPer1Dollar": 50,
  "rewardPer50Dollar": 50,
  "totalReward": 100,
  "quantity": 1,
  "totalPrice": 150.0,
  "item": "washing machine"
  },
  {
  "rewardPer1Dollar": 100,
  "rewardPer50Dollar": 50,
  "totalReward": 150,
  "quantity": 2,
  "totalPrice": 240.0,
  "item": "Plasma"
  }
  ]
- response status: 200

#Endpoint to create new Customer 
- path: /customer
- method: POST
- request body:{
  "name":"Kehinde",
  "email":"r@gmail.com",
  "shippingAddress":"Dalax TX"
  }
- response status: 201

#Endpoint to create new stock
- path: /stock
- method: POST
- request payload:{
  "item":"Cigar",
  "unitPrice":120.00,
  "shippingAddress":"Dalax TX"
  }
- response status: 201

#Endpoint to create new transaction
- path: /transaction
- method: POST
- request payload:{
  "CustomerIdentifier":10001,
  "stockIdentifier":10002,
  "quantity":4
  }
- response status: 201