package kr.or.kosta.pl.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {
	private int boardIndex;
	private String boardTitle;
	private Date boardDate;
	private int boardReadCount;
	private String boardContent;
	private String boardWriter;
	private int boardCategory;
	private String boardCategoryName;

	public Board() {}

	public Board(int boardIndex, String boardTitle, Date boardDate, int boardReadCount, String boardContent,
			String boardWriter, int boardCategory, String boardCategoryName) {
		super();
		this.boardIndex = boardIndex;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardReadCount = boardReadCount;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.boardCategory = boardCategory;
		this.boardCategoryName = boardCategoryName;
	}

	public int getBoardIndex() {
		return boardIndex;
	}

	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardCategoryName() {
		return boardCategoryName;
	}

	public void setBoardCategoryName(String boardCategoryName) {
		this.boardCategoryName = boardCategoryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardCategory;
		result = prime * result + ((boardCategoryName == null) ? 0 : boardCategoryName.hashCode());
		result = prime * result + ((boardContent == null) ? 0 : boardContent.hashCode());
		result = prime * result + ((boardDate == null) ? 0 : boardDate.hashCode());
		result = prime * result + boardIndex;
		result = prime * result + boardReadCount;
		result = prime * result + ((boardTitle == null) ? 0 : boardTitle.hashCode());
		result = prime * result + ((boardWriter == null) ? 0 : boardWriter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (boardCategory != other.boardCategory)
			return false;
		if (boardCategoryName == null) {
			if (other.boardCategoryName != null)
				return false;
		} else if (!boardCategoryName.equals(other.boardCategoryName))
			return false;
		if (boardContent == null) {
			if (other.boardContent != null)
				return false;
		} else if (!boardContent.equals(other.boardContent))
			return false;
		if (boardDate == null) {
			if (other.boardDate != null)
				return false;
		} else if (!boardDate.equals(other.boardDate))
			return false;
		if (boardIndex != other.boardIndex)
			return false;
		if (boardReadCount != other.boardReadCount)
			return false;
		if (boardTitle == null) {
			if (other.boardTitle != null)
				return false;
		} else if (!boardTitle.equals(other.boardTitle))
			return false;
		if (boardWriter == null) {
			if (other.boardWriter != null)
				return false;
		} else if (!boardWriter.equals(other.boardWriter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [boardIndex=" + boardIndex + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardReadCount=" + boardReadCount + ", boardContent=" + boardContent + ", boardWriter="
				+ boardWriter + ", boardCategory=" + boardCategory + ", boardCategoryName=" + boardCategoryName + "]";
	}
}
