package com.geektech.myapplicationdopzanyatieintensfragmrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Person> list = new ArrayList<>();

    // получаем данные извне
    public void setList(ArrayList<Person> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    // указываем как выглядит ViewHolder (отображаемый элемент). Привязка элемента
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    // отправляем данные ViewHolder (элемент) по позиции
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(list.get(position));

    }

    @Override
    // мы указываем размер списка
    public int getItemCount() {
        return list.size();
    }

    // работа с данными
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name, tv_surname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_surname = itemView.findViewById(R.id.tv_surname);
        }
        // сеттим данные во вьюшки
        public void onBind(Person person) {

            tv_name.setText(person.getName());
            tv_surname.setText(person.getSurname());
        }
    }
}
