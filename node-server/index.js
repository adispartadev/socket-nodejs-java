
var port = process.env.PORT || 5000


var net = require('net');
var server = net.createServer(function(c) { //'connection' listener

  console.log('client connected');
  

  c.write('hello \r\n')

  
  c.on('end', function() {
    console.log('client disconnected');
  });
  
  

  
  c.on('data', function (data) {
      c.write( data + '\r\n');
      c.pipe(c);
  });
  
  
});
server.listen(port, function() { //'listening' listener
  console.log('server bound');

});

