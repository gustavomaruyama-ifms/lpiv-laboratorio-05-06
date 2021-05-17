<template>
    <div>
        <v-card :loading="loading">
                <v-card-title>
                    Cliente
                </v-card-title>

                <v-card-subtitle>
                  {{ title }}
                </v-card-subtitle>
                <v-divider></v-divider>
                <v-card-text>
                    <v-form ref="form">
                        <v-text-field
                                label="Nome"
                                type="text"
                                outlined
                                dense
                                v-model="cliente.nome">
                        </v-text-field>
                        <v-text-field
                                label="E-mail"
                                type="text"
                                outlined
                                dense
                                v-model="cliente.email">
                        </v-text-field>

                    </v-form>
                    <v-btn class="ma-2"
                           color="success"
                           dark
                           v-if="!cliente.id"
                           v-on:click="save">
                        Salvar
                    </v-btn>
                    <v-btn class="ma-2"
                         color="success"
                         dark
                         v-if="cliente.id"
                         v-on:click="update">
                        Atualizar
                    </v-btn>
                    <v-btn class="ma-2"
                           color="red"
                           dark
                           v-on:click="cancel">
                        Cancelar
                    </v-btn>
                </v-card-text>
        </v-card>
    </div>
</template>

<script>
    import clienteService from '../services/clienteService'

    export default {
        name: "ClienteForm",
        props: ['cliente'],
        data() {
            return {
                loading: false,
                title: this.cliente.id? "Editar Cliente" : "Novo Cliente"
            }
        },
        methods: {
            save() {
                this.loading = true;
                clienteService.createCliente(this.cliente)
                    .then(response => {
                        response
                        this.$router.push("/clientes");
                        this.loading = false;
                        this.$store.commit('SUCCESS', [{msg: "Cliente inserido com sucesso!"}]);
                    })
                    .catch(response => {
                        const errors = response.data.errors;
                        this.loading = false;
                        this.$store.commit('ERROR', errors);
                    })
            },
            update(){

              this.loading = true;
              console.log("UPDATING")
              clienteService.updateCliente(this.cliente)
                  .then(response => {
                    response
                    this.$router.push("/clientes");
                    this.loading = false;
                    this.$store.commit('SUCCESS', [{msg: "Cliente atualizado com sucesso!"}]);
                  })
                  .catch(response => {
                    const errors = response.data.errors;
                    this.loading = false;
                    this.$store.commit('ERROR', errors);
                  })
            },
            cancel() {
                this.$router.push("/clientes");
            }
        }
    }
</script>

<style scoped>

</style>
