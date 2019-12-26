package main.java.com.termux.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.termux.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import main.java.com.termux.app.TermuxActivity;
import main.java.com.termux.app.TermuxInstaller;
import main.java.com.termux.fragment.BackupFragment;
import main.java.com.termux.fragment.RestoreFragment;
import main.java.com.termux.fragment.SettingFragment;
import main.java.com.termux.utils.ExeCommand;

public class BackNewActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout mBackup;
    private LinearLayout mRestore;
    private LinearLayout mSetting;
    private FragmentManager mSupportFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private BackupFragment mBackupFragment;
    private RestoreFragment mRestoreFragment;
    private SettingFragment mSettingFragment;


    private TextView mBackupText;
    private TextView mRestoreText;
    private TextView mSettingText;

    public int mSwitch = 0;

    public static boolean mIsRun = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_new);

        mBackup = findViewById(R.id.backup);
        mRestore = findViewById(R.id.restore);
        mSettingText = findViewById(R.id.setting_text);

        mBackupText = findViewById(R.id.backup_text);
        mRestoreText = findViewById(R.id.restore_text);
        mSetting = findViewById(R.id.setting);

        mBackup.setOnClickListener(this);
        mRestore.setOnClickListener(this);
        mSetting.setOnClickListener(this);


        mSupportFragmentManager = getSupportFragmentManager();

        mFragmentTransaction = mSupportFragmentManager.beginTransaction();
        mBackupFragment = new BackupFragment();
        mRestoreFragment = new RestoreFragment();
        mSettingFragment = new SettingFragment();
        mFragmentTransaction.add(R.id.fragment, mRestoreFragment);
        mFragmentTransaction.add(R.id.fragment, mSettingFragment);
        mFragmentTransaction.add(R.id.fragment, mBackupFragment);
        mFragmentTransaction.show(mBackupFragment).commit();
        mBackupText.setTextColor(Color.parseColor("#FF6EC7"));



    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return isCosumenBackKey();
        }
        return false;
    }

    private boolean isCosumenBackKey() {
        if (mIsRun) {
            Toast.makeText(this, "有任务正在进行,防止误触碰,如果执意退出,请大退", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            // Toast.makeText(this, "返回键被阻拦了，您可以按home键退出再进来", Toast.LENGTH_SHORT).show();
            finish();
            return false;
        }


    }

    @Override
    public void onClick(View v) {


        if (mIsRun) {
            Toast.makeText(this, "有任务进行中，无法切换!", Toast.LENGTH_SHORT).show();
            return;
        }


        switch (v.getId()) {

            case R.id.backup:
                mBackupText.setTextColor(Color.parseColor("#ffffff"));
                mRestoreText.setTextColor(Color.parseColor("#ffffff"));
                mSettingText.setTextColor(Color.parseColor("#ffffff"));

                mBackupText.setTextColor(Color.parseColor("#FF6EC7"));
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                supportFragmentManager.beginTransaction().replace(R.id.fragment, mBackupFragment).commit();
                break;
            case R.id.restore:
                mBackupText.setTextColor(Color.parseColor("#ffffff"));
                mRestoreText.setTextColor(Color.parseColor("#ffffff"));
                mSettingText.setTextColor(Color.parseColor("#ffffff"));

                mRestoreText.setTextColor(Color.parseColor("#FF6EC7"));
                FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                supportFragmentManager1.beginTransaction().replace(R.id.fragment, mRestoreFragment).commit();
                break;

            case R.id.setting:
                mBackupText.setTextColor(Color.parseColor("#ffffff"));
                mRestoreText.setTextColor(Color.parseColor("#ffffff"));
                mSettingText.setTextColor(Color.parseColor("#ffffff"));

                mSettingText.setTextColor(Color.parseColor("#FF6EC7"));

                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                supportFragmentManager2.beginTransaction().replace(R.id.fragment, mSettingFragment).commit();

                break;

        }

    }

    @Override
    public void finish() {
        super.finish();
        mIsRun = false;
    }



}
