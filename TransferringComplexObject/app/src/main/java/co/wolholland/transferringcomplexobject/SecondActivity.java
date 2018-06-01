package co.wolholland.transferringcomplexobject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        final Product product;
        if(arguments!=null){
            product = arguments.getParcelable(Product.class.getSimpleName());

            textView.setText("Name: " + product.getName() + "\nCompany: " + product.getCompany() +
                    "\nPrice: " + String.valueOf(product.getPrice()));
        }
        setContentView(textView);
    }
}