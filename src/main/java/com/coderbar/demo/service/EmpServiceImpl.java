package com.coderbar.demo.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.form.EmpForm;
import com.coderbar.demo.mapper.EmpMapper;

@Service
//EmpServiceを実装する
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpMapper mapper;

	//社員情報一覧を取得する
	@Override
	public List<EmpData> listEmp() {
		//EmpMapper.listEmp()メソッドを呼出し、すべての社員情報を取得する
		return mapper.listEmp();
	}

	//keyWordより社員情報検索
	@Override
	public List<EmpData> searchEmp(String keyWord) {
		//EmpMapper.searchEmpメソッドを呼出し、キーワードより社員情報を検索する
		return mapper.searchEmp("%" + keyWord + "%");
	}

	//社員の詳細情報を取得
	@Override
	public EmpData getEmpData(String empCd) {
		//EmpMapper.getEmpDataを呼出し、社員番号より社員情報を取得する
		return mapper.getEmpData(empCd);
	}

	//社員情報をデータベースに登録
	@Override
	public void insertEmp(EmpForm empForm) {
		//EmpMapper.insertEmpを呼出し、社員情報を登録する
		mapper.insertEmp(empForm);
	}

	//社員情報を変更
	@Override
	public void changeEmp(EmpForm empForm) {
		//EmpMapper.changeEmpを呼出し、社員情報を変更する
		mapper.changeEmp(empForm);

	}
	
	//社員情報を削除
	@Override
	public void deleteEmp(String empCd) {
		//EmpMapper.deleteEmpを呼出し、社員情報を削除する
		mapper.deleteEmp(empCd);
	}

	// 社員情報をexcelファイルにダウンロード
	public void empListExcel(HttpServletResponse response, List<EmpData> empList) throws IOException {
		if (empList != null) {
			// ワークブックを作成する
			HSSFWorkbook workBook = new HSSFWorkbook();

			// ワークシートを作成する
			HSSFSheet sheet = workBook.createSheet("社員情報一覧表");
			HSSFRow row = null;

			// excelの一行目、テーブルのタイトルを作成する
			row = sheet.createRow(0);

			// 行の高さを設定する
			row.setHeight((short) (22.50 * 20));
			// 行のセルを作成
			row.createCell(1).setCellValue("社員情報一覧表");

			// excelの二行目、テーブルのヘーダを作成する
			row = sheet.createRow(1);
			// 高さを設定する
			row.setHeight((short) (22.50 * 20));

			row.createCell(0).setCellValue("社員番号");
			row.createCell(1).setCellValue("名前");
			row.createCell(2).setCellValue("生年月日");
			row.createCell(3).setCellValue("国籍");
			row.createCell(4).setCellValue("性別");

			// 社員情報リス内容を読み込み
			for (int i = 0; i < empList.size(); i++) {
				// excelの三行目から書き込む
				row = sheet.createRow(i + 2);
				// 社員情報リストを一つずつ取り出す
				EmpData empData = empList.get(i);
				// 社員番号の設定
				row.createCell(0).setCellValue(empData.getEmpCd());
				// 社員名前の設定
				row.createCell(1).setCellValue(empData.getName());
				// 生年月日の設定
				row.createCell(2).setCellValue(empData.getBirthday().toString());
				// 国籍の設定
				row.createCell(3).setCellValue(empData.getNationality().getNationalityName());
				// 性別の設定
				row.createCell(4).setCellValue(empData.getGender().getGenderName());
			}
			// 行のデフォルトの高さを設定
			sheet.setDefaultRowHeight((short) (16.50 * 20));
			// 列の幅を設定
			for (int i = 0; i < 15; i++) {
				sheet.setColumnWidth(i, 255 * 15);
			}
			// レスポンスのコンテンツタイプの設定
			response.setContentType("application/vnd.ms-excel;charset=utf-8");

			// レスポンスにバイナリデータを書き込むのに適したServletOutputStreamを返す
			OutputStream outStream = response.getOutputStream();

			// attachment (ダウンロードすべきであることを示す
			// 多くのブラウザーは filename 引数の値を使い、「名前を付けて保存」ダイアログを表示します) を最初の引数して指定
			String exportValue = "attachment; filename=" + "empList" + ".xls";

			// レスポンスのヘーダを設定、ダウンロードしてローカルに保存する添付ファイルとするかを示す
			response.setHeader("Content-disposition", exportValue);// Excel名

			// このワークブックをOutputStreamに書き出す
			workBook.write(outStream);
			// ワークブックを閉じる
			workBook.close();

			// 出力ストリームをフラッシュして、バッファリングされていたすべての出力バイトを強制的に書き込みます
			outStream.flush();
			// 出力ストリームを閉じる
			outStream.close();
		}
	}
}
