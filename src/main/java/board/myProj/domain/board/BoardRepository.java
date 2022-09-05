package board.myProj.domain.board;

import board.myProj.domain.member.member.Member;

import java.util.List;

public interface BoardRepository {
    List<Board> findAll();

    Board save(Board board);

    Board findById(int id);
    Board findByNo(int no);


    void updateContent(int no,String content);

    void delete(int no);
}
