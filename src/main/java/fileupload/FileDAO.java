package fileupload;

import java.util.List;
import java.util.Vector;

import common.JDBConnect;

public class FileDAO extends JDBConnect {
	public int registFile(FileDTO dto) {
		int result = 0;
		
		try {
			String sql = "insert into kmc_files(bbs_idx,title, orgfile, savefile) Values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,dto.getBbs_idx()+"");
			psmt.setString(2,dto.getTitle());
			psmt.setString(3,dto.getOrgFile());
			psmt.setString(4,dto.getSaveFile());
			result = psmt.executeUpdate();
				
		}
		catch(Exception e) {
			System.out.println("파일 등록 에러" +e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<FileDTO> fileList(String idx) {
		List<FileDTO> fList = new Vector<FileDTO>();
		
		String sql = "select * from kmc_files where bbs_idx = ? order by idx desc";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				FileDTO dto = new FileDTO();
				dto.setIdx(String.valueOf(rs.getInt("idx")));
				dto.setBbs_idx(rs.getInt("bbs_idx"));
				dto.setTitle(rs.getString("title"));
				dto.setOrgFile(rs.getString("orgFile"));
				dto.setSaveFile(rs.getString("saveFile"));
				dto.setReg_date(rs.getString("reg_date"));
				
				fList.add(dto);
			}
		}
		catch(Exception e){
			System.out.println("파일 목록 조회시 에러 발생");
			e.printStackTrace();
		}
		return fList;
	}
	
	public int deleteFile(String sFileName) {
		int result = 0;
		
		try {
			String sql = "delete from kmc_files where saveFile = '"+sFileName+"'";
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("파일 삭제 에러" +e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
}
