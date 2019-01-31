package me.azhar.student__management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by azharul on 5/9/2016.
 */
public class DbResultManager {

    private DataBaseHelper dbHelper;
    private SQLiteDatabase database;

    public DbResultManager(Context context) {
        dbHelper = new DataBaseHelper(context);

    }

    private void open() {
        database = dbHelper.getWritableDatabase();

    }

    private void close() {
        dbHelper.close();
    }


    public boolean addResult(ResultModel resultModel) {
        this.open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_EXAMINATION_LEVEL, resultModel.getExaminationLevel());
        contentValues.put(DataBaseHelper.COL_UNIVERSITY_BOARD, resultModel.getUniversityBoard());
        contentValues.put(DataBaseHelper.COL_INSTITUTE, resultModel.getInstitute());
        contentValues.put(DataBaseHelper.COL_SUBJECT_GROUP, resultModel.getSubjectGroup());
        contentValues.put(DataBaseHelper.COL_RESULT, resultModel.getResult());
        contentValues.put(DataBaseHelper.COL_PASSING_YEAR, resultModel.getPassingYear());
        contentValues.put(DataBaseHelper.COL_EXTRA_ID, resultModel.getExtraId());

        long inserted = database.insert(DataBaseHelper.TABLE_NAME_RESULT, null, contentValues);

        this.close();

        if (inserted > 0) {
            return true;
        } else {
            return false;
        }

    }




    public ArrayList<ResultModel> getAllResultByExtraId(String extraID) {

        ArrayList<ResultModel> resultList = new ArrayList<>();

        this.open();

        String selectQuery = "SELECT  * FROM " + DataBaseHelper.TABLE_NAME_RESULT + " WHERE " +
                DataBaseHelper.COL_EXTRA_ID + " = '" + extraID + "'";

        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int noteId = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_RESULT_ID));
                String examinationLevel = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXAMINATION_LEVEL));
                String universityBoard = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_UNIVERSITY_BOARD));
                String Institute = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_INSTITUTE));
                String subjectGroup = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_SUBJECT_GROUP));
                String result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_RESULT));
                String passingYear = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PASSING_YEAR));
                String extraId = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXTRA_ID));

                ResultModel resultModel = new ResultModel(noteId, examinationLevel, universityBoard, Institute, subjectGroup, result, passingYear, extraId);

                resultList.add(resultModel);

                cursor.moveToNext();

            }
        }
        database.close();
        this.close();
        return  resultList;
    }


    public ArrayList<ResultModel> getAllResultByID(int resultID) {

        ArrayList<ResultModel> resultList = new ArrayList<>();

        this.open();

        String selectQuery = "SELECT  * FROM " + DataBaseHelper.TABLE_NAME_RESULT + " WHERE " +
                DataBaseHelper.COL_RESULT_ID + " = '" + resultID + "'";

        Cursor cursor = database.rawQuery(selectQuery, null);


        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int noteId = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_RESULT_ID));
                String examinationLevel = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXAMINATION_LEVEL));
                String universityBoard = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_UNIVERSITY_BOARD));
                String Institute = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_INSTITUTE));
                String subjectGroup = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_SUBJECT_GROUP));
                String result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_RESULT));
                String passingYear = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PASSING_YEAR));
                String extraId = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXTRA_ID));

                ResultModel resultModel = new ResultModel(noteId, examinationLevel, universityBoard, Institute, subjectGroup, result, passingYear, extraId);

                resultList.add(resultModel);

                cursor.moveToNext();

                cursor.moveToNext();
            }
        }
        database.close();
        this.close();
        return resultList;
    }

    public ResultModel getResultInfo(int id) {

        this.open();

        Cursor cursor = database.query(DataBaseHelper.TABLE_NAME_RESULT, new String[]{DataBaseHelper.COL_RESULT_ID, DataBaseHelper.COL_EXAMINATION_LEVEL, DataBaseHelper.COL_UNIVERSITY_BOARD, DataBaseHelper.COL_INSTITUTE, DataBaseHelper.COL_SUBJECT_GROUP, DataBaseHelper.COL_RESULT, DataBaseHelper.COL_PASSING_YEAR, DataBaseHelper.COL_EXTRA_ID}, DataBaseHelper.COL_RESULT_ID + " = " + id, null, null, null, null);

        cursor.moveToFirst();

        int noteId = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_RESULT_ID));
        String examinationLevel = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXAMINATION_LEVEL));
        String universityBoard = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_UNIVERSITY_BOARD));
        String Institute = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_INSTITUTE));
        String subjectGroup = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_SUBJECT_GROUP));
        String result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_RESULT));
        String passingYear = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PASSING_YEAR));
        String extraId = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EXTRA_ID));

        ResultModel resultModel = new ResultModel(noteId, examinationLevel, universityBoard, Institute, subjectGroup, result, passingYear, extraId);

        cursor.moveToNext();

        this.close();
        return resultModel;


    }


    public boolean updateResult(int id, ResultModel resultModel) {

        this.open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_EXAMINATION_LEVEL, resultModel.getExaminationLevel());
        contentValues.put(DataBaseHelper.COL_UNIVERSITY_BOARD, resultModel.getUniversityBoard());
        contentValues.put(DataBaseHelper.COL_INSTITUTE, resultModel.getInstitute());
        contentValues.put(DataBaseHelper.COL_SUBJECT_GROUP, resultModel.getSubjectGroup());
        contentValues.put(DataBaseHelper.COL_RESULT, resultModel.getResult());
        contentValues.put(DataBaseHelper.COL_PASSING_YEAR, resultModel.getPassingYear());
        contentValues.put(DataBaseHelper.COL_EXTRA_ID, resultModel.getExtraId());

        int update = database.update(DataBaseHelper.TABLE_NAME_RESULT, contentValues, DataBaseHelper.COL_RESULT_ID + " = " + id, null);
        this.close();

        if (update > 0) {
            return true;
        } else return false;
    }


    public boolean deleteResult(int id) {

        this.open();
        int delete = database.delete(DataBaseHelper.TABLE_NAME_RESULT, DataBaseHelper.COL_RESULT_ID + " = " + id, null);
        this.close();
        if (delete > 0) {
            return true;
        } else return false;

    }


}
