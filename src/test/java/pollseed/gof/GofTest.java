package pollseed.gof;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import pollseed.gof.adaptor.Adaptee;
import pollseed.gof.adaptor.Adaptor_Abstract_pattern;
import pollseed.gof.adaptor.Adaptor_Interface_pattern;
import pollseed.gof.adaptor.abst.AbstractAdaptor;
import pollseed.gof.adaptor.interfaces.IntrAdaptor;
import pollseed.gof.bridge.Bridge;
import pollseed.gof.bridge.BridgeImplA;
import pollseed.gof.bridge.BridgeImplB;
import pollseed.gof.bridge.abst.AbstractBridge;
import pollseed.gof.conposit.Directory;
import pollseed.gof.conposit.File;
import pollseed.gof.conposit.abst.Root;
import pollseed.gof.singleton_abstractFactory.MathFactory;
import pollseed.gof.singleton_abstractFactory.MathImpl;
import pollseed.gof.singleton_abstractFactory.interfaces.MathClient;

/**
 * LT用のGoFサンプルクラス.
 * 
 * @author pollseed
 *
 */
public class GofTest extends AbstractMain {

    /**
     * <b>[Composite]</b></br> 入れ物や中身を考えず処理を同一化させる.<br>
     * <br>
     * {@link Directory}の中に{@link File}は存在しているが、どちらも同じメソッドが存在し同じ意味をもたせる処理を与える.<br>
     * 例えば、{@link Directory}の名前を知りたければ、中に存在する名前を全て返すが、{@link File}
     * の名前を知りたければ、ファイル名のみ返す.(あるいは、ディレクトリとファイルの関係)<br>
     * メソッドの概念を同じくさせ、{@link Root}の中に存在するメソッドを全て同じ感覚で使わせるというニュアンスを与えたい時に使う.<br>
     * 
     */
    @Test
    public void test_composit_pattern() {
        @SuppressWarnings("serial")
        final Directory directory = new Directory(Collections.unmodifiableCollection(new ArrayList<Root>() {
            {
                add(new File("hoge"));
                add(new File("hoge1"));
                add(new File("hoge2"));
                add(new File("hoge3"));
                add(new File("hoge4"));
            }
        }));

        // 実際にgetNameかけているのはdirecotryだが、実質的にはfileのgetNameが呼ばれている.
        eq(directory.getName(), "hoge:hoge1:hoge2:hoge3:hoge4");
        eq(directory.getSize(), 5);
    }

    /**
     * <b>[Singleton]</b></br> インスタンスの生成を1つにすることを保証.<br>
     * <b>[AbstractFactory]</b></br> 特定のメソッド名のみを提供させる.<br>
     * <br>
     * {@link MathFactory}クラスは工場のようなイメージであり、{@link MathImpl}をくれるような実装を与える.<br>
     * {@link MathImpl}は{@link MathClient}を実装しており、{@link MathClient}
     * こそが今回インタフェースとして本当に使いたいアイテム.
     */
    @Test
    public void test_singleton_and_abstractfactory_pattern() {

        // singleton
        final MathClient client = MathFactory.getInstance();

        // abstractfactory
        eq(client.multiply(10, 2), 100);
    }

    /**
     * <b>[Adapter]</b></br> 既に存在するメソッドを使いたいが、互換性がない場合にその<b>アダプタ</b>を作る.<br>
     * 互換性がないinterfaceと全く別物のクラスの処理があるとし、例えばそのinterfaceの実装にしたい場合があれば最適.
     * 
     * <ul>
     * <li>1)</li>
     * {@link Adaptee#run()}の処理と同様の実装を{@link IntrAdaptor#execute()}で使いたい場合<br>
     * {@link Adaptor_Interface_pattern}の形で継承と実装を組み合わせることで委譲させることができる.
     * <li>2)</li>
     * {@link Adaptee#run()}の処理と同様の実装を{@link AbstractAdaptor#execute()}で使いたい場合<br>
     * {@link Adaptor_Abstract_pattern}の形で継承後、{@link Adaptor}のインスタンスを直接生成する.
     */
    @Test
    public void test_adaptor_pattern() {

        // 1)
        final IntrAdaptor adaptor_intr = new Adaptor_Interface_pattern();
        eq(adaptor_intr.execute(), 1);

        // 2)
        final Adaptor_Abstract_pattern adaptor_abst = new Adaptor_Abstract_pattern();
        eq(adaptor_abst.execute(), 1);
    }

    /**
     * <b>[Bridge]</b></br> 機能と実装を分離させ、それぞれに成長させることが可能.<br>
     * <ol>
     * <li>
     * 例えば{@link BridgeImplA#execute()}と{@link BridgeImplB#execute()}があったとする.</li>
     * <li>1.のクラスで使われているメソッドを利用したいが、逆はない.</li>
     * <li>{@link AbstractBridge#execute()}をRootとし、継承した1.のクラスとは別に{@link Bridge}
     * を作り継承させる.</li>
     * <li>3.で作った{@link Bridge}クラスで1.のクラスのインスタンスを用意し、個別のメソッドを別に用意する.</li>
     * </ol>
     */
    @Test
    public void bridge_pattern() {

        // BridgeImplAとBridgeImplBのexecute()処理を使える
        final AbstractBridge abstractBridgeA = new Bridge(new BridgeImplA());
        eq(abstractBridgeA.execute(), "execute BridgeImplA");
        final AbstractBridge abstractBridgeB = new Bridge(new BridgeImplB());
        eq(abstractBridgeB.execute(), "execute BridgeImplB");

        // BridgeだけにexecuteBridge()という個別メソッドを用意できる
        final Bridge bridge = new Bridge();
        eq(bridge.executeBridge(), "execute Bridge");
    }
    
    @Test
    public void state_pattern() {
        final Logger userLogger = new LoggerImpl(new UserLogger());
        final Logger serverLogger = new LoggerImpl(new ServerLogger());
        eq(userLogger.info(), "user info >");
        eq(userLogger.warn(), "user warn >");
        eq(userLogger.error(), "user error >");
        eq(serverLogger.info(), "server info >");
        eq(serverLogger.warn(), "server warn >");
        eq(serverLogger.error(), "server error >");
    }
    
    @Test
    public void visitor_pattern() {
        Visitor v1 = new VisitorImpl1();
        Visitor v2 = new VisitorImpl2();
        Acceptor a1 = new AcceptImpl1();
        Acceptor a2 = new AcceptImpl2();
        eq(a1.accept(v1), "VisitorImpl1 ok 1");
        eq(a2.accept(v1), "VisitorImpl1 ok 2");
        eq(a1.accept(v2), "VisitorImpl2 ok 1");
        eq(a2.accept(v2), "VisitorImpl2 ok 2");
    }
}
