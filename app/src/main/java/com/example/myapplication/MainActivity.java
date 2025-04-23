package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.fragment.DiscoverFragment;
import com.example.myapplication.fragment.ExtendFragment;
import com.example.myapplication.fragment.LibraryFragment;
import com.example.myapplication.fragment.WriteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    // LoginActivity传入的用户名
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取LoginActivity传入的的用户名，用来在“我的”功能区中显示用户名
        username = getIntent().getStringExtra("username");

        // Debug，记得注释掉
//        if (username != null && !username.isEmpty()) {
//            android.widget.Toast.makeText(this, "[Debug]: Pass in username: " + username, android.widget.Toast.LENGTH_SHORT).show();
//        } else {
//            android.widget.Toast.makeText(this, "[Debug]: Passing in user name failed!", android.widget.Toast.LENGTH_SHORT).show();
//            username = "";
//        }

        bottomNavigationView = findViewById(R.id.bottom_nav);

        // 设置默认选中项
        if (savedInstanceState == null) {
            loadFragment(new DiscoverFragment());
        }

        // 设置底部导航栏监听器，处理不同菜单项的点击
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_discover) {
                selectedFragment = new DiscoverFragment();
            } else if (id == R.id.nav_write) {
                selectedFragment = new WriteFragment();
            } else if (id == R.id.nav_library) {
                selectedFragment = new LibraryFragment();
            } else if (id == R.id.nav_extend) {
                selectedFragment = new ExtendFragment();
            }

            return loadFragment(selectedFragment);
        });

    }

    // 提供用户名的getter方法
    public String getUsername() {
        return username;
    }

    // 加载 Fragment
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)  // fragment_container 是你的 FrameLayout 的 ID
                    .commit();
            return true;
        }
        return false;
    }
}
