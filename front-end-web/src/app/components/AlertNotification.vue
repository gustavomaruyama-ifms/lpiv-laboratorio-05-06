<template>
    <div>
        <v-snackbar top
                    elevation="12"
                    v-model="showSnackbar"
                    :timeout="timeout"
                    :color="color">
            <v-container>
                <div v-for="(message,i) in messages" v-bind:key="i">
                        {{message.msg}}
                </div>
            </v-container>
            <v-btn
                    text
                    @click="showSnackbar = false">
                Fechar
            </v-btn>
        </v-snackbar>
    </div>
</template>

<script>
    export default {
        name: "AlertNotification",
        data() {
            return {
                timeout: 3000
            }
        },
        mounted(){

        },
        computed: {
            showSnackbar: {
                get: function () {
                    const notificationStatus = this.$store.getters.notificationStatus
                    if (notificationStatus == 'HIDE') {
                        return false;
                    }
                    return true;
                },
                set: function () {
                    this.$store.commit('HIDE');
                }
            },
            messages() {
                return this.$store.getters.notificationMessages
            },
            color(){
                const notificationStatus = this.$store.getters.notificationStatus
                if (notificationStatus == 'ERROR') {
                    return "error";
                }
                if (notificationStatus == 'SUCCESS') {
                    return "success";
                }
                return "primary";
            }
        }
    }
</script>

<style scoped>

</style>