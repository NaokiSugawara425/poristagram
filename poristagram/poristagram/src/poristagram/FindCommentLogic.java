package poristagram;

import java.util.List;

public class FindCommentLogic {
    public List<Board> executeFindComment() {
        FindCommentDAO fcdao = new FindCommentDAO();
        List<Board> list = fcdao.findcomment();
        return list;
    }

}