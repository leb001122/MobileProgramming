package com.example.recyclerview2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.MyViewHolder>{

    private List<Item> itemList;
    private Context context;

    public WordListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    // 뷰홀더를 생성(레이아웃 생성)
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater는 특정 xml 파일을 클래스로 변환하게 도와줌
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    // 뷰홀더가 재활용될 때 실행되는 메서드
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Item item = itemList.get(position);
        Drawable drawable = context.getDrawable(item.getImgId());
        holder.image.setImageDrawable(drawable);
        holder.nameKor.setText(item.getTitleKor());
        holder.nameEng.setText(item.getTitleEng());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /*
    ViewHolder는 현재 화면에 보이는 아이템 레이아웃 개수만큼 생성되고 새롭게 그려져야 할 아이템 레이아웃이 있다면(스크롤 동작)
    가장 위의 ViewHolder를 재사용해서 데이터만 바꾼다.
    */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameKor;
        private TextView nameEng;
        private ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameKor = itemView.findViewById(R.id.name_kor);
            nameEng = itemView.findViewById(R.id.name_eng);
            image = itemView.findViewById(R.id.image);
            nameKor.setOnClickListener(this);
            nameEng.setOnClickListener(this);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = null;
            int pos = getLayoutPosition();
            switch (view.getId()) {
                case R.id.name_eng:  //Implicit intent
                    // 방법1
//                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
//                    intent.putExtra(SearchManager.QUERY, itemList.get(pos).getTitleEng());
//                    // 방법2
                    try {
                        String eQuery = URLEncoder.encode(itemList.get(pos).getTitleEng());
                        Uri uri = Uri.parse("http://www.google.com/search?q=" + eQuery);
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    context.startActivity(intent);
                    break;
                case R.id.img_view:
                    intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("image", itemList.get(pos).getImgId());
                    intent.putExtra("myData", "if you need more");

                    context.startActivity(intent);
                    break;
            }


//            String msg = "";
//            if(view.getId() == R.id.name_kor)
//                msg = "name(kor) clicked";
//            if(view.getId() == R.id.name_eng)
//                msg = "name(eng) clicked ";
//            if(view.getId() == R.id.image)
//                msg = "image clicked";
//
//            int pos = getLayoutPosition();
//            msg += ("\nPosition = " + pos + "\nItem = " + itemList.get(pos).getTitleKor() + "(" +
//                    itemList.get(pos).getTitleEng() + ")");
//            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
