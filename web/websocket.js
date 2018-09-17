
function openConection() {
    var wsUri = "ws://" + document.location.host + document.location.pathname + "pong";
    var websocket = new WebSocket(wsUri);
    websocket.binaryType = "arraybuffer";
    websocket.onopen = onOpen;
    websocket.onmessage=onMessage;
}
function onOpen() {
console.log("conexao iniciada!");

}

function onMessage(evt) {
    console.log("received: " + evt.data);
}