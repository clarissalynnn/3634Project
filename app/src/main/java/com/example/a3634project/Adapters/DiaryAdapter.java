package com.example.a3634project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634project.DiaryEntry;
import com.example.a3634project.R;

import java.util.ArrayList;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder> {

    List<DiaryEntry> diaryEntryList = new ArrayList<>();
    private Context context;

    public DiaryAdapter(Context context, List<DiaryEntry> noteList) {
        this.context = context;
        this.diaryEntryList = noteList;
    }

    @Override
    public DiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.diary_row, parent, false);
        DiaryViewHolder diaryViewHolder = new DiaryViewHolder(v);
        return diaryViewHolder;
    }

    @Override
    public void onBindViewHolder(DiaryViewHolder holder, int position) {
        holder.tvDiaryTitle.setText(diaryEntryList.get(position).getDiaryEntryTitle());
        holder.tvDiaryText.setText(diaryEntryList.get(position).getDiaryText());
    }

    @Override
    public int getItemCount() {
        return diaryEntryList.size();
    }

    public class DiaryViewHolder extends RecyclerView.ViewHolder {

        TextView tvDiaryTitle, tvDiaryText;

        public DiaryViewHolder(View itemView) {
            super(itemView);

            tvDiaryTitle = itemView.findViewById(R.id.tvDiaryTitle);
            tvDiaryText = itemView.findViewById(R.id.tvDiaryText);

        }
    }

}
