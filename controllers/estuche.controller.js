let estucheRepository = require('../repositories/estuche.repository') 


exports.altaModeloEstuche = (req, res) => {
    estucheRepository.altaModeloEstuche(req.body.marca, req.body.material, req.body.color, req.body.codigo, req.body.stock)
                        .then(estucheRegistrado => {
                                            res.status(200).json({
                                                ok : true,
                                                message: 'El estuche fue agregado exitosamente!',
                                                data: estucheRegistrado
                                            });
                        }).catch(error =>{
                                        res.status(500).json({
                                            ok: false,
                                            message: 'Ocurrio un error agregando el estuche',
                                            error
                                        })
                        });
}

exports.stockDeEstuche = function (req, res){
    estucheRepository.stockDeEstuche(req.params.marca, req.params.material, req.params.color, req.params.codigo)
                        .then( stock =>{
                            res.status(200).json({
                                ok:true,
                                stock 
                            })
                        .catch( err => {
                            res.status(500).json({
                                ok:false,
                                err
                            })
                        });
                     });
}