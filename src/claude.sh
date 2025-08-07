#!/bin/bash

read -p "💬 Prompt Claude : " prompt

response=$(echo "$prompt" | claude --dangerously-skip-permissions)
diff=$(git diff)

echo "$response"

if [ -n "$diff" ]; then
  echo "Changes detected in git repository:"
  echo "$diff"
  response="$response\n\nChanges detected in git repository:\n$diff"
else
  echo "No changes detected in git repository."
fi

python main.py "$prompt" "$response"
