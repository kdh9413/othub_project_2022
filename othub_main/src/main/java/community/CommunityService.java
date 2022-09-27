package community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("commuservice")
public class CommunityService {

	@Autowired
	@Qualifier("commu")
	CommunityDAO dao;
	
	// 전체 게시물 조회
	public List<CommunityDTO> communityList() {
		return dao.communityList();
	}
	
	// 최대 페이지 수
	public int countCommunity() {
		int countCommunity = dao.countCommunity();
		int limitPage = 0;
		if(countCommunity % 16 ==0) {
			limitPage = countCommunity/10;
		}else {
			limitPage = countCommunity/10 + 1;
		}
		return limitPage;
	};
	
	//전체 게시물 갯수
	public int amountCommunity() {
		int totalboard =  dao.countCommunity();
		return totalboard;
	}

	// 페이징(최신순)
	public List<CommunityDTO> limitCommunity(int page){
		int limit = (page - 1) * 16;
		return dao.limitCommunity(limit);
	}
	//페이징(좋아요순)
	public List<CommunityDTO> likeCommunity(int page){
		int limit = (page - 1) * 16;
		return dao.likeCommunity(limit);
	}
	
	//게시판 저장
	public int insertCommunity(CommunityDTO dto) {
		return dao.insertCommunity(dto);
	}
	
	
	//게시물 디테일
	public CommunityDTO oneCommunity(int s_seq){
		return dao.oneCommunity(s_seq);
	}
	
	//게시물 수정
	public int updateWriting(CommunityDTO dto) {
		return dao.updateWriting(dto);
	}
	
	//게시물 조회수
	public void viewCount(int s_seq) {
		 dao.viewCount(s_seq);
	}
	//게시물 삭제
	public void deleteCommunity(int s_seq) {
		dao.deleteCommunity(s_seq);
	}
	
	//좋아요 중복 확인
	public int likeCount(int s_seq) {
		return dao.likeCount(s_seq);
	}
	
	//좋아요 중복 체크
	public int likeCheck(int s_seq, String m_id) throws Exception{
		return dao.likeCheck(s_seq,m_id);
	}
	
	//insert 좋아요
	public void insertLike(int s_seq, String m_id) throws Exception{
		dao.insertLike(s_seq,m_id);
	}
	
	//update 좋아요
	public void updateLike(int s_seq) throws Exception{
		dao.updateLike(s_seq);
	}
	
	//update 좋아요 체크
	public void updateLikeCheck(int s_seq, String m_id) {
		dao.updateLikeCheck(s_seq, m_id);
	}
	
	//update 좋아요 취소 체크
	public void updateLikeCheckCancel(int s_seq, String m_id) {
		dao.updateLikeCheckCancel(s_seq,m_id);
	}
	
	public void updateLikeCancel(int s_seq) {
		dao.updateLikeCancel(s_seq);
	}
	
	//delete 좋아요
	public void deleteLike(int s_seq, String m_id) {
		dao.deleteLike(s_seq,m_id);
	}
	
	public int likeCheck_main(int s_seq,String m_id){
		return dao.likeCheck_main(s_seq,m_id);
	}
}
