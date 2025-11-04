package com.kuleuven;

import sootup.callgraph.CallGraphAlgorithm;
import sootup.callgraph.ClassHierarchyAnalysisAlgorithm;
import sootup.callgraph.RapidTypeAnalysisAlgorithm;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.signatures.MethodSignature;
import sootup.core.signatures.MethodSubSignature;
import sootup.java.bytecode.frontend.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.types.JavaClassType;
import sootup.java.core.views.JavaView;

import java.util.Collections;
import java.util.Optional;

public class CallGraph {
    public static void main(String[] args) {
        AnalysisInputLocation inputLocation =
                new JavaClassPathAnalysisInputLocation("./target/classes");

        JavaView view = new JavaView(inputLocation);

        JavaClassType classType =
                view.getIdentifierFactory().getClassType("com.kuleuven.library.Main");

        JavaSootClass sootClass = view.getClass(classType).get();

        MethodSignature methodSignature = view.getIdentifierFactory().getMethodSignature(
                classType,
                "main", // method name
                "void", // return type
                Collections.singletonList("java.lang.String[]")); // args

        MethodSubSignature mss = methodSignature.getSubSignature();
        Optional<JavaSootMethod> opt = sootClass.getMethod(mss);

        if(opt.isEmpty()) {
            return;
        }

        JavaSootMethod sootMethod = opt.get();

//        CallGraphAlgorithm cha = new ClassHierarchyAnalysisAlgorithm(view);
        CallGraphAlgorithm rta = new RapidTypeAnalysisAlgorithm(view); // or RTA

        sootup.callgraph.CallGraph cg = rta.initialize(Collections.singletonList(methodSignature));

        cg.callsFrom(methodSignature).stream()
                .forEach(tgt -> System.out.println(methodSignature + " may call " + tgt));

//        System.out.println("dotUrl: " + cg.exportAsDot());
    }
}
