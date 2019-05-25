describe('dao', ()=>{
    const assert = require('assert');
    const mongoose = require('mongoose');
    const mongoUnit = require('../../node_modules/mongo-unit/index')
    const testData = require('../data.json');
    const estucheRepository= require('../../repositories/estuche.repository');
    var db;
    
    before(() => mongoUnit.start()
                          .then(url => {db = mongoose.connect(url); return url;})
                          .then( async url =>{await mongoUnit.initDb(url, testData)})
          )
   
    after(async () => { await mongoUnit.stop();
                  console.log(await mongoose.connection.close())})
   
    it('should return 10 when I ask for Estuches stock', async () => {
      const result= await estucheRepository.stockDeEstuche("Ray-Ban", "Plastico", "Negro", "E001")
      assert.strictEqual(result.stock, 10);
    })
  })