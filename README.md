# spring-boot-microservices-simplecasino

## How to run main application

1) `git clone https://github.com/nvgup/spring-boot-microservices-simplecasino.git && cd spring-boot-microservices-simplecasino`
2) `mvn clean install`
3) `docker-compose up --scale game-service=2`

to start an additional instance of some service use:

`docker-compose scale game-service=2` or `docker-compose scale wallet-service=2`

## How to run functional test case
1) run the main app
2) go to test folder, open `test.html`

## Short API description
### wallet-service

1) To register a new player, send `POST` request to http://localhost:9999/api/ws/player

body: 
```json
{
  "playerId": "1"
}
```
2) To update a player balance (add to the current), send `PUT` request to http://localhost:9999/api/ws/player/{id}/balance

where `{id}` - a player id

body: 
```json
{
  "balance": 1000
}
```
if `balance` is positive, deposite will be performed, if `balance` is negative - withdraw will be performed

3) To get a player balance, send `GET` request to http://localhost:9999/api/ws/player/{id}/balance

where `{id}` - a player id

### game-service

1) to add a new game, send `POST` request to http://localhost:9999/api/gs/game

body:
```json
{
  "gameId": 1
}
```

2) to make a bet, send `POST`request to http://localhost:9999/api/gs/game/{id}/bet

where `{id}` - a game id

body:
```json
{
  "playerId": 1,
  "amount": 100
}
```

3) to see all player's bets, send `GET` request to http://localhost:9999/api/gs/games/player/{id}/bets

where `{id}` - a player id
