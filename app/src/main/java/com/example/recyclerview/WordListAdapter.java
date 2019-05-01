package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(LinkedList<String> mWordList, Context context) {
        this.mWordList = mWordList;
        mInflater  =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, viewGroup,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
        String mCurrent = mWordList.get(i);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter mAdapter) {
            super(itemView);
            wordItemView =itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            //Use that to access the affected item in mWordlist
            String element = mWordList.get(mPosition);
            //Change the word in the mWordlist
            mWordList.set(mPosition,"Clicked! "+ element);
            //Notify the adapter, that the data has changed so it can
            //update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}