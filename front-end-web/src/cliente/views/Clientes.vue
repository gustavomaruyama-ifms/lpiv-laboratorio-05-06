<template>
    <div>
        <v-card>
            <v-card-title>
                Clientes

                <v-spacer></v-spacer>

                <v-btn class="ma-2"
                       color="indigo"
                       v-on:click="createNewCliente"
                       dark>
                    Novo Cliente
                </v-btn>
            </v-card-title>

            <v-divider></v-divider>

            <v-card-title>
                <v-text-field
                        append-icon="mdi-magnify"
                        label="Buscar"
                        single-line
                        hide-details></v-text-field>
            </v-card-title>

            <v-card-text>
                <v-data-table
                        v-model="selectedClientes"
                        :loading="loading"
                        :headers="headers"
                        :items="clientes"
                        :options.sync="options"
                        item-key="id"
                        show-select>
                  <template v-slot:item.actions="{ item }">
                    <v-icon
                        small
                        class="mr-2"
                        @click="editCliente(item)"
                    >

                      {{editIcon}}
                    </v-icon>
                    <v-icon
                        small
                        @click="openDialogDelete(item)">
                      {{removeIcon}}
                    </v-icon>
                  </template>
                </v-data-table>
            </v-card-text>

          <v-dialog v-model="dialogDelete" max-width="500px">
            <v-card :loading="loadingDelete">
              <v-card-title class="headline">Tem certeza que deseja remover {{itemToRemove.nome}}?</v-card-title>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="closeDialogDelete">Não</v-btn>
                <v-btn color="blue darken-1" text @click="confirmDelete">Sim</v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-card>
    </div>
</template>

<script>
    import clienteService from '../services/clienteService'
    import Cliente from "../models/Cliente";
    import {mdiDelete, mdiPencil} from '@mdi/js'

    export default {
        name: "Clientes",

        data() {
            return {
                loading: false,
                options: {
                    itemsPerPage: 5
                },
                clientes: [],
                selectedClientes: [],
                headers: [
                    {
                        text: 'Id:',
                        align: 'left',
                        sortable: true,
                        value: 'id',
                    },
                    {
                        text: 'Nome:',
                        align: 'left',
                        sortable: true,
                        value: 'nome',
                    },
                    {
                        text: 'E-mail',
                        value: 'email',
                        sortable: true
                    },
                    {   text: 'Ações',
                        value: 'actions',
                        sortable: false
                    },
                ],
              dialogDelete: false,
              loadingDelete: false,
              itemToRemove: {},
              editIcon: mdiPencil,
              removeIcon: mdiDelete
            }
        },
        mounted() {
            this.listClientes();
        },
        watch: {
            options: {
                handler() {
                    this.listClientes();
                },
                deep: true,
            },
        },
        methods: {
            listClientes() {
                this.loading = true;
                clienteService.listClientes()
                    .then(response => {
                        this.loading = false;
                        this.clientes = response.data;
                        this.closeDialogDelete();
                    })
                    .catch(response => {
                        response
                        this.loading = false;
                    })
            },
            createNewCliente() {
                const params = {
                    cliente: new Cliente()
                };
                this.$router.push({name: 'cliente-form', params: params})
            },
            editCliente(cliente) {
                const params = {
                  cliente: cliente
                };
                this.$router.push({name: 'cliente-form', params: params})
            },
            openDialogDelete(cliente){
              this.dialogDelete = true;
              this.itemToRemove = cliente;
            },
            closeDialogDelete(){
              this.dialogDelete = false;
              this.loadingDelete = false;
              this.itemToRemove = {};
            },
            confirmDelete(){
              this.loadingDelete = true;
              clienteService.deleteCliente(this.itemToRemove.id)
                  .then(response => {
                    response
                    this.listClientes();
                  })
                  .catch(response => {
                    response
                    this.dialogDelete = false;
                    this.loading = false;
                  })
            }
        }
    }
</script>

<style scoped>

</style>
