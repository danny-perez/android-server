package co.wolholland.transferringcomplexobject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View v) {

        final EditText nameText = findViewById(R.id.name);
        final EditText companyText = findViewById(R.id.company);
        final EditText priceText = findViewById(R.id.price);

        String name = nameText.getText().toString();
        String company = companyText.getText().toString();
        int price = Integer.parseInt(priceText.getText().toString());

        Product product = new Product(name, company, price);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Product.class.getSimpleName(), product);
        startActivity(intent);
    }
}
