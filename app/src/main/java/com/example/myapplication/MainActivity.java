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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
