echo "This is a test commit" >> README.md
git add README.md
git commit -m "Test commit to trigger Jenkins"
git push origin main
