package com.kuleuven;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.*;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.utils.SourceRoot;

import java.nio.file.Paths;

public class ParseWithSymbols {
    public static void main(String[] args) throws Exception {
        String projectPath = ".";
        String srcMainJava = projectPath + "/src/main/java";

        CombinedTypeSolver typeSolver = new CombinedTypeSolver(
                new ReflectionTypeSolver(),
                new JavaParserTypeSolver(srcMainJava)
        );

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);

        ParserConfiguration config = new ParserConfiguration()
                .setSymbolResolver(symbolSolver);
        StaticJavaParser.setConfiguration(config);

        SourceRoot sourceRoot = new SourceRoot(Paths.get(srcMainJava));
        sourceRoot.setParserConfiguration(config);

        sourceRoot.parse("", (localPath, absolutePath, result) -> {
            result.ifSuccessful(cu -> {
                System.out.println("\n============================");
                System.out.println("FILE: " + absolutePath);
                System.out.println("============================\n");

                // Print the full AST / full reconstructed source
                cu.walk(node -> System.out.println(node.getClass().getSimpleName() + " -> " + node));
            });

            return SourceRoot.Callback.Result.DONT_SAVE;
        });

        System.out.println("\n✅ Done printing all parsed code!");
    }
}
