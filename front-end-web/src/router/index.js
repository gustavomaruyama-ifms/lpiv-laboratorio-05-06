import Vue from 'vue'
import VueRouter from 'vue-router'
import clienteRoutes from '../cliente/routes'
import appRoutes from '../app/routes'

Vue.use(VueRouter);

const routes = [];

Array.prototype.push.apply(routes, clienteRoutes);
Array.prototype.push.apply(routes, appRoutes);

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router
