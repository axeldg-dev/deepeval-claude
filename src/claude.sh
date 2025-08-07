#!/bin/bash

response=""
git_diff=""
git_status=""

read -p "💬 Prompt Claude : " prompt

response="Response from claude code : $(echo "$prompt" | claude --dangerously-skip-permissions)"
git_diff="Git Diff : $(git diff)"
git_status="Git Status : $(git status --porcelain)"

final_response="$response\n\n$git_diff\n\n$git_status"
echo "$final_response"

python main.py "$prompt" "$final_response"
