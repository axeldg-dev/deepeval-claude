import sys
from Deepeval import Deepeval
from Bedrock import Bedrock
from config import AWS_PROFILE, AWS_REGION, BEDROCK_MODEL_ID

def main(prompt, response):
    deepeval_model = Bedrock(
        profile_name=AWS_PROFILE,
        region_name=AWS_REGION,
        model_id=BEDROCK_MODEL_ID
    )
    deepeval = Deepeval(model=deepeval_model.model)
    deepeval.evaluate_response(prompt, response)

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python main.py <prompt> <response>")
        sys.exit(1)
    prompt = sys.argv[1]
    response = sys.argv[2]
    main(prompt, response)
