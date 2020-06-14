package com.leospiritlee.springBootDemo.lucene;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Project: SpringBootDemo
 * @ClassName Indexer
 * @description: 索引对象
 * @author: leospiritlee
 * @create: 2020-06-14 17:07
 **/
@Slf4j
public class Indexer {

    private IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        //标准分词器， 会自动去掉空格 以及is a the 等单词
        Analyzer analyzer = new StandardAnalyzer();
        //将标准分词器写到索引配置中
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        //实例化写索引对象
        writer = new IndexWriter(dir, config);
    }


    /**
     * 关闭写索引
     * @throws Exception
     */
    public void close() throws Exception {
        writer.close();
    }

    /**
     *  索引指定目录下的所有文件
     * @param dataDir
     * @return
     */
    public int indexAll(String dataDir) throws IOException {
        File[] files = new File(dataDir).listFiles();
        if(null != files){
            for(File file : files){
                indexFile(file);
            }
        }

        return writer.numDocs();
    }

    /**
     *  索引指定文件
     * @param file
     */
    private void indexFile(File file) throws IOException {
        log.info("index file path: {}", file.getCanonicalPath());
        //获取指定文件的document
        Document document = getDocument(file);
        //将document 添加到索引中
        writer.addDocument(document);
    }


    /**
     *  获取指定文件
     * @param file
     * @return
     */
    private Document getDocument(File file) throws IOException {
        Document doc = new Document();

        //添加内容
        doc.add(new TextField("contents", new FileReader(file)));
        //添加文件名称
        doc.add(new TextField("fileName", file.getName(), Field.Store.YES));
        //添加文件路径
        doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES));


        return doc;
    }

    public static void main(String[] args) {
        //索引保存到的路径
        String indexDir = "d:\\MyWorkTool\\lucene";
        //需要索引的文件数据存放的目录
        String dataDir = "D:\\MyWorkTool\\lucene\\data";

        Indexer indexer = null;
        int indexedNum = 0;
        //记录索引开始时间
        long startTime = System.currentTimeMillis();
        try {
        // 开始构建索引
            indexer = new Indexer(indexDir);
            indexedNum = indexer.indexAll(dataDir);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != indexer) {
                    indexer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //记录索引结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("索引耗时" + (endTime - startTime) + "毫秒");
        System.out.println("共索引了" + indexedNum + "个文件");
    }

}
