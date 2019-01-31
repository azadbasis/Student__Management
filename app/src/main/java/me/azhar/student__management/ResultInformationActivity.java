package me.azhar.student__management;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResultInformationActivity extends AppCompatActivity {

    EditText examinationLevelEt;
    EditText universityBoardEt;
    EditText instituteEt;
    EditText subjectGroupEt;
    EditText resultEt;
    EditText passingYearEt;

    Button buttonSave;
    Button buttonGoto;

    DbResultManager manager;
    ResultModel model;

    int extraIdKey;
    int bitForUpdate;
    int resultId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_information);

        examinationLevelEt = (EditText) findViewById(R.id.examinationLevelEt);
        universityBoardEt = (EditText) findViewById(R.id.universityBoardEt);
        instituteEt = (EditText) findViewById(R.id.instituteEt);
        subjectGroupEt = (EditText) findViewById(R.id.subjectGroupEt);
        resultEt = (EditText) findViewById(R.id.resultEt);
        passingYearEt = (EditText) findViewById(R.id.passingYearEt);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonGoto = (Button) findViewById(R.id.buttonGoto);

        bitForUpdate = getIntent().getIntExtra("bitForUpdate", 1);
        extraIdKey = getIntent().getIntExtra("extraId", 1);
        resultId = getIntent().getIntExtra("resultId", 1);

        manager = new DbResultManager(this);

        if (bitForUpdate==2){
            buttonSave.setText("Update");
            buttonGoto.setText("Delete");



        }

        getDateForUpdate();
    }

    public void btnSave(View view) {

        String examinationLevel = examinationLevelEt.getText().toString();
        String universityBoard = universityBoardEt.getText().toString();
        String institute = instituteEt.getText().toString();
        String subjectGroup = subjectGroupEt.getText().toString();
        String result = resultEt.getText().toString();
        String passingYear = passingYearEt.getText().toString();
        String extraId = String.valueOf(extraIdKey);

        if (examinationLevel.length() > 0) {

            model = new ResultModel(examinationLevel, universityBoard, institute, subjectGroup, result, passingYear, extraId);


            if (bitForUpdate == 1) {
                boolean insertedResult = manager.addResult(model);

                if (insertedResult) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
                    listBlank();
                    showMessage("Edit Quick Settings","Press And Hold Result Information Box To Rearrange");
                } else {
                    Toast.makeText(this, "Insert Failed", Toast.LENGTH_LONG).show();
                }
            } else if (bitForUpdate == 2) {

                boolean updateResult = manager.updateResult(resultId, model);

                if (updateResult) {
                    Toast.makeText(this, "Updated", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(ResultInformationActivity.this, StudentActivity.class);
                    intent.putExtra("key", extraIdKey);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(this, "Update Failed", Toast.LENGTH_LONG).show();
                }
            }
        }


    }

    private void getDateForUpdate() {


        if (bitForUpdate==2) {
            examinationLevelEt.setText(manager.getResultInfo(resultId).getExaminationLevel());
            universityBoardEt.setText(manager.getResultInfo(resultId).getUniversityBoard());
            instituteEt.setText(manager.getResultInfo(resultId).getInstitute());
            subjectGroupEt.setText(manager.getResultInfo(resultId).getSubjectGroup());
            resultEt.setText(manager.getResultInfo(resultId).getResult());
            passingYearEt.setText(manager.getResultInfo(resultId).getPassingYear());

        }
    }

    private void listBlank() {

        examinationLevelEt.setText("");
        universityBoardEt.setText("");
        instituteEt.setText("");
        subjectGroupEt.setText("");
        resultEt.setText("");
        passingYearEt.setText("");

    }

    public void btnProfileList(View view) {
//        Intent intent = new Intent(ResultInformationActivity.this, ResultInformationActivity.class);
//        startActivity(intent);
        finish();

        if (bitForUpdate==2){
            manager.deleteResult(resultId);
        }
    }



    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
