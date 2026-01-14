package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTabela extends AbstractTableModel {

    private static final String[] colunas = {"ID", "CPF/CNPJ", "Nome", "E-mail", "Telefone", "Endereço"};
    private ArrayList<Cliente> clientes;

    
    public ModeloTabela(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getCpfCnpj();
            case 2: return c.getNome();
            case 3: return c.getEmail();
            case 4: return c.getTelefone();
            case 5: return c.getEndereco();
            default: return null;
        }
    }

    
    public void adicionarCliente(Cliente c) {
        clientes.add(c);
        fireTableRowsInserted(clientes.size()-1, clientes.size()-1);
    }
}
