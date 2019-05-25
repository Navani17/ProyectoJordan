const mongoose = require('mongoose')
const estucheRepository = require ('../../repositories/estuche.repository');
 
exports.dao = (url) => {
 
  mongoose.connection.openUri(url,
    (err,res) => {

            if ( err ) throw err;
            console.log('BBDD: \x1b[32m%s\x1b[0m', 'online');
    }
);
 
  return {
    EstucheRepository: estucheRepository
  }
}