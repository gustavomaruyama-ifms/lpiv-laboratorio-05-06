const HIDE = 'HIDE';
const ERROR = 'ERROR';
const SUCCESS = 'SUCCESS';

export default {
    state: {
        notificationMessages:'',
        notificationStatus :HIDE
    },
    getters: {
        notificationMessages: (state) => {
            return state.notificationMessages
        },
        notificationStatus: (state) => {
            return state.notificationStatus
        }
    },
    mutations: {
        [HIDE](state) {
            state.notificationMessages = []
            state.notificationStatus = HIDE
        },
        [ERROR](state, messages) {
            state.notificationMessages = messages
            state.notificationStatus = ERROR
        },
        [SUCCESS](state, messages) {
            state.notificationMessages = messages
            state.notificationStatus = SUCCESS
        }
    },
    actions: {

    }
}
