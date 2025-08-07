from deepeval import assert_test
from deepeval.metrics import GEval
from deepeval.test_case import LLMTestCase, LLMTestCaseParams


class Deepeval:
    def __init__(self, model):
        self.model = model

    def evaluate_response(self, prompt: str, response: str):
        print("\n")
        if not response or len(response.strip()) < 10:
            print("⚠️ Réponse trop courte ou vide, évaluation non fiable")
            return

        test_case = LLMTestCase(
            input=prompt,
            actual_output=response
        )

        metrics = []
        correctness_metric = GEval(
            name="Correctness Evaluation",
            criteria="Evaluate the correctness of the response based on the input prompt.",
            evaluation_params=[LLMTestCaseParams.ACTUAL_OUTPUT],
            threshold=0.5,
            model=self.model
        )
        metrics.append(correctness_metric)

        try:
            print("🚀 Lancement de l'évaluation...")
            assert_test(test_case, metrics)
            print("✅ Toutes les évaluations ont été exécutées avec succès!")
        except Exception as e:
            print(f"⚠️ Évaluation terminée avec des alertes: {str(e)}")