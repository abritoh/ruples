package org.apache.ruples.plantuml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.ruples.util.PropertiesProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;

/**
 * The UMLGenerator automates the generation of PlantUML class diagrams 
 * and their corresponding PNG images for all classes within a specified package.
 * 
 * This class performs the following tasks:
 * <ul>
 *     <li>Scans all classes in a given package.</li>
 *     <li>Generates PlantUML syntax for each class, including:
 *         <ul>
 *             <li>Class name</li>
 *             <li>Class fields with types</li>
 *             <li>Declared methods with return types</li>
 *             <li>Superclass relationships</li>
 *             <li>Implemented interfaces</li>
 *         </ul>
 *     </li>
 *     <li>Writes the generated PlantUML code to a `.puml` file in the specified output folder.</li>
 *     <li>Uses PlantUML to generate PNG diagrams from the `.puml` files and saves them to the output directory.</li>
 * </ul>
 * 
 * The generated class diagrams can help visualize the structure and relationships of classes in the package.
 * The UML generation is triggered by running the main method, which loads configuration from properties
 * and processes the specified package to generate the UML files and images.
 * 
 * Configuration is loaded from a `PropertiesProvider` instance that specifies:
 * <ul>
 *     <li>The package to scan for classes.</li>
 *     <li>Where to save the generated `.puml` and `.png` files.</li>
 * </ul>
 * 
 * Important notes:
 * <ul>
 * <li>The implementation relies on the ClassGraph library to scan classes in the specified package.</li>
 * <li>The implementation uses the PlantUML library for generating image-diagrams of the generated PUML file.</li>
 * <li>This implementation perform the same as UMLGraph dependency which is no loger supported beyond Java 8.</li>
 * <li>Class-diagrams of the Javadocs for this project have been generated with this implementation.</li>
 * </ul>
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/plantuml/images/UMLGenerator.png" alt="UML Diagram"></div>
 * 
 * <a href="https://github.com/abritoh/ruples" target="_blank">https://github.com/abritoh/ruples</a>
 * 
 * @since 2024-1118
 * @author ClusterBR * 
 */
public class UMLGenerator {
    
    private static final Logger logger = LoggerFactory.getLogger(UMLGenerator.class);
    
    public static final String 
        NewLine = "\n" 
        , Space = " "
        ;
    

    public static void main(String[] args) {

        PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();

        String generatePlantumlForPackage = propertiesProvider
                .getProperty("application.generate.plantuml.for.package");
        String plantumlDestinationFolderPuml = propertiesProvider
                .getProperty("application.plantuml.destination.folder.puml");
        String plantumlDestinationFolderImg = propertiesProvider
                .getProperty("application.plantuml.destination.folder.images");

        File outputDirPuml = new File(plantumlDestinationFolderPuml);
        if (!outputDirPuml.exists()) {
            outputDirPuml.mkdirs();
        }

        File outputDirImg = new File(plantumlDestinationFolderImg);
        if (!outputDirImg.exists()) {
            outputDirImg.mkdirs();
        }

        String msg;
        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages(generatePlantumlForPackage)
                .scan() ) {

            List<ClassInfo> classInfos = scanResult.getAllClasses();

            for (ClassInfo classInfo : classInfos) {
                StringBuilder plantUML = new StringBuilder("@startuml ").append(NewLine);

                plantUML.append("skinparam class { ").append(NewLine)
                        .append(" BackgroundColor #DEE3E9 ").append(NewLine)
                        .append(" ArrowColor #4D7A97 ").append(NewLine)
                        .append(" BorderColor #4D7A97 ").append(NewLine)
                        .append("}").append(NewLine)
                        ;

                plantUML.append("top to bottom direction ").append(NewLine);

                plantUML.append("title package: ")
                        .append(classInfo.getPackageName()).append(NewLine)
                        .append("skinparam titleBackgroundColor White").append(NewLine)
                        .append("skinparam classHeaderBackgroundColor #4D7A97").append(NewLine)
                        .append("skinparam stereotypeCBackgroundColor #F8981D").append(NewLine)                        
                        .append(NewLine).append(NewLine);

                String className = classInfo.getSimpleName();
                plantUML.append("class ")
                        .append(className)
                        .append(" {").append(NewLine);

                classInfo.getDeclaredFieldInfo()
                        .forEach(field -> plantUML.append("  ")
                                        .append(field.getTypeSignatureOrTypeDescriptor())
                                        .append(Space)
                                        .append(field.getName())
                                        .append(NewLine)
                                );

                classInfo.getDeclaredMethodInfo()
                        .forEach(method -> plantUML.append("  ")
                                        .append(method.getTypeSignatureOrTypeDescriptor())
                                        .append(Space)
                                        .append(method.getName()).append("()").append(NewLine)
                                );

                plantUML.append("}").append(NewLine);

                if (classInfo.getSuperclass() != null) {
                    String superclassName = classInfo.getSuperclass().getName();
                    plantUML.append(className)
                            .append(" --|> ")
                            .append(superclassName)
                            .append(NewLine);
                }

                classInfo.getInterfaces().forEach(implementedInterface -> {
                    String interfaceName = implementedInterface.getName();
                    plantUML.append(className)
                            .append(" ..|> ")
                            .append(interfaceName)
                            .append(NewLine);
                });

                plantUML.append("@enduml");

                File pumlFile = new File(outputDirPuml, className + ".puml");

                try (FileWriter writer = new FileWriter(pumlFile, false)) {
                    writer.write(plantUML.toString());
                    msg = String.format("(UMLGenerator) PUML file generated : %s", pumlFile);
                    logger.info(msg);
                }

                SourceFileReader reader = new SourceFileReader(pumlFile, outputDirImg);
                List<GeneratedImage> list = reader.getGeneratedImages();
                for (GeneratedImage image : list) {
                    File pngFile = image.getPngFile();
                    msg = String.format("(UMLGenerator) PNG file generated : %s", pngFile);
                    logger.info(msg);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("[Exception] (UMLGenerator)", ex);
        }
    }
}
