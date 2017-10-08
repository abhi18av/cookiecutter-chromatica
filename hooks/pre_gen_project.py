from dulwich.repo import Repo
from dulwich import porcelain

r = Repo(".")
c = r[r.head()]
c.message
porcelain.log(".", max_entries=1)
