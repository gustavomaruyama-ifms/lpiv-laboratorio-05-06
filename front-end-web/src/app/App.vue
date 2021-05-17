<template>
    <div id="app">
        <v-app>
            <navbar></navbar>
            <sidebar></sidebar>

            <v-content>
                <v-container fluid>
                    <alert-notification></alert-notification>
                    <router-view>
                    </router-view>
                </v-container>
            </v-content>

        </v-app>
    </div>
</template>

<script>
    import Navbar from "./components/Navbar";
    import Sidebar from "./components/Sidebar";
    import AlertNotification from "./components/AlertNotification";

    export default {
        name: 'App',
        components: {AlertNotification, Navbar, Sidebar},
        data() {
            return {

            }
        }
    };
</script>
