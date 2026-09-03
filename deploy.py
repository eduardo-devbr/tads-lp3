import subprocess

def run_command(command_list):
    """Executa um comando (como lista) e mostra o resultado de forma segura."""
    print(f"\n> {' '.join(command_list)}")

    process = subprocess.run(
        command_list,
        text=True,
        capture_output=True
    )

    if process.stdout:
        print(process.stdout.strip())

    if process.returncode != 0:
        if process.stderr:
            print(f"❌ {process.stderr.strip()}")
        return False

    return True

def main():
    print("🚀 === Script de Deploy Automático - OrderFlow ===")

    # 1. DADOS DO GITHUB
    username = input("Digite seu usuário do GitHub: ").strip()
    email = input("Digite seu e-mail do GitHub: ").strip()

    if not username or not email:
        print("❌ Usuário e e-mail são obrigatórios.")
        return

    # 2. CONFIGURAÇÃO DO GIT
    print("\n⚙️ Configurando identidade do Git...")
    if not run_command(["git", "config", "user.name", username]):
        return
    if not run_command(["git", "config", "user.email", email]):
        return

    # 3. VERIFICA REMOTE
    remote = subprocess.run(
        ["git", "remote", "get-url", "origin"],
        text=True,
        capture_output=True
    )

    if remote.returncode != 0:
        print("❌ Remote 'origin' não encontrado. Configure o repositório primeiro.")
        return

    print(f"\n🌐 Repositório remoto: {remote.stdout.strip()}")

    # 4. ADICIONA ARQUIVOS
    print("\n📦 Adicionando arquivos...")
    if not run_command(["git", "add", "."]):
        return

    # 5. VERIFICA ALTERAÇÕES
    print("\n📋 Arquivos preparados para commit:")
    run_command(["git", "status"])

    # 6. COMMIT
    commit_msg = input("\n💬 Digite a mensagem do commit: ").strip()
    if not commit_msg:
        commit_msg = "Atualização do projeto"

    print(f'\n📝 Criando commit: "{commit_msg}"...')
    
    # Executa o commit sem risco de quebra por aspas
    commit_result = subprocess.run(
        ["git", "commit", "-m", commit_msg],
        text=True,
        capture_output=True
    )

    if commit_result.returncode != 0:
        if "nothing to commit" in commit_result.stdout or "nada a submeter" in commit_result.stdout:
            print("\nℹ️ Nenhuma alteração detectada para commit. Continuando sincronização...")
        else:
            print(f"❌ Erro no commit: {commit_result.stderr.strip()}")
            return
    else:
        print(commit_result.stdout.strip())

    # 7. PULL
    print("\n🔄 Sincronizando com o GitHub...")
    if not run_command(["git", "pull", "origin", "main", "--allow-unrelated-histories", "--no-edit"]):
        print("\n⚠️ Não foi possível fazer o pull. Verifique conflitos ou o branch remoto.")
        return

    # 8. PUSH
    print("\n⬆️ Enviando projeto para o GitHub...")
    if not run_command(["git", "push", "-u", "origin", "main"]):
        print("\n❌ Falha ao enviar para o GitHub.")
        return

    print("\n✅ Projeto enviado com sucesso para o GitHub!")

    # 9. TAG OPCIONAL
    criar_tag = input("\n🏷️ Deseja criar uma tag para esta aula? (ex: aula-03 ou N para pular): ").strip()
    if criar_tag and criar_tag.lower() != "n":
        if run_command(["git", "tag", criar_tag]):
            if run_command(["git", "push", "origin", criar_tag]):
                print(f"\n✅ Tag '{criar_tag}' criada e enviada!")
            else:
                print(f"\n❌ Não foi possível enviar a tag '{criar_tag}'.")

if __name__ == "__main__":
    main()