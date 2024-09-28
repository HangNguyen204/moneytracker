package com.example.moneytracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.text.InputType;
import android.widget.Toast;

;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }
    private TextView tvBalance;
    private Button btnAdd, btnSubtract;
    private int balance = 0;
    private ImageView income_img, category_img;
    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvBalance = view.findViewById(R.id.tv_balance);
        btnAdd = view.findViewById(R.id.btn_add);
        btnSubtract = view.findViewById(R.id.btn_subtract);
        income_img = view.findViewById(R.id.Income_view);
        category_img = view.findViewById(R.id.danhmuc_imgview);
        // Hiển thị số dư ban đầu
        updateBalanceText();
        income_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireActivity(),IncomeCreate.class);
                startActivity(i);
            }
        });
        category_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireActivity(), CategoryActivity.class);
                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(v -> showAmountDialog(true));
        btnSubtract.setOnClickListener(v -> showAmountDialog(false));

        return view;
    }
    private void showAmountDialog(boolean isAdd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(isAdd ? "Nhập số tiền để thêm" : "Nhập số tiền để giảm");

        // Tạo EditText cho số tiền
        EditText input = new EditText(getContext());
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String amountStr = input.getText().toString();
            if (!amountStr.isEmpty()) {
                int amount = Integer.parseInt(amountStr);
                if (isAdd) {
                    balance += amount; // Tăng số dư
                } else {
                    balance -= amount; // Giảm số dư
                }
                updateBalanceText(); // Cập nhật số dư hiển thị
            }
        });
        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void updateBalanceText() {
        tvBalance.setText("Số dư: " + balance + " VNĐ");
    }

}
