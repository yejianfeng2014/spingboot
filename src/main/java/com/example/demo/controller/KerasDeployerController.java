package com.example.demo.controller;

//import org.tensorflow.Graph;
//import org.tensorflow.Session;
//import org.tensorflow.Tensor;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;

public class KerasDeployerController {


  /*  public static void main(String[] args) throws Exception {
        try (Graph graph = new Graph()) {
            graph.importGraphDef(Files.readAllBytes(Paths.get(
                    "D:\\python_workspace\\semanaly\\lstm\\model.pb"
            )));
            try (Session sess = new Session(graph)) {
                // 自己构造一个输入
                float[][] input = {{56, 632, 675, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                float[][] input_2 = {{56, 632, 675, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

                try (Tensor x = Tensor.create(input);
                     // input是输入的name，output是输出的name
                     Tensor y = sess.runner().feed({x:"input_1",y:"input_2" }).fetch("output").run().get(0)) {
//                    float[][] result = new float[1][y.shape[1]];
//                    y.copyTo(result);
                    System.out.println(Arrays.toString(y.shape()));
//                    System.out.println(Arrays.toString(result[0]));
                }
            }
        }
    }*/




}
