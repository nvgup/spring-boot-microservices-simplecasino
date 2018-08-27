$( document ).ready(function() {

    var playerId = 453452;

    // register player
    var data = {playerId: playerId};
    console.log("Register player. Request:");
    console.log(data);

    appendParagraph("Register player. Request:");
    appendParagraph(JSON.stringify(data));

    $.ajax({
        url : 'http://localhost:9999/api/ws/player',
        type : 'POST',
        data : JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    // deposit
    data = {balance: 100};
    console.log("Deposit. Request:");
    console.log(data);

    appendParagraph("Deposit. Request:");
    appendParagraph(JSON.stringify(data));

    $.ajax({
        type : "PUT",
        url : "http://localhost:9999/api/ws/player/" + playerId + "/balance",
        data : JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    var gameId = 2247747;

    // Add game
    data = {gameId: gameId};
    console.log("Add game. Request:");
    console.log(data);

    appendParagraph("Add game. Request:");
    appendParagraph(JSON.stringify(data));

    $.ajax({
        type : "POST",
        url : "http://localhost:9999/api/gs/game",
        data : JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    // place bet OK
    data = {playerId: playerId, amount: 70};
    console.log("Place bet. Request:");
    console.log(data);

    appendParagraph("Place bet. Request:");
    appendParagraph(JSON.stringify(data));

    $.ajax({
        type : "POST",
        url : "http://localhost:9999/api/gs/game/" + gameId + "/bet",
        data : JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    // place bet KO
    data = {playerId: playerId, amount: 50};
    console.log("Place bet. Request:");
    console.log(data);

    appendParagraph("Place bet. Request:");
    appendParagraph(JSON.stringify(data));

    $.ajax({
        type : "POST",
        url : "http://localhost:9999/api/gs/game/" + gameId + "/bet",
        data : JSON.stringify(data),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    // show bets
    console.log("Show bets");

    appendParagraph("Show bets:");

    $.ajax({
        type : "GET",
        url : "http://localhost:9999/api/gs/games/player/" + playerId + "/bets",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });

    // show balance
    console.log("Show balance");
    appendParagraph("Show balance:");

    $.ajax({
        type : "GET",
        url : "http://localhost:9999/api/ws/player/" + playerId + "/balance",
        contentType: "application/json;charset=UTF-8",
        async: false,
        success : function(result) {
            console.log("Response:");
            console.log(result);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result));
        },
        error : function(result) {
            console.log("Response:");
            console.log(result.responseJSON);

            appendParagraph("Response:");
            appendParagraph(JSON.stringify(result.responseJSON));
        }
    });
});

function appendParagraph(text) {
    var p = $("<p/>").text(text);
    $("body").append(p);
}