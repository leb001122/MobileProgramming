package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final ArrayList<String> wordList;
    private LayoutInflater inflater;

    public WordListAdapter(Context context, ArrayList<String> wordList) {
        inflater = LayoutInflater.from(context);
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String current = wordList.get(position);
        holder.wordItemView.setText(current);


    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView wordItemView;
        final WordListAdapter adapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            String element = wordList.get(position);
            wordList.set(position, "Clicked " + element);
            adapter.notifyDataSetChanged(); // 아이템의 내용이 바뀌면 반드시 어댑터에게 알려야함.
        }
    }

}
