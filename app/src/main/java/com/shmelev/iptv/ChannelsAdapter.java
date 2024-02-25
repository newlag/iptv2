package com.shmelev.iptv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChannelsAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<Channel> channels;
    AdapterInterface adapterInterface;

    public ChannelsAdapter(ArrayList<Channel> channels, AdapterInterface adapterInterface) {
        this.channels = channels;
        this.adapterInterface = adapterInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.channel_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setChannel(channels.get(position), adapterInterface);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    ImageView logotype;
    TextView name;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        logotype = itemView.findViewById(R.id.logotype);
        name = itemView.findViewById(R.id.channel_name);
    }

    void setChannel(Channel channel, AdapterInterface adapterInterface) {
        Glide.with(logotype)
                .load(channel.image)
                .into(logotype);

        name.setText(channel.name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterInterface.onClick(channel);
            }
        });
    }
}

interface AdapterInterface {
    void onClick(Channel channel);
}
