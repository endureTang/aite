var refuseData = [
    {
        text: "R01 客户放弃",
        selectable: false,
        nodes: [
            {
                text: "R0101 借款人放弃申请",
                selectable: false,
                nodes: [
                    {
                        text: "R010101 借款人放弃申请"
                    }
                ]
            }
        ]
    },
    {
        text: "R02 无有效联系方式",
        selectable: false,
        nodes: [
            {
                text: "R0201 无有效联系方式",
                selectable: false,
                nodes: [
                    {
                        text: "R020101 借款人本人无有效联系方式"
                    },
                    {
                        text: "R020102 单位固话无有效联系方式"
                    },
                    {
                        text: "R020103 直系无有效联系方式"
                    }
                ]
            }
        ]
    },
    {
        text: "R03 不符合进件要求",
        selectable: false,
        nodes: [
            {
                text: "R0301 禁止推广的行业及职业",
                selectable: false,
                nodes: [
                    {
                        text: "R030101 高风险行业"
                    },
                    {
                        text: "R030102 现役部队在编人员"
                    },
                    {
                        text: "R030103 职业保密单位人员"
                    },
                    {
                        text: "R030104 司法相关人员"
                    },
                    {
                        text: "R030105 高风险职业人员"
                    },
                    {
                        text: "R030106 难以联络人员"
                    },
                    {
                        text: "R030107 媒体从业人员"
                    },
                    {
                        text: "R030108 同业人员"
                    },
                    {
                        text: "R030109 其他"
                    }
                ]
            },
            {
                text: "R0302 没有稳定工作收入的人士",
                selectable: false,
                nodes: [
                    {
                        text: "R030201 无业人员"
                    },
                    {
                        text: "R030202 直销人员"
                    },
                    {
                        text: "R030203 流动性强的人员"
                    }
                ]
            },
            {
                text: "R0303 与非法活动相关工种",
                selectable: false,
                nodes: [
                    {
                        text: "R030301 经营和从事赌博、赌场等服务"
                    },
                    {
                        text: "R030302 经营和从事濒危物种贸易公约管理下的野生动植物交易"
                    },
                    {
                        text: "R030303 涉及使用童工、强迫劳动等非法手段从事生产经营或服务"
                    },
                    {
                        text: "R030304 从事危险化学品的生产、经营和服务"
                    },
                    {
                        text: "R030305 从事国家明令禁止的其他非法生产、经营和服务"
                    }
                ]
            },
            {
                text: "R0304 进件资质不符",
                selectable: false,
                nodes: [
                    {
                        text: "R030401 年龄不符"
                    },
                    {
                        text: "R030402 工作或经营时间不符"
                    },
                    {
                        text: "R030403 收入不符"
                    },
                    {
                        text: "R030404 状态不符"
                    },
                    {
                        text: "R030405 工作地不符"
                    },
                    {
                        text: "R030406 月负债不符"
                    },
                    {
                        text: "R030407 工商网异常"
                    },
                    {
                        text: "R030408 信用卡金额使用率不符"
                    },
                    {
                        text: "R030409 近3月个人查询次数不符"
                    },
                    {
                        text: "R030410 信用记录不良"
                    }
                ]
            },
            {
                text: "R0305 资料不符",
                selectable: false,
                nodes: [
                    {
                        text: "R030501 手机证明不符合要求"
                    },
                    {
                        text: "R030502 收入证明不符要求"
                    },
                    {
                        text: "R030503 资产证明不符合要求"
                    }
                ]
            }
        ]
    },
    {
        text: "R04 关联信息拒贷",
        selectable: false,
        nodes: [
            {
                text: "R0401 关联历史信息虚假",
                selectable: false,
                nodes: [
                    {
                        text: "R040101 关联历史信息虚假"
                    }
                ]
            },
            {
                text: "R0402 关联申贷异常",
                selectable: false,
                nodes: [
                    {
                        text: "R040201 关联直系申贷异常"
                    },
                    {
                        text: "R040202 关联经营主体审贷异常"
                    }
                ]
            },
            {
                text: "R0403 关联信息异常",
                selectable: false,
                nodes: [
                    {
                        text: "R040301 关联本人、直亲案件未结清"
                    }
                ]
            },
        ]
    },
    {
        text: "R05 黑名单",
        selectable: false,
        nodes: [
            {
                text: "R0501 黑名单",
                selectable: false,
                nodes: [
                    {
                        text: "R050101 借款人为黑名单"
                    },
                    {
                        text: "R050102 借款人直系为黑名单"
                    },
                    {
                        text: "R050103 联系人为黑名单"
                    },
                    {
                        text: "R050104 客手机号码或直系手机号码命中网贷黑名单"
                    },
                    {
                        text: "R050105 客身份证号码或直系身份证号码命中网贷黑名单"
                    }
                ]
            },
        ]
    },
    {
        text: "R06 国政通拒贷",
        selectable: false,
        nodes: [
            {
                text: "R0601 国政通拒贷",
                selectable: false,
                nodes: [
                    {
                        text: "R060101 国政通拒贷"
                    }
                ]
            },
        ]
    },
    {
        text: "R07 虚假类",
        selectable: false,
        nodes: [
            {
                text: "R0701 决策性资料虚假",
                selectable: false,
                nodes: [
                    {
                        text: "R070101 信用报告虚假"
                    },
                    {
                        text: "R070102 手机证明虚假"
                    },
                    {
                        text: "R070103 收入证明虚假"
                    },
                    {
                        text: "R070104 资产证明虚假"
                    },
                    {
                        text: "R070105 其它信息虚假"
                    }
                ]
            },
            {
                text: "R0702 单位虚假",
                selectable: false,
                nodes: [
                    {
                        text: "R070201 职业信息虚假"
                    },
                    {
                        text: "R070202 单位信息虚假"
                    }
                ]
            },
            {
                text: "R0703 直系亲属虚假",
                selectable: false,
                nodes: [
                    {
                        text: "R070301 直系亲属虚假"
                    }
                ]
            },
        ]
    },
    {
        text: "R08 风险类",
        selectable: false,
        nodes: [
            {
                text: "R0801 借款用途风险",
                selectable: false,
                nodes: [
                    {
                        text: "R080101 借款用途风险"
                    }
                ]
            },
            {
                text: "R0802 不良信息",
                selectable: false,
                nodes: [
                    {
                        text: "R080201 借款人有不良嗜好"
                    },
                    {
                        text: "R080202 家人不同意贷款"
                    },
                    {
                        text: "R080203 态度非常不配合"
                    }
                ]
            },
            {
                text: "R0803 还款记录差",
                selectable: false,
                nodes: [
                    {
                        text: "R080301 关联还款记录差"
                    },
                    {
                        text: "R080302 其它还款记录差"
                    }
                ]
            },
            {
                text: "R0804 还款能力不足",
                selectable: false,
                nodes: [
                    {
                        text: "R080401 其它情况还款能力不足"
                    }
                ]
            },
            {
                text: "R0805 稳定性差",
                selectable: false,
                nodes: [
                    {
                        text: "R080501 稳定性差"
                    }
                ]
            },
            {
                text: "R0806 负面信息",
                selectable: false,
                nodes: [
                    {
                        text: "R080601 负面信息"
                    }
                ]
            },
            {
                text: "R0807 调查异常",
                selectable: false,
                nodes: [
                    {
                        text: "R080701 信审调查异常"
                    }
                ]
            },
        ]
    },
    {
        text: "R09 信用评级不符",
        selectable: false,
        nodes: [
            {
                text: "R0901 信用评级不符",
                selectable: false,
                nodes: [
                    {
                        text: "R090101 信用评级不符"
                    }
                ]
            }
        ]
    },
];