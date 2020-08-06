package poristagram;
import java.util.List;
public class KensakuLogic {

    public List<KensakuBean> executeKensaku (String kensakuname) {
    	KensakuDAO  ksdao = new KensakuDAO ();
        List<KensakuBean> list = ksdao.kensaku(kensakuname);
        return list;
    }

}
