import Vue from 'vue';
import Vuex from 'vuex'
import notificationStore from "./notificationStore";

Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
        notification: notificationStore,
    }
});

export default store;
