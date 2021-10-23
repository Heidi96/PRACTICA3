const net = require('net');
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

const data={
    port: 4040,
    host: '127.0.0.1'
}
const cliente = net.createConnection(data);

cliente.on('connect',()=>{
    console.log("cliente conectado al servidor");
    rl.question('ESCRIBA SU NOMBRE ', (answer) => {
         cliente.write(answer);
    });
   
})
cliente.on('data',(data)=>{
    console.log("msj :"+ data);
    cliente.end();
})
cliente.on('err',(err)=>{
    console.log(err.message);
})