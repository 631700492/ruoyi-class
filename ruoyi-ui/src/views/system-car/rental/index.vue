<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车牌号" prop="carNumber">
        <el-input
          v-model="queryParams.carNumber"
          placeholder="请输入车牌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆名称" prop="carName">
        <el-input
          v-model="queryParams.carName"
          placeholder="请输入车辆名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--<el-form-item label="租车价格" prop="carPrice">
        <el-input
          v-model="queryParams.carPrice"
          placeholder="请输入车辆价格 日均"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>-->
      <el-form-item label="车辆型号" prop="carModel">
        <el-input
          v-model="queryParams.carModel"
          placeholder="请输入车辆型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆类型" prop="carType">
        <el-select v-model="queryParams.carType" placeholder="车辆类型" clearable>
          <el-option
            v-for="dict in dict.type.car_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!--<el-form-item label="行驶公里" prop="run">
        <el-input
          v-model="queryParams.run"
          placeholder="请输入行驶公里"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>-->
      <el-form-item label="租车人" prop="driverUserName">
        <el-input
          v-model="queryParams.driverUserName"
          placeholder="请输入租车人名字"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system-car:rental:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system-car:rental:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system-car:rental:remove']"
        >删除</el-button>
      </el-col>
      <!--<el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system-car:rental:export']"
        >导出</el-button>
      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="rentalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="车牌号" align="center" prop="carNumber" />
      <el-table-column label="图片信息" align="center" prop="images" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.images" :width="50" :height="50"/>
        </template>
      </el-table-column>
     <!-- <el-table-column label="轮播图" align="center" prop="luoImages" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.luoImages" :width="50" :height="50"/>
        </template>
      </el-table-column>-->
      <!--<el-table-column label="燃油标号" align="center" prop="fuelOilLabel" />-->
      <el-table-column prop="fuelOilLabel" label="燃油标号" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.fuel_oil_label" :value="scope.row.fuelOilLabel"/>
        </template>
      </el-table-column>
     <!-- <el-table-column label="能源类型" align="center" prop="sourceType" />-->
      <el-table-column prop="sourceType" label="能源类型" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.source_type" :value="scope.row.sourceType"/>
        </template>
      </el-table-column>
      <el-table-column label="结构/座位" align="center" prop="seat" />
      <!--<el-table-column label="车辆类型" align="center" prop="carType" />-->
      <el-table-column prop="carType" label="能源类型" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.car_type" :value="scope.row.carType"/>
        </template>
      </el-table-column>
      <el-table-column label="车辆颜色" align="center" prop="carColor" />
      <el-table-column label="车辆价格" align="center" prop="carPrice" />
      <el-table-column label="车辆名称" align="center" prop="carName" />
      <el-table-column label="车辆型号" align="center" prop="carModel" />
      <el-table-column label="行驶公里" align="center" prop="run" />
      <el-table-column label="车辆介绍" align="center" prop="carMemo"  :show-overflow-tooltip="true"/>
      <!--<el-table-column label="车辆状态" align="center" prop="carStatus" />-->
      dict in dict.type.sys_yes_no

      <el-table-column label="是否热门" align="center" key="hostImage">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.hostImage"
            active-value="1"
            inactive-value="0"
            @change="handleHostImageChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="租车人名字" align="center" prop="driverUserName" />
      <el-table-column label="配置信息" align="center" prop="configurationMemo" :show-overflow-tooltip="true"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system-car:rental:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system-car:rental:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改可以租借车辆信息 对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车牌号" prop="carNumber">
          <el-input v-model="form.carNumber" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="图片信息">
          <image-upload v-model="form.images"/>
        </el-form-item>
        <el-form-item label="轮播图">
          <image-upload v-model="form.luoImages"/>
        </el-form-item>
        <el-form-item label="车辆价格(元/日)" prop="carPrice">
          <el-input v-model="form.carPrice" placeholder="请输入车辆价格 日均" />
        </el-form-item>
        <el-form-item label="车辆名称" prop="carName">
          <el-input v-model="form.carName"  placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="结构/座位" prop="seat">
          <el-input v-model="form.seat"  placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="车辆颜色" prop="carColor">
          <el-input v-model="form.carColor"  placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="车辆型号" prop="carModel">
          <el-input v-model="form.carModel" placeholder="请输入车辆型号" />
        </el-form-item>
        <el-form-item label="车辆类型" prop="carType">
          <el-select v-model="form.carType" placeholder="车辆类型" clearable>
            <el-option
              v-for="dict in dict.type.car_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="能源类型" prop="sourceType">
          <el-select v-model="form.sourceType" placeholder="能源类型" clearable>
            <el-option
              v-for="dict in dict.type.source_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="燃油标号" prop="fuelOilLabel">
          <el-select v-model="form.fuelOilLabel" placeholder="燃油标号" clearable>
            <el-option
              v-for="dict in dict.type.fuel_oil_label"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="行驶公里" prop="run">
          <el-input v-model="form.run" placeholder="请输入行驶公里" />
        </el-form-item>
        <el-form-item label="车辆介绍" prop="carMemo">
          <el-input v-model="form.carMemo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="租车人名字" prop="driverUserName">
          <el-input v-model="form.driverUserName" placeholder="请输入租车人名字" />
        </el-form-item>
        <el-form-item label="配置信息" prop="configurationMemo">
          <el-input v-model="form.configurationMemo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRental, getRental, delRental, addRental, updateRental,changeHostImage } from "@/api/system-car/rental";

export default {
  name: "Rental",
  dicts: ['source_type','car_type','fuel_oil_label'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 可以租借车辆信息 表格数据
      rentalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carNumber: null,
        fuelOilLabel: null,
        sourceType: null,
        seat: null,
        carType: null,
        carColor: null,
        carPrice: null,
        carName: null,
        carModel: null,
        run: null,
        carMemo: null,
        carStatus: null,
        driverUserName: null,
        configurationMemo: null,
        isDel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询可以租借车辆信息 列表 */
    getList() {
      this.loading = true;
      listRental(this.queryParams).then(response => {
        this.rentalList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //  是否热门，如果热门的话   会上轮播图
    handleHostImageChange(row) {
      let text = row.status === "0" ? "普通" : "热门推荐";
      this.$modal.confirm('确认要设置为"' + text+'"？').then(function() {
        return changeHostImage(row.id, row.hostImage);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.hostImage = row.hostImage === "0" ? "1" : "0";
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        carNumber: null,
        images: null,
        luoImages: null,
        fuelOilLabel: null,
        sourceType: null,
        seat: null,
        carType: null,
        carColor: null,
        carPrice: null,
        carName: null,
        carModel: null,
        run: null,
        carMemo: null,
        carStatus: null,
        driverUserId: null,
        driverUserName: null,
        configurationMemo: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        isDel: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加可以租借车辆信息 ";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRental(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改可以租借车辆信息 ";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRental(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRental(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除可以租借车辆信息 编号为"' + ids + '"的数据项？').then(function() {
        return delRental(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system-car/rental/export', {
        ...this.queryParams
      }, `rental_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
