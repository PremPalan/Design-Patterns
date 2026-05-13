package com.ram.Template.practice.OnlineExamEvaluationSystem;

abstract class ExamEvaluator {
    public final void evaluateExam(){

        loadSubmission();

        validateSubmission();

        if(requiresPlagiarismCheck()){
            plagiarismCheck();
        }

        evaluateAnswers();

        calculateScore();

        generateResult();

        publishResult();
    }

    private void plagiarismCheck() {
        System.out.println("Checking for plagiarism....");
    }

    public void loadSubmission(){
        System.out.println("Loading the submission .....");
    }

    public void validateSubmission(){
        System.out.println("Validating submission...");
    }

    protected boolean requiresPlagiarismCheck(){
        return false;
    }

    public abstract void evaluateAnswers();

    public void calculateScore(){
        System.out.println("Calculating final score...");
    }

    public void generateResult(){
        System.out.println("Generating result...");
    }

    public void publishResult(){
        System.out.println("Publishing result to portal...");
    }
}

class MCQEvaluator extends ExamEvaluator{
    @Override
    public void evaluateAnswers(){
        System.out.println("Comparing answers with MCQ key...");
    }
}

class CodingEvaluator extends ExamEvaluator{

    @Override
    protected boolean requiresPlagiarismCheck(){
        return true;
    }

    @Override
    public void evaluateAnswers(){
        System.out.println("Running coding test cases...");
    }
}

class VivaEvaluator extends ExamEvaluator{
    @Override
    public void evaluateAnswers(){
        System.out.println("Professor manually evaluating viva...");
    }
}

public class ExamEvaluatorMain {

    public static void main(String[] args) {

        System.out.println("========== MCQ EXAM ==========");
        ExamEvaluator mcqExam = new MCQEvaluator();
        mcqExam.evaluateExam();

        System.out.println("\n========== CODING EXAM ==========");
        ExamEvaluator codingExam = new CodingEvaluator();
        codingExam.evaluateExam();

        System.out.println("\n========== VIVA EXAM ==========");
        ExamEvaluator vivaExam = new VivaEvaluator();
        vivaExam.evaluateExam();
    }
}