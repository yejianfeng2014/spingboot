package com.example.demo.controller;


import edu.mit.ll.mitie.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 *  实体关系检测
 */

@RestController("/relation")

@Api(tags = "relation_tag", description = "关系检测")
public class EntityRelationsController {

//    @RequestMapping(value = "init",method = RequestMethod.GET)
//    public String hello() {
//        return "hello entity init";
//
//    }

    @RequestMapping(value = "born_in",method = RequestMethod.GET)
    public String getBornIn(String text) {



        String file1 = this.getClass().getClassLoader().getResource("Google.js").getFile();
        File file = new File(file1);
        String base_path = file.getParent(); // null


        // todo 如果载入出现出错误，第一个采用引用maven里面的dll 文件
        String  fileName1 = base_path + "/english/javamitie.dll";
        String  fileName2 = base_path + "/english/msvcp100.dll";
        String  fileName3 = base_path + "/english/msvcr100.dll";
        String  fileName4 = base_path + "/english/ner_model.dat";

        System.load(fileName1); //绝对路径
        System.load(fileName2); //绝对路径
        System.load(fileName3); //绝对路径


        System.out.println("loading NER model...");
        NamedEntityExtractor ner = new NamedEntityExtractor(fileName4);

        System.out.println("Tags output by this NER model are: ");
        StringVector possibleTags = ner.getPossibleNerTags();



        String s = text;


        System.out.println(">>>>");
        System.out.println(s);

        StringVector words = global.tokenize(s);


        EntityMentionVector entities = ner.extractEntities(words);

        BinaryRelationDetector relDetector = new BinaryRelationDetector("C:\\Users\\order\\Downloads\\MITIE-Java\\MITIE-models\\english\\binary_relations\\rel_classifier_people.person.place_of_birth.svm");
        System.out.println("Relation detector type: " + relDetector.getNameString());

        // Let's ask MITIE if any of the neighboring pairs of entities are examples of the
        // "person born in place" relation.
        for (int i = 1; i < entities.size(); ++i)
        {
            // Was entities.get(i) born in entities.get(i-1)?  Note that the detection has
            // two steps in MITIE. First, you convert a pair of entities into a special
            // representation.  Then you ask the detector to classify that pair of
            // entities.  If the score value is > 0 then it is saying that it has found a
            // relation.  The larger the score the more confident it is.  Finally, the
            // reason we do detection in two parts is so you can reuse the intermediate
            // object in many calls to different relation detectors without needing to redo



            // the processing done in extractBinaryRelation().  However, in this example
            // such complications are not necessary.
            if (relDetector.classify(ner.extractBinaryRelation(words, entities.get(i), entities.get(i-1))) > 0)
            {
                printEntity(words, entities.get(i));
                System.out.println("BORN IN");
                printEntity(words, entities.get(i-1));
                System.out.println("");
            }
            // Was entities.get(i-1) born in entities.get(i)?
            if (relDetector.classify(ner.extractBinaryRelation(words, entities.get(i-1), entities.get(i))) > 0)
            {
                printEntity(words, entities.get(i-1));
                System.out.println("BORN IN");
                printEntity(words, entities.get(i));
                System.out.println("");
            }
        }





        return "hello entity init";

    }



    public static void printEntity (
            StringVector words,
            EntityMention ent
    )

    {
        // Print all the words in the range indicated by the entity ent.
        for (int i = ent.getStart(); i < ent.getEnd(); ++i)
        {
            System.out.print(words.get(i) + " ");
        }
        System.out.println("");
    }



}
