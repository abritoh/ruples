package org.clusterbr.ruples.uml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.clusterbr.ruples.util.O_____O;
import org.clusterbr.ruples.util.PropertiesProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import net.sourceforge.plantuml.SourceFileReader;

/**
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/UmlProcessor.png" alt="UMLDiagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
public class UmlProcessor {
    private static final String 
    ___$ = O_____O.o______o("YXBwLnVtMS40LnBrZ2U="),
    ___$__ = O_____O.o______o("YXBwLnVtMi5kM3MuZDFy"),
    ___$___ = O_____O.o______o("YXBwLnVtMy5kM3NzLmQxci5pbQ=="),
    ___$____ = O_____O.o______o("QHN0YXJ0dW1sIA=="),
    ___$_____ = O_____O.o______o("c2tpbnBhcmFtIGNsYXNzIHsg"),
    ___$______ = O_____O.o______o("IEJhY2tncm91bmRDb2xvciAjREVFM0U5IA=="),
    ___$_______ = O_____O.o______o("IEFycm93Q29sb3IgIzREN0E5NyA="),
    ___$________ = O_____O.o______o("IEJvcmRlckNvbG9yICM0RDdBOTcg"),
    ___$_________ = O_____O.o______o("dG9wIHRvIGJvdHRvbSBkaXJlY3Rpb24g"),
    ___$__________ = O_____O.o______o("dGl0bGUgcGFja2FnZTog"),
    ___$____________ = O_____O.o______o("c2tpbnBhcmFtIHRpdGxlQmFja2dyb3VuZENvbG9yIFdoaXRl"),
    ___$_______________ = O_____O.o______o("c2tpbnBhcmFtIGNsYXNzSGVhZGVyQmFja2dyb3VuZENvbG9yICM0RDdBOTc="),
    ___$________________ = O_____O.o______o("c2tpbnBhcmFtIHN0ZXJlb3R5cGVCQmFja2dyb3VuZENvbG9yICNGODk4MUQ="),
    ___$___________________ = O_____O.o______o("QGVuZHVtbA=="),
    $______________________ = O_____O.o______o("Y2xhc3Mg"),
    $_______________________ = (" --|> "),
    $_________________________ = (" ..|> "),
    $___________________________ = (" - "),
    $_______________________________ = O_____O.o______o("ICsg"),
    $_________________________________ = O_____O.o______o("IA=="),
    $__________________________________ = O_____O.o______o("IHs="),
    $______________________________________ = O_____O.o______o("fQ=="),
    $_____________________________________________________________ = O_____O.o______o("LnB1bWw=");

    public static void main(String[] ______$______) {

        PropertiesProvider $___$____ = PropertiesProvider.getInstance();
        
        String 
        $_________$__$ = $___$____.getProperty(___$),
        _________$___$ = $___$____.getProperty(___$__),
        _________$____$ = $___$____.getProperty(___$___);
        
        File $_________$ = new File(_________$___$);

        if (!$_________$.exists())
            $_________$.mkdirs();
        File $_________$_ = new File(_________$____$);
        if (!$_________$_.exists())
            $_________$_.mkdirs();
        try (ScanResult _____$_____ = new ClassGraph().enableAllInfo().acceptPackages($_________$__$).scan()) {
            List<ClassInfo> ____$$____ = _____$_____.getAllClasses();
            for (ClassInfo ____$________$____ : ____$$____) {
                StringBuilder $____________ = new StringBuilder(___$____).append(___$______$___);
                $____________.append(___$_____).append(___$______$___).append(___$______)
                        .append(___$______$___).append(___$_______).append(___$______$___)
                        .append(___$________).append(___$______$___).append("}").append(___$______$___);
                $____________.append(___$_________).append(___$______$___);

                $____________.append(___$__________).append(____$________$____.getPackageName()).append(___$______$___)
                        .append(___$____________).append(___$______$___).append(___$_______________).append(___$______$___)
                        .append(___$________________).append(___$______$___).append(___$______$___).append(___$______$___);

                String __$____________$__ = ____$________$____.getSimpleName();
                $____________.append($______________________).append(__$____________$__)
                        .append($__________________________________).append(___$______$___);
                ____$________$____.getDeclaredFieldInfo()
                        .forEach(_$ -> $____________.append($___________________________)
                                .append(_$.getTypeSignatureOrTypeDescriptor())
                                .append($_________________________________).append(_$.getName())
                                .append(___$______$___));

                ____$________$____.getDeclaredMethodInfo()
                        .forEach(_$ -> $____________.append($_______________________________)
                                .append(_$.getTypeSignatureOrTypeDescriptor())
                                .append($_________________________________)
                                .append(_$.getName()).append("()")
                                .append(___$______$___));
                $____________.append($______________________________________).append(___$______$___);
                if (____$________$____.getSuperclass() != null) {
                    String ___$______ = ____$________$____.getSuperclass().getName();
                    $____________.append(__$____________$__).append($_______________________).append(___$______)
                            .append(___$______$___);
                }
                ____$________$____.getInterfaces().forEach(_$ -> {
                    String $_____ = _$.getName();
                    $____________.append(__$____________$__).append($_________________________).append($_____)
                            .append(___$______$___);
                });
                $____________.append(___$___________________);
                File $___________$ = new File($_________$,
                        __$____________$__ + $_____________________________________________________________);
                try (FileWriter $_____________$ = new FileWriter($___________$, false)) {
                    $_____________$.write($____________.toString());
                }
                SourceFileReader $___$______ = new SourceFileReader($___________$, $_________$_);
                $___$______.getGeneratedImages();
            }
        } catch (IOException ex) {
            __$________$__.error("$____x____$", ex);
        }
    }

    public static final String ___$______$___ = "\n", _$__________$_ = " ";
    private static final Logger __$________$__ = LoggerFactory.getLogger(UmlProcessor.class);
}
