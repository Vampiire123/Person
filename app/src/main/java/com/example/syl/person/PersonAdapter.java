package com.example.syl.person;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.syl.person.model.Client;
import com.example.syl.person.model.Employee;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_CLIENT = 1, TYPE_EMPLOYEE = 2;

    private List<Object> personArray;

    public PersonAdapter(List<Object> personArray) {
        this.personArray = personArray;
    }

    @Override
    public int getItemViewType(int position) {
        if (personArray.get(position) instanceof Client) {
            return TYPE_CLIENT;
        } else if (personArray.get(position) instanceof Employee) {
            return TYPE_EMPLOYEE;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case TYPE_CLIENT:
                Client client = (Client) personArray.get(position);
                ((ClientViewHolder) holder).showClientDetails(client);
                break;
            case TYPE_EMPLOYEE:
                Employee employee = (Employee) personArray.get(position);
                ((EmployeeViewHolder) holder).showEmployeeDetails(employee);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return personArray.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layout;
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case TYPE_CLIENT:
                layout = R.layout.row_client;
                View callsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new ClientViewHolder(callsView);
                break;
            case TYPE_EMPLOYEE:
                layout = R.layout.row_employee;
                View smsView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new EmployeeViewHolder(smsView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name, tv_age, tv_product, tv_vip;

        public ClientViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_product = itemView.findViewById(R.id.tv_product);
            tv_vip = itemView.findViewById(R.id.tv_vip);
        }

        public void showClientDetails(Client client) {
            tv_name.setText(client.getName());
            tv_age.setText(String.valueOf(client.getAge()));
            tv_product.setText(client.getName_product());
            tv_vip.setText(String.valueOf(client.isVIP()));
        }
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name, tv_age, tv_job, tv_salary;

        public EmployeeViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_job = itemView.findViewById(R.id.tv_job);
            tv_salary = itemView.findViewById(R.id.tv_salary);
        }

        public void showEmployeeDetails(Employee employee) {
            tv_name.setText(employee.getName());
            tv_age.setText(String.valueOf(employee.getAge()));
            tv_job.setText(employee.getJob());
            tv_salary.setText(String.valueOf(employee.getSalary()));
        }
    }
}