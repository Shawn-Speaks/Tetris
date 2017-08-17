package shawn.c4q.nyc.tetristakeone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DEBUG TOOL";
    TetrisView tetrisView;

    Button leftBtn;
    Button downBtn;
    Button rotateBtn;
    Button rightBtn;
    int[][] tetrisBoard = new int[10][20];


    /**
     *
     * left button will temporarily debug and toast (Custom) Tetris view width.
     * right *---------------------------------------------------------* height.
     * rotate *---------------------------------------------------------*
     *
     *
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        leftBtn = findViewById(R.id.left_btn);
        rotateBtn = findViewById(R.id.rotate_btn);
        downBtn = findViewById(R.id.down_btn);
        rightBtn = findViewById(R.id.right_btn);

        tetrisView = findViewById(R.id.tetris_view);


        for(int i = 0; i < tetrisBoard.length; i++){
            for(int j = 0; j < tetrisBoard[i].length; j++){
                tetrisBoard[i][j] = -1;
            }
        }

        leftBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_btn:
                tetrisView.state = 1;
                tetrisView.invalidate();
                break;
            case R.id.down_btn:
                tetrisView.state = 2;
                tetrisView.invalidate();
                break;
            case R.id.right_btn:
                tetrisView.state = 3;
                tetrisView.invalidate();
                break;
            case R.id.rotate_btn:
                tetrisView.state = 5;
                tetrisView.invalidate();
                break;
            default:

        }
    }
}
