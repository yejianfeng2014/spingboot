package com.example.demo.controller;


import edu.mit.ll.mitie.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import edu.mit.ll.mitie.*;
import java.io.File;

/**
 *  实体识别模块
 *
 */


@RestController

@RequestMapping("/entity")
@Api(tags = "Entity", description = "实体识别")
public class EntityController {
//    @RequestMapping(value = "init",method = RequestMethod.GET)
//    public String hello() {
//        return "hello entity init";
//
//    }

    @RequestMapping(value = "getEntity",method = RequestMethod.GET)
    public String getEntity(String text) {

        String file1 = this.getClass().getClassLoader().getResource("Google.js").getFile();
        File file = new File(file1);
        String base_path = file.getParent(); // null

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

        for (int i = 0; i < possibleTags.size(); ++i){


            System.out.println(possibleTags.get(i));
        }
        // todo 暂时在这儿调用，以后全部转移到service层进行调用

        // Load a text file and convert it into a list of words.
//        mitie

//        String s = global.loadEntireFile("D:\\data_pre\\src\\test\\resource\\sample_text.txt");


        String s = text;


        System.out.println(">>>>");
        System.out.println(s);

        StringVector words = global.tokenize(s);



        EntityMentionVector entities = ner.extractEntities(words);
        System.out.println("Number of entities found: " + entities.size());

        // Now print out all the named entities and their tags
        for (int i = 0; i < entities.size(); ++i)
        {
            // Each EntityMention contains three integers.  The start and end define the
            // range of tokens in the words vector that are part of the entity.  There is
            // also a tag which indicates which element of possibleTags is associated with
            // the entity.  So we can print out all the tagged entities as follows:
            EntityMention entity = entities.get(i);
            String tag = possibleTags.get(entity.getTag());
            System.out.print("Entity tag: " + tag + "\t Entity text: ");
            printEntity(words, entity);
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
