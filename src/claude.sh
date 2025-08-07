#!/bin/bash

read -p "💬 Prompt Claude : " prompt
response=$(echo "$prompt" | claude --dangerously-skip-permissions)
echo "$response"
python main.py "$prompt" "$response"
