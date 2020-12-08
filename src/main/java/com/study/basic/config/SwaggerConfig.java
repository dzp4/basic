package com.study.basic.config;

import com.google.common.base.Predicate;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author dzp 2020/11/17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SPLIT = ";";

    @Value("config.base-package")
    private String basePackage;

    /**
     * 布隆过滤器
     */
    @Bean
    public Docket docket1() {
        return commonCode("1.布隆过滤器", basePackage+".bloomfilter");
    }


    private Docket commonCode(String groupName, String path) {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();

        //header中的ticket参数非必填，传空也可以
        ticketPar.name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();

        //根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(groupName)
                .apiInfo(comInfo())
                .select()
                .apis(basePackage(path))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo comInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("temp")
                .version("1.0")
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String path) {
        return input -> declaringClass(input).map(handlerPackage(path)).orElse(true);
    }

    private static Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }

    private static Function<Class<?>, @Nullable Boolean> handlerPackage(final String path) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : path.split(SPLIT)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

}
