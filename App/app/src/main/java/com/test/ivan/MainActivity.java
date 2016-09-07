package com.test.ivan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.ivan.app.R;
import com.test.ivan.behavioral.observer.ObserveManager;
import com.test.ivan.behavioral.observer.Observer;
import com.test.ivan.behavioral.strategy.Math;
import com.test.ivan.behavioral.strategy.Plus;
import com.test.ivan.creational.Singleton;
import com.test.ivan.creational.builder.Builder;
import com.test.ivan.creational.builder.BuilderModel;
import com.test.ivan.creational.factmethod.FactoryMethod;
import com.test.ivan.creational.factmethod.FactoryMethodObject;
import com.test.ivan.struct.adapter.RandomGeneratorAdapter;
import com.test.ivan.struct.adapter.SequenceGenerator;
import com.test.ivan.struct.bridge.CustomShape;
import com.test.ivan.struct.bridge.DrawCube;
import com.test.ivan.struct.bridge.DrawLine;
import com.test.ivan.struct.facade.Computer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ObserveManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Singleton singleton = Singleton.getInstance();
        //
        Builder builder = new Builder();
        builder.setField1("1");
        builder.setField3("3");
        BuilderModel model13 = builder.create();

        Builder builder2 = new Builder();
        builder.setField2("2");
        builder.setField4("4");
        BuilderModel model24 = builder2.create();
        //
        FactoryMethodObject object = FactoryMethod.getInstance();
        FactoryMethodObject object1 = FactoryMethod.getInstance("");
        //
        CustomShape shape = new CustomShape(new DrawCube());
        shape.resize();
        shape.draw();
        CustomShape shape2 = new CustomShape(new DrawLine());
        shape2.resize();
        shape2.draw();
        //
        RandomGeneratorAdapter adapter = new RandomGeneratorAdapter();
        SequenceGenerator generator = new SequenceGenerator(adapter);

        for (int i : generator.generate(10)) {
            System.out.print(i + " ");
        }
        //
        Computer computer = new Computer();
        computer.start();
        //
        Math math = new Math(new Plus());
        math.apply(1, 2);
        //
        mManager = new ObserveManager();
        //
    }

    @Override
    protected void onResume() {
        super.onResume();
        mManager.registerObserver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mManager.removeObserver(this);
    }

    @Override
    public void update() {
        // update this somehow
    }
}