import http from '../../app/services/config'

const url = '/cliente';

export default {
    createCliente: (cliente) => {
        return http.post(url, cliente);
    },
    listClientes: () => {
        return http.get(url);
    },
    updateCliente: (cliente) => {
        return http.put(url, cliente);
    },
    deleteCliente: (id) =>{
        return http.delete(url+"/"+id);
    }
}
