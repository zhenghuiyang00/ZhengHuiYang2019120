package combwei.zhenghuiyang20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import combwei.zhenghuiyang20191203.R;
import combwei.zhenghuiyang20191203.entity.EntityBean;

public class ShopingAdapter extends BaseAdapter {

    List<EntityBean> list;
    public ShopingAdapter(List<EntityBean> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView!=null){
            convertView=View.inflate(parent.getContext(), R.layout.item,null);
            holder = new ViewHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.tv=convertView.findViewById(R.id.tv);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        EntityBean entityBean = list.get(position);

        return convertView;
    }

    public class ViewHolder{
        ImageView iv;
        TextView tv;
    }

}
