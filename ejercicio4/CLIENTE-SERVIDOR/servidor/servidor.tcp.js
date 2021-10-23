const net = require('net');
var c=0
const servidor = net.createServer();//creamos el servidor
servidor.on('connection', (socket)=>{
    console.log("CLIENTE CONECTADO")
    c++
    socket.on('data',(data)=>{
        console.log("MSJ "+ data);
        var result= "Hola cliente: "+data+ "usted es cliente numero: "+c+"conectado";
        socket.write(result.toString());
    })
    socket.on('close',()=>{
        console.log('cliente desconectado');
    });
    socket.on('error',(err)=>{
        console.log(err.message);
    });
})
servidor.listen(4040,()=>{
    console.log('servidor escuchando',servidor.address().port);
})