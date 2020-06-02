package com.codurance.retropolis.services;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codurance.retropolis.entities.Board;
import com.codurance.retropolis.entities.Column;
import com.codurance.retropolis.repositories.BoardRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

  public static final Long USER_ID = 1L;
  public static final Long COLUMN_ID = 1L;
  public static final Long BOARD_ID = 1L;

  @Mock
  private BoardRepository boardRepository;

  private BoardService boardService;

  @BeforeEach
  void setUp() {
    boardService = new BoardService(boardRepository);
  }

  @Test
  void should_return_a_board() {
    String columnTitle = "Start";
    when(boardRepository.getBoard(BOARD_ID)).thenReturn(
        new Board(BOARD_ID, "test board", List.of(new Column(COLUMN_ID, columnTitle, emptyList()))));

    Board board = boardService.getBoard(BOARD_ID);

    verify(boardRepository).getBoard(BOARD_ID);
    assertEquals(BOARD_ID, board.getColumns().get(0).getId());
    assertEquals(columnTitle, board.getColumns().get(0).getTitle());
    assertEquals(0, board.getColumns().get(0).getCards().size());
  }

  @Test
  void add_user_to_board() {
    boardService.addToBoard(USER_ID, BOARD_ID);
    verify(boardRepository).addToBoard(USER_ID, BOARD_ID);
  }

}
