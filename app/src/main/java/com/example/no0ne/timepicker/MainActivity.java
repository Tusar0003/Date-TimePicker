package com.example.no0ne.timepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar mCalendarTime = Calendar.getInstance();
    private Calendar mCalenderDate = Calendar.getInstance();
    private DateFormat mFormat = DateFormat.getDateTimeInstance();

    private TextView mDateTextView;
    private TextView mTimeTextView;
    private Button mDateButton;
    private Button mTimeButton;

    private int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateTextView = findViewById(R.id.text_view_date);
        mTimeTextView = findViewById(R.id.text_view_time);
        mDateButton = findViewById(R.id.button_date_picker);
        mTimeButton = findViewById(R.id.button_time_picker);

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                day = mCalenderDate.get(Calendar.DAY_OF_MONTH);
//                month = mCalenderDate.get(Calendar.MONTH);
//                year = mCalenderDate.get(Calendar.YEAR);
//
//                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                        mDateTextView.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
//                    }
//                }, year, month, day);
//
//                dialog.show();

                updateDate();
            }
        });

        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });
    }

    private void updateDate() {
        new DatePickerDialog(this, date,
                mCalenderDate.get(Calendar.DAY_OF_MONTH),
                mCalenderDate.get(Calendar.MONTH),
                mCalenderDate.get(Calendar.YEAR))
                .show();
    }

    private void updateTime() {
        new TimePickerDialog(this, time,
                mCalendarTime.get(Calendar.HOUR_OF_DAY),
                mCalendarTime.get(Calendar.MINUTE), false)
                .show();
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            mCalenderDate.set(Calendar.YEAR, year);
            mCalenderDate.set(Calendar.MONTH, month);
            mCalenderDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            Log.d("LOG_CAT", mFormat.format(mCalenderDate.getTime()));
//            mDateTextView.setText(datePicker.getYear());
//            mDateTextView.setText(mFormat.format(mCalendarTime.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            mCalendarTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendarTime.set(Calendar.MINUTE, minute);

            mTimeTextView.setText(mFormat.format(mCalendarTime.getTime()));
        }
    };
}
