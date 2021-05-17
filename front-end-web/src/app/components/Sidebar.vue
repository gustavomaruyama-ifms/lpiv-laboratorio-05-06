<template>
    <v-navigation-drawer
            app
            clipped
            permanent>
        <v-list dense>
            <v-list-item-group>
                <v-list-item v-for="(item,i) in items" v-bind:key="i" :to="item.to">
                    <v-list-item-icon>
                        <v-icon>{{item.icon}}</v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title v-text="item.text">}</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    import {mdiAccountTie, mdiSettings, mdiHome} from '@mdi/js'

    export default {
        name: "Sidebar",
        data() {
            return {
                items: [
                    {icon: mdiHome, text: 'Home', to: '/'},
                    {icon: mdiAccountTie, text: 'Clientes', to: '/clientes'},
                    {icon: mdiSettings, text: 'Configurações', to: '/configurations'}
                ]
            }
        }
    }
</script>

<style scoped>

</style>
