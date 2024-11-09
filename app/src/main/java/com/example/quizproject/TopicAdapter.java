// TopicAdapter.java
package com.example.quizproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private final List<String> topics;

    public TopicAdapter(List<String> topics) {
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_card, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        String topic = topics.get(position);
        holder.topicTitle.setText(topic);

        holder.itemView.setOnClickListener(v -> {
            // Uncomment this once QuizActivity is created
            // Intent intent = new Intent(v.getContext(), QuizActivity.class);
            // intent.putExtra("TOPIC", topic);
            // v.getContext().startActivity(intent);
            Toast.makeText(v.getContext(), topic + " quiz screen will be implemented later.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public static class TopicViewHolder extends RecyclerView.ViewHolder {
        TextView topicTitle;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.topicTitle);
        }
    }
}
