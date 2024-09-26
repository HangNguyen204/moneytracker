package com.example.moneytracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;

;
public class HomeFragment extends Fragment {

    private TextView tvBalance;
    private Button btnAdd, btnSubtract;
    private int balance = 0;

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

        // Hiển thị số dư ban đầu
        updateBalanceText();

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
