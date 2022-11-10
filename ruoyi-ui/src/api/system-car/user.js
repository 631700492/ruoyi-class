import request from '@/utils/request'

// 查询司机用户 列表
export function listUser(query) {
  return request({
    url: '/system-car/user/list',
    method: 'get',
    params: query
  })
}

// 查询司机用户 详细
export function getUser(id) {
  return request({
    url: '/system-car/user/' + id,
    method: 'get'
  })
}

// 新增司机用户 
export function addUser(data) {
  return request({
    url: '/system-car/user',
    method: 'post',
    data: data
  })
}

// 修改司机用户 
export function updateUser(data) {
  return request({
    url: '/system-car/user',
    method: 'put',
    data: data
  })
}

// 删除司机用户 
export function delUser(id) {
  return request({
    url: '/system-car/user/' + id,
    method: 'delete'
  })
}
