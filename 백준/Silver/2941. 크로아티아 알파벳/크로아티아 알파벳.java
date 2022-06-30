import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.FlavorException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String a = br.readLine();
    a = a.replace("c=", "가");
    a = a.replace("c-", "가");
    a = a.replace("dz=", "가");
    a = a.replace("d-", "가");

    a = a.replace("lj", "가");
    a = a.replace("nj", "가");
    a = a.replace("s=", "가");
    a = a.replace("z=", "가");

    bw.write(a.length() + "\n");
    bw.flush();
    bw.close();
  }

}
