package com.example.sysadmin.alilayoutdemo1.Fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sysadmin.alilayoutdemo1.Adapter.FlashSaleAdapter;
import com.example.sysadmin.alilayoutdemo1.Model.Product;
import com.example.sysadmin.alilayoutdemo1.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sysadmin on 4/5/17.
 */

public class FragmentFlashSale extends BaseFragment {
    @BindView(R.id.tvevent)
    TextView txtEvent;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.txtTimerDay)
    TextView txtTimerDay;
    @BindView(R.id.txtTimerHour)
    TextView txtTimerHour;
    @BindView(R.id.txtTimerMinute)
    TextView txtTimerMinute;
    @BindView(R.id.txtTimerSecond)
    TextView txtTimerSecond;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.imgFirstFlashSale)
    ImageView imgFirstFlashSale;
    @BindView(R.id.txtPriceGroupFristFlashShare)
    TextView txtPriceGroupFristFlashShare;
    @BindView(R.id.txtPriceDiscountFristFlashShare)
    TextView txtPriceDiscountFristFlashShare;
    @BindView(R.id.txtPriceFristFlashShare)
    TextView txtPriceFristFlashShare;
    @BindView(R.id.recylcerFlashSale)
    RecyclerView recylcerFlashSale;
    @BindView(R.id.imgSecond)
    ImageView imgSecond;
    @BindView(R.id.txtSecondPriceDicount)
    TextView txtSecondPriceDicount;
    @BindView(R.id.txtSecondPrice)
    TextView txtSecondPrice;
    @BindView(R.id.imgThird)
    ImageView imgThird;
    @BindView(R.id.txtThirdPriceDicount)
    TextView txtThirdPriceDicount;
    @BindView(R.id.txtThirdPrice)
    TextView txtThirdPrice;

    private ArrayList<Product> products;
    private Product firstItem;
    private View v;
    private RecyclerView.Adapter adapter;
    private Handler handler;
    private Runnable runnable;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_flash_sale, container, false);
        unbinder = ButterKnife.bind(this, v);
        addCreateView();
        return v;
    }

    @Override
    protected void initData() {
        products = new ArrayList<>();
        firstItem = new Product(1, "Cafe 01", "", R.drawable.cafe, 23.56, 20.00, 22.5);
        Product p1 = new Product(1, "Cafe 02", "", R.drawable.cafe, 25.06, 22.00, 23.47);
        Product p2 = new Product(1, "Cafe 03", "", R.drawable.cafe, 26.56, 23.10, 24.25);
        products.add(p1);
        products.add(p2);

        //set First , Second , Third item
        imgFirstFlashSale.setImageDrawable(getResources().getDrawable(firstItem.getResImg()));
        txtPriceGroupFristFlashShare.setText(firstItem.getPriceGroup() + "");
        txtPriceDiscountFristFlashShare.setText(firstItem.getDiscountPrice() + "");
        txtPriceFristFlashShare.setText(firstItem.getPrice() + "");
        txtPriceFristFlashShare.setPaintFlags(txtPriceFristFlashShare.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        imgSecond.setImageDrawable(getResources().getDrawable(p1.getResImg()));
        txtSecondPriceDicount.setText(p1.getDiscountPrice() + "");
        txtSecondPrice.setText(p1.getPrice() + "");
        txtSecondPrice.setPaintFlags(txtPriceFristFlashShare.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        imgThird.setImageDrawable(getResources().getDrawable(p2.getResImg()));
        txtThirdPriceDicount.setText(p2.getDiscountPrice() + "");
        txtThirdPrice.setText(p2.getPrice() + "");
        txtThirdPrice.setPaintFlags(txtPriceFristFlashShare.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        //set recyclerview (visable = gone)
        adapter = new FlashSaleAdapter(getContext(), products);
        recylcerFlashSale.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation());
        recylcerFlashSale.setLayoutManager(linearLayoutManager);
//        recylcerFlashSale.addItemDecoration(dividerItemDecoration);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
//        recylcerFlashSale.setLayoutManager(mLayoutManager);
    }


    @Override
    protected void setData() {
        countDownStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
void  abc (){
    int i=0;
    i=i+2;
}
    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd HH:mm");
                    // Here Set your Event Date
                    Date eventDate = dateFormat.parse("2017-5-5 23:00");
                    Date currentDate = new Date();
                    if (!currentDate.after(eventDate)) {
                        long diff = eventDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText("" + String.format("%02d", minutes));
                        txtTimerSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        ll1.setVisibility(View.VISIBLE);
                        ll2.setVisibility(View.GONE);
                        txtEvent.setText("Event Start");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    // //////////////COUNT DOWN END/////////////////////////
}
