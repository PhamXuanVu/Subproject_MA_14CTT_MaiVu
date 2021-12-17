package com.example.detai;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SanPhamAdapter4 extends RecyclerView.Adapter<SanPhamAdapter4.SamPhamViewHolder> {
    private ArrayList<SanPham> list = new ArrayList<>();
    private Context context;
    @NonNull
    @Override
    public SamPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_s4,parent,false);
        SamPhamViewHolder samPhamViewHolder = new SamPhamViewHolder(view);
        return samPhamViewHolder;
    }

    public SanPhamAdapter4(ArrayList<SanPham> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter4.SamPhamViewHolder holder, int position) {
        SanPham sanPham =list.get(position);
        holder.imageView.setImageResource(sanPham.getAnh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SamPhamViewHolder extends RecyclerView.ViewHolder {
        private TextView name , gia;
        private ImageView imageView;
        public SamPhamViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mPosition = getLayoutPosition();
                    SanPham sanPham = list.get(mPosition);
                    Intent intent = new Intent(context,Screen3.class);
                    intent.putExtra("img",sanPham.getAnh());
                    context.startActivity(intent);
                }
            });
        }
    }
}
