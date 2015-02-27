package pollseed.tools.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;

import pollseed.tools.helper.abst.AbstractFileParser;

public class FileParser extends AbstractFileParser {

    /**
     * @param path
     *            出力するファイルのパス
     * @param cut
     *            省きたいカラムの数
     */
    public FileParser(String path, int cut) {
        super(path, cut);
    }

    /**
     * @param path
     *            出力するファイルのパス
     * @param cut
     *            省きたいカラムの数
     * @param splits
     *            区切り文字
     */
    FileParser(String path, int cut, String splits) {
        super(path, cut, splits);
    }

    @Override
    public void parse(File file) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new PrintWriter(super.path));
            String line = null;
            int lineCnt = 0;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(super.splits);
                if (strs.length <= super.cut) {
                    continue;
                }
                if (lineCnt != 0) {
                    bw.newLine();
                }
                int strCnt = 0;
                for (String str : strs) {
                    if (strCnt != 0) {
                        bw.append(",");
                    }
                    bw.append(str);
                    strCnt++;
                    if (strCnt > 500) {
                        bw.flush();
                    }
                }
                lineCnt++;
                if (lineCnt > 100) {
                    bw.flush();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(bw);
        }
    }
}
