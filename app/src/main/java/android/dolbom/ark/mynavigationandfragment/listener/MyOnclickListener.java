package android.dolbom.ark.mynavigationandfragment.listener;

import android.content.Context;
import android.dolbom.ark.mynavigationandfragment.MainActivity;
import android.dolbom.ark.mynavigationandfragment.R;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.widget.Toast;

/**
 * Created by samsung on 2017-06-06.
 */

public class MyOnclickListener implements View.OnClickListener {
    private Context context;

    public MyOnclickListener(Context context){
        this.context = context;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnNavigationDrawerFistButton:
                Toast.makeText(context, "첫번째 네이게이션 버튼", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnNavigationDrawerSecondButton:
                Toast.makeText(context, "두번째 네이게이션 버튼", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
