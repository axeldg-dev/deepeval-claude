from langchain_aws import ChatBedrock
from langchain_core.messages import HumanMessage

class Bedrock:
    def __init__(self, profile_name, region_name, model_id):
        self.model = ChatBedrock(
            credentials_profile_name=profile_name,
            region_name=region_name,
            model_id=model_id,
        )

    def generate(self, prompt: str) -> str:
        response = self.model.invoke([HumanMessage(content=prompt)])
        return response.content
