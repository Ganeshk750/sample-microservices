# sample-microservices
Sample Microservices

## 1. product-service
``````````````````````
## GET ==>  http://localhost:7777/product/details/102
``````````````````````
``````````````````````
{
    "productId": 102,
    "productName": "LapTop",
    "productDescription": "It is useful for students",
    "productPrice": 2625000,
    "productStock": true
}
``````````````````````
## 2. pricing-service
``````````````````````
## GET ==>  http://localhost:7771/price/101
``````````````````````
``````````````````````
{
    "priceId": 201,
    "productId": 101,
    "originalPrice": 35000,
    "discountedPrice": 17000
}
``````````````````````
## 3. inventory-service
``````````````````````
## GET ==>  http://localhost:7772/inventory/103
``````````````````````
``````````````````````
{
    "inventoryId": 303,
    "productId": 103,
    "inStock": false
}
``````````````````````
## 4. exchange-service
``````````````````````
## GET ==>  http://localhost:7773/currexg/from/USD/to/YEN
``````````````````````
``````````````````````
{
    "id": 901,
    "from": "USD",
    "to": "YEN",
    "exchangeValue": 105
}
``````````````````````
