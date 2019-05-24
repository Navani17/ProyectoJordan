const Estuche = require('../model/estuche.model');

// Busquen la documentacion en la pagina de MongoDB.
// Ahi van a ver todos los metodos de busqueda y que parametros aceptan, y para que sirve cada uno.
// Solo les voy a decir una cosa que puede que pasen de largo: Todos los metodos de mongoose devuelven Promises.
// Lean sobre eso en documentacion de Node (videos en youtube tambien son validos) para saber como se usan y para que sirven.

exports.altaModeloEstuche =(marca, material, color, codigo, stock = 0)  => {
    return new Estuche({
        marca: marca,
        material: material,
        color: color,
        codigo: codigo,
        stock: stock
    }).save();                
};



exports.stockDeEstuche = (marca, material, color, codigo) => {
    return Estuche.findOne({marca: marca, 
                            material: material, 
                            color: color, 
                            codigo: codigo},
                            { stock: 1}); 
}