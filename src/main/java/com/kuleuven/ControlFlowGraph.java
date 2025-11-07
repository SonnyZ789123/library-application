package com.kuleuven;

import sootup.core.graph.StmtGraph;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.signatures.MethodSignature;
import sootup.core.signatures.MethodSubSignature;
import sootup.core.util.DotExporter;
import sootup.java.bytecode.frontend.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.types.JavaClassType;
import sootup.java.core.views.JavaView;

import java.util.Collections;
import java.util.Optional;

public class ControlFlowGraph {

    public static void main(String[] args) {
        AnalysisInputLocation inputLocation =
                new JavaClassPathAnalysisInputLocation("./target/classes");

        JavaView view = new JavaView(inputLocation);

        JavaClassType classType =
                view.getIdentifierFactory().getClassType("com.kuleuven.library.Book");

        JavaSootClass sootClass = view.getClass(classType).get();

        MethodSignature methodSignature = view.getIdentifierFactory().getMethodSignature(
                classType,
                "getReducedPrice", // method name
                "double", // return type
                Collections.emptyList()); // args

        MethodSubSignature mss = methodSignature.getSubSignature();
        Optional<JavaSootMethod> opt = sootClass.getMethod(mss);

        if(opt.isEmpty()) {
            return;
        }

        JavaSootMethod sootMethod = opt.get();

        StmtGraph<?> graph = sootMethod.getBody().getStmtGraph();

        System.out.println(DotExporter.buildGraph(graph, false, null, null));
        String urlToWebeditor = DotExporter.createUrlToWebeditor(graph);
        System.out.println(urlToWebeditor);
    }
}
