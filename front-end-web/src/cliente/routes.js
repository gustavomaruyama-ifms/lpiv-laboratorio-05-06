export default [
    {
        path: '/clientes',
        name: 'clientes',
        component: () => import('./views/Clientes'),
        meta: {
            authenticationRequired: true
        }
    },
    {
        path: '/cliente-form',
        name: 'cliente-form',
        props: true,
        component: () => import('./views/ClienteForm'),
        meta: {
            authenticationRequired: true
        }
    }
]
