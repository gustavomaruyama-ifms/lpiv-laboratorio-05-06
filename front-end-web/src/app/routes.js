import Home from '../app/views/Home'

export default [
    {
        path: '/',
        name: 'home',
        component: Home,
        meta: {
            authenticationRequired: true
        }
    },
    {
        path: '/about',
        name: 'about',
        component: () => import('../app/views/About'),
        meta: {
            authenticationRequired: true
        }
    }
]
