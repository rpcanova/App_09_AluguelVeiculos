package com.example.app_09_aluguelveiculos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locacoesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewLocacoes = findViewById<ListView>(R.id.listViewLocacoes)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val txtCliente = findViewById<TextView>(R.id.txtCliente)
        val txtVeiculo = findViewById<TextView>(R.id.txtVeiculo)
        val txtValor = findViewById<TextView>(R.id.txtValor)

        listViewLocacoes.adapter = locacoesAdapter
        btnCadastrar.setOnClickListener {
            val cliente = txtCliente.text.toString()
            val veiculo = txtVeiculo.text.toString()
            val valor = txtValor.text.toString().toDouble()

            if (cliente.isNotEmpty()) {
                locacoesAdapter.add(cliente)
                txtCliente.text = ""
            } else{
                txtCliente.error= "Insira o nome do cliente"
            }

            if (veiculo.isNotEmpty()) {
                locacoesAdapter.add(veiculo)
                txtVeiculo.text = ""
            } else{
                txtVeiculo.error= "Insira o modelo do veículo"
            }

            if (valor != null) {
                locacoesAdapter.add(valor.toString())
                txtValor.text = ""
            } else{
                txtValor.error= "Insira o valor do veículo"
            }
        }

        listViewLocacoes.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id: Long ->
            val item = locacoesAdapter.getItem(position)
            locacoesAdapter.remove(item)
        }
    }
}