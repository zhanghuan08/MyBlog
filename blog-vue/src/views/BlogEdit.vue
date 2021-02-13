<template>
  <div>
    <Header/>
    <div class="m-content">
      <el-container>
        <el-main>
          <el-form :model="blogForm" :rules="rules" ref="blogForm" label-width="100px" class="login—form">
            <el-form-item label="标题" prop="title">
              <el-input v-model="blogForm.title"></el-input>
            </el-form-item>
            <el-form-item label="摘要" prop="description">
              <el-input v-model="blogForm.description"></el-input>
            </el-form-item>
            <el-form-item label="内容" prop="content">
              <mavon-editor v-model="blogForm.content"></mavon-editor>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('blogForm')">提交</el-button>
              <el-button @click="resetForm('blogForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";

export default {
  name: "BlogEdit",
  components: {Header},
  data() {
    return {
      blogForm: {
        id: '',
        title: '',
        description: '',
        content: ''
      },
      rules: {
        title: [
          {required: true, message: '请输入标题', trigger: 'blur'},
          {min: 3, max: 25, message: '长度在 3 到 25 个字符', trigger: 'blur'}
        ],
        description: [
          {required: true, message: '请输入摘要', trigger: 'blur'},
          {min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur'}
        ],
        content: [
          {required: true, message: '请输入内容', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this
          this.$axios.post('/blog/edit', this.blogForm, {
            headers: {
              "Authorization": localStorage.getItem('token')
            }
          }).then(res => {
            _this.$alert('操作成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                _this.$router.push('/blogs')
              }
            });
          })
        } else {
          console.log("error submit")
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const blogId = this.$route.params.blogId
    console.log(blogId)
    const _this = this
    if (blogId) {
      _this.$axios.get('/blog/' + blogId).then(res => {
        const blog = res.data.data
        _this.blogForm.id = blog.id
        _this.blogForm.title = blog.title
        _this.blogForm.description = blog.description
        _this.blogForm.content = blog.content
      })
    }
  }
}
</script>

<style scoped>
.m-content {
  text-align: center;
}
</style>
