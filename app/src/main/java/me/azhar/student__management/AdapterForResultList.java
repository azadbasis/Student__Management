package me.azhar.student__management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by azharul on 5/9/2016.
 */
public class AdapterForResultList extends ArrayAdapter<ResultModel> {

    private ArrayList<ResultModel> resultList;
    private Context context;


    public AdapterForResultList (Context context, ArrayList<ResultModel> companyList) {
        super(context, R.layout.custom_layout_for_result_list,companyList );
        this.context = context;
        this.resultList = companyList;
    }

    static class ViewHolder {
        TextView examinationLevelTv;
        TextView universityBoardTv;
        TextView instituteTv;
        TextView subjectGroupTv;
        TextView resultTv;
        TextView passingYearTv;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_layout_for_result_list,null);

            viewHolder = new ViewHolder();


            viewHolder.examinationLevelTv = (TextView) convertView.findViewById(R.id.examinationLevelTv);
            viewHolder.universityBoardTv = (TextView) convertView.findViewById(R.id.universityBoardTv);
            viewHolder.instituteTv = (TextView) convertView.findViewById(R.id.instituteTv);
            viewHolder.subjectGroupTv = (TextView) convertView.findViewById(R.id.subjectGroupTv);
            viewHolder.resultTv =(TextView) convertView.findViewById(R.id.resultTv);
            viewHolder.passingYearTv =(TextView) convertView.findViewById(R.id.passingYearTv);




            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.examinationLevelTv.setText(resultList.get(position).getExaminationLevel());
        viewHolder.universityBoardTv.setText(resultList.get(position).getUniversityBoard());
        viewHolder.instituteTv.setText(resultList.get(position).getInstitute());
        viewHolder.subjectGroupTv.setText(resultList.get(position).getSubjectGroup());
        viewHolder.resultTv.setText(resultList.get(position).getResult());
        viewHolder.passingYearTv.setText(resultList.get(position).getPassingYear());



        return convertView;
    }
}
